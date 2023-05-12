package com.softgraf.agenda.dao;

import com.softgraf.agenda.dao.abstrato.Repository;
import com.softgraf.agenda.model.Contato;

public class ContatoRepository implements Repository<Contato> {

	@Override
	public boolean save(Contato entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Contato findById(Long primaryKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Contato> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Contato entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean existsById(Long primaryKey) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update(Long primaryKey, Contato entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

}
