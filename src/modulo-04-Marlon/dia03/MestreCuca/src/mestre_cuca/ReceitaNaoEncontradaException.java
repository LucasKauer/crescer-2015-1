package mestre_cuca;

public class ReceitaNaoEncontradaException extends RuntimeException{
	public ReceitaNaoEncontradaException() {
		super("Receita não encontrada!");
	}
}
