package mestre_cuca;

public class Ingrediente {
	String nome;
	double quantidade;
	UnidadeMedida unidadeMedida;
	
	public Ingrediente(String nome, double quantidade, UnidadeMedida unidadeMedida) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.unidadeMedida = unidadeMedida;
	}
}
