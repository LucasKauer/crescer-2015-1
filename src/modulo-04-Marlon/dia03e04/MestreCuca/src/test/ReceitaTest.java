package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import mestrecuca.Ingrediente;
import mestrecuca.Receita;
import mestrecuca.UnidadeMedida;

import org.junit.Test;


public class ReceitaTest {

	@Test
	public void valorTotalReceitaDeveSerSomaDoValorDosIngredientes() throws Exception {
		List<Ingrediente> listaDeIngrediente = new ArrayList<>();
		
		listaDeIngrediente.add(new Ingrediente("Feijão", 0.5, 5, UnidadeMedida.KG));
		listaDeIngrediente.add(new Ingrediente("Sal", 1, 1, UnidadeMedida.COLHER_SOPA));
		
		Receita receita = new Receita("Feijoada", listaDeIngrediente, null);
		
		double resultado = receita.valorTotalReceita();
		assertEquals(6, resultado, 0.0005);
	}
	

}
