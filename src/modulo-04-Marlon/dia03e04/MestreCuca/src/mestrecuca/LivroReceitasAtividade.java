// Skype: andre_298
/**
 * Atividade do Livro de Receita
 * @author CWI Software
 * 
 * Created by Lucas Kauer on 19/05/2015.
 * Last updated on: 20/05/2015
 */

package mestrecuca;

import java.util.ArrayList;
import java.util.LinkedHashMap;
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
			System.out.println("A receita informada � nula ou sem nome");
		}
	}
	
	public void atualizar(String nome, Receita receitaAtualizada) {
		int x = 0;
		for (Receita receitaAtual : livroDeReceita) {

			if(receitaAtual.getNome() == nome) {
				/*boolean receitaEhNula = receita.equals(null);*/
				boolean receitaSemNome = receitaAtual.getNome().isEmpty();
				if(receitaSemNome == false /*|| receitaEhNula != true*/) {
					livroDeReceita.set(x, receitaAtualizada);
				}
				return;
			}
		}
		
		System.out.println("A receita informada � nula ou sem nome");
	}
	
	public void excluir(String nome) {
		/*for (int i = 0; i < livroDeReceita.size(); i++) {
			Receita receitaAtual = livroDeReceita.get(i);
			
			if(receitaAtual.getNome() == nome) {
				livroDeReceita.remove(i);
			}
		}*/
		
		for (Receita receitaAtual : livroDeReceita) {
			if(receitaAtual.getNome() == nome) {
				livroDeReceita.remove(receitaAtual);
			}
		}
	}
	
	public List<Receita> getTodasReceitas() {
		return livroDeReceita;
	}
	
	public Receita buscaReceitaPeloNome(String nome) {
		/*for (int i = 0; i < livroDeReceita.size(); i++) {
			Receita receitaAtual = livroDeReceita.get(i);
			if(receitaAtual.getNome() == nome) {
				return livroDeReceita.get(i);
			}
		}*/
		
		for (Receita receitaAtual : livroDeReceita) {
			if(receitaAtual.getNome() == nome) {
				return receitaAtual;
			}
		}
		
		throw new ReceitaNaoEncontradaException();
	}
	
	public double valorTotalReceitas(List<Receita> listaDeReceitas) {
		double valorTotal = 0;
		for (Receita receitaAtual : listaDeReceitas) {
			valorTotal += receitaAtual.valorTotalReceita();
		}
		return valorTotal;
	}
	
	public List<Receita> buscaReceitasSemIngredientesProibidos(List<Ingrediente> listaDeIngredientesDosAlergicos) {
		List<Receita> listaDeReceitaDosAlergicos = new ArrayList<>();
		
		for (Receita receitaAtual : livroDeReceita) {
						
			List<Ingrediente> listaIngredientesDaReceitaAtual = receitaAtual.getListaDeIngredientes();
			
			for(int j = 0; j < listaIngredientesDaReceitaAtual.size(); j++) {
				
				Ingrediente ingredienteAtual = listaIngredientesDaReceitaAtual.get(j);
				
				if(!listaDeIngredientesDosAlergicos.contains(ingredienteAtual) && !listaDeReceitaDosAlergicos.contains(receitaAtual)) {
					
					listaDeReceitaDosAlergicos.add(receitaAtual);
					continue;
					
				} else if(listaDeIngredientesDosAlergicos.contains(ingredienteAtual) && listaDeReceitaDosAlergicos.contains(receitaAtual)) {
						
					listaDeReceitaDosAlergicos.remove(receitaAtual);
					break;
				}
				
				break;
			}
			
		}
		
		return listaDeReceitaDosAlergicos;
	}
	
	public List<Ingrediente> geraListaDeCompras(List<Receita> listaDeReceitas) {
		List<Ingrediente> listaDeCompras = new ArrayList<>();
		Map<Ingrediente, Double> compras = new LinkedHashMap<>();
		// LinkedHashMap resolve o bug do Mil�nio
		
		for (Receita receitaAtual : livroDeReceita) {
			for(Ingrediente ingredienteAtual : receitaAtual.getListaDeIngredientes()) {
				if(!compras.containsKey(ingredienteAtual)) {
					compras.put(ingredienteAtual, ingredienteAtual.getQuantidade());
					// listaDeCompras.add(ingredienteAtual);
				} else {
					double valorAntigo = compras.get(ingredienteAtual);
					double valorAtual = ingredienteAtual.getQuantidade();
					
					compras.put(ingredienteAtual, valorAntigo+valorAtual);
				}
			}	
		}
		
		for (Ingrediente chaveAtual : compras.keySet()) {
			Double valorAtual = compras.get(chaveAtual);
			Ingrediente ingredienteAtual = new Ingrediente(chaveAtual.getNome(), valorAtual, chaveAtual.getQuantidade(), chaveAtual.getUnidadeMedida());
			listaDeCompras.add(ingredienteAtual);
		}
		
		return listaDeCompras;
	}
	
	public static void main(String[] args) {		
		// LISTA DE INGREDIENTES 1
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
		//System.out.println(livro.getTodasReceitas());
		
	}
}
