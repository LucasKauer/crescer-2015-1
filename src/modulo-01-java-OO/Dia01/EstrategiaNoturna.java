import java.util.*;
/**
 * Define a Estrategia Noturna de ataque dos Elfos
 * Diferente da Estrategia Normal a Estrategia Noturna preserva a vida dos seus Elfos Noturnos ;D
 * 
 * @author Lucas Kauer
 */
public class EstrategiaNoturna implements EstrategiaDeAtaque {
    private ArrayList<Elfo> ordemAtaque = new ArrayList<>();
    
    /**
     * Cada Elfo atira em toda a horda de Orcs
     * Porém, os elfos noturno pode ser usados, no máximo, em 30% dos ataques.
     * @param umElfo Elfo que atacará a horda inteira de Orcs
     */
    public void atacarOrcs(ArrayList<Elfo> elfos, ArrayList <Orc> orcs) {
        System.out.println("Estratégia Noturna");
        
        int qtdAtaques = elfos.size() * orcs.size();
        int limiteElfosNoturnos = (int) (qtdAtaques * 0.3);
        int qtdElfosNoturnosQueJaAtacaram = 0;
        
        for (Elfo elfoQueVaiAtacar : elfos) {
            boolean eElfoNoturno = elfoQueVaiAtacar instanceof ElfoNoturno;
            
            if (eElfoNoturno) {
                if (qtdElfosNoturnosQueJaAtacaram >= limiteElfosNoturnos)
                    continue;
                qtdElfosNoturnosQueJaAtacaram++;
            ordemAtaque.add(elfoQueVaiAtacar);
            }
            
            for (Orc orc : orcs) {
                elfoQueVaiAtacar.atiraFlecha(orc);
            }
        }
    }
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
        return ordemAtaque;
    }
}