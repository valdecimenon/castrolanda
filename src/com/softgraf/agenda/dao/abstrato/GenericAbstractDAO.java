package com.softgraf.agenda.dao.abstrato;

/*
 * Design Pattern DAO = Data Access Object
 * DAO é genérico = interface ou classe abstrata
 * DAO é um padrão de projeto, não uma tecnologia
 * DAO é uma interface de operação CRUD
 */
public interface GenericAbstractDAO<T, ID> {

	/*
	 * principais operações CRUD:
	 * - inserir()
	 * - apagar()
	 * - atualizar()
	 * - listar()
	 * - buscarPorId()
	 */
	
	// todos os métodos de uma interfaces são implicitamente públicos
	boolean save(T entity);
	
	T findById(ID primaryKey);
	
	Iterable<T> findAll();
	
	void delete(T entity);
	
	boolean existsById(ID primaryKey);
	
	void update(ID primaryKey, T entity);
	
	long count();
}
