import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Testes integrados entre objetos Elfo e Orc.
 *
 * @author  Lucas Kauer
 */
public class TestesIntegrados
{
    private final double DELTA = 0.005;
    @Test
    public void umElfoAtiraEmDoisOrcs() {
        // Arrange
        Elfo umElfo = new Elfo("O Elfo");
        Orc umOrc1 = new Orc("Nome Grande Aqui 1");
        Orc umOrc2 = new Orc("Nome Grande Aqui 2");
        // Act
        umElfo.atiraFlecha(umOrc1);
        umElfo.atiraFlecha(umOrc2);
        // Assert
        int experienciaEsperada = 2;
        int flechasEsperadas = 40;
        double vidaEsperadaOrc = 100;
        String toStringEsperadoOrc = "Vida atual: 100.0";
        
        assertEquals(experienciaEsperada, umElfo.getExperiencia());
        assertEquals(flechasEsperadas, umElfo.getFlechas());
        assertEquals(vidaEsperadaOrc, umOrc1.getVida(), DELTA);
        assertEquals(vidaEsperadaOrc, umOrc2.getVida(), DELTA);
        assertEquals(toStringEsperadoOrc, umOrc1.toString());
        assertEquals(toStringEsperadoOrc, umOrc2.toString());
    }
}
