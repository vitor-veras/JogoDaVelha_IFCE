package ifce.edu.ed.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import ifce.edu.ed.model.Jogador;

public class Eventos {

	private Controlador c;
	private JButton[] o;
	private boolean jogada;
	public Eventos(Jogador jogador1, Jogador jogador2, JLabel msg, JLabel j1, JLabel j2, Object[] o) {
		c = new Controlador(jogador1, jogador2);
		jogada = !c.isJogada();
		this.o = (JButton[]) o;
		addEvento(msg, j1, j2, jogada);
	}
	
	private void addEvento(JLabel msg, JLabel j1, JLabel j2, boolean jogada) {
		
		for (JButton bt : o) {
			bt.setFocusable(false);
			bt.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					c.realizarJogada(bt, msg);
					c.verificaJogadas(msg, j1, j2, o);
				}
			});
		}
		
	}
	public Controlador getC() {
		return c;
	}
	public void setC(Controlador c) {
		this.c = c;
	}
	
}
