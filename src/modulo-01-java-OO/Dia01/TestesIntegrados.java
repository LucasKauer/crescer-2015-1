import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Testes integrados entre objetos Elfo e Orc.
 *
 * @author  CWI Software
 */
public class TestesIntegrados
{
    @Test
    public void umElfoAtiraEmDoisOrcs() {
        // Arrange
        Elfo umElfo = new Elfo("O Elfo");
        Orc umOrc1 = new Orc();
        Orc umOrc2 = new Orc();
        // Act
        umElfo.atiraFlecha(umOrc1);
        umElfo.atiraFlecha(umOrc2);
        // Assert
        int experienciaEsperada = 2;
        int flechasEsperadas = 40;
        int vidaEsperadaOrc = 100;
        String toStringEsperadoOrc = "Vida atual: 100";
        
        assertEquals(experienciaEsperada, umElfo.getExperiencia());
        assertEquals(flechasEsperadas, umElfo.getFlechas());
        assertEquals(vidaEsperadaOrc, umOrc1.getVida());
        assertEquals(vidaEsperadaOrc, umOrc2.getVida());
        assertEquals(toStringEsperadoOrc, umOrc1.toString());
        assertEquals(toStringEsperadoOrc, umOrc2.toString());
    }
}
