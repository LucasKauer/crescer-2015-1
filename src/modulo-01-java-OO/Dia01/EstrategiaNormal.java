import java.util.*;
/**
 * Escreva a descrição da classe EstrategiaNormal aqui.
 * 
 * @author Lucas Kauer
 */
public class EstrategiaNormal implements EstrategiaDeAtaque {
    public void atacarOrcs(ArrayList<Elfo> elfos, ArrayList<Orc> orcs) {
       System.out.println("Estratégia Normal");
       
       for (Elfo umElfo : elfos) {
           for (Orc umOrc : orcs) {
               umElfo.atiraFlecha(umOrc);
            }
        }
    }
}