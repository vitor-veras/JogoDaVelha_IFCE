package ifce.edu.ed.controller;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ifce.edu.ed.model.Jogador;


public class Ranking {
	private JTable tbRanking;
	private JogadorImp jogadorImp = new JogadorImp();
	private ArrayList<Jogador> jogador;
	public Ranking(JTable tbRanking) {
		this.tbRanking = tbRanking;
	}
	
	public void pesquisa() {
		jogador = jogadorImp.ranking();
		DefaultTableModel dftm = (DefaultTableModel) tbRanking.getModel();
		for (int i = 0; i < jogador.size(); i++) {
			dftm.addRow(new Object[]{jogador.get(i).getNick()
					,jogador.get(i).getId_jogador()
					,jogador.get(i).getNome()
					,jogador.get(i).getNum_vitorias()
					,jogador.get(i).getNum_derrotas()});
		}
	}
	

}
