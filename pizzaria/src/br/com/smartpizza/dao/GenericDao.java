package br.com.smartpizza.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public interface GenericDao <T,PK extends Serializable> {

	public void saveOrUpdate(T entity);
	
	public void save(T entity);
	
	public void update(T entity);
	
	public void delete(T entity);
	
	public T findById(Long id);
	
	public List<T> listAll();
	
	public List<T> findByNames(String name);
	
	
	
}
