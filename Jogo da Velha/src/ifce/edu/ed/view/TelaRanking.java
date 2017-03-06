package ifce.edu.ed.view;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import ifce.edu.ed.controller.Ranking;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaRanking extends JFrame {

	private static final long serialVersionUID = -1518829535917787861L;
	private JPanel contentPane;
	private JTable tbRanking;
	private Ranking ranking;
	/**
	 * Create the frame.
	 */
	public TelaRanking() {
		setVisible(true);
		setTitle("Ranking #");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(115)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
							.addGap(113)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(17)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
		);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new TelaInicial().setVisible(true);;
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(btnVoltar, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
		);
		panel.setLayout(gl_panel);
		
		tbRanking = new JTable();
		tbRanking.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nick", "Id", "Nome", "Vitorias", "Derrotas"
			}
		));
		scrollPane.setViewportView(tbRanking);
		contentPane.setLayout(gl_contentPane);
		
		ranking = new Ranking(tbRanking);
		ranking.pesquisa();
	}
}
