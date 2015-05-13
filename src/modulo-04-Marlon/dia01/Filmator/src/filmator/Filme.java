package filmator;

import java.util.ArrayList;

public class Filme {
	String name;
	Genero gender;
	ArrayList<Ator> listActors = new ArrayList<Ator>();
	
	public static void main(String[] args) {

		/* Ator a1 = new Ator("Ator 1");
		Ator a2 = new Ator("Ator 2");
		Ator a3 = new Ator("Nao deve encontrar esse");
		
		Filme f = new Filme("Filme 1");
		
		f.newActor(a1);
		f.newActor(a2);
		f.newActor(a3);
		
		System.out.println(f.actorsContainsStr("Ator")); */
		
	}

	public Filme(String name, Genero gender) {
		this.name = name;
		this.gender = gender; 
	}
	
	public void newActor (Ator actor) {
		listActors.add(actor);
	}
	
	public ArrayList<Ator> actorsContainsStr(String str) {
		ArrayList<Ator> listContains = new ArrayList<Ator>();
		for (Ator actor : listActors) {
			
			if (actor.getNome().contains(str)) {
				listContains.add(actor);
			}
			
		}
		return listContains;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String toString() {
		return "Filme: " + this.name;
	}
}