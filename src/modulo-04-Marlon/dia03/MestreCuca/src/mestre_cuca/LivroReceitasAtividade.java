// andre_298

package mestre_cuca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LivroReceitasAtividade {
	List<Receita> livroDeReceita= new ArrayList<Receita>();
	
	public void inserir(Receita receita) {
		boolean receitaSemNome = receita.getNome().isEmpty();
		boolean receitaEhNula = receita.equals(null);
		if(receitaSemNome != true || receitaEhNula != true) {
			livroDeReceita.add(receita);
		} else {
			System.out.println("A receita informada é nula ou sem nome");
		}
	}
	
	public void atualizar(String nome, Receita receitaAtualizada) {
		Receita receita = null;
		int x = 0;
		for (int i = 0; i < livroDeReceita.size(); i++) {
			Receita receitaAtual = livroDeReceita.get(i);

			if(receitaAtual.getNome() == nome) {
				receita = livroDeReceita.get(i);
				/*boolean receitaEhNula = receita.equals(null);*/
				boolean receitaSemNome = receita.getNome().isEmpty();
				if(receitaSemNome == false /*|| receitaEhNula != true*/) {
					livroDeReceita.set(x, receitaAtualizada);
				}
				return;
			}
		}
		
		System.out.println("A receita informada é nula ou sem nome");
	}
	
	public void excluir(String nome) {
		for (int i = 0; i < livroDeReceita.size(); i++) {
			Receita receitaAtual = livroDeReceita.get(i);
			
			if(receitaAtual.getNome() == nome) {
				livroDeReceita.remove(i);
			}
		}
	}
	
	public List<Receita> getTodasReceitas() {
		return livroDeReceita;
	}
	
	public Receita buscaReceitaPeloNome(String nome) {
		for (int i = 0; i < livroDeReceita.size(); i++) {
			Receita receitaAtual = livroDeReceita.get(i);
			if(receitaAtual.getNome() == nome) {
				return livroDeReceita.get(i);
			}
		}
		
		throw new ReceitaNaoEncontradaException();
	}
	
	public double valorTotalReceitas(List<Receita> listaDeReceitas) {
		double valorTotal = 0;
		for (int i = 0; i < listaDeReceitas.size(); i++) {
			Receita receitaAtual = livroDeReceita.get(i);
			valorTotal += receitaAtual.valorTotalReceita(receitaAtual);
		}
		return valorTotal;
	}
	
	public List<Receita> protecaoAosAlergicos(List<Ingrediente> listaDeIngredientesDosAlergicos) {
		List<Receita> listaDeReceitaDosAlergicos = new ArrayList<>();
		
		for(int i = 0; i < livroDeReceita.size(); i++) {
			
			Receita receitaAtual = livroDeReceita.get(i);
			
			List<Ingrediente> listaIngredientesDaReceitaAtual = receitaAtual.getListaDeIngredientes();
			
			for(int j = 0; j < listaIngredientesDaReceitaAtual.size(); j++) {
				
				Ingrediente ingredienteAtual = listaIngredientesDaReceitaAtual.get(j);
				
				if(!listaDeIngredientesDosAlergicos.contains(ingredienteAtual) && !listaDeReceitaDosAlergicos.contains(receitaAtual)) {
					
					listaDeReceitaDosAlergicos.add(receitaAtual);
					continue;
					
				} else if(listaDeIngredientesDosAlergicos.contains(ingredienteAtual) && listaDeReceitaDosAlergicos.contains(receitaAtual)) {
						
					listaDeReceitaDosAlergicos.remove(receitaAtual);
					continue;
				}
				
				break;
			}
			
		}
		
		return listaDeReceitaDosAlergicos;
	}
	
	/*
	 * Lista de compras: faça um método que receba uma lista de receitas
	 * e retorne uma "lista de compras", agrupando todos os ingredientes
	 * que possuem o mesmo nome e unidade de medida.
	 */
	
	public List<Ingrediente> compras(List<Receita> listaDeReceitas) {
		List<Ingrediente> listaDeCompras = new ArrayList<>();
		Map<Ingrediente, String> compras = new HashMap<>();
		
		for (int i = 0; i < listaDeReceitas.size(); i++) {
			
		}
		
		return listaDeCompras;
	}
	
	public static void main(String[] args) {		
		/* // LISTA DE INGREDIENTES 1
		List<Ingrediente> listaDeIngrediente = new ArrayList<>();
		listaDeIngrediente.add(new Ingrediente("Ingrediente", 1, 2.0, UnidadeMedida.GRAMA));
		
		// LISTA DE INSTRUCAO 1
		List<Instrucao> listaDeInstrucao = new ArrayList<>();
		listaDeInstrucao.add(new Instrucao("Instrucao"));

		// LISTA DE RECEITA
		Receita receita = new Receita("Receita", listaDeIngrediente, listaDeInstrucao);
		
		// LISTA DE INGREDIENTES 2
		List<Ingrediente> listaDeIngrediente2 = new ArrayList<>();
		listaDeIngrediente.add(new Ingrediente("Ingrediente 2", 1, 2.0, UnidadeMedida.GRAMA));
		
		// LISTA DE INSTRUCAO 2
		List<Instrucao> listaDeInstrucao2 = new ArrayList<>();
		listaDeInstrucao.add(new Instrucao("Instrucao 2"));
		
		// LISTA DE RECEITA 2
		Receita receita2 = new Receita("Receita 2", listaDeIngrediente2, listaDeInstrucao2);
		
		LivroReceitasAtividade livro = new LivroReceitasAtividade();
		
		livro.inserir(receita);
		System.out.println(livro.getTodasReceitas());
		
		livro.atualizar("Receita", receita2);
		System.out.println(livro.getTodasReceitas());
		
		System.out.println(livro.buscaReceitaPeloNome("Receita 2"));
		
		//livro.excluir("Receita 2");
		//System.out.println(livro.getTodasReceitas()); */
		
	}
}
