package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import mestrecuca.LivroReceitasAtividade;
import mestrecuca.ReceitaNaoEncontradaException;
import mestrecuca.Ingrediente;
import mestrecuca.Receita;
import mestrecuca.UnidadeMedida;

import org.junit.Before;
import org.junit.Test;

public class LivroDaVovoTest {

	private LivroReceitasAtividade livro;
	
	@Before
	public void setUp(){
		livro = new LivroReceitasAtividade();
	}
	
	@Test
	public void quantidadeDeReceitasDeveSerZeroAntesDaInsercao() throws Exception {
		assertEquals(0, livro.getTodasReceitas().size());
	}
	
	@Test
	public void quantidadeDeReceitasDeveAumentarAposInsercao() throws Exception {
		assertEquals(0, livro.getTodasReceitas().size());
		livro.inserir(new Receita("Feijoada", null, null));
		assertEquals(1, livro.getTodasReceitas().size());
	}
	
	@Test
	public void buscaReceitaPeloNomeDeveEncontrarReceita() throws Exception {
		Receita feijoada = new Receita("Feijoada", null, null);
		livro.inserir(feijoada);
		assertEquals(feijoada, livro.buscaReceitaPeloNome("Feijoada"));
	}
	
	@Test(expected=ReceitaNaoEncontradaException.class)
	public void buscaReceitaPeloNomeDeveLancarExceptionEmBuscaInvalida() throws Exception {
		livro.buscaReceitaPeloNome("não existe");
	}
	
	@Test
	public void atualizaReceita() throws Exception {
		livro.inserir(new Receita("Feijoada", null, null));
		livro.atualizar("Feijoada", new Receita("Feijoada da Vovó", null, null));
		
		assertEquals(1, livro.getTodasReceitas().size());
		assertTrue(livro.buscaReceitaPeloNome("Feijoada da Vovó") != null);
	}
	
	@Test
	public void valorTotalDasReceitasDeveSerSomaDoValorDasReceitas() throws Exception {
		// Arrange
		List<Ingrediente> listaDeIngrediente = new ArrayList<>();
		List<Ingrediente> listaDeIngrediente2 = new ArrayList<>();
		
		listaDeIngrediente.add(new Ingrediente("Mel", 1, 10, UnidadeMedida.COLHER_SOPA));
		listaDeIngrediente.add(new Ingrediente("Queijo", 1, 5 , UnidadeMedida.COLHER_SOPA));
		
		Receita feijoada = new Receita("Feijoada com Queijo e Mel", listaDeIngrediente, null);
		livro.inserir(feijoada);
		
		listaDeIngrediente2.add(new Ingrediente("Mel", 2, 20, UnidadeMedida.COLHER_SOPA));
		listaDeIngrediente2.add(new Ingrediente("Queijo", 2, 10, UnidadeMedida.COLHER_SOPA));
		
		Receita arroz = new Receita("Arroz com Queijo e Mel", listaDeIngrediente2, null);
		livro.inserir(arroz);
		
		List<Receita> listaDeReceitas = new ArrayList<>();
		listaDeReceitas.add(feijoada);
		listaDeReceitas.add(arroz);
		// Act
		double resultado = livro.valorTotalReceitas(listaDeReceitas);
		
		// Assert
		assertEquals(45, resultado, 0.0005);
	}
	
	@Test
	public void buscaReceitasSemIngredientes() throws Exception {
		// Arrange
		List<Ingrediente> listaDeIngrediente = new ArrayList<>();
		List<Ingrediente> listaDeIngrediente2 = new ArrayList<>();
		
		listaDeIngrediente.add(new Ingrediente("Mel", 1, 10, UnidadeMedida.COLHER_SOPA));
		listaDeIngrediente.add(new Ingrediente("Queijo", 1, 5 , UnidadeMedida.COLHER_SOPA));
		
		Receita feijoada = new Receita("Feijoada com Queijo e Mel", listaDeIngrediente, null);
		livro.inserir(feijoada);
		
		listaDeIngrediente2.add(new Ingrediente("Mel", 2, 20, UnidadeMedida.COLHER_SOPA));
		listaDeIngrediente2.add(new Ingrediente("Queijo", 2, 10, UnidadeMedida.COLHER_SOPA));
		
		Receita arroz = new Receita("Arroz com Queijo e Mel", listaDeIngrediente2, null);
		livro.inserir(arroz);
		
		List<Ingrediente> listaDeIngredientesProibidos =  new ArrayList<>();
		listaDeIngredientesProibidos.add(new Ingrediente("Mel", 2, 20, UnidadeMedida.COLHER_SOPA));
		// Act
		List<Receita> receitasEncontradas = livro.buscaReceitasSemIngredientesProibidos(listaDeIngredientesProibidos);
		
		// Assert
		assertEquals(1, receitasEncontradas.size());
		assertEquals(arroz, receitasEncontradas.get(0));	
	}
		
	@Test
	public void excluiReceita() throws Exception {
		// Arrange
		livro.inserir(new Receita("Feijoada", null, null));
		
		// Act
		livro.excluir("Feijoada");
		 
		// Assert 
		assertEquals(0, livro.getTodasReceitas().size());
	}

	@Test(expected=ReceitaNaoEncontradaException.class)
	public void excluiReceitaNaoEncontrada() throws Exception {
		livro.excluir("não existe");
	}
	
	@Test
	public void geraListaDeComprasAgrupandoProdutosComMesmaUnidade() throws Exception {
		// Arrange
		List<Ingrediente> listaDeIngrediente = new ArrayList<>();
		List<Ingrediente> listaDeIngrediente2 = new ArrayList<>();
		
		listaDeIngrediente.add(new Ingrediente("Mel", 1, 10, UnidadeMedida.COLHER_SOPA));
		listaDeIngrediente.add(new Ingrediente("Queijo", 1, 5 , UnidadeMedida.COLHER_SOPA));
		
		Receita feijoada = new Receita("Feijoada com Queijo e Mel", listaDeIngrediente, null);
		livro.inserir(feijoada);
		
		listaDeIngrediente2.add(new Ingrediente("Mel", 2, 20, UnidadeMedida.COLHER_SOPA));
		listaDeIngrediente2.add(new Ingrediente("Queijo", 2, 10, UnidadeMedida.COLHER_SOPA));
		
		Receita arroz = new Receita("Arroz com Queijo e Mel", listaDeIngrediente2, null);
		livro.inserir(arroz);
		
		List<Receita> listaDeReceitasParaComprar = new ArrayList<>();
		listaDeReceitasParaComprar.add(feijoada);
		listaDeReceitasParaComprar.add(arroz);
		// Act
		List<Ingrediente> listaDeCompras = livro.geraListaDeCompras(listaDeReceitasParaComprar);
		
		// Assert
		assertEquals(2, listaDeCompras.size());
		assertTrue("Deve conter queijo na lista de compras", listaDeCompras.contains(new Ingrediente("Queijo", 1, 1, UnidadeMedida.KG)));
		assertTrue("Deve conter mel na lista de compras", listaDeCompras.contains(new Ingrediente("Mel", 1, 1, UnidadeMedida.COLHER_SOPA)));
	}
	
	@Test
	public void geraListaDeComprasAgrupandoProdutosComUnidadesDiferentes() throws Exception {
		// Arrange
		List<Ingrediente> listaDeIngrediente = new ArrayList<>();
		List<Ingrediente> listaDeIngrediente2 = new ArrayList<>();
		
		listaDeIngrediente.add(new Ingrediente("Mel", 1, 10, UnidadeMedida.COLHER_SOPA));
		listaDeIngrediente.add(new Ingrediente("Queijo", 1, 5 , UnidadeMedida.COLHER_SOPA));
		
		Receita feijoada = new Receita("Feijoada com Queijo e Mel", listaDeIngrediente, null);
		livro.inserir(feijoada);
		
		listaDeIngrediente2.add(new Ingrediente("Mel", 2, 20, UnidadeMedida.COLHER_SOPA));
		listaDeIngrediente2.add(new Ingrediente("Queijo", 2, 10, UnidadeMedida.COLHER_SOPA));
		
		Receita arroz = new Receita("Arroz com Queijo e Mel", listaDeIngrediente2, null);
		livro.inserir(arroz);

		List<Receita> listaDeReceitasParaComprar = new ArrayList<>();
		
		listaDeReceitasParaComprar.add(feijoada);
		listaDeReceitasParaComprar.add(arroz);
		// Act
		List<Ingrediente> listaDeCompras = livro.geraListaDeCompras(listaDeReceitasParaComprar);
		
		// Assert
		assertEquals(3, listaDeCompras.size());
		assertTrue("Deve conter queijo na lista de compras", listaDeCompras.contains(new Ingrediente("Queijo", 1, 1, UnidadeMedida.KG)));
		assertTrue("Deve conter colher de sopa de mel na lista de compras", listaDeCompras.contains(new Ingrediente("Mel", 1, 1, UnidadeMedida.COLHER_SOPA)));
		assertTrue("Deve conter colher de chá de mel na lista de compras", listaDeCompras.contains(new Ingrediente("Mel", 1, 1, UnidadeMedida.COLHER_CHA)));
	}
	


	
}
