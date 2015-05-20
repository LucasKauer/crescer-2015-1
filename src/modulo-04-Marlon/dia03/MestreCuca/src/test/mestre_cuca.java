package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import mestre_cuca.Ingrediente;
import mestre_cuca.Instrucao;
import mestre_cuca.LivroReceitasAtividade;
import mestre_cuca.Receita;
import mestre_cuca.UnidadeMedida;

import org.junit.Test;

public class mestre_cuca {
	@Test
	public void protecaoAosAlergicos() throws Exception {
		Ingrediente i = new Ingrediente("Ovo", 1, 0.5, UnidadeMedida.UNIDADE);
		Ingrediente i2 = new Ingrediente("Farinha", 1, 2.5, UnidadeMedida.XICARA);
		Ingrediente i3 = new Ingrediente("Leite", 1, 2.0, UnidadeMedida.XICARA);
		Ingrediente i4 = new Ingrediente("Chocolate", 500, 5.0, UnidadeMedida.GRAMA);
		// LISTA DE INGREDIENTES 1
		List<Ingrediente> listaDeIngrediente3 = new ArrayList<>();
		
		listaDeIngrediente3.add(i);
		listaDeIngrediente3.add(i2);

		// LISTA DE INSTRUCAO 1
		List<Instrucao> listaDeInstrucao3 = new ArrayList<>();
		listaDeInstrucao3.add(new Instrucao("Instrucao"));

		// LISTA DE RECEITA
		Receita receita3 = new Receita("Ovo|Farinha", listaDeIngrediente3, listaDeInstrucao3);
		
		// LISTA DE INGREDIENTES 1
		List<Ingrediente> listaDeIngrediente4 = new ArrayList<>();
		listaDeIngrediente4.add(i3);
		listaDeIngrediente4.add(i4);

		// LISTA DE INSTRUCAO 1
		List<Instrucao> listaDeInstrucao4 = new ArrayList<>();
		listaDeInstrucao4.add(new Instrucao("Instrucao"));

		// LISTA DE RECEITA
		Receita receita4 = new Receita("Leite|Chocolate", listaDeIngrediente4, listaDeInstrucao4);
		
		LivroReceitasAtividade livro = new LivroReceitasAtividade();
		livro.inserir(receita3);
		livro.inserir(receita4);
		
		// LISTA DE INGREDIENTES
		List<Ingrediente> listaDeIngredienteAlergicos = new ArrayList<>();
		listaDeIngredienteAlergicos.add(i);
		listaDeIngredienteAlergicos.add(i2);
		
		System.out.println(livro.protecaoAosAlergicos(listaDeIngredienteAlergicos));
	}
	
	@Test
	public void protecaoAosAlergicos2() throws Exception {
		Ingrediente i = new Ingrediente("Ovo", 1, 0.5, UnidadeMedida.UNIDADE);
		Ingrediente i2 = new Ingrediente("Farinha", 1, 2.5, UnidadeMedida.XICARA);
		Ingrediente i3 = new Ingrediente("Leite", 1, 2.0, UnidadeMedida.XICARA);
		Ingrediente i4 = new Ingrediente("Chocolate", 500, 5.0, UnidadeMedida.GRAMA);
		// LISTA DE INGREDIENTES 1
		List<Ingrediente> listaDeIngrediente3 = new ArrayList<>();
		
		listaDeIngrediente3.add(i);
		listaDeIngrediente3.add(i2);

		// LISTA DE INSTRUCAO 1
		List<Instrucao> listaDeInstrucao3 = new ArrayList<>();
		listaDeInstrucao3.add(new Instrucao("Instrucao"));

		// LISTA DE RECEITA
		Receita receita3 = new Receita("Ovo|Farinha", listaDeIngrediente3, listaDeInstrucao3);
		
		// LISTA DE INGREDIENTES 1
		List<Ingrediente> listaDeIngrediente4 = new ArrayList<>();
		listaDeIngrediente4.add(i3);
		listaDeIngrediente4.add(i4);

		// LISTA DE INSTRUCAO 1
		List<Instrucao> listaDeInstrucao4 = new ArrayList<>();
		listaDeInstrucao4.add(new Instrucao("Instrucao"));

		// LISTA DE RECEITA
		Receita receita4 = new Receita("Leite|Chocolate", listaDeIngrediente4, listaDeInstrucao4);
		
		LivroReceitasAtividade livro2 = new LivroReceitasAtividade();
		livro2.inserir(receita3);
		livro2.inserir(receita4);
		
		// LISTA DE INGREDIENTES PROIBIDOS
		List<Ingrediente> listaDeIngredienteAlergicos = new ArrayList<>();
		listaDeIngredienteAlergicos.add(i);
		// listaDeIngredienteAlergicos.add(i2);
		
		System.out.println(livro2.protecaoAosAlergicos(listaDeIngredienteAlergicos));
	}
	
	@Test
	public void protecaoAosAlergicos3() throws Exception {
		//LISTA DE INGREDIENTES
		List<Ingrediente> listaIngredientesBolo = new ArrayList<Ingrediente>();
		listaIngredientesBolo.add(new Ingrediente("Farinha", 3, 2.5, UnidadeMedida.XICARA));
		listaIngredientesBolo.add(new Ingrediente("Fermento", 1, 2.25, UnidadeMedida.COLHER_SOPA));
		listaIngredientesBolo.add(new Ingrediente("Ovo", 1, 0.5, UnidadeMedida.UNIDADE));

		List<Ingrediente> listaIngredientesPanqueca = new ArrayList<Ingrediente>();
		listaIngredientesPanqueca.add(new Ingrediente("Farinha", 3, 2.5, UnidadeMedida.XICARA));
		listaIngredientesPanqueca.add(new Ingrediente("Ovo", 1, 0.5, UnidadeMedida.UNIDADE));		

		//LISTA DE INSTRUCAO
		List<Instrucao> instrucaoBolo = new ArrayList<Instrucao>();
		instrucaoBolo.add(new Instrucao("Misturar e por no forno"));
		List<Instrucao> instrucaoPanqueca = new ArrayList<Instrucao>();
		instrucaoPanqueca.add(new Instrucao("Instrucao"));

		//RECEITAS
		Receita bolo = new Receita("Bolo", listaIngredientesBolo, instrucaoBolo);
		Receita panqueca = new Receita("Panqueca", listaIngredientesPanqueca, instrucaoPanqueca);
		
		//LISTA DE RECEITAS
		List<Receita> listaReceitas = new ArrayList<Receita>();
		listaReceitas.add(bolo);
		listaReceitas.add(panqueca);
		
		//LIVRO DE RECEITAS
		LivroReceitasAtividade livroReceitas = new LivroReceitasAtividade();
		livroReceitas.inserir(bolo);
		livroReceitas.inserir(panqueca);
				
		System.out.println(livroReceitas.compras(listaReceitas));
	}
}