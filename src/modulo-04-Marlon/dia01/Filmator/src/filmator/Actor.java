package filmator;

public class Actor {
	private String name;
	
	/* public static void main(String[] args) {
	
	} */

	public Actor(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		return "Ator: " + this.name;
	}
}
