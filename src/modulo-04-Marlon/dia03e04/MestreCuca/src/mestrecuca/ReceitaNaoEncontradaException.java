/**
 * Exception de receita n�o encontrada
 * @author CWI Software
 * 
 * Created by Lucas Kauer on 20/05/2015.
 * Last updated on: 20/05/2015
 */

package mestrecuca;

public class ReceitaNaoEncontradaException extends RuntimeException{
	public ReceitaNaoEncontradaException() {
		super("Receita n�o encontrada!");
	}
}
