import java.util.HashMap;
/**
 * Escreva a descrição da classe ExercitoDeElfos aqui.
 * 
 * @author Lucas Kauer
 */
public class ExercitoDeElfos {
    private HashMap<String, Elfo> exercito = new HashMap<>();
    
    public void alistar(Elfo umElfo) {
        boolean podeAlistar = umElfo instanceof ElfoVerde || umElfo instanceof ElfoNoturno;
        
        if (podeAlistar) {
            exercito.put(umElfo.getNome(), umElfo);
        }
    }
    
    public HashMap<String, Elfo> getExercito() {
        return this.exercito;
    }
    
    public Elfo buscarNome(String nome) {
        return exercito.get(nome);
    }
    
    // Falta testar!!!
}
