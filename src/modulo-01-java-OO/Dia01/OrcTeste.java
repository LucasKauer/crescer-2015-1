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
        // Arange - Montagem dos dados testes
        // Act - Execução de ação de testes
        // Assert - Verificação se o resultado é o esperado
        Orc umOrc = new Orc();
        
        int esperado = 110;
        int resultadoObtido = umOrc.getVida();
        assertEquals(resultadoObtido, esperado);
    }
}
