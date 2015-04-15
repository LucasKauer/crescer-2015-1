import java.util.HashMap;
/**
 * Escreva a descrição da classe ExercitoDeElfos aqui.
 * 
 * @author Lucas Kauer
 */
public class ExercitoDeElfos {
    private HashMap<String, Elfo> exercito = new HashMap<>();
    private HashMap<Status, Elfo> exercitoAgrupadoPorStatus = new HashMap<>();
    
    /**
     * Alista o elfo no exército para que seja utilizado em batalha.
     * 
     * @param umElfo Elfo a ser alistado no exército. Deve ser apenas do tipo ElfoVerde ou ElfoNoturno
     */
    public void alistarElfo(Elfo umElfo) {
        boolean podeAlistar = umElfo instanceof ElfoVerde
            || umElfo instanceof ElfoNoturno;
        
        if (podeAlistar) {
            exercito.put(umElfo.getNome(), umElfo);
        }
    }
    
     /**
     * Busca um elfo no meio do exército, a partir do seu nome.
     * 
     * @param nome Nome do elfo para utilizar na busca.
     * @return Elfo Resultado da busca pelo nome. Caso não encontre nada retorna null.
     */
    public Elfo buscarNomeDoElfo(String nome) {
        return exercito.get(nome);
    }
    
    /**
     * Agrupa os elfos do exército por Status.
     */
    public void agruparElfosPorStatus() {
        for(String key : exercito.keySet()) {
            Elfo umElfo = exercito.get(key);
            exercitoAgrupadoPorStatus.put(umElfo.getStatus(), umElfo);
        }
    }
    
    public HashMap<String, Elfo> getExercito() {
        return this.exercito;
    }
}