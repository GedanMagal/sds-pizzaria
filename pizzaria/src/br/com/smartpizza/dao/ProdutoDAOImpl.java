package br.com.smartpizza.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.smartpizza.model.Produto;
import br.com.smartpizza.model.Produto;

public class ProdutoDAOImpl implements GenericDao<Produto, Long> {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	
	@Override
	public void saveOrUpdate(Produto produto) {
		Session session = getSession();
		if (produto.getIdProduto() != null) {
			session.save(produto);
		} else {
			session.update(produto);
		}

	}

	@Override
	public void save(Produto produto) {
		Session session = getSession();
		session.save(produto);
	}

	@Override
	public void update(Produto produto) {
		Session session = getSession();
		session.update(produto);

	}

	@Override
	public void delete(Produto produto) {
		Session session = null;
		session = getSession();
		session.delete(produto);
	}

	@Override
	public Produto findById(Long id) {
		Session session = null;
		session = getSession();
		Criteria crit = session.createCriteria(Produto.class);
		crit.add(Restrictions.eq("id", id));
		List<Produto> listProduto = crit.list();
		return listProduto != null && !listProduto.isEmpty() ? listProduto.iterator().next() : null;
	}

	@Override
	public List<Produto> listAll() {
		Session session = null;
		session = getSession();
		Criteria crit = session.createCriteria(Produto.class);
		List<Produto> listProduto = crit.list();
		return listProduto;
	}

	@Override
	public List<Produto> findByNames(String name) {
		Session session = null;
		session = getSession();
		Criteria crit = session.createCriteria(Produto.class);
		crit.add(Restrictions.like("name", name));
		List<Produto> listProduto = crit.list();
		return listProduto;
	}
	
	public List<Produto> findBySizeAndType(String tipo, Long idTamanho) {
		Session session = null;
		session = getSession();
		Criteria crit = session.createCriteria(Produto.class);
		crit.add(Restrictions.like("tipo", tipo));
		crit.add(Restrictions.eq("idTamanho", idTamanho));
		List<Produto> listProduto = crit.list();
		return listProduto;
	}

}
