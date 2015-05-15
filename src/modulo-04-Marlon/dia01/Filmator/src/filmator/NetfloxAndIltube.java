package filmator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NetfloxAndIltube {
	private String companyName;
	private  Map<Gender, Integer> genderCount = new HashMap<Gender,Integer>();
	private  ArrayList<Movie> listOfMovies = new ArrayList<Movie>();
	
	/* public static void main(String[] args) {	
		  NetfloxAndIltube netflox = new NetfloxAndIltube("netflox");
		  NetfloxAndIltube iltube = new NetfloxAndIltube("iltube");
	} */
	
	public NetfloxAndIltube(String companyName) {
		this.companyName = companyName;
	}
	
	// adiciona um filme ao acervo da Netflox
	public void addMovieInTheCollection(Movie movie) {
		listOfMovies.add(movie);
	}
	
	/* Se o filme estiver no acervo, ele reproduz o mesmo.
	 * Se nao, ele retorna uma mensagem alertando o usuario que tal conteudo
	 * nao esta acessivel no momento
	 */
	public void playMovie(Movie movie) {
		// percorre o ArrayList e verifica se tem o filme passado como parametro
		if(listOfMovies.contains(movie)) {
			// int aux = genderCount.getOrDefault(movie.getGender(), 0);
			// aux++;
			// genderCount.put(movie.getGender(), aux);
			
			Gender genderOfMovie = movie.getGender();

			if(genderCount.containsKey(genderOfMovie)) {
				int aux = genderCount.get(genderOfMovie);
				aux++;
				genderCount.put(genderOfMovie, aux);
			} else {
				genderCount.put(movie.getGender(), 1);
			}
			
			System.out.println("Reproduzindo: " + movie.getName());
			// chama o metodo viewsCount que acrescenta +1 ao numero de visualizacoes
			// movie.getGender().viewsCount();;
			
		} else {
			System.out.println("Erro: o filme selecionado não se encontra no acervo.");
		}
	}
	
	public void createReport() {
		
		for (Map.Entry<Gender, Integer> entry : genderCount.entrySet()) {
			Gender key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println(key + ": " + value);
		}
		
		/*	// passando, atraves do metodo values, todos os "enum's" para dentro de um arraiii de "enum's"
		 *	Gender[] gender = Gender.values();
		 *		
		 *	// forEach que percorre todo o araiii de generos
		 *	for(Gender g : gender){
		 *			
		 *		System.out.println(g);
		 *			
		 *	}
		 */
	}
	
	public String getCompanyName() {
		return this.companyName;
	}
	
	
	public static void main(String[] args) {
		NetfloxAndIltube netflox = new NetfloxAndIltube("netflox");
		Movie movie = new Movie("Glee", Gender.MUSICAL);
		Movie movie2 = new Movie("Glee 2", Gender.MUSICAL);
		Movie movie3 = new Movie("Glee 3", Gender.MUSICAL);
		netflox.addMovieInTheCollection(movie);
		netflox.addMovieInTheCollection(movie2);
		netflox.addMovieInTheCollection(movie3);

		netflox.playMovie(movie);
		netflox.playMovie(movie2);
		netflox.playMovie(movie3);
		
		netflox.createReport();
	}
}