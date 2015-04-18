import java.util.Arrays;
/**
 * Define objetos ElfoVerde.
 * 
 * @author Lucas Kauer
 */
public class ElfoVerde extends Elfo {
    private final String[] ITENS_PERMITIDOS = new String[] {
        "Espada de aço valiriano",
        "Arco e Flecha de vidro"
    };
    
    /**
     * Cria objetos Elfo Verde(construtor)
     * 
     * @param nome Nome que o elfo verde receberá
     * @param flechas Quantidade inicial de flechas
     */    
    public ElfoVerde(String nome, int flechas) {
        this(nome);
        super.flechas = flechas;
    }
    
    /**
     * Cria objetos Elfo Verde (construtor) que recebe nome e usa a quantidade de flechas padrão
     * 
     * @param nome Nome a ser dado para o Elfo.
     */
    public ElfoVerde(String nome) {
        super(nome);
    }
    
    /**
     * Atira uma flecha em um Orc e perde uma unidade de flechas.
     * @param umOrc Orc que receberá uma flechada.
     */
    @Override
    public void atiraFlecha(Orc umOrc) {
        super.atiraFlecha(umOrc);
        super.experiencia++;
    }
    
    @Override
    public void adicionarItem(ItemDoInventario i) {
        boolean descricaoValida = i != null && Arrays.asList(ITENS_PERMITIDOS).contains(i.getDescricao());

        if (descricaoValida) {
            super.adicionarItem(i);
        }
    } 
    
    @Override
    public String toString() {
        return "Elfo Verde: " + super.toString();
    }
}