/**
 * Genero 
 * @author CWI Software
 * 
 * Created by Lucas Kauer on 14/05/2015.
 * Last updated on: 15/05/2015
 */

package filmator;

public enum Gender {
	
	ACAO(), ANIMACAO(), AVENTURA(), COMEDIA(), CULT(), DRAMA(), FANTASIA(),
	FAROESTE(), FICCAO_CIENTIFICA(), GUERRA(), MUSICAL(), POLICIAL(), ROMANCE(),
	SUSPENSE(), TERROR(); //, <GENDER>(0)
	
	//private int viewsNumber = 0;
	
	/*
	 *	public static void main(String[] args) {
	 *		System.out.println(Genero.ANIMACAO);
	 *	} 
	 *	
	 *	private Gender(int viewsCount) {
	 *		this.viewsNumber = viewsCount;
	 *	}
	 *	
	 *	public int getviewsCount() {
	 *		return this.viewsNumber;
	 *	}
	 */
	
	@Override
	public String toString() {
		String result = this.name();
		//result += ": " + this.viewsNumber;
		return result;
	}
}