package com.softgraf.beans;

import java.io.Serializable;
import java.util.List;

import com.softgraf.entity.Editora;
import com.softgraf.entity.Livro;
import com.softgraf.service.LivrariaService;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("bean")
@RequestScoped
public class LivrariaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Editora editora;
	private Long editoraId;

	private Livro livro;
	private Long livroId;

	private Long paramId;

	@Inject
	private LivrariaService service;

	@Inject
	private MessagesView messages;

	// construtor padrão
	public LivrariaBean() {
		this.editora = new Editora();
		this.livro = new Livro();
	}

	public String salvarEditora() {

		try {
			if (paramId == null) {
				System.out.println("\nSalvando editora: " + editora);
				service.persist(editora);
				messages.info("Editora salva");
			} else {
				
				System.out.println("\nAtualizando editora: " + editora);
				editora.setId(paramId);
				service.update(editora);
				messages.info("Editora atualizada");
			}

		} catch (Exception ex) {
			messages.error("Não foi possível salvar/atualizar editora");
		}

		this.paramId = null;
		return "index";
	}

	public String salvarLivro() {
		livro.setEditora(service.findEditoraById(editoraId));
		livro.getEditora().getLivros().add(livro);

		try {

			if (paramId == null) {
				System.out.println("Salvando livro: " + livro);	
				service.persist(livro);
				messages.info("Livro salvo");
			} else {
				livro.setId(paramId);
				System.out.println("Atualizando livro: " + livro);
				service.update(livro);
				messages.info("Livro atualizado");				
			}

		} catch (Exception ex) {
			messages.error("Não foi possível salvar/atualizar livro");
			ex.printStackTrace();
		}

		this.paramId = null;
		return "index";
	}

	public List<Editora> getEditoras() {
		return service.todasEditoras();
	}
	
	public List<Livro> getLivros() {
		return service.todosLivros();
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public String getTituloEditora() {
		return "Cadastra Editora";
	}

	public String getTituloLivro() {
		return "Cadastra Livro";
	}

	public Long getEditoraId() {
		return editoraId;
	}

	public void setEditoraId(Long editoraId) {
		this.editoraId = editoraId;
	}

	public Long getParamId() {
		return paramId;
	}

	public void setParamId(Long paramId) {
		this.paramId = paramId;
	}

	public void editarEditora() {
		if (paramId != null)
			editora = service.findEditoraById(paramId);
	}
	
	public void editarLivro() {
		if (paramId != null) {
			livro = service.findLivroById(paramId);
			if (livro.getEditora() != null)
				editoraId = livro.getEditora().getId();
		}
	}
	
	public String excluirEditora() {
		try {
			service.removeEditoraById(editoraId);
			
		} catch (Exception ex) {
			messages.error("Não foi possível excluir editora selecionada");
			System.out.println(ex);
		}
		
		return null;
	}
	
	public Long getLivroId() {
		return livroId;
	}
	
	public void setLivroId(Long livroId) {
		this.livroId = livroId;
	}
	
	public String excluirLivro() {
		try {
			service.removeLivroById(livroId);
			
		} catch (Exception ex) {
			messages.error("Não foi possível excluir livro selecionado");
			System.out.println(ex);
		}
		
		return null;
	}
	
}
