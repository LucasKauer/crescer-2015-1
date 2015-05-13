package filmator;

public class Ator {
	String name;
	
	public Ator(String name) {
		this.name = name;
	}
	
	public String getNome() {
		return this.name;
	}
	
	public String toString() {
		return "Ator: " + this.name;
	}
}