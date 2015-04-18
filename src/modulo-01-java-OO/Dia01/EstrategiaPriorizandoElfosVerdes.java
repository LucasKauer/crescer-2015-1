import java.util.*;
/**
 * Define a Estragia que Prioriza os Elfos Verdes.
 * 
 * @author Bernardo Brezende
 */
public class EstrategiaPriorizandoElfosVerdes implements EstrategiaDeAtaque {
    private ArrayList<Elfo> ordemAtaque = new ArrayList<>();
    
    public void atacarOrcs(ArrayList<Elfo> elfos, ArrayList<Orc> orcs) {
        //ordenaComBubbleSort(elfos, orcs);
        ordenaComCollectionSort(elfos, orcs);
        
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
    
    private void ordenaComBubbleSort(ArrayList<Elfo> elfos, ArrayList<Orc> orcs) {
        
        boolean houverTroca = true;
        while (houverTroca) {
            houverTroca = false;
            for (int i = 0; i < elfos.size() - 1; i++) {
                
                Elfo elfoAtual = elfos.get(i);
                Elfo elfoProximo = elfos.get(i + 1);
                
                // só precisa trocar se um elfo noturno vier antes de um elfo verde
                boolean precisaTrocar = elfoAtual instanceof ElfoNoturno && elfoProximo instanceof ElfoVerde;
                
                if (precisaTrocar) {
                    elfos.set(i, elfoProximo);
                    elfos.set(i + 1, elfoAtual);
                    houverTroca = true;
                }
                
            }
            
        }
    }
    
    private void ordenaComCollectionSort(ArrayList<Elfo> elfos, ArrayList<Orc> orcs) {
        Collections.sort(elfos, new Comparator<Elfo>() {
            public int compare(Elfo elfoAtual, Elfo proximoElfo) {
                boolean mesmoTipo = elfoAtual.getClass() == proximoElfo.getClass();
                
                if (mesmoTipo) {
                    return 0;
                }
                
                return elfoAtual instanceof ElfoVerde && proximoElfo instanceof ElfoNoturno ? -1 : 1;
            }
        });
    }
}