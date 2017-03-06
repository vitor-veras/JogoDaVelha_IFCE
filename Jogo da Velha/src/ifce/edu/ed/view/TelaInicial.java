package ifce.edu.ed.view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInicial extends JFrame {

	private static final long serialVersionUID = -7717669545767606084L;
	private JPanel contentPane;
	
	public TelaInicial() {
		setTitle("Jogo da #");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 406, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblJogoDa = new JLabel("Jogo da #");
		lblJogoDa.setBounds(5, 5, 380, 84);
		lblJogoDa.setForeground(Color.DARK_GRAY);
		lblJogoDa.setHorizontalAlignment(SwingConstants.CENTER);
		lblJogoDa.setFont(new Font("Serif", Font.ITALIC, 43));
		contentPane.add(lblJogoDa);
		
		JButton btnEntrar = new JButton("P vs P");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					setVisible(false);
					new JogadorVsJogador().setVisible(true);;
			}
		});
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnEntrar.setBounds(110, 100, 159, 58);
		contentPane.add(btnEntrar);
		
		JButton btnPvia = new JButton("Ranking");
		btnPvia.setEnabled(true);
		btnPvia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new TelaRanking();
				}
		});
		btnPvia.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnPvia.setBounds(110, 169, 159, 58);
		contentPane.add(btnPvia);
		
		JButton btHistorico = new JButton("Hist\u00F3rico");
		btHistorico.setToolTipText("Em breve.");
		btHistorico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new TelaHistorico().setVisible(true);
			}
		});
		btHistorico.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btHistorico.setBounds(110, 238, 159, 58);
		contentPane.add(btHistorico);
		
		JLabel lblPPlayer = new JLabel("P = Player");
		lblPPlayer.setBounds(5, 408, 57, 14);
		contentPane.add(lblPPlayer);
		
		JLabel lblNewLabel = new JLabel(" \u00A9 Todos os direitos reservados, Kappa");
		lblNewLabel.setBounds(84, 408, 213, 14);
		contentPane.add(lblNewLabel);
	}
}
