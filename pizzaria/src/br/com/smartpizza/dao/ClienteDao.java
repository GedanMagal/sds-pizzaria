package br.com.smartpizza.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import br.com.smartpizza.jdbc.ConexaoUtil;

@WebServlet("/novoCliente")
public class ClienteDao extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String cpf = request.getParameter("cpf");
		String telefone = request.getParameter("telefone");
		String celular = request.getParameter("celular");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String endereco = request.getParameter("endereco");
		String numero = request.getParameter("numero");
		String complemento = request.getParameter("complemento");
		String cep = request.getParameter("cep");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");
		String localReferencia = request.getParameter("localReferencia");

		try {
			Connection connection = ConexaoUtil.getConexao();
			String sql = "insert into tb_usuario values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?)";
			PreparedStatement stm = (PreparedStatement) connection.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);
			stm.setString(1, nome);
			stm.setString(2, sobrenome);
			stm.setString(3, cpf);
			stm.setString(4, telefone);
			stm.setString(5, celular);
			stm.setString(6, email);
			stm.setString(7, senha);
			stm.setString(8, endereco);
			stm.setString(9, numero);
			stm.setString(10, complemento);
			stm.setString(11, cep);
			stm.setString(12, bairro);
			stm.setString(13, cidade);
			stm.setString(14, estado);
			stm.setString(15, localReferencia);

			boolean resultado = stm.execute();
			System.out.println(resultado);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
