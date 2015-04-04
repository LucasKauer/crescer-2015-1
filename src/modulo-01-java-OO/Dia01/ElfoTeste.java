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
        Elfo umElfo = new Elfo();
        umElfo = new Elfo(umElfo.getNome());
        umElfo = new Elfo(umElfo.getNome(), 0);
        
        boolean esperado = true;
        String resultadoObtido = umElfo.getNome();
        boolean resultadoObtido2 = (resultadoObtido != null) && true;
        
        assertEquals(resultadoObtido2, esperado);
    }
    
    @Test
    public void elfoNasceComFlechas() {
       Elfo umElfo = new Elfo();
        
       boolean esperado = true;
       int resultadoObtido = umElfo.getFlechas();
       boolean resultadoObtido2 = (resultadoObtido != 0) && true;
        
       assertEquals(resultadoObtido2, esperado);
    }
    
    @Test
    public void elfoNasceCom0experiencia() {
       Elfo umElfo = new Elfo();
        
       int esperado = 0;
       int resultadoObtido = umElfo.getExperiencia();
        
       assertEquals(resultadoObtido, esperado);
    }
    
    @Test
    public void elfoPerdeFlechaQuandoAtira1Flecha() {
        Elfo umElfo = new Elfo();
        
        int esperado = umElfo.getFlechas() - 1;
        int resultadoObtido = umElfo.getPerdeFlecha();
        assertEquals(resultadoObtido, esperado);
    }
    
    @Test
    public void elfoGanha1experienciaQuandoAtira1Flecha() {
        Elfo umElfo = new Elfo();
        
        int esperado = umElfo.getExperiencia() + 1;
        int resultadoObtido = umElfo.getGanhaExperiencia();
        assertEquals(resultadoObtido, esperado);
    }
}