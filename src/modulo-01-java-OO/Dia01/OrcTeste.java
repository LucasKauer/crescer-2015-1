import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe de teste OrcTest.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class OrcTeste
{
    @Test
    public void orcNasceCom110Vida() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc;
        // Act - Execução da ação de testes
        umOrc = new Orc();
        // Assert - Verificação
        int esperado = 110;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcNasceComNomeInformado() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc;
        String nomeEsperado = "Urukhai";
        // Act - Execução da ação de testes
        umOrc = new Orc(nomeEsperado);
        // Assert - Verificação
        assertEquals(nomeEsperado, umOrc.getNome());
    }
    
    @Test
    public void orcNasceComNomeVazio() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc;
        String nomeEsperado = "";
        // Act - Execução da ação de testes
        umOrc = new Orc(nomeEsperado);
        // Assert - Verificação
        assertEquals(nomeEsperado, umOrc.getNome());
    }
    
    @Test
    public void orcNasceComNomeNulo() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc;
        String nomeEsperado = null;
        // Act - Execução da ação de testes
        umOrc = new Orc(nomeEsperado);
        // Assert - Verificação
        assertEquals(nomeEsperado, umOrc.getNome());
    }
    
    @Test
    public void orcNasceVivo() {
        // Arrange
        Orc orc;
        // Act
        orc = new Orc();
        // Assert
        Status esperado = Status.VIVO;
        assertEquals(esperado, orc.getStatus());
    }
    
    @Test
    public void orcRecebeAtaqueUmaVez() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Nome Grande Aqui");
        // Act
        umOrc.recebeAtaque();
        // Assert - Verificação
        int esperado = 100;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcFeridoAposReceberAtaque() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Nome Grande Aqui");
        // Act
        umOrc.recebeAtaque();
        // Assert - Verificação
        Status statusEsperado = Status.FERIDO;
        assertEquals(statusEsperado, umOrc.getStatus());
    }   
    
    @Test
    public void orcRecebeAtaqueDuasVezes() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Nome Grande Aqui");
        // Act
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        // Assert - Verificação
        int esperado = 90;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcRecebeAtaqueCincoVezes() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Nome Grande Aqui");
        // Act
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        // Assert - Verificação
        int esperado = 60;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcRecebeAtaqueDozeVezes() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Nome Grande Aqui");
        // Act
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        // Assert - Verificação
        int esperado = 0;
        int resultadoObtido = umOrc.getVida();
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcMorreAoZerarVida() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Nome Grande Aqui");
        // Act
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        // Assert - Verificação
        Status statusEsperado = Status.MORTO;
        assertEquals(statusEsperado, umOrc.getStatus());
    }
    
    @Test
    public void orcToStringRetornaVidaPadrao() {
        // Arrange
        Orc orc = new Orc();
        // Act
        String resultadoObtido = orc.toString();
        // Assert
        String esperado = "Vida atual: 110";
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcToStringAposReceberAtaque() {
        // Arrange
        Orc orc = new Orc("Game Shark Xiti Manha");
        // Act
        orc.recebeAtaque();
        String resultadoObtido = orc.toString();
        // Assert
        String esperado = "Vida atual: 100";
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcToStringAposReceberDozeAtaques() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Nome Grande Aqui");
        // Act
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        String resultadoObtido = umOrc.toString();
        // Assert
        String esperado = "Vida atual: 0";
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test public void orcRecebeAtaqueComNumeroGeradoMenorQueZero() {
        // Arrange
        Orc orc = new Orc("Tom");
        // Act
        orc.recebeAtaque();
        // Assert
        int vidaEsperada = 110;
        int experienciaEsperada = 2;
        
        assertEquals(vidaEsperada, orc.getVida());
        assertEquals(experienciaEsperada, orc.getExperiencia());
    }
    
    @Test
    public void orcRecebeAtaqueComNumeroEntre0e100() {
        // Arrange
        Orc orc = new Orc("Tom Bombadil");
        orc.setExperiencia(1);
        // Act
        orc.recebeAtaque();
        // Assert
        int vidaEsperada = 110;
        int experienciaEsperada = 1;
        
        assertEquals(vidaEsperada, orc.getVida());
        assertEquals(experienciaEsperada, orc.getExperiencia());
    }
    
    @Test
    public void orcRecebeAtaqueComNumeroMaiorQue100() {
        // Arrange
        Orc orc = new Orc("Tom Bombadil");
        orc.setExperiencia(2);
        // Act
        orc.recebeAtaque();
        // Assert
        int vidaEsperada = 100;
        int experienciaEsperada = 2;
        
        assertEquals(vidaEsperada, orc.getVida());
        assertEquals(experienciaEsperada, orc.getExperiencia());
    }
    
    @Test
    public void orcRecebeUmItem() {
        // Arrange
        Orc umOrc = new Orc("Nome Grande Aqui");
        // Act
        ItemDoInventario i = new ItemDoInventario("Espada", 2); 
        umOrc.adicionarItem(i);
        // Assert
        int tamanhoDoInventarioEsperado = 1;
        
        assertEquals(tamanhoDoInventarioEsperado, umOrc.getTamanhoDoInventario());
    }
}