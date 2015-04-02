
/**
 * Define objeto Orc
 * 
 * @author Lucas Kauer
 */
public class Orc
{
    private int vida ;
    {
        vida = 110;
    }
 
    /**
     * Construtor para objetos da classe Orc
     * public Orc()
     * {
     * }
     */
    
    /**
     * Desconta 10 de vida a cada chamada do método atirarFlecha.
     */
    public void recebeFlecha() {
        vida = vida - 10;
    }
}