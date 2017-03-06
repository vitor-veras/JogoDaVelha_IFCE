package ifce.edu.ed.model;

public class Jogador {
	private int id_jogador, num_vitorias, num_derrotas;
	private String nome, nick, senha;
	
	public Jogador(int id_jogador) {
		this.id_jogador = id_jogador;
	}
	public Jogador(int id_jogador, int num_vitorias, int num_derrotas, String nome) {
		this.id_jogador = id_jogador;
		this.num_vitorias = num_vitorias;
		this.num_derrotas = num_derrotas;
		this.nome = nome;
	}
	public Jogador(int num_vitorias, int num_derrotas, String nome) {
		this.id_jogador = 0;
		this.num_vitorias = num_vitorias;
		this.num_derrotas = num_derrotas;
		this.nome = nome;
	}
	public Jogador(int num_vitorias, int num_derrotas, String nome, String nick) {
		this.id_jogador = 0;
		this.num_vitorias = num_vitorias;
		this.num_derrotas = num_derrotas;
		this.nome = nome;
		this.nick = nick;
	}
	public Jogador(int num_vitorias, int num_derrotas, String nome, String nick, String senha) {
		this.id_jogador = 0;
		this.num_vitorias = num_vitorias;
		this.num_derrotas = num_derrotas;
		this.nome = nome;
		this.nick = nick;
		this.senha = senha;
	}
	
	public Jogador(int id_jogador, int num_vitorias, int num_derrotas, String nome, String nick, String senha) {
		this.id_jogador = id_jogador;
		this.num_vitorias = num_vitorias;
		this.num_derrotas = num_derrotas;
		this.nome = nome;
		this.nick = nick;
		this.senha = senha;
	}
	
	
	
	
	public int getId_jogador() {
		return id_jogador;
	}
	public void setId_jogador(int id_jogador) {
		this.id_jogador = id_jogador;
	}
	public int getNum_derrotas() {
		return num_derrotas;
	}
	public void setNum_derrotas(int num_derrotas) {
		this.num_derrotas = num_derrotas;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNum_vitorias() {
		return num_vitorias;
	}

	public void setNum_vitorias(int num_vitorias) {
		this.num_vitorias = num_vitorias;
	}
	
	
	
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	@Override
	public String toString() {
		return "\nNOME: "+ nome
				+ "\nWINS: "+ num_vitorias
				+ "\nLOSES: "+ num_derrotas 
				+ "\nNICK: " + nick + ".\n";

	}

}
