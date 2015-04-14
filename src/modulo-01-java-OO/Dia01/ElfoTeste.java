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
        
        String esperado = String.format("%s possui 42 flechas e 0 níveis de experiência.",
                umElfo.getNome());
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void elfoToStringRetornaVidaAposAtirarUmaFlechas() {
        Elfo umElfo = new Elfo("umNome");
        Orc umOrc = new Orc();
        
        umElfo.atiraFlecha(umOrc);
        String resultadoObtido = umElfo.toString();
        
        String esperado = String.format("%s possui 41 flechas e 1 nível de experiência.",
                umElfo.getNome());
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
        
        String esperado = String.format("%s possui 32 flechas e 10 níveis de experiência.",
                umElfo.getNome());
        assertEquals(esperado, resultadoObtido);
    }
    
    // Exercício 9.1
    @Test
    public void elfoContadorRetorna1() {
        Elfo umElfo = new Elfo("umNome");
        
        int resultadoObtido = Elfo.getContadorElfosCriados();
        int esperado = 1;
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void elfoContadorRetorna5() {
        Elfo umElfo = new Elfo("umNome");
        Elfo doisElfo = new Elfo("doisNome");
        Elfo tresElfo = new Elfo("trêsNome");
        Elfo quatroElfo = new Elfo("quatroNome");
        Elfo cincoElfo = new Elfo("cincoNome");
        
        int resultadoObtido = Elfo.getContadorElfosCriados();
        int esperado = 5;
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void elfoContadorRetorna10() {
        Elfo umElfo = new Elfo("umNome");
        Elfo doisElfo = new Elfo("doisNome");
        Elfo tresElfo = new Elfo("trêsNome");
        Elfo quatroElfo = new Elfo("quatroNome");
        Elfo cincoElfo = new Elfo("cincoNome");
        Elfo seisElfo = new Elfo("seisNome");
        Elfo seteElfo = new Elfo("seteNome");
        Elfo oitoElfo = new Elfo("oitoNome");
        Elfo noveElfo = new Elfo("noveNome");
        Elfo dezElfo = new Elfo("dezNome");
        
        int resultadoObtido = Elfo.getContadorElfosCriados();
        int esperado = 10;
        assertEquals(esperado, resultadoObtido);
    }
    
    @Before
    public void setUp() {
        Elfo.resetarContadorElfosCriados();
    }
}