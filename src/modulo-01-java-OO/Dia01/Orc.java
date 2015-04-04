
/**
 * Define o objeto Orc
 * 
 * @author Lucas Kauer
 */

public class Orc {
    private int vida ;
    
    {
        vida = 110;
    }
    
    /**
     * Construtor para objetos da classe Orc
     * 
     * public Orc()
     * {
     * }
     * 
     */
    
    /**
     * Recebe uma flechada e perde 10 unidades de vida.
     */
    
    public void recebeFlecha() {
        vida = vida - 10;
    }
    
    // metódo responsável por testar se o Orc está nascendo com 110 de vida.
    public int getVida() {
        return this.vida;
    }
    
    // metódo responsável por testar se o método recebeFlecha está sendo executado corretamente
    public int getRecebeFlecha() {
        recebeFlecha();
        return vida;
    }
}