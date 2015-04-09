import java.util.*;
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
    
    @Test
    public void orcPerdeUmItem() {
        // Arrange
        Orc umOrc = new Orc("Nome Grande Aqui");
        // Act
        ItemDoInventario i = new ItemDoInventario("Espada", 2); 
        umOrc.adicionarItem(i);
        umOrc.perderItem(i);
        // Assert
        int tamanhoDoInventarioEsperado = 0;
        
        assertEquals(tamanhoDoInventarioEsperado, umOrc.getTamanhoDoInventario());
    }
    
    // [!] KEEP CALM!
    @Test
    public void orcRecebeAdaga() {
        // Arrange
        Orc umOrc = new Orc();
        ItemDoInventario adaga = new ItemDoInventario("Adaga", 10);
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<>();
        inventarioEsperado.add(adaga);
        // Act
        umOrc.adicionarItem(adaga);
        ArrayList<ItemDoInventario> inventarioObtido = umOrc.getInventario();
        // Assert
        assertEquals(inventarioEsperado, inventarioObtido);
    }

    @Test
    public void orcRecebeAdagaEEscudo() {
        // Arrange
        Orc umOrc = new Orc();
        ItemDoInventario adaga = new ItemDoInventario("Adaga", 11);
        ItemDoInventario escudo = new ItemDoInventario("Escudo", 10);
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<>();
        inventarioEsperado.add(adaga);
        inventarioEsperado.add(escudo);
        // Act
        umOrc.adicionarItem(adaga);
        umOrc.adicionarItem(escudo);
        ArrayList<ItemDoInventario> inventarioObtido = umOrc.getInventario();
        // Assert
        assertEquals(inventarioEsperado, inventarioObtido);
    }

    @Test
    public void orcRecebeAdagaEPerdeAdaga() {
        // Arrange
        Orc umOrc = new Orc();
        ItemDoInventario adaga = new ItemDoInventario("Adaga", 12);
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<>();
        umOrc.adicionarItem(adaga);
        // Act
        umOrc.perderItem(adaga);
        ArrayList<ItemDoInventario> inventarioObtido = umOrc.getInventario();
        // Assert
        assertEquals(inventarioEsperado, inventarioObtido);
    }

    @Test
    public void orcRecebeAdagaEEscudoEPerdeEscudo() {
        // Arrange
        Orc umOrc = new Orc();
        ItemDoInventario adaga = new ItemDoInventario("Adaga", 13);
        ItemDoInventario escudo = new ItemDoInventario("Escudo", 11);
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<>();
        inventarioEsperado.add(adaga);
        umOrc.adicionarItem(adaga);
        umOrc.adicionarItem(escudo);
        // Act
        umOrc.perderItem(escudo);
        ArrayList<ItemDoInventario> inventarioObtido = umOrc.getInventario();
        // Assert
        assertEquals(inventarioEsperado, inventarioObtido);
    }
    
    // [!] KEEP CALM²
    @Test
    public void getDescricoesComNenhumItem() {
        // Arrange
        Orc umOrc = new Orc();
        String descricoesEsperada = "";
        // Act
        String resultadoDescricoes = umOrc.getDescricoesItens();
        // Assert
        assertEquals(descricoesEsperada, resultadoDescricoes);
    }
    
    @Test
    public void getDescricoesComUmItem() {
        // Arrange
        Orc umOrc = new Orc();
        ItemDoInventario adaga = new ItemDoInventario("Adaga", 34);
        umOrc.adicionarItem(adaga);
        String descricoesEsperada = "Adaga";
        // Act
        String resultadoDescricoes = umOrc.getDescricoesItens();
        // Assert
        assertEquals(descricoesEsperada, resultadoDescricoes);
    }
    
    @Test
    public void getDescricoesComDoisItens() {
        // Arrange
        Orc umOrc = new Orc();
        ItemDoInventario adaga = new ItemDoInventario("Adaga", 34);
        ItemDoInventario escudo = new ItemDoInventario("Escudo de carvalho", 12);
        umOrc.adicionarItem(adaga);
        umOrc.adicionarItem(escudo);
        String descricoesEsperada = "Adaga,Escudo de carvalho";
        // Act
        String resultadoDescricoes = umOrc.getDescricoesItens();
        // Assert
        assertEquals(descricoesEsperada, resultadoDescricoes);
    }
    
    @Test
    public void orcTentaSorte() {
        // Nome menor que 5
        // Status dormindo ou caçando
        // Experiência ímpar maior que 2
        Orc umOrc = new Orc();
        umOrc.setStatus(Status.DORMINDO);
        umOrc.setExperiencia(3);
        // "Eu não faço elfos terem MANA para evitar insesto" - CWI, Bernardo.
        // Dê um getMana e seja feliz ;D
        umOrc.adicionarItem(new ItemDoInventario ("Poção de mana", 3));
        umOrc.adicionarItem(new ItemDoInventario ("Poção Lança", 1));
        
        umOrc.tentarSorte();
        
        ItemDoInventario pocao = umOrc.getInventario().get(0);
        ItemDoInventario lanca = umOrc.getInventario().get(1);
        
        assertEquals(1003, pocao.getQuantidade());
        assertEquals(1001, lanca.getQuantidade());
    }
    
    @Test
    public void orcPegaOItemComMaiorQuantidade() {
        Orc umOrc = new Orc();
        ItemDoInventario espada = new ItemDoInventario("Espada", 10);
        ItemDoInventario escudo = new ItemDoInventario("Escudo", 20);
        ItemDoInventario pocaoDeVida = new ItemDoInventario("Poção de Vida", 30);
        
        umOrc.adicionarItem(espada);
        umOrc.adicionarItem(escudo);
        umOrc.adicionarItem(pocaoDeVida);
        
        ItemDoInventario resultadoObtido = umOrc.getItemComMaiorQuantidade();
        
        assertEquals(pocaoDeVida, resultadoObtido);
    }
    
    @Test
    public void orcPegaOItemComMaiorQuantidadeQuandoEleEstaNaPosicaoDois() {
        Orc umOrc = new Orc();
        ItemDoInventario espada = new ItemDoInventario("Espada", 10);
        ItemDoInventario escudo = new ItemDoInventario("Escudo", 30);
        ItemDoInventario pocaoDeVida = new ItemDoInventario("Poção de Vida", 20);
        
        umOrc.adicionarItem(espada);
        umOrc.adicionarItem(escudo);
        umOrc.adicionarItem(pocaoDeVida);
        
        ItemDoInventario resultadoObtido = umOrc.getItemComMaiorQuantidade();
        
        assertEquals(escudo, resultadoObtido);
    }
    
    @Test
    public void orcPegaOItemComMaiorQuantidadeQuandoTodosItensTemAMesmaQuantidade() {
        Orc umOrc = new Orc();
        ItemDoInventario espada = new ItemDoInventario("Espada", 10);
        ItemDoInventario escudo = new ItemDoInventario("Escudo", 10);
        ItemDoInventario pocaoDeVida = new ItemDoInventario("Poção de Vida", 10);
        
        umOrc.adicionarItem(espada);
        umOrc.adicionarItem(escudo);
        umOrc.adicionarItem(pocaoDeVida);
        
        ItemDoInventario resultadoObtido = umOrc.getItemComMaiorQuantidade();
        
        assertEquals(espada, resultadoObtido);
    }
}