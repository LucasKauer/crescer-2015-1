package filmator.model;

public enum Genero {
	COMEDIA("Comédia"),
	ACAO("Ação"),
	Ficcao_Cientifica("Ficção Científica");
	
	private String descricao;
	
	private Genero(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}