package ifce.edu.ed.interfaces;

import java.util.ArrayList;

import ifce.edu.ed.model.Conexao;
import ifce.edu.ed.model.Historico;
import ifce.edu.ed.model.Jogador;

public interface HistoricoDAO {

	Conexao conexao = new Conexao();
	
	public boolean insereHistorico(Historico historico, char vencedor);
}
