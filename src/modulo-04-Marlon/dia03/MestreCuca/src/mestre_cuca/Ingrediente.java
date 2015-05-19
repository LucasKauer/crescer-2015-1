package mestre_cuca;

public class Ingrediente {
	private String nome;
	private double quantidade;
	private double valor;
	private UnidadeMedida unidadeMedida;
	
	public Ingrediente(String nome, double quantidade, double valor,UnidadeMedida unidadeMedida) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.valor = valor;
		this.unidadeMedida = unidadeMedida;
	}

	public String getNome() {
		return nome;
	}


	public double getQuantidade() {
		return quantidade;
	}


	public double getValor() {
		return valor;
	}


	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}

	@Override
	public String toString() {
		return getUnidadeMedida() + " de " + getNome();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((unidadeMedida == null) ? 0 : unidadeMedida.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingrediente other = (Ingrediente) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (unidadeMedida != other.unidadeMedida)
			return false;
		return true;
	}
}