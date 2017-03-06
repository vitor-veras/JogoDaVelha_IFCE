package ifce.edu.ed.structs;


import javax.swing.JButton;

import ifce.edu.ed.interfaces.Pilha;

public class PilhaImpDesfaz implements Pilha<JButton> {
	
	private No<JButton> header = null;
	
	
	@Override
	public void inserePilha(No<JButton> no) {
		if(header == null) {
			header = no;
		} else {
			No<JButton> noAux = header;
			while(noAux.getProximo() != null) {
				noAux = noAux.getProximo();
			}
			noAux.setProximo(no);
		}
		imprimePilha();
	}

	@Override
	public No<JButton> removePilha() {
		No<JButton> noRetorno = null;
		if(header.getProximo() == null) {
			noRetorno = header;
			header = null;
		} else {
			No<JButton> noAux = header;
			while(noAux.getProximo().getProximo() != null) {
				noAux = noAux.getProximo();
			}
			noRetorno = noAux.getProximo();
			noAux.setProximo(null);
		}
		return noRetorno;
	}


	@Override
	public void imprimePilha() {
		No<JButton> noAux = header;
		while(noAux != null) {
			System.out.print(((JButton)noAux.getT()).getName() + " ");
			noAux = noAux.getProximo();
		}
		System.out.println();
		
	}


	@Override
	public boolean esvaziaPilha() {
		header = null;
		return true;
	}







	
	
}
