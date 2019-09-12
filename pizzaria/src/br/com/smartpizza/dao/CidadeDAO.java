package br.com.smartpizza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	public List<Cidade> getListCidades(Integer idCidade){
		List<Cidade> listCidades = new ArrayList<Cidade>();
		Connection conn = null;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM TB_CIDADE WHERE ID_CIDADE = ? ");
		try {
			conn = ConexaoUtil.getConexao();
			PreparedStatement stmt = conn.prepareStatement(sql.toString());
			stmt.setInt(1, idCidade);
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
}
