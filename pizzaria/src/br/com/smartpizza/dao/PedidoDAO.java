package br.com.smartpizza.dao;

public class PedidoDAO {
	
	public void cadastrarPedido() {
		
	}
	
	
//	public List<PedidosDTO> listaPedidos() {
//		List<PedidosDTO> listaPedidos = new ArrayList<PedidosDTO>();
//		Connection conn = null;
//
//		try {
//			conn = ConexaoUtil.getConexao();
//			StringBuilder sql = new StringBuilder();
//			sql.append("SELECT CLI.ID_CLIENTE, CLI.NM_CLIENTE,CLI.SOBRENOME,CLI.DS_EMAIL, CLI.CLI_TELEFONE, CLI.CLI_CELULAR,EN.DS_LOGRADOURO, EN.NM_ENDERECO, EN.NM_CEP,EN.DS_BAIRRO");
//			sql.append(" FROM TB_CLIENTE CLI INNER JOIN  TB_ENDERECO EN ON EN.ID_CLIENTE = CLI.ID_CLIENTE");
//			PreparedStatement stmt = conn.prepareStatement(sql.toString());
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				PessoaDTO p = new PessoaDTO();
//				p.setIdPessoa(rs.getInt("CLI.ID_CLIENTE"));
//				p.setNome(rs.getString("NM_CLIENTE"));
//				p.setSobrenome(rs.getString("SOBRENOME"));
//				p.setEmail(rs.getString("DS_EMAIL"));
//				p.setTelefone(rs.getString("CLI_TELEFONE"));
//				p.setCelular(rs.getString("CLI_CELULAR"));
//				p.setEndereco(rs.getString("DS_LOGRADOURO"));
//				p.setNumero(rs.getString("NM_ENDERECO"));
//				p.setCep(rs.getString("NM_CEP"));
//				p.setBairro(rs.getString("DS_BAIRRO"));
//				listPessoas.add(p);
//			}
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return listPessoas;
//	}
}
