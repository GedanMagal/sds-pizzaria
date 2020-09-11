package br.com.smartpizza.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.smartpizza.model.Cidade;
import br.com.smartpizza.model.Pessoa;

public class CidadeDAOImpl implements GenericDao<Cidade, Long>{

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void saveOrUpdate(Cidade cidade) {
		Session session = getSession();
		if(cidade.getIdCidade()!=null) {
			session.save(cidade);
		}else {
			session.update(cidade);
		}
		
	}

	@Override
	public void save(Cidade cidade) {
		Session session = getSession();
		session.save(cidade);
		
	}

	@Override
	public void update(Cidade cidade) {
		Session session = getSession();
		session.update(cidade);
		
	}

	@Override
	public void delete(Cidade cidade) {
		Session session = getSession();
		session.delete(cidade);
	}

	@Override
	public Cidade findById(Long id) {
		Session session = null;
		session = getSession();
		Criteria crit = session.createCriteria(Cidade.class);
		crit.add(Restrictions.eq("id", id));
		List<Cidade> listCidade = crit.list();
		return listCidade != null && !listCidade.isEmpty() ? listCidade.iterator().next() : null;
	}

	@Override
	public List<Cidade> listAll() {
		Session session = null;
		session = getSession();
		Criteria crit = session.createCriteria(Cidade.class);
		List<Cidade> listCidade = crit.list();
		return listCidade;
	}

	@Override
	public List<Cidade> findByNames(String name) {
		Session session = null;
		session = getSession();
		Criteria crit = session.createCriteria(Cidade.class);
		crit.add(Restrictions.eq("cidade", name));
		List<Cidade> listCidade = crit.list();
		return listCidade;
	}
	
	
	
	
}