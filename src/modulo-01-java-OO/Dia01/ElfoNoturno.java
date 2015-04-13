
/**
 * Escreva a descrição da classe ElfoNoturno aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class ElfoNoturno extends Elfo
{
    /**
     * Cria objetos Elfo Noturno(construtor)
     * 
     * @param nome Nome que o elfo noturno receberá
     * @param flechas Quantidade inicial de flechas
     */    
    public ElfoNoturno(String nome, int flechas) {
        this(nome);
        super.flechas = flechas;
    }
    
    /**
     * Cria objetos Elfo Noturno (construtor) que recebe nome e usa a quantidade de flechas padrão
     * 
     * @param nome Nome a ser dado para o Elfo.
     */
    public ElfoNoturno(String nome) {
        super(nome);
    }
    
    /**
     * Atira uma flecha em um Orc e perde uma unidade de flechas.
     * @param umOrc Orc que receberá uma flechada.
     */
    public void atiraFlecha(Orc umOrc) {
        super.atiraFlecha(umOrc);
        super.experiencia += 2;
        super.vida -= (5 * vida) / 100;
    }
}
