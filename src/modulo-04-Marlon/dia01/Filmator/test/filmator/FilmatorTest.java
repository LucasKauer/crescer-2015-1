package filmator;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class FilmatorTest {
	
	@Test
	public void actorsContainsStrWithoutOneActor() throws Exception {
		Ator actor1 = new Ator("Ator 1");
		Ator actor2 = new Ator("Ator 2");
		Ator actor3 = new Ator("N�o deve retornar esse!");
		
		Filme movie = new Filme("Filme (Musical)", Genero.MUSICAL);
		
		movie.newActor(actor1);
		movie.newActor(actor2);
		movie.newActor(actor3);
		
		ArrayList<Ator> actual = movie.actorsContainsStr("Ator");
		
		ArrayList<Ator> expected = new ArrayList<Ator>();
		expected.add(actor1);
		expected.add(actor2);
		
		assertEquals(expected, actual);
	}
}