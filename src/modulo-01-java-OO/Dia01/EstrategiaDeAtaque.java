import java.util.*;
/**
 * Escreva a descrição da interface EstrategiaDeAtaque aqui.
 * 
 * @author Lucas Kauer
 */
// Interface não são instanciáveis. #DONTCRY #AND #STAYSTRONG
public interface EstrategiaDeAtaque {
    void atacarOrcs(ArrayList<Elfo> elfos, ArrayList<Orc> orcs);
    
    ArrayList<Elfo> getOrdemDoUltimoAtaque();
}