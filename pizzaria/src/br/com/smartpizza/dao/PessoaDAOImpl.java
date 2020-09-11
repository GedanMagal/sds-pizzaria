package br.com.smartpizza.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.smartpizza.model.Pessoa;

public class PessoaDAOImpl implements GenericDao<Pessoa, Long>{
	@Autowired
	private UsuarioDAO us;
	@Autowired
	private EnderecoDAOImpl enderecoDAO;
	@Autowired
	private CargoDAO cargoDAO;
	
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void saveOrUpdate(Pessoa pessoa) {
		Session session = getSession();
		if(pessoa.getId()!=null) {
			session.save(pessoa);
		}else {
			session.update(pessoa);
		}
		
	}

	@Override
	public void save(Pessoa pessoa) {
		Session session = getSession();
		session.save(pessoa);
	}

	@Override
	public void update(Pessoa pessoa) {
		Session session = getSession();
		session.update(pessoa);
		
	}

	@Override
	public void delete(Pessoa pessoa) {
		Session session = null;
		session = getSession();
		session.delete(pessoa);
	}

	@Override
	public Pessoa findById(Long id) {
		Session session = null;
		session = getSession();
		Criteria crit = session.createCriteria(Pessoa.class);
		crit.add(Restrictions.eq("id", id));
		List<Pessoa> listPessoa = crit.list();
		return listPessoa != null && !listPessoa.isEmpty() ? listPessoa.iterator().next() : null;
	}

	@Override
	public List<Pessoa> listAll() {
			Session session = null;
			session = getSession();
			Criteria crit = session.createCriteria(Pessoa.class);
			List<Pessoa> listPessoa = crit.list();
			return listPessoa;
	}

	@Override
	public List<Pessoa> findByNames(String name) {
		Session session = null;
		session = getSession();
		Criteria crit = session.createCriteria(Pessoa.class);
		crit.add(Restrictions.like("name", name));
		List<Pessoa> listPessoa = crit.list();
		return listPessoa;
	}
	
	
	

	
}
