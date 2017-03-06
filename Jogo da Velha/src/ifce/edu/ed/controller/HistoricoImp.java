package ifce.edu.ed.controller;

import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import ifce.edu.ed.interfaces.HistoricoDAO;
import ifce.edu.ed.model.Historico;
import ifce.edu.ed.model.Jogador;

public class HistoricoImp implements HistoricoDAO {

	@Override
	public boolean insereHistorico(Historico historico, char vencedor) {
		try {
			conexao.abrirConexao();
			String sql = "INSERT INTO historico VALUES (?, ?, ?, ?, NOW())";
			PreparedStatement ps = (PreparedStatement) conexao.getCon().prepareStatement(sql);
			
			ps.setInt(1, historico.getId_partida());
			ps.setInt(2, historico.getJ1().getId_jogador());
			ps.setInt(3, historico.getJ2().getId_jogador());
			ps.setString(4, String.valueOf(vencedor));
			
			ps.execute();	
			ps.close();
			conexao.fecharConnexao();
		} catch(Exception e) {
			System.out.println("Nao foi possivel inserir no historico.");
			e.printStackTrace();
		}
		return false;
	}

}
