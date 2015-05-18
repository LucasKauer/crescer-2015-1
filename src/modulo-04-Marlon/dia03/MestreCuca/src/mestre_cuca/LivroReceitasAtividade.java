package mestre_cuca;

import java.util.ArrayList;
import java.util.List;

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
		
		for (int i = 0; i < livroDeReceita.size(); i++) {
			Receita receitaAtual = livroDeReceita.get(i);

			if(receitaAtual.getNome() == nome) {
				receita = livroDeReceita.get(i);
				break;
			}
		}
		
		boolean receitaSemNome = nome.isEmpty();
		boolean receitaEhNula = receita.equals(null);
		if(receitaSemNome != true || receitaEhNula != true) {
			receita.setNome(nome);
			receita.setListaDeIngredientes(receitaAtualizada.getListaDeIngredientes());
			receita.setListaDeInstrucao(receitaAtualizada.getListaDeInstrucao());
		} else {
			System.out.println("A receita informada é nula ou sem nome");
		}
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
	
	public static void main(String[] args) {		
		// LISTA DE INGREDIENTES 1
		List<Ingrediente> listaDeIngrediente = new ArrayList<>();
		listaDeIngrediente.add(new Ingrediente("Ingrediente", 1, UnidadeMedida.GRAMA));
		
		// LISTA DE INSTRUCAO 1
		List<Instrucao> listaDeInstrucao = new ArrayList<>();
		listaDeInstrucao.add(new Instrucao("Instrucao"));

		// LISTA DE RECEITA
		Receita receita = new Receita("Receita", listaDeIngrediente, listaDeInstrucao);
		
		// LISTA DE INGREDIENTES 2
		List<Ingrediente> listaDeIngrediente2 = new ArrayList<>();
		listaDeIngrediente.add(new Ingrediente("Ingrediente 2", 1, UnidadeMedida.GRAMA));
		
		// LISTA DE INSTRUCAO 2
		List<Instrucao> listaDeInstrucao2 = new ArrayList<>();
		listaDeInstrucao.add(new Instrucao("Instrucao 2"));
		
		// LISTA DE RECEITA 2
		Receita receita2 = new Receita("Receita 2", listaDeIngrediente, listaDeInstrucao);
		
		LivroReceitasAtividade livro = new LivroReceitasAtividade();
		
		livro.inserir(receita);
		System.out.println(livro.getTodasReceitas());
		
		//livro.atualizar("Receita 2", receita2);
		//System.out.println(livro.getTodasReceitas());
		
		//System.out.println(livro.buscaReceitaPeloNome("Receita 2"));
		
		//livro.excluir("Receita 2");
		//System.out.println(livro.getTodasReceitas());
	}
}
