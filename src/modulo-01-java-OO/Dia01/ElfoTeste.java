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
    public void elfoNasceComNome() {
        // Arange - Montagem dos dados testes
        // Act - Execução de ação de testes
        String esperado = "umNome";
        Elfo umElfo = new Elfo(esperado);
        
        // Assert - Verificação se o resultado é o esperado
        assertEquals(esperado, umElfo.getNome());
    }
    
    @Test
    public void elfoNasceComNomeEMuitasFlechasInformadas() {
       String nomeEsperado = "Robin";
       int flechasEsperadas = 12;
        
       Elfo umElfo = new Elfo(nomeEsperado, flechasEsperadas);
        
       assertEquals(nomeEsperado, umElfo.getNome());
       assertEquals(flechasEsperadas, umElfo.getFlechas());
    }
    
    @Test
    public void elfoNasceCom42FlechasPorPadrao() {
       Elfo umElfo = new Elfo("umNome");
        
       int esperado = 42;
       int resultadoObtido = umElfo.getFlechas();
       assertEquals(resultadoObtido, esperado);
    }
    
    @Test
    public void elfoNasceCom0experiencia() {
       Elfo umElfo = new Elfo("umNome");
        
       int esperado = 0;
       int resultadoObtido = umElfo.getExperiencia();
       assertEquals(resultadoObtido, esperado);
    }
    
    @Test
    public void elfoPerdeFlechaQuandoAtira1Flecha() {
        Elfo umElfo = new Elfo("umNome");
        
        int esperado = umElfo.getFlechas() - 1;
        int resultadoObtido = umElfo.getPerdeFlecha();
        assertEquals(resultadoObtido, esperado);
    }
    
    @Test
    public void elfoGanha1experienciaQuandoAtira1Flecha() {
        Elfo umElfo = new Elfo("umNome");
        
        int esperado = umElfo.getExperiencia() + 1;
        int resultadoObtido = umElfo.getGanhaExperiencia();
        assertEquals(resultadoObtido, esperado);
    }
}