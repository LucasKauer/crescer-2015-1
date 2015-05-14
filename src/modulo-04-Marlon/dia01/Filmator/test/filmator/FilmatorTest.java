package filmator;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class FilmatorTest {
	
	@Test
	public void createActorAndReturingHisName() throws Exception {
		Actor actor1 = new Actor("Kurt");
		
		assertEquals("Kurt", actor1.getName());
	}
	
	@Test
	public void createMovieAndReturingHisName() throws Exception {
		Movie movie = new Movie("Glee", Gender.MUSICAL);
		
		assertEquals("Glee", movie.getName());
	}
	
	@Test
	public void createMovieAndAddActors() throws Exception {
		Movie movie = new Movie("Glee", Gender.MUSICAL);
		
		Actor actor1 = new Actor("Kurt");
		Actor actor2 = new Actor("Blaine");
		Actor actor3 = new Actor("Santana");
		
		movie.newActor(actor1);
		movie.newActor(actor2);
		movie.newActor(actor3);
		
		ArrayList<Actor> expected = new ArrayList<Actor>();
		expected.add(actor1);
		expected.add(actor2);
		expected.add(actor3);

		assertEquals(expected, movie.getListOfActors());
	}
	
	@Test
	public void actorsContainsStrWithoutReturningOneActor() throws Exception {
		Actor actor1 = new Actor("Kurt Hummel");
		Actor actor2 = new Actor("Amigo do Kurt");
		Actor actor3 = new Actor("Não deve retornar esse!");
		
		Movie movie = new Movie("Glee", Gender.MUSICAL);
		
		movie.newActor(actor1);
		movie.newActor(actor2);
		movie.newActor(actor3);
		
		ArrayList<Actor> actual = movie.actorsContainsStr("Kurt");
		
		ArrayList<Actor> expected = new ArrayList<Actor>();
		expected.add(actor1);
		expected.add(actor2);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void addMovieInTheCollectionAndPlayMovie() throws Exception {
		Movie movie = new Movie("Glee", Gender.MUSICAL);
		
		Netflox.addMovieInTheCollection(movie);
		
		Netflox.playMovie(movie);
	}
	
	@Test
	public void addMovieInTheCollectionAndNotPlayMovie() throws Exception {
		Movie movie = new Movie("Glee", Gender.MUSICAL);
		Movie movie2 = new Movie("Love, Rose", Gender.ROMANCE);
		
		Netflox.addMovieInTheCollection(movie);
		Netflox.playMovie(movie2);
	}
	
	@Test
	public void createReport() throws Exception {
		Movie movie = new Movie("Glee", Gender.MUSICAL);
		Movie movie2 = new Movie("Love, Rose", Gender.ROMANCE);
		
		Netflox.addMovieInTheCollection(movie);
		Netflox.addMovieInTheCollection(movie2);
		
		Netflox.playMovie(movie);
		Netflox.playMovie(movie2);
		Netflox.playMovie(movie2);
		
		// retornar um musical a mais porque o ENUM nao foi resetado (PRECISA CORRIGIR ISSO)
		Netflox.createReport();
	}
}