package ifce.edu.ed.model;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import ifce.edu.ed.controller.Configuracao;


public class Conexao {

	private Connection con;
	private String url, user, pass;
	
	public Connection getCon() {
		return con;
	}
	
	public boolean abrirConexao() {
		try {
			cfg();
			
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(url, user, pass);
			System.out.println("Conectado ao banco com sucesso.");
			return true;
		} catch (Exception e) {
			System.out.println("Nao foi possivel conectar ao banco de dados.");
			e.printStackTrace();
			return false;
		}
	}
	private void cfg() {
		try {
			Configuracao cfg = new Configuracao();
			url = cfg.getUrl();
			pass = cfg.getPass();
			user = cfg.getUser();
		} catch (Exception e) {
			url = user = pass = null;
			System.out.println("Nao foi possivel configurar.");
		}
		
		
	}
	public void fecharConnexao() {
		try {
			con.close();
			System.out.println("Conexao encerrada.");
		} catch (SQLException e) {
			System.out.println("Nao foi possivel encerrar conexao.");
		}
	}
	
}
