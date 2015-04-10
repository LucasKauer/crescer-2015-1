
/**
 * Escreva a descrição da classe ElfoVerde aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class ElfoVerde extends Elfo {
    
    public ElfoVerde(String nome, int flechas) {
        this(nome);
        super.flechas = flechas;
    }
    
    public ElfoVerde(String nome) {
        super(nome);
    }
}
