package ifce.edu.ed.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

import com.mysql.jdbc.PreparedStatement;

import ifce.edu.ed.interfaces.JogadorDAO;
import ifce.edu.ed.model.Historico;
import ifce.edu.ed.model.Jogador;

public class JogadorImp implements JogadorDAO {

	private Jogador jogadorRetorno;
	private ArrayList<Historico> historico;
	private ArrayList<Jogador> jogadores;
	
	
	@Override
	public boolean insererJogador(Jogador jogador) {
		try { 
			conexao.abrirConexao();
			String sql = "INSERT INTO jogador(id_jogador, nome, num_vitorias, num_derrotas, nick, senha) "
					+ "VALUES(?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = (PreparedStatement) conexao.getCon().prepareStatement(sql);
			ps.setInt(1, jogador.getId_jogador());
			ps.setString(2, jogador.getNome());
			ps.setInt(3, jogador.getNum_vitorias());
			ps.setInt(4, jogador.getNum_derrotas());
			ps.setString(5, jogador.getNick());
			ps.setString(6, jogador.getSenha());
			
			ps.execute();
			ps.close();
			conexao.fecharConnexao();
			return true;
		} catch(SQLException e1) {
			System.err.println("ERRO: " + e1);
			return false;
		} catch(Exception e2) {
			System.err.println("ERRO: " + e2);
			return false;
		}
	}



	@Override
	public ArrayList<Historico> pegarHistorico(Jogador jogador) {
		try {
			historico = new ArrayList<>();
			conexao.abrirConexao();
			String sql = "SELECT * FROM historico WHERE id_jogador1 = ? OR id_jogador2 = ?";
			PreparedStatement ps = (PreparedStatement) conexao.getCon().prepareStatement(sql);
			ps.setInt(1, jogador.getId_jogador());
			ps.setInt(2, jogador.getId_jogador());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				historico.add(new Historico(rs.getInt("id_partida")
						, new Jogador(rs.getInt("id_jogador1"))
						, new Jogador(rs.getInt("id_jogador2"))
						, rs.getString("vencedor").charAt(0)
						, rs.getDate("data").toString()));
			}
			
			ps.close();
			rs.close();
			conexao.fecharConnexao();
			return historico;
		} catch (Exception e) {
			System.err.println("ERRO: " + e.getMessage());
			return null;
		}
	}

	

	@Override
	public Jogador buscarJogador(Jogador jogador) {
		jogadorRetorno = null;
		try {
			conexao.abrirConexao();
			String sql ="SELECT * FROM jogador WHERE nick = ? and senha = ?";
			PreparedStatement ps = (PreparedStatement) conexao.getCon().prepareStatement(sql);
			ps.setString(1, jogador.getNick());
			ps.setString(2, jogador.getSenha());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				jogadorRetorno = new Jogador(rs.getInt("id_jogador")
						, rs.getInt("num_vitorias")
						, rs.getInt("num_derrotas")
						, rs.getString("nome")
						, rs.getString("nick")
						, rs.getString("senha"));
			}
			ps.close();
			rs.close();
			conexao.fecharConnexao();
			return this.jogadorRetorno;
		} catch (Exception e) {
			e.printStackTrace();
			return jogadorRetorno;
		}
	}

	@Override
	public ArrayList<Jogador> buscarTodos() {
		try {
			conexao.abrirConexao();
			jogadores = new ArrayList<>();
			String sql = "SELECT * FROM jogador";
			Statement st = (Statement) conexao.getCon().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				jogadores.add(new Jogador(rs.getInt("id_jogador")
						, rs.getInt("num_vitorias")
						, rs.getInt("num_derrotas")
						, rs.getString("nome")));
			}
			st.close();
			rs.close();
			conexao.fecharConnexao();
			return jogadores;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean atualizaJogador(Jogador jogador) {
		try {
			conexao.abrirConexao();
			String sql = "UPDATE jogador SET num_vitorias = ?, num_derrotas = ? WHERE id_jogador = ?";
			PreparedStatement ps = (PreparedStatement) conexao.getCon().prepareStatement(sql);
			ps.setInt(1, jogador.getNum_vitorias());
			ps.setInt(2, jogador.getNum_derrotas());
			ps.setInt(3, jogador.getId_jogador());	
			ps.executeUpdate();
			ps.close();
			conexao.fecharConnexao();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	public Jogador buscarUltimo() {
		jogadorRetorno = null;
		try {
			conexao.abrirConexao();
			String sql ="SELECT * FROM jogador ORDER BY id_jogador DESC LIMIT 1";
			Statement st = (Statement) conexao.getCon().createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				jogadorRetorno = new Jogador(rs.getInt("id_jogador")
						, rs.getInt("num_vitorias")
						, rs.getInt("num_derrotas")
						, rs.getString("nome"));
			}
			st.close();
			rs.close();
			conexao.fecharConnexao();
			return this.jogadorRetorno;
		} catch (Exception e) {
			e.printStackTrace();
			return jogadorRetorno;
		}
	}
	@Override
	public ArrayList<Jogador> ranking() {
		try {
			ArrayList<Jogador> jogador = new ArrayList<>();
			conexao.abrirConexao();
			String sql = "SELECT nick, id_jogador, nome, num_vitorias, num_derrotas FROM jogador ORDER BY num_vitorias DESC";
			PreparedStatement ps = (PreparedStatement) conexao.getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				jogador.add(new Jogador(rs.getInt("id_jogador")
						, rs.getInt("num_vitorias")
						, rs.getInt("num_derrotas")
						, rs.getString("nome")
						, rs.getString("nick")
						, ""));
			}
			ps.execute();
			ps.close();
			conexao.fecharConnexao();
			return jogador;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Jogador buscaJogadorId(Jogador jogador) {
		jogadorRetorno = null;
		try {
			conexao.abrirConexao();
			String sql ="SELECT * FROM jogador WHERE id_jogador = ?";
			PreparedStatement ps = (PreparedStatement) conexao.getCon().prepareStatement(sql);
			ps.setInt(1, jogador.getId_jogador());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				jogadorRetorno = new Jogador(rs.getInt("id_jogador")
						, rs.getInt("num_vitorias")
						, rs.getInt("num_derrotas")
						, rs.getString("nome")
						, rs.getString("nick")
						, rs.getString("senha"));
			}
			ps.close();
			rs.close();
			conexao.fecharConnexao();
			return this.jogadorRetorno;
		} catch (Exception e) {
			e.printStackTrace();
			return jogadorRetorno;
		}
	}
}
