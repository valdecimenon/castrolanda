package com.softgraf.agenda.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import com.softgraf.agenda.dao.abstrato.Pageable;
import com.softgraf.agenda.dao.abstrato.Repository;
import com.softgraf.agenda.model.Contato;

public class ContatoRepository implements Repository<Contato>, Pageable<Contato> {

	private Connection conexao;
	private String sql;
	private PreparedStatement stmt;
	
	// interface pageable
	private int pageNumber = 0;
	private int pageSize = 5;
	private Long ultimoId = null;

	public ContatoRepository(Connection conexao) {
		this.conexao = conexao;
	}

	@Override
	public boolean save(Contato contato) {
		// 1, 2
		sql = "INSERT INTO Contato (nome, fone) VALUES (?, ?)";
		int retorno = 0;

		try {
			// compila o código sql
			// Statement representa um terminal de comandos
			stmt = conexao.prepareStatement(sql);
			// insere as variáveis
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getFone());
			// executa o comando no banco
			retorno = stmt.executeUpdate();

			// se retorno > 0 significa que inseriu
			if (retorno > 0) {
				ResultSet rs = stmt.executeQuery("SELECT LAST_INSERT_ID() AS id");
				// move ponteiro do resultSet para o primeiro e único registro
				rs.next();
				Long id = rs.getLong("id");
				contato.setId(id);
			}

			stmt.close();

		} catch (SQLException e) {
			System.out.println("Erro em save()");
			e.printStackTrace();
		}

		return retorno > 0;
	}

	@Override
	public Contato findById(Long id) {
		sql = "SELECT * FROM Contato WHERE id=?";
		Contato contato = null;

		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				String nome = rs.getString("nome");
				String fone = rs.getString("fone");
				contato = new Contato(id, nome, fone);
			}

			stmt.close();

		} catch (SQLException e) {
			System.out.println("Erro em findById()");
			e.printStackTrace();
		}

		return contato;
	}

	@Override
	public List<Contato> findAll() {
		List<Contato> lista = new ArrayList<>();
		sql = "SELECT * FROM Contato";
		Contato contato = null;

		try {
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Long id = rs.getLong("id");
				String nome = rs.getString("nome");
				String fone = rs.getString("fone");
				contato = new Contato(id, nome, fone);
				lista.add(contato);
			}

			stmt.close();

		} catch (SQLException e) {
			System.out.println("Erro em findAll()");
			e.printStackTrace();
		}

		return lista;
	}

	// assinatura do método: delete(Contato contato)
	@Override
	public void delete(Contato contato) {
		sql = "DELETE FROM Contato WHERE id=?";

		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, contato.getId());
			stmt.executeUpdate();
			stmt.close();

		} catch (SQLException e) {
			System.out.println("Erro em delete()");
			e.printStackTrace();
		}
	}

	// método sobrecarregado
	// assinatura do método: delete(Long id)
	public void delete(Long id) {
		Contato contato = findById(id);
		if (contato != null) {
			delete(contato);
		}
	}

	@Override
	public boolean existsById(Long id) {
		// select retorna 1 ou 0
		sql = "SELECT EXISTS(SELECT * FROM Contato WHERE id=?) AS existe";
		boolean existe = false;

		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();   // Query == SELECT
			
			// joga o ponteiro na primeira posição
			rs.next();
			existe = rs.getInt("existe") == 1;
			stmt.close();
			
		} catch (SQLException e) {
			System.out.println("Erro existsById");
			e.printStackTrace();
		}
		
		return existe;
	}

	@Override
	public void update(Long id, Contato contato) {
		sql = "UPDATE Contato SET nome=?, fone=? WHERE id=?";

		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getFone());
			stmt.setLong(3, id);
			stmt.executeUpdate();
			stmt.close();
			
		} catch (SQLException e) {
			System.out.println("Erro em update()");
			e.printStackTrace();
		} 
	}

	@Override
	public long count() {
		sql = "SELECT count(*) as count FROM Contato";
		long count = 0;
		
		try {
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			rs.next(); // vai para o registro inicial do rs
			count = rs.getLong("count");
			stmt.close();
			
		} catch (SQLException e) {
			System.out.println("Erro em count()");
			e.printStackTrace();
		}
		
		return count;
	}
	
	public int storeProcedureTotalContatos() {
		int total = 0;
		
		try {
			CallableStatement stmt = conexao.prepareCall("CALL get_total_contatos(?)");
			stmt.registerOutParameter(1, Types.INTEGER);
			stmt.execute();
			total = stmt.getInt(1);
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return total;
	}

	@Override
	public int getPageNumber() {
		return pageNumber;
	}

	@Override
	public int getPageSize() {
		return pageSize;
	}

	@Override
	public void setPageSize(int size) {
		this.pageSize = size;
	}

	@Override
	public void first() {
		this.ultimoId = null;
		this.pageNumber = 0;
	}

	@Override
	public List<Contato> next() {
		List<Contato> lista = new ArrayList<>();
		String sql;
		
		if (ultimoId == null)
			sql = "SELECT * FROM Contato LIMIT ?";
		else
			sql = "SELECT * FROM Contato WHERE id>? LIMIT ?";
		
		Contato contato = null;
		
		try {
			stmt = conexao.prepareStatement(sql);
			
			if (ultimoId == null) {
				stmt.setLong(1, pageSize);
			} else {
				stmt.setLong(1, ultimoId);
				stmt.setLong(2, pageSize);
			}
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Long id = rs.getLong("id");
				ultimoId = id;
				String nome = rs.getString("nome");
				String fone = rs.getString("fone");
				contato = new Contato(id, nome, fone);
				lista.add(contato);
			}
			
			stmt.close();
			
			
		} catch (SQLException e) {
			System.out.println("Erro ao listar entidades com next()");
			e.printStackTrace();
		}
		
		if (!lista.isEmpty()) {
			this.pageNumber++;
		}
		
		return lista;
	}

}
