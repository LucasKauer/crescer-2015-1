import java.util.*;
/**
 * Escreva a descrição da classe ExercitoDeElfos aqui.
 * 
 * @author Lucas Kauer
 */
public class ExercitoDeElfos {
    private HashMap<String, Elfo> exercito = new HashMap<>();
    private HashMap<Status, ArrayList<Elfo>> exercitoAgrupadoPorStatus = new HashMap<>();
    private EstrategiaDeAtaque estrategia = new EstrategiaNormal();
    
    /**
     * Alista o elfo no exército para que seja utilizado em batalha.
     * 
     * @param umElfo Elfo a ser alistado no exército. Deve ser apenas do tipo ElfoVerde ou ElfoNoturno
     */
    public void alistarElfo(Elfo umElfo) throws NaoPodeAlistarException {
        boolean podeAlistar = umElfo instanceof ElfoVerde
            || umElfo instanceof ElfoNoturno;
        
        if (podeAlistar) {
            exercito.put(umElfo.getNome(), umElfo);
        } else {
            throw new NaoPodeAlistarException();
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
    
    public ArrayList<Elfo> buscarElfosPorStatus(Status status) {
        agruparElfosPorStatus();
        return exercitoAgrupadoPorStatus.get(status);
    }
    
    /**
     * Agrupa os elfos do exército utilizando o campo status dos objetos.
     */
    public void agruparElfosPorStatus() {
        /* Minha maneira de resolver o problema:
         * for(String key : exercito.keySet()) {
         * Elfo umElfo = exercito.get(key);
         * exercitoAgrupadoPorStatus.put(umElfo.getStatus(), umElfo);
         * } 
         */
        exercitoAgrupadoPorStatus.clear();
        
        for (Map.Entry<String, Elfo> parChaveValor : exercito.entrySet()) {
            Elfo umElfo = parChaveValor.getValue();
            Status status = umElfo.getStatus();   
            
            if (exercitoAgrupadoPorStatus.containsKey(status)) {
                exercitoAgrupadoPorStatus.get(status).add(umElfo);
            } else {
                exercitoAgrupadoPorStatus.put(status, new ArrayList<> (
                    Arrays.asList(umElfo)
                ));
                
                // C#
                // var arr = new [] { elfo, elfo1, elfo2, elfo3 };
            }
        }
    }
    
    public void atacarHorda(ArrayList<Orc> orcs) {        
        ArrayList<Elfo> elfosQueVãoPraPeleia = buscarElfosPorStatus(Status.VIVO);
        
        estrategia.atacarOrcs(elfosQueVãoPraPeleia, orcs);
    }
    
    public HashMap<String, Elfo> getExercito() {
        return this.exercito;
    }
    
    public HashMap<Status, ArrayList<Elfo>> getExercitoAgrupadoPorStatus() {
        return exercitoAgrupadoPorStatus;
    }
}