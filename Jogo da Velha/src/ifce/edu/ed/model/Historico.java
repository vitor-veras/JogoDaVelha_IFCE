package ifce.edu.ed.model;

public class Historico {
	
	private int id_partida;
	private Jogador j1, j2;
	private char vencedor;
	private String data;

	
	public Historico(int id_partida, Jogador j1, Jogador j2) {
		this.id_partida = id_partida;
		this.j1 = j1;
		this.j2 = j2;
		this.vencedor = '0';
	}
	public Historico(Jogador j1, Jogador j2) {
		this.id_partida = 0;
		this.j1 = j1;
		this.j2 = j2;
		this.vencedor = '0';
	}
	public Historico(int id_partida, Jogador j1, Jogador j2, char vencedor, String data) {
		this.id_partida = 0;
		this.j1 = j1;
		this.j2 = j2;
		this.vencedor = vencedor;
		this.data = data;
	}
	
	public int getId_partida() {
		return id_partida;
	}


	public void setId_partida(int id_partida) {
		this.id_partida = id_partida;
	}


	public Jogador getJ1() {
		return j1;
	}

	public void setJ1(Jogador j1) {
		this.j1 = j1;
	}
	
	
	public Jogador getJ2() {
		return j2;
	}

	public void setJ2(Jogador j2) {
		this.j2 = j2;
	}
	public String getVencedor() {
		if (vencedor == '1')
				return "Jogador 1 ganhou";
		else if (vencedor == '2')
				return "Jogador 2 ganhou";
		else return "Jogo empatado";
	}
	public void setVencedor(char vencedor) {
		this.vencedor = vencedor;
	}
	
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Historico [ID : " + id_partida + ", Jogador 1 : " + j1 + ", Jogador 2 : " + j2 + ", Vencedor : " + vencedor + "]";
	}
	
	
	
}
