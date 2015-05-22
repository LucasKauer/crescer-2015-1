package filmator.model;

public class Filme {

	private String nome;
	private Genero genero;
	
	public Filme(){}
	
	public Filme(String nome){
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
}
