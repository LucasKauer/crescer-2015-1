package filmator;

import java.util.ArrayList;

public class Netflox {
	static ArrayList<Movie> listOfMovies = new ArrayList<Movie>();
	
	/* public static void main(String[] args) {
		
	} */
	
	// adiciona um filme ao acervo da Netflox
	public static void addMovieInTheCollection(Movie movie) {
		listOfMovies.add(movie);
	}
	
	/* Se o filme estiver no acervo, ele reproduz o mesmo.
	 * Se nao, ele retorna uma mensagem alertando o usuario que tal conteudo
	 * nao esta acessivel no momento
	 */
	public static void playMovie(Movie movie) {
		// percorre o ArrayList e verifica se tem o filme passado como parametro
		if(listOfMovies.contains(movie)) {
			
			System.out.println("Reproduzindo: " + movie.getName());
			// chama o metodo viewsCount que acrescenta +1 ao numero de visualizacoes
			movie.getGender().viewsCount();;
			
		} else {
			System.out.println("Erro: o filme selecionado não se encontra no acervo.");
		}
	}
	
	// gera um relatorio
	public static void createReport() {
		
		// passando, atraves do metodo values, todos os "enum's" para dentro de um arraiii de "enum's"
		Gender[] gender = Gender.values();
		
		// forEach que percorre todo o araiii de generos
		for(Gender g : gender){
			
			System.out.println(g);
			
		}
	}
}