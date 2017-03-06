package ifce.edu.ed.view;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.border.LineBorder;

import ifce.edu.ed.controller.Eventos;
import ifce.edu.ed.model.Jogador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {


	private static final long serialVersionUID = -6095200132371558905L;
	private JPanel contentPane;
	private JButton btJogada00, btJogada01, btJogada02, 
	btJogada10, btJogada11, btJogada12, 
	btJogada20, btJogada21, btJogada22;
	private Eventos e;
	protected Jogador jogador1; 
	protected Jogador jogador2;
	
	/**
	 * Create the frame.
	 */
	public TelaPrincipal(Jogador jogador1, Jogador jogador2) {
		this.jogador1 = jogador1;
		this.jogador2 = jogador2;
		setResizable(false);
		setTitle("Jogo da Velha");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 1, 5, 5));
		
		JPanel panelGame = new JPanel();
		panelGame.setBackground(new Color(0, 0, 0));
		contentPane.add(panelGame);
		panelGame.setLayout(new GridLayout(3, 3, 7, 5));
		
		btJogada00 = new JButton(" ");
		panelGame.add(btJogada00);
		
		btJogada01 = new JButton(" ");
		panelGame.add(btJogada01);
		
		btJogada02 = new JButton(" ");
		panelGame.add(btJogada02);
		
		btJogada10 = new JButton(" ");
		panelGame.add(btJogada10);
		
		btJogada11 = new JButton(" ");
		panelGame.add(btJogada11);
		
		btJogada12 = new JButton(" ");
		panelGame.add(btJogada12);
		
		btJogada20 = new JButton(" ");
		panelGame.add(btJogada20);
		
		btJogada21 = new JButton(" ");
		panelGame.add(btJogada21);
		
		btJogada22 = new JButton(" ");
		panelGame.add(btJogada22);
		
		JButton o[] = {btJogada00, btJogada01, btJogada02, 
						btJogada10, btJogada11, btJogada12,
						btJogada20, btJogada21, btJogada22};
		
		for (int i = 0; i < o.length; i++) {
			((JButton) o[i]).setName(String.valueOf(i));
		}
		
		JPanel panelFoot = new JPanel();
		contentPane.add(panelFoot);
		panelFoot.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panelStatus = new JPanel();
		panelStatus.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelFoot.add(panelStatus);
		panelStatus.setLayout(null);
		
		JLabel lblPontuao = new JLabel("PONTUA\u00C7\u00C3O");
		lblPontuao.setBounds(55, 29, 91, 17);
		panelStatus.add(lblPontuao);
		lblPontuao.setForeground(new Color(30, 144, 255));
		lblPontuao.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblJogador1 = new JLabel(jogador1.getNome());
		lblJogador1.setForeground(new Color(0, 128, 0));
		lblJogador1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblJogador1.setBounds(10, 91, 91, 22);
		panelStatus.add(lblJogador1);
		
		JLabel lblJogador2 = new JLabel(jogador2.getNome());
		lblJogador2.setForeground(new Color(65, 105, 225));
		lblJogador2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblJogador2.setBounds(10, 124, 91, 22);
		panelStatus.add(lblJogador2);
		
		JLabel lblPts1 = new JLabel("0");
		lblPts1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPts1.setBounds(156, 94, 21, 17);
		panelStatus.add(lblPts1);
		
		JLabel lblPts2 = new JLabel("0");
		lblPts2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPts2.setBounds(156, 127, 21, 17);
		panelStatus.add(lblPts2);
		
		JPanel panelInfo = new JPanel();
		panelInfo.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelFoot.add(panelInfo);
		panelInfo.setLayout(null);
		
		JLabel lblInformao = new JLabel("INFORMA\u00C7\u00C3O");
		lblInformao.setForeground(new Color(165, 42, 42));
		lblInformao.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInformao.setBounds(55, 29, 106, 14);
		panelInfo.add(lblInformao);
		
		JLabel lblMsg = new JLabel("Vez de " + jogador1.getNome() + ".");
		lblMsg.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsg.setForeground(new Color(0, 0, 128));
		lblMsg.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMsg.setBounds(10, 108, 192, 43);
		panelInfo.add(lblMsg);
		
		e = new Eventos(jogador1, jogador2, lblMsg, lblPts1, lblPts2, o);
		
		JButton btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				if(!lblPts1.getText().equals("0") || !lblPts2.getText().equals("0") ) {
					if(JOptionPane.showConfirmDialog(null
							, "Deseja reiniciar a contagem?"
							, "Alerta"
							, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						lblPts1.setText("0");
						lblPts2.setText("0");
						lblMsg.setText("<html>O jogo foi reiniciado.<br/>"
								+ "<center>Vez de " + jogador1.getNome() + ".<center></html>");
						for (JButton b : o) {
							b.setText(" ");
						}
						e.getC().setJogada(true);
						e.getC().getP().setpJogador1(0);
						e.getC().getP().setpJogador2(0);
						e.getC().getGravaPilha().esvaziaPilha();
					}
				} else {
					JOptionPane.showMessageDialog(null
							, "O jogo não pode ser reiniciado."
							, "Alerta"
							, JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnReiniciar.setBackground(new Color(255, 255, 255));
		btnReiniciar.setForeground(new Color(128, 0, 0));
		btnReiniciar.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 11));
		btnReiniciar.setBounds(10, 191, 91, 17);
		btnReiniciar.setFocusable(false);
		panelStatus.add(btnReiniciar);
		
		JButton btnRefazer = new JButton("Refazer");
		btnRefazer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg01) {
				e.getC().desfazJogada(e.getC().getGravaPilha(), lblMsg, o);
			}
		});
		btnRefazer.setForeground(new Color(128, 0, 0));
		btnRefazer.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 11));
		btnRefazer.setFocusable(false);
		btnRefazer.setBackground(Color.WHITE);
		btnRefazer.setBounds(116, 191, 91, 17);
		panelStatus.add(btnRefazer);
	}
}
