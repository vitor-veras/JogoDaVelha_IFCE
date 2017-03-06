package ifce.edu.ed.view;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ifce.edu.ed.controller.JogadorImp;
import ifce.edu.ed.model.Jogador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;

public class JogadorVsJogador extends JFrame {

	private static final long serialVersionUID = -1541735514665723325L;
	private JPanel contentPane;
	protected boolean jogar = false;
	protected Jogador jogador1, jogador2;
	protected JogadorImp jogadorImp = new JogadorImp();
	private JTextField txtNome;
	private JTextField txtNick;
	private JPasswordField txtSenha;
	private JButton btSalvar;
	private JButton btLimpar;
	private JPanel panel_1;
	private JButton btnVoltar;
	private JLabel lblJogador;
	private JLabel lblNick_1;
	private JTextField tfNick1;
	private JLabel lblSenha_1;
	private JPasswordField tfSenha1;
	private JLabel label;
	private JTextField tfNick2;
	private JLabel label_1;
	private JPasswordField tfSenha2;
	private JLabel lblJogador_1;
	private JButton btnEntrar;


	
	/**
	 * Create the frame.
	 */
	public JogadorVsJogador() {
		setTitle("Cadastrar Jogador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "CADASTRO", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "OP\u00C7\u00D5ES", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
							.addGap(4))
						.addComponent(panel_1, 0, 0, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
		);
		
		lblJogador = new JLabel("Jogador 1:");
		
		lblNick_1 = new JLabel("Nick:");
		
		tfNick1 = new JTextField();
		tfNick1.setColumns(10);
		
		lblSenha_1 = new JLabel("Senha:");
		
		tfSenha1 = new JPasswordField();
		
		label = new JLabel("Nick:");
		
		tfNick2 = new JTextField();
		tfNick2.setColumns(10);
		
		label_1 = new JLabel("Senha:");
		
		tfSenha2 = new JPasswordField();
		
		lblJogador_1 = new JLabel("Jogador 2:");
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jogador1 = jogadorImp.buscarJogador(new Jogador(0, 0, " "
						, tfNick1.getText().trim()
						, String.valueOf(tfSenha1.getPassword())));
				jogador2 = jogadorImp.buscarJogador(new Jogador(0, 0, " "
						, tfNick2.getText().trim()
						, String.valueOf(tfSenha2.getPassword())));
				if(jogador1 == null) {
					JOptionPane.showMessageDialog(null, "Jogador 1 : Usuario ou Senha incorreto."
							,"Falha", JOptionPane.ERROR_MESSAGE);
					
				}
				if(jogador2 == null) {
					JOptionPane.showMessageDialog(null, "Jogador 2 : Usuario ou Senha incorreto."
							,"Falha", JOptionPane.ERROR_MESSAGE);
				}
				if(jogador1 != null && jogador2 != null && !jogador1.getNick().equals(jogador2.getNick())) {
					setVisible(false);
					new TelaPrincipal(jogador1, jogador2).setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Nicks iguais, não é possível conectar."
							,"Falha", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new TelaInicial().setVisible(true);
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(143)
							.addComponent(btnEntrar, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblJogador, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(10)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(lblSenha_1, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
										.addComponent(lblNick_1, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(tfNick1, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
								.addComponent(tfSenha1, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_1, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
								.addComponent(label, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
							.addGap(4)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addComponent(tfSenha2)
								.addComponent(tfNick2, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblJogador_1, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
							.addGap(122))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(btnVoltar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(130)))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblJogador)
						.addComponent(lblJogador_1))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfNick2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label))
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_1)
								.addComponent(tfSenha2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNick_1)
								.addComponent(tfNick1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSenha_1)
								.addComponent(tfSenha1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEntrar)
						.addComponent(btnVoltar))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel("Nome: ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		
		JLabel lblNick = new JLabel("Nick:");
		lblNick.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		
		txtNick = new JTextField();
		txtNick.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		
		txtSenha = new JPasswordField();
		
		btSalvar = new JButton("Salvar");
		btSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNick.getText().trim().isEmpty() 
						|| txtNome.getText().trim().isEmpty() 
						|| String.valueOf(txtSenha.getPassword()).trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha os campos."
					,"Registro", JOptionPane.ERROR_MESSAGE);
				} else {
					Jogador jogadorRegistro = new Jogador(0, 0
							, txtNome.getText().trim()
							, txtNick.getText().trim()
							, String.valueOf(txtSenha.getPassword()));
					
					if(jogadorImp.insererJogador(jogadorRegistro)) {
						JOptionPane.showMessageDialog(null, "Jogador Registrado.\n" + jogadorRegistro.toString()
						,"Registro", JOptionPane.INFORMATION_MESSAGE);
						btLimpar.doClick();
					} else {
						JOptionPane.showMessageDialog(null, "Ocorreu um erro ao registrar o jogador.\n" + jogadorRegistro.toString()
						,"Registro", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		btLimpar = new JButton("Limpar");
		btLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText("");
				txtSenha.setText("");
				txtNick.setText("");
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addGap(173)
							.addComponent(lblNick, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(txtNome, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(txtNick, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(txtSenha, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
											.addGap(18))
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(lblSenha)
											.addGap(138)))
									.addComponent(btSalvar, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btLimpar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(12)))
							.addGap(29)))
					.addGap(15))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(lblNick))
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNick, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(23)
					.addComponent(lblSenha)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btSalvar)
						.addComponent(btLimpar))
					.addContainerGap(13, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
