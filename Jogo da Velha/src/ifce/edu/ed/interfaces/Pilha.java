package ifce.edu.ed.interfaces;

import ifce.edu.ed.structs.No;

public interface Pilha<T> {
	public void inserePilha(No<T> no);
	public No<T> removePilha();
	public void imprimePilha();
	public boolean esvaziaPilha();
}

