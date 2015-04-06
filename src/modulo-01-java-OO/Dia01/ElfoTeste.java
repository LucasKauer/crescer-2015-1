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
        // Assert - Verificação se o resultado é o esperado
        String esperado = "umNome";
        Elfo umElfo = new Elfo(esperado);
        
        boolean resultadoObtido = (umElfo.getNome() != null);
        assertEquals(resultadoObtido, esperado);
    }
    
    @Test
    public void elfoNasceComFlechas() {
       Elfo umElfo = new Elfo("umNome");
        
       boolean esperado = true;
       int resultadoObtido = umElfo.getFlechas();
       boolean resultadoObtido2 = (resultadoObtido != 0) && true;
       assertEquals(resultadoObtido2, esperado);
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