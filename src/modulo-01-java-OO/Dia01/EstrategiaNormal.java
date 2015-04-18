import java.util.*;
/**
 * Define a Estrategia Normal de ataque dos Elfos.
 * 
 * @author Lucas Kauer
 */
public class EstrategiaNormal implements EstrategiaDeAtaque {
    private ArrayList<Elfo> ordemAtaque = new ArrayList<>();
    
    /**
     * Cada Elfo atira em toda a horda de Orcs
     * @param umElfo Elfo que atacará a horda inteira de Orcs
     */
    public void atacarOrcs(ArrayList<Elfo> elfos, ArrayList<Orc> orcs) {
       System.out.println("Estratégia Normal");
       
       for (Elfo umElfo : elfos) {
           ordemAtaque.add(umElfo);
           for (Orc umOrc : orcs) {
               umElfo.atiraFlecha(umOrc);
            }
        }
    }
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
        return ordemAtaque;
    }
}