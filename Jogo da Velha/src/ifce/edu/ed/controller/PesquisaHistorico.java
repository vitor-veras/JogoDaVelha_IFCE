package ifce.edu.ed.controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ifce.edu.ed.model.Historico;
import ifce.edu.ed.model.Jogador;

public class PesquisaHistorico {

	private JTable tbHistorico;
	private JogadorImp jogadorImp = new JogadorImp();
	private ArrayList<Historico> historico;
	public PesquisaHistorico(JTable tbHistorico) {
		this.tbHistorico = tbHistorico;
	}
	
	public void pesquisar(Jogador jogador) {
		try {
			DefaultTableModel dfm = (DefaultTableModel) tbHistorico.getModel();
			dfm.setRowCount(0);
			historico = jogadorImp.pegarHistorico(jogador);
			Jogador jogador1, jogador2;
			for (int i = 0; i < historico.size(); i++) {
				jogador1 = jogadorImp.buscaJogadorId(historico.get(i).getJ1());
				jogador2 = jogadorImp.buscaJogadorId(historico.get(i).getJ2());
				dfm.addRow(new Object[] {
						historico.get(i).getData()
						, jogador1.getNome() + " - " + jogador1.getNick()
						, jogador2.getNome() + " - " + jogador2.getNick()
						, historico.get(i).getVencedor()
				});
			}
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Usuario ou senha inválido.", "Falha", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
}
