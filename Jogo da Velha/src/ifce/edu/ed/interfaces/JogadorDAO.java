package ifce.edu.ed.interfaces;

import java.util.ArrayList;

import ifce.edu.ed.model.Conexao;
import ifce.edu.ed.model.Historico;
import ifce.edu.ed.model.Jogador;

public interface JogadorDAO {
	
	Conexao conexao = new Conexao();
	
	public boolean insererJogador(Jogador jogador);
	public ArrayList<Historico> pegarHistorico(Jogador jogador);
	public Jogador buscarJogador(Jogador jogador);
	public ArrayList<Jogador> buscarTodos();
	public boolean atualizaJogador(Jogador jogador);
	public ArrayList<Jogador> ranking();
	public Jogador buscaJogadorId(Jogador jogador) ;

	
}
