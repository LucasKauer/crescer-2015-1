import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe de teste ElfoNoturnoTeste.
 *
 * @author  Lucas Kauer
 */
public class ElfoNoturnoTeste
{
    private final double DELTA = 0.005;
    @Test
    public void elfoNoturnoNasceComNomeInformado() {
        // Arrange
        String esperado = "Celeborn";        
        // Act
        ElfoNoturno umElfo = new ElfoNoturno(esperado);
        // Assert
        assertEquals(esperado, umElfo.getNome());
    }
    
    @Test
    public void elfoNoturnoNasceComNomeVazio() {
        // Arrange
        String esperado = "";        
        // Act
        ElfoNoturno umElfo = new ElfoNoturno(esperado);
        // Assert
        assertEquals(esperado, umElfo.getNome());
    }
    
    @Test
    public void elfoNoturnoNasceComNomeNulo() {
        // Arrange
        String esperado = null;        
        // Act
        ElfoNoturno umElfo = new ElfoNoturno(esperado);
        // Assert
        assertEquals(esperado, umElfo.getNome());
    }
    
    @Test
    public void elfoNoturnoNasceCom42FlechasPorPadrao() {
        // Arrange
        int esperado = 42;
        // Act
        ElfoNoturno umElfo = new ElfoNoturno("um nome qualquer");
        // Assert
        assertEquals(esperado, umElfo.getFlechas());
    }
    
    @Test
    public void elfoNoturnoNasceComNomeEMuitasFlechasInformados() {
        // Arrange
        String nomeEsperado = "Robin";
        int flechasEsperadas = 567853;
        // Act
        ElfoNoturno umElfo = new ElfoNoturno(nomeEsperado, flechasEsperadas);
        // Assert
        assertEquals(nomeEsperado, umElfo.getNome());
        assertEquals(flechasEsperadas, umElfo.getFlechas());
    }
    
    @Test
    public void elfoNoturnoGanhaOTriploDeExperienciaQuandoAtira1Flecha() {
        // Arrange
        // Act
        ElfoNoturno umElfo = new ElfoNoturno("umNome");
        // Assert
        umElfo.atiraFlecha(new Orc());
        
        int esperado = 3;
        int resultadoObtido = umElfo.getExperiencia();
        assertEquals(resultadoObtido, esperado);
    }
    
    @Test
    public void elfoNoturnoGanhaOTriploDeExperienciaQuandoAtira5Flechas() {
        // Arrange
        // Act
        ElfoNoturno umElfo = new ElfoNoturno("umNome");
        // Assert
        umElfo.atiraFlecha(new Orc());
        umElfo.atiraFlecha(new Orc());
        umElfo.atiraFlecha(new Orc());
        umElfo.atiraFlecha(new Orc());
        umElfo.atiraFlecha(new Orc());
        
        int esperado = 15;
        int resultadoObtido = umElfo.getExperiencia();
        assertEquals(resultadoObtido, esperado);
    }
    
    @Test
    public void elfoNoturnoGanhaOTriploDeExperienciaQuandoAtira12Flechas() {
        // Arrange
        // Act
        ElfoNoturno umElfo = new ElfoNoturno("umNome");
        // Assert
        umElfo.atiraFlecha(new Orc());
        umElfo.atiraFlecha(new Orc());
        umElfo.atiraFlecha(new Orc());
        umElfo.atiraFlecha(new Orc());
        umElfo.atiraFlecha(new Orc());
        umElfo.atiraFlecha(new Orc());
        umElfo.atiraFlecha(new Orc());
        umElfo.atiraFlecha(new Orc());
        umElfo.atiraFlecha(new Orc());
        umElfo.atiraFlecha(new Orc());
        umElfo.atiraFlecha(new Orc());
        umElfo.atiraFlecha(new Orc());
        
        int esperado = 36;
        int resultadoObtido = umElfo.getExperiencia();
        assertEquals(resultadoObtido, esperado);
    }
    
    @Test
    public void elfoNoturnoPerde5PorcentoDaVidaQuandoAtiraUmaFlehca() {
        // Arrange
        // Act
        ElfoNoturno umElfo = new ElfoNoturno("umNome");
        // Assert
        umElfo.atiraFlecha(new Orc());
        
        double esperado = 95;
        double resultadoObtido = umElfo.getVida();
        assertEquals(esperado, resultadoObtido, DELTA);
    }
    
    @Test
    public void elfoNoturnoMorreQuandoAtira90Flechas() {
        // Arrange
        // Act
        ElfoNoturno umElfo = new ElfoNoturno("umNome");
        // Assert
        
        for (int i = 0; i < 90; i++) {
            umElfo.atiraFlecha(new Orc());
        }

        Status esperado = Status.MORTO;
        Status resultadoObtido = umElfo.getStatus();
        assertEquals(resultadoObtido, esperado);
    }
}
