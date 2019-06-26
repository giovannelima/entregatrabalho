package br.com.park.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.park.object.funcionarios;

public class funcionariosBD {

	PreparedStatement stmt = null;
	
	boolean verifica = false;
	private static ArrayList<funcionarios> lista = new ArrayList<funcionarios>();

	public boolean insert(funcionarios insere) throws ClassNotFoundException, SQLException {
		boolean retorno = false;
		Connection con = this.getConnection();

		String sql = "insert into estacionamento.funcionarios (usu_codigo, usu_nome, usu_login, usu_senha)"
				+ " values (?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, insere.getCodigo());
		ps.setString(2, insere.getNome());
		ps.setString(3, insere.getLogin());
		ps.setString(4, insere.getSenha());
		ps.executeUpdate();

		retorno = (insere.getCodigo() > 0);
		con.close();
		return retorno;
	}

	public funcionarios verificaUsuario(String login, String senha) throws SQLException, ClassNotFoundException {
		Connection con = this.getConnection();
		funcionarios funcionarios = null;
		
		String sql = "SELECT * FROM estacionamento.funcionarios WHERE usu_login = ? and usu_senha = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, login);
		stmt.setString(2, senha);
		
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			
			String usuario = rs.getString("usu_login");
			String senhaUsu = rs.getString("usu_senha");
			
			funcionarios = new funcionarios(usuario,senhaUsu);
		}
		rs.close();
		stmt.close();
		return funcionarios;

	}

	private Connection getConnection() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/estacionamento", "root", "");

		return conn;
		
	}

}
