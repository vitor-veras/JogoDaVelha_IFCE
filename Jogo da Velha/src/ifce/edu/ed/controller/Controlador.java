package ifce.edu.ed.controller;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import ifce.edu.ed.model.Historico;
import ifce.edu.ed.model.Jogador;
import ifce.edu.ed.structs.No;
import ifce.edu.ed.structs.PilhaImpDesfaz;

public class Controlador {
	
	private boolean jogada = true; //Jogador 01
	private Pontuacao p = new Pontuacao();
	private PilhaImpDesfaz gravaPilha = new PilhaImpDesfaz();
	private Jogador jogador1, jogador2;
	private Historico historico;
	private HistoricoImp historicoImp = new HistoricoImp();
	private JogadorImp jogadorImp = new JogadorImp();
	public Controlador(Jogador jogador1, Jogador jogador2) {
		this.jogador1 = jogador1;
		this.jogador2 = jogador2;
		historico = new Historico(jogador1, jogador2);
	}
	public void realizarJogada(JButton bt, JLabel msg) {
		 if(!bt.getText().equals(" ")) {
				JOptionPane.showMessageDialog(null
						, "Este lugar está preenchido."
						, "Alerta"
						, JOptionPane.WARNING_MESSAGE);
				return;
		} else if (!isJogada() && bt.getText().equals(" ")) {
			bt.setText("O");
			msg.setText("Vez de " + jogador1.getNome() + ".");
			setJogada(true);
		} else if (isJogada() && bt.getText().equals(" ")) {
			bt.setText("X");
			msg.setText("Vez de " + jogador2.getNome() + ".");
			setJogada(false);

		} 
		gravaPilha.inserePilha(new No<JButton>(bt, null));
	}
	public void verificaJogadas(JLabel msg, JLabel j1, JLabel j2, Object[] o) {
		try {
			JButton[] b = (JButton[]) o;
			if((b[0].getText().charAt(0) == b[1].getText().charAt(0) &&
					b[0].getText().charAt(0) == b[2].getText().charAt(0) &&
					b[0].getText().charAt(0) == 'X') ||
				(b[3].getText().charAt(0) == b[4].getText().charAt(0) &&
					b[3].getText().charAt(0) == b[5].getText().charAt(0) &&
					b[3].getText().charAt(0) == 'X') ||
				(b[6].getText().charAt(0) == b[7].getText().charAt(0) &&
					b[6].getText().charAt(0) == b[8].getText().charAt(0) &&
					b[6].getText().charAt(0) == 'X') ||
				(b[0].getText().charAt(0) == b[4].getText().charAt(0) &&
					b[0].getText().charAt(0) == b[8].getText().charAt(0) &&
					b[0].getText().charAt(0) == 'X') ||
				(b[2].getText().charAt(0) == b[4].getText().charAt(0) &&
					b[2].getText().charAt(0) == b[6].getText().charAt(0) &&
					b[2].getText().charAt(0) == 'X') ||
				(b[0].getText().charAt(0) == b[3].getText().charAt(0) &&
					b[0].getText().charAt(0) == b[6].getText().charAt(0) &&
					b[0].getText().charAt(0) == 'X') ||
				(b[1].getText().charAt(0) == b[4].getText().charAt(0) &&
					b[1].getText().charAt(0) == b[7].getText().charAt(0) &&
					b[1].getText().charAt(0) == 'X') ||
				(b[2].getText().charAt(0) == b[5].getText().charAt(0) &&
					b[2].getText().charAt(0) == b[8].getText().charAt(0) &&
					b[2].getText().charAt(0) == 'X')) {
				msg.setText(jogador1.getNome() + " GANHOU!");
				j1.setText(String.valueOf(p.vitoria_jogador1()));
				historicoImp.insereHistorico(historico, '1');
				jogador1.setNum_vitorias(jogador1.getNum_vitorias() + 1);
				jogador2.setNum_derrotas(jogador2.getNum_derrotas() + 1);
				jogadorImp.atualizaJogador(jogador1);
				jogadorImp.atualizaJogador(jogador2);
				if((JOptionPane.showConfirmDialog(null
						, "Deseja continuar jogando?"
						, "Mensagem"
						, JOptionPane.YES_NO_OPTION)) == JOptionPane.YES_OPTION) {
					for (JButton bt : b) {
						bt.setText(" ");
					}
					if(!isJogada()) {
						msg.setText("Vez de " + jogador2.getNome() + ".");
					} else {
						msg.setText("Vez de " + jogador1.getNome() + ".");
					}
					gravaPilha.esvaziaPilha();
				} else {
					System.exit(0);
				}
			} else if((b[0].getText().charAt(0) == b[1].getText().charAt(0) &&
					b[0].getText().charAt(0) == b[2].getText().charAt(0) &&
					b[0].getText().charAt(0) == 'O') ||
				(b[3].getText().charAt(0) == b[4].getText().charAt(0) &&
					b[3].getText().charAt(0) == b[5].getText().charAt(0) &&
					b[3].getText().charAt(0) == 'O') ||
				(b[6].getText().charAt(0) == b[7].getText().charAt(0) &&
					b[6].getText().charAt(0) == b[8].getText().charAt(0) &&
					b[6].getText().charAt(0) == 'O') ||
				(b[0].getText().charAt(0) == b[4].getText().charAt(0) &&
					b[0].getText().charAt(0) == b[8].getText().charAt(0) &&
					b[0].getText().charAt(0) == 'O') ||
				(b[2].getText().charAt(0) == b[4].getText().charAt(0) &&
					b[2].getText().charAt(0) == b[6].getText().charAt(0) &&
					b[2].getText().charAt(0) == 'O') ||
				(b[0].getText().charAt(0) == b[3].getText().charAt(0) &&
					b[0].getText().charAt(0) == b[6].getText().charAt(0) &&
					b[0].getText().charAt(0) == 'O') ||
				(b[1].getText().charAt(0) == b[4].getText().charAt(0) &&
					b[1].getText().charAt(0) == b[7].getText().charAt(0) &&
					b[1].getText().charAt(0) == 'O') ||
				(b[2].getText().charAt(0) == b[5].getText().charAt(0) &&
					b[2].getText().charAt(0) == b[8].getText().charAt(0) &&
					b[2].getText().charAt(0) == 'O')) {
				msg.setText(jogador2.getNome() + " GANHOU!");
				j2.setText(String.valueOf(p.vitoria_jogador2()));	
				historicoImp.insereHistorico(historico, '2');
				jogador2.setNum_vitorias(jogador2.getNum_vitorias() + 1);
				jogador1.setNum_derrotas(jogador1.getNum_derrotas() + 1);
				jogadorImp.atualizaJogador(jogador1);
				jogadorImp.atualizaJogador(jogador2);
				if((JOptionPane.showConfirmDialog(null
						, "Deseja continuar jogando?"
						, "Mensagem"
						, JOptionPane.YES_NO_OPTION)) == JOptionPane.YES_OPTION) {
					for (JButton bt : b) {
						bt.setText(" ");
					}	
					if(!isJogada()) {
						msg.setText("Vez de " + jogador2.getNome() + ".");
					} else {
						msg.setText("Vez de " + jogador1.getNome() + ".");
					}
					gravaPilha.esvaziaPilha();
				} else {
					System.exit(0);
				}
			} else if(b[0].getText().charAt(0) != ' ' && b[5].getText().charAt(0) != ' ' && 
					b[1].getText().charAt(0) != ' ' &&  b[6].getText().charAt(0) != ' ' && 
					b[2].getText().charAt(0) != ' ' &&  b[7].getText().charAt(0) != ' ' && 
					b[3].getText().charAt(0) != ' ' &&  b[8].getText().charAt(0) != ' ' && 
					b[4].getText().charAt(0) != ' ' ) {
				msg.setText("O jogo empatou!!");
				historicoImp.insereHistorico(historico, '0');
				if((JOptionPane.showConfirmDialog(null
						, "Deseja continuar jogando?"
						, "Mensagem"
						, JOptionPane.YES_NO_OPTION)) == JOptionPane.YES_OPTION) {
					for (JButton bt : b) {
						bt.setText(" ");
					}						
					if(isJogada()) {
						msg.setText("Vez de " + jogador1.getNome() + ".");
					} else {
						msg.setText("Vez de " + jogador2.getNome() + ".");
					}
					gravaPilha.esvaziaPilha();
				} else {
					System.exit(0);
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void desfazJogada(PilhaImpDesfaz p, JLabel msg, Object[] o) {
		try {
			No<JButton> no = p.removePilha();
			int index = Integer.parseInt( ((JButton) no.getT()).getName());
			System.out.println(index);
			
			((JButton[]) o)[index].setText(" ");
			if(isJogada()) {
				msg.setText("Vez de " + jogador2.getNome() + ".");
			} else {
				msg.setText("Vez de " + jogador1.getNome() + ".");
			}
			setJogada(!isJogada());
		} catch(NullPointerException npe) {
			JOptionPane.showMessageDialog(null, "Não é possível refazer jogada, não há jogadas a serem refeitas.", "Alerta", JOptionPane.WARNING_MESSAGE);
		}
	}



	public Pontuacao getP() {
		return p;
	}
	public void setP(Pontuacao p) {
		this.p = p;
	}
	public PilhaImpDesfaz getGravaPilha() {
		return gravaPilha;
	}

	public boolean isJogada() {
		return jogada;
	}
	public void setJogada(boolean jogada) {
		this.jogada = jogada;		
	}


}
