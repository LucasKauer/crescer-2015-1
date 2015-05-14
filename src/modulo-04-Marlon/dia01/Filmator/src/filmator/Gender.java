package filmator;

public enum Gender {
	
	ACAO(0), ANIMACAO(0), AVENTURA(0), COMEDIA(0), CULT(0), DRAMA(0), FANTASIA(0),
	FAROESTE(0), FICCAO_CIENTIFICA(0), GUERRA(0), MUSICAL(0), POLICIAL(0), ROMANCE(0),
	SUSPENSE(0), TERROR(0);
	
	private int viewsNumber;
	
	/* public static void main(String[] args) {
		System.out.println(Genero.ANIMACAO);
	} */
	
	private Gender(int viewsCount) {
		this.viewsNumber = viewsCount;
	}
	
	// incrementa +1 toda vez que o metodo for chamado (conta o numero de visualizacoes)
	public void viewsCount() {
		this.viewsNumber++;
	}
	
	public int getviewsCount() {
		return this.viewsNumber;
	}
	
	@Override
	public String toString() {
		String result = this.name();
		result += ": " + this.viewsNumber;
		return result;
	}
}