import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe de teste OrcTest.
 *
 * @author  Lucas Kauer
 */
public class OrcTeste
{
    @Test
    public void orcNasceCom110vida() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc;
        // Act - Execução de ação de testes
        umOrc = new Orc();
        // Assert - Verificação
        int esperado = 110;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(resultadoObtido, esperado);
    }
    
    @Test
    public void orcNasceVivo() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc;
        // Act - Execução de ação de testes
        umOrc = new Orc();
        // Assert - Verificação
        Status esperado = Status.VIVO;
        Status resultadoObtido = umOrc.getStatus();
        
        assertEquals(resultadoObtido, esperado);
    }
    
    @Test
    public void orcRecebeAtaqueUmVez() {
        Orc umOrc = new Orc("Artorias");
        
        umOrc.recebeFlecha();
        
        int esperado = 100;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(resultadoObtido, esperado);
    }
    
    @Test
    public void orcRecebeAtaqueDuasVezes() {
        Orc umOrc = new Orc("Artorias");
        
        umOrc.recebeFlecha();
        umOrc.recebeFlecha();
        
        int esperado = 90;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(resultadoObtido, esperado);
    }
    
    @Test
    public void orcRecebeAtaqueCincoVezes() {
        Orc umOrc = new Orc("Artorias");
        
        umOrc.recebeFlecha();
        umOrc.recebeFlecha();
        umOrc.recebeFlecha();
        umOrc.recebeFlecha();
        umOrc.recebeFlecha();
        
        int esperado = 60;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(resultadoObtido, esperado);
    }
    
    @Test
    public void orcRecebeAtaqueDozeVezes() {
        Orc umOrc = new Orc("Artorias");
 
        umOrc.recebeFlecha();
        umOrc.recebeFlecha();
        umOrc.recebeFlecha();
        umOrc.recebeFlecha();
        umOrc.recebeFlecha();
        umOrc.recebeFlecha();
        umOrc.recebeFlecha();
        umOrc.recebeFlecha();
        umOrc.recebeFlecha();
        umOrc.recebeFlecha();
        umOrc.recebeFlecha();
        umOrc.recebeFlecha();

        int esperado = 0;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcFicaFeridoAoReceberAtaque() {
        Orc umOrc = new Orc("Artorias");
        
        umOrc.recebeFlecha();

        Status esperado = Status.FERIDO;
        Status resultadoObtido = umOrc.getStatus();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcToStringRetornaVidaPadrao() {
        Orc umOrc = new Orc();
        
        String resultadoObtido = umOrc.toString();
        
        String esperado = "Vida atual: 110";
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcToStringRetornaVidaAposReceberFlechada() {
        Orc umOrc = new Orc("Artorias");
        
        umOrc.recebeFlecha();
        String resultadoObtido = umOrc.toString();
        
        String esperado = "Vida atual: 100";
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcToStringAposReceberDozeAtaques() {
        Orc umOrc = new Orc("Artorias");
        
        umOrc.recebeFlecha();
        umOrc.recebeFlecha();
        umOrc.recebeFlecha();
        umOrc.recebeFlecha();
        umOrc.recebeFlecha();
        umOrc.recebeFlecha();
        umOrc.recebeFlecha();
        umOrc.recebeFlecha();
        umOrc.recebeFlecha();
        umOrc.recebeFlecha();
        umOrc.recebeFlecha();
        umOrc.recebeFlecha();
        String resultadoObtido = umOrc.toString();
        
        String esperado = "Vida atual: 0";
        assertEquals(esperado, resultadoObtido);
    }
    
    // !
    
    @Test
    public void orcNasceComNomeInformado() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc;
        String esperado = "Artorias";	
        // Act - Execução da ação de testes
        umOrc = new Orc(esperado);
        // Assert - Verificação
        String resultadoObtido = umOrc.getNome();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcNasceComNomeVazioInformado() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc;
        String esperado = "";	
        // Act - Execução da ação de testes
        umOrc = new Orc(esperado);
        // Assert - Verificação
        String resultadoObtido = umOrc.getNome();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcNasceComNomeNuloInformado() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc;
        String esperado = null;	
        // Act - Execução da ação de testes
        umOrc = new Orc(esperado);
        // Assert - Verificação
        String resultadoObtido = umOrc.getNome();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcMorreAposDozeFlechadas() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Artorias");
        Status esperado = Status.MORTO;
        // Act
        umOrc.recebeFlecha();
        umOrc.recebeFlecha();
        umOrc.recebeFlecha();
        umOrc.recebeFlecha();
        umOrc.recebeFlecha();
        umOrc.recebeFlecha();
        umOrc.recebeFlecha();
        umOrc.recebeFlecha();
        umOrc.recebeFlecha();
        umOrc.recebeFlecha();
        umOrc.recebeFlecha();
        umOrc.recebeFlecha();
        Status resultadoObtido = umOrc.getStatus();
        // Assert
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcRecebeAtaqueComNumeroGeradoMenorQueZero() {
        Orc umOrc = new Orc("Artorias");
        umOrc.recebeFlecha();
        
        int vidaEsperada = 110;
        int experienciaEsperada = 2;
        
        assertEquals(vidaEsperada, umOrc.getVida());
        assertEquals(experienciaEsperada, umOrc.getExperiencia());
    }
    
    @Test
    public void orcRecebeAtaqueComNumeroGeradoEntre0e100() {
        Orc umOrc = new Orc("Artorias"); // para somar 65 ao número gerado
        umOrc.setExperiencia(1); // ímpar e menor que 2 para poder manter entre 0 e 100
        umOrc.recebeFlecha();
        
        int vidaEsperada = 110;
        int experienciaEsperada = 1;
        
        assertEquals(vidaEsperada, umOrc.getVida());
        assertEquals(experienciaEsperada, umOrc.getExperiencia());
    }
    
    @Test
    public void orcRecebeAtaqueNormal() {
        Orc umOrc = new Orc("Artorias"); // para somar 65 ao número gerado e elevar ao cubo e não estar nos casos acima.
        umOrc.recebeFlecha();
        
        int vidaEsperada = 100;
        Status statusEsperado = Status.FERIDO;
        
        assertEquals(vidaEsperada, umOrc.getVida());
        assertEquals(statusEsperado, umOrc.getStatus());
    }
}
