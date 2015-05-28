package filmator.model;

public class Filme {

	private String nome;
	private Genero genero;
	private int anoLancamento;
	private String diretor;
	private String sinopse;
	private String imagem;

	public Filme() {
	}

	public Filme(String nome, Genero genero, int anoLancamento, String diretor,
			String sinopse, String imagem) {
		setNome(nome);
		setGenero(genero);
		setAnoLancamento(anoLancamento);
		setDiretor(diretor);
		setSinopse(sinopse);
		setImagem(imagem);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

}
