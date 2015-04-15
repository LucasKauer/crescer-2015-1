import java.util.*;
/**
 * Escreva a descrição da classe EstrategiaNoturna aqui.
 * 
 * @author Lucas Kauer
 */
public class EstrategiaNoturna implements EstrategiaDeAtaque {
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
            }
            
            for (Orc orc : orcs) {
                elfoQueVaiAtacar.atiraFlecha(orc);
            }
            
        }
    }
}