package ifce.edu.ed.structs;

public class No<T> {

	private T t;
	private No<T> proximo;
	
	public No(T t) {
		this.t = t;
		this.proximo = null;
	}
	public No(T t, No<T> proximo) {
		this.t = t;
		this.proximo = proximo;
	}
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
	public No<T> getProximo() {
		return proximo;
	}
	public void setProximo(No<T> proximo) {
		this.proximo = proximo;
	}
	
	
}
