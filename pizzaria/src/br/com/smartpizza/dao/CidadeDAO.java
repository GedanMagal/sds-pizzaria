package br.com.smartpizza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.smartpizza.model.Cidade;
import br.com.smartpizza.model.Estado;
import br.com.smartpizza.util.ConexaoUtil;

public class CidadeDAO {
	
	public List<Cidade> consultaCidades(Integer idEstado){
		List<Cidade> listCidades = new ArrayList<Cidade>();
		Connection conn = null;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM TB_CIDADE WHERE ID_ESTADO = ? ");
		try {
			conn = ConexaoUtil.getConexao();
			PreparedStatement stmt = conn.prepareStatement(sql.toString());
			stmt.setInt(1, idEstado);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Cidade cid = new Cidade();
				cid.setIdCidade(rs.getInt("ID_CIDADE"));
				cid.setCidade(rs.getString("DS_CIDADE"));
				Estado estado = new Estado();
				cid.setEstado(estado);
				estado.setIdEstado(rs.getInt("ID_ESTADO"));
				listCidades.add(cid);
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listCidades;
	}
	public List<Cidade> getListCidades(){
		List<Cidade> listCidades = new ArrayList<Cidade>();
		Connection conn = null;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM TB_CIDADE");
		try {
			conn = ConexaoUtil.getConexao();
			PreparedStatement stmt = conn.prepareStatement(sql.toString());
		
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Cidade cid = new Cidade();
				cid.setIdCidade(rs.getInt("ID_CIDADE"));
				cid.setCidade(rs.getString("DS_CIDADE"));
				Estado estado = new Estado();
				cid.setEstado(estado);
				estado.setIdEstado(rs.getInt("ID_ESTADO"));
				listCidades.add(cid);
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listCidades;
	}
	public Integer cadastrarCidade(Cidade cidade) {
		Connection conn = null;
		Integer idCidade = null;
		System.out.println(cidade.getCidade());
		System.out.println(cidade.getIdCidade());
		try {
			StringBuilder sql = new StringBuilder();
			conn = ConexaoUtil.getConexao();
			sql.append("INSERT INTO TB_CIDADE(DS_CIDADE,ID_ESTADO)");
			sql.append(" VALUES(?,?)");
			PreparedStatement stmt = conn.prepareStatement(sql.toString(),Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, cidade.getCidade());
			stmt.setInt(2, cidade.getEstado().getIdEstado());
			stmt.executeUpdate();
			ResultSet rs =  stmt.getGeneratedKeys();
			if(rs.first()) {
				idCidade = rs.getInt(1);
			}
			
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return idCidade;
	}
	public List<Estado> listarEstados(){
		List<Estado> listEstados = new  ArrayList<Estado>();
		Connection conn = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM TB_ESTADO");
		try {
			conn = ConexaoUtil.getConexao();
			PreparedStatement stmt = conn.prepareStatement(sql.toString());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Estado estado = new Estado();
				estado.setIdEstado(rs.getInt(1));
				estado.setDsuf(rs.getString(2));
				estado.setDsSigla(rs.getString(3));
				listEstados.add(estado);
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listEstados;
	}
	
	
}