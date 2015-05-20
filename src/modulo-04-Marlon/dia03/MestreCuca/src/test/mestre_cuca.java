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
		Ingrediente i2 = new Ingrediente("Farinha", 1, 2.5,
				UnidadeMedida.XICARA);
		Ingrediente i3 = new Ingrediente("Leite", 1, 2.0, UnidadeMedida.XICARA);
		Ingrediente i4 = new Ingrediente("Chocolate", 500, 5.0,
				UnidadeMedida.GRAMA);
		// LISTA DE INGREDIENTES 1
		List<Ingrediente> listaDeIngredienteOvoFarinha = new ArrayList<>();

		listaDeIngredienteOvoFarinha.add(i);
		listaDeIngredienteOvoFarinha.add(i2);

		// LISTA DE INSTRUCAO 1
		List<Instrucao> listaDeInstrucaoOvoFarinha = new ArrayList<>();
		listaDeInstrucaoOvoFarinha.add(new Instrucao("Instrucao"));

		// LISTA DE RECEITA
		Receita receitaOvoFarinha = new Receita("Ovo|Farinha",
				listaDeIngredienteOvoFarinha, listaDeInstrucaoOvoFarinha);

		// LISTA DE INGREDIENTES 1
		List<Ingrediente> listaDeIngredienteLeiteChocolate = new ArrayList<>();
		listaDeIngredienteLeiteChocolate.add(i3);
		listaDeIngredienteLeiteChocolate.add(i4);

		// LISTA DE INSTRUCAO 1
		List<Instrucao> listaDeInstrucaoLeiteChocolate = new ArrayList<>();
		listaDeInstrucaoLeiteChocolate.add(new Instrucao("Instrucao"));

		// LISTA DE RECEITA
		Receita receitaLeiteChocolate = new Receita("Leite|Chocolate",
				listaDeIngredienteLeiteChocolate,
				listaDeInstrucaoLeiteChocolate);

		LivroReceitasAtividade livroOFLC2 = new LivroReceitasAtividade();
		livroOFLC2.inserir(receitaOvoFarinha);
		livroOFLC2.inserir(receitaLeiteChocolate);

		// LISTA DE INGREDIENTES
		List<Ingrediente> listaDeIngredienteAlergicos = new ArrayList<>();
		listaDeIngredienteAlergicos.add(i);
		listaDeIngredienteAlergicos.add(i2);

		// System.out.println(livroOFLC2.protecaoAosAlergicos(listaDeIngredienteAlergicos));
		List<Receita> expecteds = new ArrayList<Receita>();
		expecteds.add(receitaLeiteChocolate);
		List<Receita> actuals = livroOFLC2
				.protecaoAosAlergicos(listaDeIngredienteAlergicos);

		assertEquals(expecteds, actuals);
	}

	@Test
	public void protecaoAosAlergicos2() throws Exception {
		Ingrediente i = new Ingrediente("Ovo", 1, 0.5, UnidadeMedida.UNIDADE);
		Ingrediente i2 = new Ingrediente("Farinha", 1, 2.5,
				UnidadeMedida.XICARA);
		Ingrediente i3 = new Ingrediente("Leite", 1, 2.0, UnidadeMedida.XICARA);
		Ingrediente i4 = new Ingrediente("Chocolate", 500, 5.0,
				UnidadeMedida.GRAMA);
		// LISTA DE INGREDIENTES 1
		List<Ingrediente> listaDeIngredienteOvoFarinha = new ArrayList<>();

		listaDeIngredienteOvoFarinha.add(i);
		listaDeIngredienteOvoFarinha.add(i2);

		// LISTA DE INSTRUCAO 1
		List<Instrucao> listaDeInstrucaoOvoFarinha = new ArrayList<>();
		listaDeInstrucaoOvoFarinha.add(new Instrucao("Instrucao"));

		// LISTA DE RECEITA
		Receita receitaOvoFarinha = new Receita("Ovo|Farinha",
				listaDeIngredienteOvoFarinha, listaDeInstrucaoOvoFarinha);

		// LISTA DE INGREDIENTES 1
		List<Ingrediente> listaDeIngredienteLeiteChocolate = new ArrayList<>();
		listaDeIngredienteLeiteChocolate.add(i3);
		listaDeIngredienteLeiteChocolate.add(i4);

		// LISTA DE INSTRUCAO 1
		List<Instrucao> listaDeInstrucaoLeiteChocolate = new ArrayList<>();
		listaDeInstrucaoLeiteChocolate.add(new Instrucao("Instrucao"));

		// LISTA DE RECEITA
		Receita receitaLeiteChocolate = new Receita("Leite|Chocolate",
				listaDeIngredienteLeiteChocolate,
				listaDeInstrucaoLeiteChocolate);

		LivroReceitasAtividade livroOFLC = new LivroReceitasAtividade();
		livroOFLC.inserir(receitaOvoFarinha);
		livroOFLC.inserir(receitaLeiteChocolate);

		// LISTA DE INGREDIENTES PROIBIDOS
		List<Ingrediente> listaDeIngredienteAlergicos = new ArrayList<>();
		listaDeIngredienteAlergicos.add(i);

		List<Receita> expecteds = new ArrayList<Receita>();
		expecteds.add(receitaLeiteChocolate);
		List<Receita> actuals = livroOFLC
				.protecaoAosAlergicos(listaDeIngredienteAlergicos);

		assertEquals(expecteds, actuals);
	}
	
	@Test
	public void protecaoAosAlergicos3() throws Exception {
		Ingrediente farinha = new Ingrediente("Farinha", 3, 2.5,
				UnidadeMedida.XICARA);
		Ingrediente fermento = new Ingrediente("Fermento", 1, 2.25,
				UnidadeMedida.COLHER_SOPA);
		Ingrediente ovo = new Ingrediente("Ovo", 1, 0.5, UnidadeMedida.UNIDADE);

		// LISTA DE INGREDIENTES
		List<Ingrediente> listaIngredientesBolo = new ArrayList<Ingrediente>();
		listaIngredientesBolo.add(farinha);
		listaIngredientesBolo.add(fermento);
		listaIngredientesBolo.add(ovo);

		List<Ingrediente> listaIngredientesPanqueca = new ArrayList<Ingrediente>();
		listaIngredientesPanqueca.add(farinha);
		listaIngredientesPanqueca.add(ovo);

		// LISTA DE INSTRUCAO 1
		List<Instrucao> instrucaoBolo = new ArrayList<Instrucao>();
		instrucaoBolo.add(new Instrucao("Misturar e por no forno"));
		List<Instrucao> instrucaoPanqueca = new ArrayList<Instrucao>();
		instrucaoPanqueca.add(new Instrucao("Instrucao"));

		// LISTA DE RECEITA
		Receita bolo = new Receita("Bolo", listaIngredientesBolo, instrucaoBolo);
		Receita panqueca = new Receita("Panqueca", listaIngredientesPanqueca,
				instrucaoPanqueca);

		// LIVRO DE RECEITAS
		LivroReceitasAtividade livroReceitas = new LivroReceitasAtividade();
		livroReceitas.inserir(bolo);
		livroReceitas.inserir(panqueca);

		// LISTA DE INGREDIENTES PROIBIDOS
		List<Ingrediente> listaDeIngredienteProibidos = new ArrayList<Ingrediente>();
		listaDeIngredienteProibidos.add(fermento);
		
		List<Receita> expecteds = new ArrayList<>();
		expecteds.add(panqueca);
		List<Receita> actuals = livroReceitas.protecaoAosAlergicos(listaDeIngredienteProibidos);
		assertEquals(expecteds, actuals);
	}

	@Test
	public void listaDeComprasTest() throws Exception {
		// LISTA DE INGREDIENTES
		List<Ingrediente> listaIngredientesBolo = new ArrayList<Ingrediente>();
		listaIngredientesBolo.add(new Ingrediente("Farinha", 4, 2.5,
				UnidadeMedida.XICARA));
		listaIngredientesBolo.add(new Ingrediente("Chocolate", 500, 2.25,
				UnidadeMedida.GRAMA));
		listaIngredientesBolo.add(new Ingrediente("Ovo", 4, 0.5,
				UnidadeMedida.UNIDADE));

		List<Ingrediente> listaIngredientesPanqueca = new ArrayList<Ingrediente>();
		listaIngredientesPanqueca.add(new Ingrediente("Farinha", 1, 2.5,
				UnidadeMedida.XICARA));
		listaIngredientesPanqueca.add(new Ingrediente("Ovo", 1, 0.5,
				UnidadeMedida.UNIDADE));

		// LISTA DE INSTRUCAO
		List<Instrucao> instrucaoBolo = new ArrayList<Instrucao>();
		instrucaoBolo.add(new Instrucao("Instrucao do Bolo"));
		List<Instrucao> instrucaoPanqueca = new ArrayList<Instrucao>();
		instrucaoPanqueca.add(new Instrucao("Instrucao da Panqueca"));

		// RECEITAS
		Receita bolo = new Receita("Bolo", listaIngredientesBolo, instrucaoBolo);
		Receita panqueca = new Receita("Panqueca", listaIngredientesPanqueca,
				instrucaoPanqueca);

		// LISTA DE RECEITAS
		List<Receita> listaReceitas = new ArrayList<Receita>();
		listaReceitas.add(bolo);
		listaReceitas.add(panqueca);

		// LIVRO DE RECEITAS
		LivroReceitasAtividade livroReceitas = new LivroReceitasAtividade();
		livroReceitas.inserir(bolo);
		livroReceitas.inserir(panqueca);

		List<Ingrediente> expecteds = new ArrayList<Ingrediente>();
		expecteds.add(new Ingrediente("Farinha", 5, 0.5, UnidadeMedida.XICARA));
		expecteds.add(new Ingrediente("Chocolate", 500, 0.5,
				UnidadeMedida.GRAMA));
		expecteds.add(new Ingrediente("Ovo", 5, 0.5, UnidadeMedida.UNIDADE));

		List<Ingrediente> actuals = livroReceitas.compras(listaReceitas);
		assertEquals(expecteds, actuals);
	}
}