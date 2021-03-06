/**
 * Filme 
 * @author CWI Software
 * 
 * Created by Lucas Kauer on 14/05/2015.
 * Last updated on: 14/05/2015
 */

package filmator;

import java.util.ArrayList;

public class Movie {
	private String name;
	private Gender gender;
	private ArrayList<Actor> listOfActors = new ArrayList<Actor>();
	
	public static void main(String[] args) {

		/* Actor a1 = new Actor("Ator 1");
		Actor a2 = new Actor("Ator 2");
		Actor a3 = new Actor("Nao deve encontrar esse");
		
		Movie m = new Movie("Filme 1");
		
		m.newActor(a1);
		m.newActor(a2);
		m.newActor(a3);
		
		System.out.println(m.actorsContainsStr("Ator")); */
		
	}
	
	/**
	 * Cria novos filmes
	 * @param name Nome do filme
	 * @param gender Genero do filme
	 * 
	 * Created by Lucas Kauer on 14/05/2015.
	 */
	public Movie(String name, Gender gender) {
		this.name = name;
		this.gender = gender; 
	}
	
	/**
	 * Adiciona atores ao elenco do filme
	 * @param actor Ator que ser� adiciona ao elenco do filme
	 * 
	 * Created by Lucas Kauer on 14/05/2015.
	 */
	// adiciona um ator ao elenco do filme
	public void newActor (Actor actor) {
		listOfActors.add(actor);
	}
	
	/**
	 * Verifica os atores do elenco que contem uma determina String no nome 
	 * @param str String que far� o filtro
	 * @return Retorna os atores do elenco que contem no nome a String informada
	 * 
	 * Created by Lucas Kauer on 14/05/2015.
	 */
	// verifica e retorna os atores do elenco que contem no nome a str passada como parametro
	public ArrayList<Actor> actorsContainsStr(String str) {
		ArrayList<Actor> listContains = new ArrayList<Actor>();
		
		// percorre toda a lista dos atores do elenco
		for (Actor actor : listOfActors) {
			
			// variaveis auxiliares para ajudar na compreensao
			String NameInLowercase = actor.getName().toLowerCase();
			String StrInLowercase = str.toLowerCase();
			// verifica se o nome do ator contem a str
			if (NameInLowercase.contains(StrInLowercase)) {
				listContains.add(actor);
			}
			
		}
		// retorna o arraiii auxiliar com todos os atores que contem a str no nome
		return listContains;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Gender getGender() {
		return this.gender;
	}
	
	public ArrayList<Actor> getListOfActors() {
		return this.listOfActors;
	}
	
	@Override
	public String toString() {
		return "Filme: " + this.name;
	}
}