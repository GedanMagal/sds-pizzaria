package br.com.smartpizza.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.smartpizza.dto.PessoaDTO;
import br.com.smartpizza.model.Cliente;
import br.com.smartpizza.model.Funcionario;
import br.com.smartpizza.model.Pessoa;
import br.com.smartpizza.util.ConexaoUtil;

public class ClienteDAOImpl implements GenericDao<Cliente, Long>{
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
	public void saveOrUpdate(Cliente cliente) {
		Session session = getSession();
		if(cliente.getId()!=null) {
			session.save(cliente);
		}
		
	}

	@Override
	public void save(Cliente cliente) {
		Session session = getSession();
		session.save(cliente);
	}

	@Override
	public void update(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> findByNames(String name) {
		// TODO Auto-generated method stub
		return null;
	}


}
