/**
 * Classe base para armazenar todos os Erros Do Jogo.
 * 
 * @author Lucas Kauer
 */
public class ErrosDoJogo {
    public static NaoPodeAlistarException naoPodeAlistar() throws NaoPodeAlistarException {
        throw new NaoPodeAlistarException();
    }
}