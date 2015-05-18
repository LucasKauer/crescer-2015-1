package mestre_cuca;

import java.util.List;

public class Receita {
	private String nome;
	private List<Ingrediente> listaDeIngredientes;
	private List<Instrucao> listaDeInstrucao;
	
	public Receita(String nome, List<Ingrediente> listaDeIngredientes, List<Instrucao> listaDeInstrucao) {
		this.nome = nome;
		this.listaDeIngredientes = listaDeIngredientes;
		this.listaDeInstrucao = listaDeInstrucao;
	}
	
	public String getNome() {
		return nome;
	}
	
	public List<Ingrediente> getListaDeIngredientes() {
		return listaDeIngredientes;
	}
	
	public List<Instrucao> getListaDeInstrucao() {
		return listaDeInstrucao;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setListaDeIngredientes(List<Ingrediente> listaDeIngredientes) {
		this.listaDeIngredientes = listaDeIngredientes;
	}
	
	public void setListaDeInstrucao(List<Instrucao> listaDeInstrucao) {
		this.listaDeInstrucao = listaDeInstrucao;
	}

}
