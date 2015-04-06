import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Testa o objeto Orc.
 *
 * @author  Lucas Kauer
 */
public class OrcTeste
{
    @Test
    public void orcNasceCom110vida() {
        Orc umOrc = new Orc();
        
        int esperado = 110;
        int resultadoObtido = umOrc.getVida();
        assertEquals(resultadoObtido, esperado);
    }
    
    @Test
    public void orcPerde10vidaComFlechada() {
        Orc umOrc = new Orc();
        
        int esperado = umOrc.getVida() - 10;
        int resultadoObtido = umOrc.getRecebeFlecha();
        assertEquals(resultadoObtido, esperado);
    }
    
    @Test
    public void orcRecebeAtaqueUmVez() {
        Orc umOrc = new Orc();
        
        umOrc.getRecebeFlecha();
        
        int esperado = 100;
        int resultadoObtido = umOrc.getVida();
        assertEquals(resultadoObtido, esperado);
    }
    
    @Test
    public void orcRecebeAtaqueDuasVezes() {
        Orc umOrc = new Orc();
        
        umOrc.getRecebeFlecha();
        umOrc.getRecebeFlecha();
        
        int esperado = 90;
        int resultadoObtido = umOrc.getVida();
        assertEquals(resultadoObtido, esperado);
    }
    
    @Test
    public void orcRecebeAtaqueCincoVezes() {
        Orc umOrc = new Orc();
        
        umOrc.getRecebeFlecha();
        umOrc.getRecebeFlecha();
        umOrc.getRecebeFlecha();
        umOrc.getRecebeFlecha();
        umOrc.getRecebeFlecha();
        
        int esperado = 60;
        int resultadoObtido = umOrc.getVida();
        assertEquals(resultadoObtido, esperado);
    }
    
    @Test
    public void orcRecebeAtaqueDozeVezes() {
        Orc umOrc = new Orc();
 
        umOrc.getRecebeFlecha();
        umOrc.getRecebeFlecha();
        umOrc.getRecebeFlecha();
        umOrc.getRecebeFlecha();
        umOrc.getRecebeFlecha();
        umOrc.getRecebeFlecha();
        umOrc.getRecebeFlecha();
        umOrc.getRecebeFlecha();
        umOrc.getRecebeFlecha();
        umOrc.getRecebeFlecha();
        umOrc.getRecebeFlecha();
        umOrc.getRecebeFlecha();

        int esperado = -10;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
}
