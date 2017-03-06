package ifce.edu.ed.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ifce.edu.ed.controller.JogadorImp;
import ifce.edu.ed.controller.PesquisaHistorico;
import ifce.edu.ed.model.Jogador;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaHistorico extends JFrame {

	private static final long serialVersionUID = -5996154931560668356L;
	private JPanel contentPane;
	private JTextField tfNick;
	private JPasswordField tfSenha;
	private JTable tbHistorico;
	private PesquisaHistorico ph;
	private JogadorImp jogadorImp = new JogadorImp();

	/**
	 * Create the frame.
	 */
	public TelaHistorico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
							.addGap(3)))
					.addGap(0))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
					.addGap(6))
		);
		
		tbHistorico = new JTable();
		tbHistorico.setRowSelectionAllowed(false);
		tbHistorico.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Data Partida", "Jogador - X", "Jogador - O", "Vencedor"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, false, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tbHistorico.getColumnModel().getColumn(1).setResizable(false);
		scrollPane.setViewportView(tbHistorico);
		
		JLabel lblNewLabel = new JLabel("Nick:");
		
		tfNick = new JTextField();
		tfNick.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		
		tfSenha = new JPasswordField();
		
		JButton btnVerHistorico = new JButton("Ver Historico");
		btnVerHistorico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfNick.getText().trim().isEmpty() || String.valueOf(tfSenha.getPassword()).isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
				} else {
					Jogador jogador = jogadorImp.buscarJogador(new Jogador(0, 0, 0, " "
							, tfNick.getText().trim()
							, String.valueOf(tfSenha.getPassword())));
					ph.pesquisar(jogador);
				}
			}
		});
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new TelaInicial().setVisible(true);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfNick, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSenha)
						.addComponent(tfSenha, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
					.addGap(65))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(101)
					.addComponent(btnVerHistorico, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnVoltar, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
					.addGap(137))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblSenha))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfNick, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfSenha, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnVerHistorico)
						.addComponent(btnVoltar))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);	
		ph = new PesquisaHistorico(tbHistorico);

	}

}
