import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Testes unitários para a classe Elfo.
 *
 * @author  CWI Software
 */
public class ElfoTest
{
    @Test
    public void elfoNasceComNomeInformado() {
        // Arrange
        String esperado = "Celeborn";
        // Act
        Elfo umElfo = new Elfo(esperado);
        // Assert
        assertEquals(esperado, umElfo.getNome());
    }
    
    @Test
    public void elfoNasceComNomeVazio() {
        // Arrange
        String esperado = "";        
        // Act
        Elfo umElfo = new Elfo(esperado);
        // Assert
        assertEquals(esperado, umElfo.getNome());
    }
    
    @Test
    public void elfoNasceComNomeNulo() {
        // Arrange
        String esperado = null;        
        // Act
        Elfo umElfo = new Elfo(esperado);
        // Assert
        assertEquals(esperado, umElfo.getNome());
    }
    
    @Test
    public void elfoNasceCom42FlechasPorPadrao() {
        // Arrange
        int esperado = 42;
        // Act
        Elfo umElfo = new Elfo("um nome qualquer");
        // Assert
        assertEquals(esperado, umElfo.getFlechas());
    }
    
    @Test
    public void elfoNasceComNomeEMuitasFlechasInformados() {
        // Arrange
        String nomeEsperado = "Robin";
        int flechasEsperadas = 567853;
        // Act
        Elfo umElfo = new Elfo(nomeEsperado, flechasEsperadas);
        // Assert
        assertEquals(nomeEsperado, umElfo.getNome());
        assertEquals(flechasEsperadas, umElfo.getFlechas());
    }
    
    @Test
    public void elfoNasceComNomeEPoucasFlechasInformados() {
        // Arrange
        String nomeEsperado = "Robin";
        int flechasEsperadas = 12;
        // Act
        Elfo umElfo = new Elfo(nomeEsperado, flechasEsperadas);
        // Assert
        assertEquals(nomeEsperado, umElfo.getNome());
        assertEquals(flechasEsperadas, umElfo.getFlechas());
    }
    
    @Test
    public void elfoNasceComNomeEFlechasNegativasInformados() {
        // Arrange
        String nomeEsperado = "Robin";
        int flechasEsperadas = -567853;
        // Act
        Elfo umElfo = new Elfo(nomeEsperado, flechasEsperadas);
        // Assert
        assertEquals(nomeEsperado, umElfo.getNome());
        assertEquals(flechasEsperadas, umElfo.getFlechas());
    }

    @Test
    public void elfoAtiraFlechaEmUmOrc() {
        // Arrange
        Elfo umElfo = new Elfo("Legolas");
        Orc umOrc = new Orc();
        // Act
        umElfo.atiraFlecha(umOrc);
        // Assert
        int experienciaEsperada = 1;
        int flechasEsperadas = 41;
        
        assertEquals(experienciaEsperada, umElfo.getExperiencia());
        assertEquals(flechasEsperadas, umElfo.getFlechas());
    }
    
    @Test
    public void elfoAtiraFlechasDuasVezesNoMesmoOrc() {
        // Arrange
        Elfo umElfo = new Elfo("Legolas");
        Orc umOrc = new Orc();
        // Act
        umElfo.atiraFlecha(umOrc);
        umElfo.atiraFlecha(umOrc);
        // Assert
        int experienciaEsperada = 2;
        int flechasEsperadas = 40;
        
        assertEquals(experienciaEsperada, umElfo.getExperiencia());
        assertEquals(flechasEsperadas,umElfo.getFlechas());
    }
    
    @Test
    public void elfoAtiraFlechasCincoVezesNoMesmoOrc() {
        // Arrange
        Elfo umElfo = new Elfo("Legolas", 4);
        Orc umOrc = new Orc();
        // Act
        umElfo.atiraFlecha(umOrc);
        umElfo.atiraFlecha(umOrc);
        umElfo.atiraFlecha(umOrc);
        umElfo.atiraFlecha(umOrc);
        umElfo.atiraFlecha(umOrc);
        // Assert
        int experienciaEsperada = 5;
        int flechasEsperadas = -1;
        
        assertEquals(experienciaEsperada, umElfo.getExperiencia());
        assertEquals(flechasEsperadas, umElfo.getFlechas());
    }
    
    @Test
    public void elfoToStringPadrao() {
        // Arrange
        Elfo umElfo = new Elfo("Faustão");
        String resultadoEsperado = "Faustão possui 42 flechas e 0 níveis de experiência.";
        // Act
        String resultadoObtido = umElfo.toString();
        // Assert
        assertEquals(resultadoEsperado, resultadoObtido);
    }
}



