package filmator;

public enum Genero {
	
	ACAO(0), ANIMACAO(0), AVENTURA(0), COMEDIA(0), CULT(0), DRAMA(0), FANTASIA(0),
	FAROESTE(0), FICCAO_CIENTIFICA(0), GUERRA(0), MUSICAL(0), POLICIAL(0), ROMANCE(0),
	SUSPENSE(0), TERROR(0);
	
	private int value;
	
	private Genero(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void countValue() {
		this.value++;
	}
	
	@Override
	public String toString() {
		String result = this.name();
		result += ": " + this.value;
		return result;
	}
	
	/* public static void main(String[] args) {
		System.out.println(Genero.ANIMACAO);
	} */
	
}