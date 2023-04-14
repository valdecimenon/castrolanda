package dao;

import java.util.List;

// Design Pattern: DAO (Data Access Object)
// DAO é um CRUD abstrato
public interface AbstractGenericDAO<T>  {

	public boolean inserir(T obj);
	
	public boolean remover(T obj);
	
	public boolean atualizar(T obj);
	
	public List<T> listar();
	
}
