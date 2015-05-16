/**
 * Ator 
 * @author CWI Software
 * 
 * Created by Lucas Kauer on 14/05/2015.
 * Last updated on: 14/05/2015
 */

package filmator;

public class Actor {
	private String name;
	
	/* public static void main(String[] args) {
	
	} */
	/**
	 * Cria novos atores
	 * @param name Nome do ator
	 * 
	 * Created by Lucas Kauer on 14/05/2015.
	 */
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
