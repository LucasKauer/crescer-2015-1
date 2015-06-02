package filmator.model;

public enum Genero {
	ACAO("Ação"), ANIMACAO("Animação"), AVENTURA("Aventura"), COMEDIA("Comédia"), CULT(
			"Cult"), DRAMA("Drama"), FANTASIA("Fantasia"), FAROESTE("Faroeste"), FICCAO_CIENTIFICA(
			"Ficção Científica"), GUERRA("Guerra"), MUSICAL("Musical"), POLICIAL(
			"Policial"), ROMANCE("Romance"), SUSPENSE("Suspense"), TERROR(
			"Terro");

	private String descricao;

	private Genero(String descricao) {
		setDescricao(descricao);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}