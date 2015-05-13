package filmator;

import java.util.ArrayList;

public class Netflox {
	ArrayList<Filme> listMovies = new ArrayList<Filme>();
	
	public void adicionarFilmeNoAcervoDaNetflox(Filme movie) {
		listMovies.add(movie);
	}
	
	public void reproduzirFilme(Filme movie) {
		
		if(listMovies.contains(movie)) {
			
			System.out.println("Reproduzindo: " + movie.getName());
			movie.gender.countValue();
			
		} else {
			System.out.println("Amigo, esse filme não está no acervo!");
		}
	}
	
	public static void gerarRelatorio() {
		
		Genero[] gender = Genero.values();
		
		for(Genero g : gender){
			
			System.out.println(g);
			
		}
	}
}