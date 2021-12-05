package br.com.smartpizza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.smartpizza.dto.PessoaDTO;
import br.com.smartpizza.model.Cliente;
import br.com.smartpizza.model.Funcionario;
import br.com.smartpizza.util.ConexaoUtil;

public class PessoaDAO {
	private UsuarioDAO us = new UsuarioDAO();
	private EnderecoDAO enderecoDAO = new EnderecoDAO();
	private CargoDAO cargoDAO = new CargoDAO();
	private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	

	public Integer cadastroPessoaClient(Cliente p, Integer id) throws ClassNotFoundException, SQLException {

		Connection conn = null;
		Integer idPessoa = null;

		try {

			conn = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			sql.append(
					"INSERT INTO TB_CLIENTE (nm_cliente, nm_cpf,sobrenome,ds_email,senha,cli_telefone,cli_celular,us_id)");
			sql.append(" VALUES (?,?,?,?,?,?,?,?)");

			PreparedStatement stmt = conn.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, p.getNome());
			stmt.setString(2, p.getCpf());
			stmt.setString(3, p.getSobrenome());
			stmt.setString(4, p.getEmail());
			stmt.setString(5, p.getSenha());
			stmt.setString(6, p.getTelefone());
			stmt.setString(7, p.getCelular());
			stmt.setInt(8, id);
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.first()) {
				idPessoa = rs.getInt(1);
			}
			enderecoDAO.cadastrarEndereco(p.getEndereco(), idPessoa);
			return idPessoa;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idPessoa;
	}

	public void cadastroFuncionario(Funcionario f, int idCargo, Integer id) throws ClassNotFoundException, SQLException {

		Connection conn = null;
		Integer idFuncionario = null;

		try {

			conn = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO TB_FUNCIONARIO");
			sql.append(" (nm_funcionario, nm_cpf, sobrenome, dataAdmissao, telefone, id_cargo, us_id)");
			sql.append(" VALUES (?,?,?,?,?,?,?)");

			PreparedStatement stmt = conn.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, f.getNome());
			stmt.setString(2, f.getCpf());
			stmt.setString(3, f.getSobrenome());
			java.sql.Date dataAdmiss = new java.sql.Date(dateFormat.parse(f.getDataAdmissao()).getTime());
			stmt.setDate(4, dataAdmiss);
			stmt.setString(5, f.getTelefone());
			stmt.setInt(6, idCargo);
			stmt.setInt(7, id);
			
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.first()) {
				idFuncionario = rs.getInt(1);
			}
		

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<PessoaDTO> listaPessoas() {
		List<PessoaDTO> listPessoas = new ArrayList<PessoaDTO>();
		Connection conn = null;

		try {
			conn = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT CLI.ID_CLIENTE, CLI.NM_CLIENTE,CLI.SOBRENOME,CLI.DS_EMAIL, CLI.CLI_TELEFONE, CLI.CLI_CELULAR,EN.DS_LOGRADOURO, EN.NM_ENDERECO, EN.NM_CEP,EN.DS_BAIRRO");
			sql.append(" FROM TB_CLIENTE CLI INNER JOIN  TB_ENDERECO EN ON EN.ID_CLIENTE = CLI.ID_CLIENTE");
			PreparedStatement stmt = conn.prepareStatement(sql.toString());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				PessoaDTO p = new PessoaDTO();
				p.setIdPessoa(rs.getInt("CLI.ID_CLIENTE"));
				p.setNome(rs.getString("NM_CLIENTE"));
				p.setSobrenome(rs.getString("SOBRENOME"));
				p.setEmail(rs.getString("DS_EMAIL"));
				p.setTelefone(rs.getString("CLI_TELEFONE"));
				p.setCelular(rs.getString("CLI_CELULAR"));
				p.setEndereco(rs.getString("DS_LOGRADOURO"));
				p.setNumero(rs.getString("NM_ENDERECO"));
				p.setCep(rs.getString("NM_CEP"));
				p.setBairro(rs.getString("DS_BAIRRO"));
				listPessoas.add(p);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listPessoas;
	}

	public PessoaDTO getPessoa(Integer idPessoa) {
		Connection conn = null;
		PessoaDTO p = null;
		try {
			conn = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT CLI.ID_CLIENTE,CLI.NM_CLIENTE, CLI.NM_CPF,CLI.SOBRENOME,CLI.DS_EMAIL, CLI.CLI_TELEFONE, CLI.CLI_CELULAR, EN.ID_ENDERECO,EN.DS_LOGRADOURO, EN.NM_ENDERECO, EN.NM_CEP,EN.DS_BAIRRO");
			sql.append(" FROM TB_CLIENTE CLI INNER JOIN  TB_ENDERECO EN ON EN.ID_CLIENTE = CLI.ID_CLIENTE");
			sql.append(" WHERE CLI.ID_CLIENTE = ?");
			PreparedStatement stmt = conn.prepareStatement(sql.toString());
			stmt.setInt(1, idPessoa);
			ResultSet rs = stmt.executeQuery();
			if (rs.first()) {
				p = new PessoaDTO();
				p.setIdPessoa(rs.getInt("ID_CLIENTE"));
				p.setNome(rs.getString("NM_CLIENTE"));
				p.setSobrenome(rs.getString("SOBRENOME"));
				p.setCpf(rs.getString("NM_CPF"));
				p.setEmail(rs.getString("DS_EMAIL"));
				p.setTelefone(rs.getString("CLI_TELEFONE"));
				p.setCelular(rs.getString("CLI_CELULAR"));
				p.setIdEndereco(rs.getInt("ID_ENDERECO"));
				p.setEndereco(rs.getString("DS_LOGRADOURO"));
				p.setNumero(rs.getString("NM_ENDERECO"));
				p.setCep(rs.getString("NM_CEP"));
				p.setBairro(rs.getString("DS_BAIRRO"));
			}
			stmt.close();
			conn.close();
			rs.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
	
	public PessoaDTO getFuncionarioUsuario(Integer idPessoa) {
		Connection conn = null;
		PessoaDTO p = null;
		try {
			conn = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT F.ID_FUNCIONARIO, F.NM_FUNCIONARIO, F.NM_CPF, F.DATAADMISSAO, F.TELEFONE, US.US_LOGIN,");
			sql.append(" US.GP_USUARIO, C.DS_DESCRICAOCARGO FROM TB_FUNCIONARIO F INNER JOIN TB_USUARIO US on US.US_ID = F.US_ID");
			sql.append(" INNER JOIN TB_CARGO C ON C.ID_CARGO = F.ID_CARGO WHERE US.US_ID = ?");
			PreparedStatement stmt = conn.prepareStatement(sql.toString());
			stmt.setInt(1, idPessoa);
			ResultSet rs = stmt.executeQuery();
			if (rs.first()) {
				p = new PessoaDTO();
				p.setIdPessoa(rs.getInt("ID_FUNCIONARIO"));
				p.setNome(rs.getString("NM_FUNCIONARIO"));
				p.setCpf(rs.getString("NM_CPF"));
				p.setDataAdmissao(rs.getString("DATAADMISSAO"));
				p.setTelefone(rs.getString("TELEFONE"));
				p.setEmail(rs.getString("US_LOGIN"));
				p.setGpUsuario(rs.getString("GP_USUARIO"));
				p.setDescricaoCargo(rs.getString("DS_DESCRICAOCARGO"));
			
			}
			stmt.close();
			conn.close();
			rs.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
	public PessoaDTO getClienteUsuario(Integer idPessoa) {
		Connection conn = null;
		PessoaDTO p = null;
		try {
			conn = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT C.ID_CLIENTE, C.NM_CLIENTE, C.NM_CPF, C.SOBRENOME, C.DS_EMAIL,");
			sql.append(" US.GP_USUARIO FROM TB_CLIENTE C INNER JOIN TB_USUARIO US on US.US_ID = C.US_ID WHERE US.US_ID=?");
			PreparedStatement stmt = conn.prepareStatement(sql.toString());
			stmt.setInt(1, idPessoa);
			ResultSet rs = stmt.executeQuery();
			if (rs.first()) {
				p = new PessoaDTO();
				p.setIdPessoa(rs.getInt("ID_CLIENTE"));
				p.setNome(rs.getString("NM_CLIENTE"));
				p.setCpf(rs.getString("NM_CPF"));
				p.setSobrenome(rs.getString("SOBRENOME"));
				p.setEmail(rs.getString("DS_EMAIL"));
				p.setGpUsuario(rs.getString("GP_USUARIO"));
			}
			stmt.close();
			conn.close();
			rs.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	
	public void atualizarPessoa(Cliente p) throws ClassNotFoundException, SQLException {

		Integer idPessoa = null;
		Connection conn = null;

		try {

			conn = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE TB_CLIENTE ");
			sql.append(" set nm_cliente = ?, nm_cpf = ?, sobrenome = ?, cli_telefone = ?, cli_celular = ?");
			sql.append(" WHERE id_cliente = ?");

			PreparedStatement stmt = conn.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, p.getNome());
			stmt.setString(2, p.getCpf());
			stmt.setString(3, p.getSobrenome());
			stmt.setString(4, p.getTelefone());
			stmt.setString(5, p.getCelular());
			stmt.setInt(6, p.getId());

			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();

	
			enderecoDAO.atualizarEndereco(p.getEndereco());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<PessoaDTO> getClientes(String nome) {
		List<PessoaDTO> listPessoas = new ArrayList<PessoaDTO>();
		Connection conn = null;

		try {
			conn = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT CLI.ID_CLIENTE, CLI.NM_CLIENTE,CLI.SOBRENOME,CLI.DS_EMAIL, CLI.CLI_TELEFONE, CLI.CLI_CELULAR,EN.DS_LOGRADOURO, EN.NM_ENDERECO, EN.NM_CEP,EN.DS_BAIRRO");
			sql.append(" FROM TB_CLIENTE CLI INNER JOIN  TB_ENDERECO EN ON EN.ID_CLIENTE = CLI.ID_CLIENTE");
			sql.append(" WHERE CLI.NM_CLIENTE like ?");
			PreparedStatement stmt = conn.prepareStatement(sql.toString());
			stmt.setString(1, nome+"%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				PessoaDTO p = new PessoaDTO();
				p.setIdPessoa(rs.getInt("CLI.ID_CLIENTE"));
				p.setNome(rs.getString("NM_CLIENTE"));
				p.setSobrenome(rs.getString("SOBRENOME"));
				p.setEmail(rs.getString("DS_EMAIL"));
				p.setTelefone(rs.getString("CLI_TELEFONE"));
				p.setCelular(rs.getString("CLI_CELULAR"));
				p.setEndereco(rs.getString("DS_LOGRADOURO"));
				p.setNumero(rs.getString("NM_ENDERECO"));
				p.setCep(rs.getString("NM_CEP"));
				p.setBairro(rs.getString("DS_BAIRRO"));
				listPessoas.add(p);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listPessoas;
	}
}
