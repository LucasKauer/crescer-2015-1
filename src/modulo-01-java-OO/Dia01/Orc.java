
/**
 * Define o objeto Orc
 * 
 * @author Lucas Kauer
 */

public class Orc {
    private int vida;
    private Status status;
    
    {
        vida = 110;
        status = Status.VIVO;
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
    
    /**
     * Imprime a vida atual do Orc.
     * 
     * @return String com a vida atual do orc
     * Ex: "Vida atual: " + this.vida
     */
    
    public String toString() {
        return "Vida atual: " + this.vida;
    }
}