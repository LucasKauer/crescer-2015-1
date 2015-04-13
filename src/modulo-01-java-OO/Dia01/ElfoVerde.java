
/**
 * Escreva a descrição da classe ElfoVerde aqui.
 * 
 * @author Lucas Kauer
 */
public class ElfoVerde extends Elfo {
    
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
    public void atiraFlecha(Orc umOrc) {
        super.atiraFlecha(umOrc);
        super.experiencia++;
    }
    
    public void adicionarItem(ItemDoInventario i) {
        String descricaoDoItem = i.getDescricao();
        boolean EEspadaDeAcoValirianoOuArcoEFlechaDeVidro = descricaoDoItem.equalsIgnoreCase("Espada de aço valiriano") || descricaoDoItem.equalsIgnoreCase("Arco e Flecha de vidro");; 
        if (EEspadaDeAcoValirianoOuArcoEFlechaDeVidro) {
            super.adicionarItem(i);
        }
    }
}
