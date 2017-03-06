package ifce.edu.ed.controller;

public class Pontuacao {
	
	private int pJogador1 = 0, pJogador2 = 0;
	
	public int vitoria_jogador1() {
		return ++pJogador1;
	}
	public int vitoria_jogador2() {
		return ++pJogador2;
	}

	public void reiniciar() {
		pJogador1 = pJogador2 = 0;
	}
	/**
	 * @return the pJogador1
	 */
	public int getpJogador1() {
		return pJogador1;
	}
	/**
	 * @param pJogador1 the pJogador1 to set
	 */
	public void setpJogador1(int pJogador1) {
		this.pJogador1 = pJogador1;
	}
	/**
	 * @return the pJogador2
	 */
	public int getpJogador2() {
		return pJogador2;
	}
	/**
	 * @param pJogador2 the pJogador2 to set
	 */
	public void setpJogador2(int pJogador2) {
		this.pJogador2 = pJogador2;
	}
	
}
