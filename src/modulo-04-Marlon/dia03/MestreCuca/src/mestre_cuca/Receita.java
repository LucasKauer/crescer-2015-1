package mestre_cuca;

import java.util.ArrayList;
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
	
	public static void main(String[] args) {
		// LISTA DE INGREDIENTES 1
		List<Ingrediente> listaDeIngrediente = new ArrayList<>();
		listaDeIngrediente.add(new Ingrediente("Ingrediente", 1, 2.0, UnidadeMedida.GRAMA));
		listaDeIngrediente.add(new Ingrediente("Ingrediente 2", 1, 3.0, UnidadeMedida.UNIDADE));
				
		// LISTA DE INSTRUCAO 1
		List<Instrucao> listaDeInstrucao = new ArrayList<>();
		listaDeInstrucao.add(new Instrucao("Instrucao"));

		// LISTA DE RECEITA
		Receita receita = new Receita("Receita", listaDeIngrediente, listaDeInstrucao);
		
		System.out.println(receita.valorTotalReceita());
	}
	
	public double valorTotalReceita() {
		double valorTotal = 0;
		for (Ingrediente ingredienteAtual : listaDeIngredientes) {
			valorTotal += ingredienteAtual.getValor();
		}
		return valorTotal;
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
	
	@Override
	public String toString() {
		return getNome();
	}

}
