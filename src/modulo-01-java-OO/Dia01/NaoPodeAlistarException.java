
/**
 * Escreva a descrição da classe NaoPodeAlistarException aqui.
 * 
 * @author Lucas Kauer
 */
public class NaoPodeAlistarException extends Exception {
    public NaoPodeAlistarException() {
        super("Erro ao alistar um Elfo. Por favor, tente novamente e se o error persistir contate o Administrador!");
    }
}
