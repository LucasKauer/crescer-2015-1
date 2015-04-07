import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Testa o objeto Elfo.
 *
 * @author  Lucas Kauer
 */
public class ElfoTeste
{
    @Test
    public void elfoNasceComNomeInformado() {
        // Arrange
        String esperado = "Celeborn";        
        // Act
        Elfo elfo = new Elfo(esperado);
        // Assert
        assertEquals(esperado, elfo.getNome());
    }
    
    @Test
    public void elfoNasceComNomeVazio() {
        // Arrange
        String esperado = "";        
        // Act
        Elfo elfo = new Elfo(esperado);
        // Assert
        assertEquals(esperado, elfo.getNome());
    }
    
    @Test
    public void elfoNasceComNomeNulo() {
        // Arrange
        String esperado = null;        
        // Act
        Elfo elfo = new Elfo(esperado);
        // Assert
        assertEquals(esperado, elfo.getNome());
    }
    
    @Test
    public void elfoNasceCom42FlechasPorPadrao() {
        // Arrange
        int esperado = 42;
        // Act
        Elfo elfo = new Elfo("um nome qualquer");
        // Assert
        assertEquals(esperado, elfo.getFlechas());
    }
    
    @Test
    public void elfoNasceComNomeEMuitasFlechasInformados() {
        // Arrange
        String nomeEsperado = "Robin";
        int flechasEsperadas = 567853;
        // Act
        Elfo elfo = new Elfo(nomeEsperado, flechasEsperadas);
        // Assert
        assertEquals(nomeEsperado, elfo.getNome());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void elfoNasceComNomeEPoucasFlechasInformados() {
        // Arrange
        String nomeEsperado = "Robin";
        int flechasEsperadas = 12;
        // Act
        Elfo elfo = new Elfo(nomeEsperado, flechasEsperadas);
        // Assert
        assertEquals(nomeEsperado, elfo.getNome());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void elfoNasceComNomeEFlechasNegativasInformados() {
        // Arrange
        String nomeEsperado = "Robin";
        int flechasEsperadas = -567853;
        // Act
        Elfo elfo = new Elfo(nomeEsperado, flechasEsperadas);
        // Assert
        assertEquals(nomeEsperado, elfo.getNome());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void elfoNasceCom0experiencia() {
       // Arrange
       // Act
       Elfo umElfo = new Elfo("umNome");
       // Assert
       int esperado = 0;
       int resultadoObtido = umElfo.getExperiencia();
       assertEquals(resultadoObtido, esperado);
    }
    
    @Test
    public void elfoPerdeFlechaQuandoAtira1Flecha() {
        // Arrange
        // Act
        Elfo umElfo = new Elfo("umNome");
        // Assert
        int esperado = umElfo.getFlechas() - 1;
        int resultadoObtido = umElfo.getPerdeFlecha();
        assertEquals(resultadoObtido, esperado);
    }
    
    @Test
    public void elfoGanha1experienciaQuandoAtira1Flecha() {
        // Arrange
        // Act
        Elfo umElfo = new Elfo("umNome");
        // Assert
        int esperado = umElfo.getExperiencia() + 1;
        int resultadoObtido = umElfo.getGanhaExperiencia();
        assertEquals(resultadoObtido, esperado);
    }
    
    @Test
    public void elfoToStringRetornaVidaPadrao() {
        Elfo umElfo = new Elfo("umNome");
        
        String resultadoObtido = umElfo.toString();
        
        String esperado = String.format("%s possui $d %s e %d %s de experiência.",
                umElfo.getNome(),
                umElfo.getFlechas(),
                // ternerio (in line) na linha
                umElfo.getFlechas() == 1 ? "flecha" : "flechas",
                umElfo.getExperiencia(),
                // ternerio (in line) na linha
                umElfo.getExperiencia() == 1 ? "nível" : "níveis"
                );
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void elfoToStringRetornaVidaAposAtirarUmaFlechas() {
        Elfo umElfo = new Elfo("umNome");
        Orc umOrc = new Orc();
        
        umElfo.atiraFlecha(umOrc);
        String resultadoObtido = umElfo.toString();
        
        String esperado = String.format("%s possui $d %s e %d %s de experiência.",
                umElfo.getNome(),
                umElfo.getFlechas(),
                // ternerio (in line) na linha
                umElfo.getFlechas() == 1 ? "flecha" : "flechas",
                umElfo.getExperiencia(),
                // ternerio (in line) na linha
                umElfo.getExperiencia() == 1 ? "nível" : "níveis"
                );
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void elfoToStringRetornaVidaAposAtirarDezFlechas() {
        Elfo umElfo = new Elfo("umNome");
        Orc umOrc = new Orc();
        
        umElfo.atiraFlecha(umOrc);
        umElfo.atiraFlecha(umOrc);
        umElfo.atiraFlecha(umOrc);
        umElfo.atiraFlecha(umOrc);
        umElfo.atiraFlecha(umOrc);
        umElfo.atiraFlecha(umOrc);
        umElfo.atiraFlecha(umOrc);
        umElfo.atiraFlecha(umOrc);
        umElfo.atiraFlecha(umOrc);
        umElfo.atiraFlecha(umOrc);
        
        String resultadoObtido = umElfo.toString();
        
        String esperado = String.format("%s possui $d %s e %d %s de experiência.",
                umElfo.getNome(),
                umElfo.getFlechas(),
                // ternerio (in line) na linha
                umElfo.getFlechas() == 1 ? "flecha" : "flechas",
                umElfo.getExperiencia(),
                // ternerio (in line) na linha
                umElfo.getExperiencia() == 1 ? "nível" : "níveis"
                );
        assertEquals(esperado, resultadoObtido);
    }
}