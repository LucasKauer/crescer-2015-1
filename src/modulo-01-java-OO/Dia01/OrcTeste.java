import java.util.*;
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
    private final double DELTA = 0.005;
    
    @Test
    public void orcNasceCom110Vida() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc;
        // Act - Execução da ação de testes
        umOrc = new Orc();
        // Assert - Verificação
        double esperado = 110;
        double resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido, DELTA);
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
        double esperado = 100;
        double resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido, DELTA);
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
        double esperado = 90;
        double resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido, DELTA);
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
        double esperado = 60;
        double resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido, DELTA);
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
        double esperado = 0;
        double resultadoObtido = umOrc.getVida();
        assertEquals(esperado, resultadoObtido, DELTA);
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
        String esperado = "Vida atual: 110.0";
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
        String esperado = "Vida atual: 100.0";
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
        String esperado = "Vida atual: 0.0";
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test public void orcRecebeAtaqueComNumeroGeradoMenorQueZero() {
        // Arrange
        Orc orc = new Orc("Tom");
        // Act
        orc.recebeAtaque();
        // Assert
        double vidaEsperada = 110;
        int experienciaEsperada = 2;
        
        assertEquals(vidaEsperada, orc.getVida(), DELTA);
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
        double vidaEsperada = 110;
        int experienciaEsperada = 1;
        
        assertEquals(vidaEsperada, orc.getVida(), DELTA);
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
        double vidaEsperada = 100;
        int experienciaEsperada = 2;
        
        assertEquals(vidaEsperada, orc.getVida(), DELTA);
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
    
    // Exemplo proposto em aula
    // Vários itens com diferentes quantidades
    @Test
    public void orcPegaOItemComMaiorQuantidadeDeUnidades() {
        Orc umOrc = new Orc();
        ItemDoInventario adaga = new ItemDoInventario("Adaga", 15);
        ItemDoInventario pocao = new ItemDoInventario("Poção", 2);
        ItemDoInventario flechas = new ItemDoInventario("Flechas", 17);
        ItemDoInventario pedrasPreciosas = new ItemDoInventario("Pedras Preciosas", 9);
        ItemDoInventario beyblade = new ItemDoInventario("Beyblade", 18);
        
        umOrc.adicionarItem(adaga);
        umOrc.adicionarItem(pocao);
        umOrc.adicionarItem(flechas);
        umOrc.adicionarItem(pedrasPreciosas);
        umOrc.adicionarItem(beyblade);
        
        ItemDoInventario resultadoObtido = umOrc.getItemComMaiorQuantidade();
        
        assertEquals(beyblade, resultadoObtido);
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
    
    // Um item
    @Test
    public void orcPegaOItemComMaiorQuantidadeQuandoTemUmItem() {
        Orc umOrc = new Orc();
        ItemDoInventario espada = new ItemDoInventario("Espada", 10);
        
        umOrc.adicionarItem(espada);
        
        ItemDoInventario resultadoObtido = umOrc.getItemComMaiorQuantidade();
        
        assertEquals(espada, resultadoObtido);
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
    
    // Dois itens com a mesma quantidade
    @Test
    public void orcPegaOItemComMaiorQuantidadeQuandoDoisItensTemAMesmaQuantidade() {
        Orc umOrc = new Orc();
        ItemDoInventario espada = new ItemDoInventario("Espada", 20);
        ItemDoInventario escudo = new ItemDoInventario("Escudo", 10);
        ItemDoInventario pocaoDeVida = new ItemDoInventario("Poção de Vida", 20);
        
        umOrc.adicionarItem(espada);
        umOrc.adicionarItem(escudo);
        umOrc.adicionarItem(pocaoDeVida);
        
        ItemDoInventario resultadoObtido = umOrc.getItemComMaiorQuantidade();
        
        assertEquals(espada, resultadoObtido);
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
    
    // Nenhum item
    @Test
    public void orcPegaOItemComMaiorQuantidadeQuandoNaoTemItens() {
        Orc umOrc = new Orc();
        
        ItemDoInventario esperado = null;
        ItemDoInventario resultadoObtido = umOrc.getItemComMaiorQuantidade();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    // TESTE DESAFIO 1
    @Test
    public void orcOrdenarItens() {
        Orc umOrc = new Orc();
        ItemDoInventario espada = new ItemDoInventario("Espada", 2);
        ItemDoInventario escudo = new ItemDoInventario("Escudo", 1);
        ItemDoInventario pocaoDeVida = new ItemDoInventario("Poção de Vida", 7);
        ItemDoInventario pocaoDeMana = new ItemDoInventario("Poção de Mana", 5);
        ItemDoInventario pedraPreciosa = new ItemDoInventario("Pedra Preciosa", 3);
        
        umOrc.adicionarItem(espada);
        umOrc.adicionarItem(escudo);
        umOrc.adicionarItem(pocaoDeVida);
        umOrc.adicionarItem(pocaoDeMana);
        umOrc.adicionarItem(pedraPreciosa);
               
        umOrc.ordenarItens();
        
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<ItemDoInventario>();
        inventarioEsperado.add(escudo);
        inventarioEsperado.add(espada);
        inventarioEsperado.add(pedraPreciosa);
        inventarioEsperado.add(pocaoDeMana);
        inventarioEsperado.add(pocaoDeVida);
        
        ArrayList<ItemDoInventario> esperado = inventarioEsperado;
        
        assertEquals(esperado, umOrc.getInventario());
    }
    
    // TESTE DESAFIO 2
    @Test
    public void orcOrdenarItensQuandoOInventarioEstiverEmOrdem() {
        Orc umOrc = new Orc();
        ItemDoInventario espada = new ItemDoInventario("Espada", 1);
        ItemDoInventario escudo = new ItemDoInventario("Escudo", 2);
        ItemDoInventario pocaoDeVida = new ItemDoInventario("Poção de Vida", 3);
        ItemDoInventario pocaoDeMana = new ItemDoInventario("Poção de Mana", 4);
        ItemDoInventario pedraPreciosa = new ItemDoInventario("Pedra Preciosa", 5);
        
        umOrc.adicionarItem(espada);
        umOrc.adicionarItem(escudo);
        umOrc.adicionarItem(pocaoDeVida);
        umOrc.adicionarItem(pocaoDeMana);
        umOrc.adicionarItem(pedraPreciosa);
               
        umOrc.ordenarItens();
        
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<ItemDoInventario>();
        inventarioEsperado.add(espada);
        inventarioEsperado.add(escudo);
        inventarioEsperado.add(pocaoDeVida);
        inventarioEsperado.add(pocaoDeMana);
        inventarioEsperado.add(pedraPreciosa);
        
        ArrayList<ItemDoInventario> esperado = inventarioEsperado;
        
        assertEquals(esperado, umOrc.getInventario());
    }
    
    // TESTE DESAFIO 3
    @Test
    public void orcOrdenarItensQuandoOInventarioEstiverVazio() {
        Orc umOrc = new Orc();
        
        umOrc.ordenarItens();
        
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<ItemDoInventario>();
        
        ArrayList<ItemDoInventario> esperado = inventarioEsperado;
        
        assertEquals(esperado, umOrc.getInventario());
    }
    
    // TESTE DESAFIO 4
    @Test
    public void orcOrdenarItensQuandoOSegundoForOMenor() {
        Orc umOrc = new Orc();
        ItemDoInventario espada = new ItemDoInventario("Espada", 2);
        ItemDoInventario escudo = new ItemDoInventario("Escudo", 1);
        ItemDoInventario pocaoDeVida = new ItemDoInventario("Poção de Vida", 3);
        
        umOrc.adicionarItem(espada);
        umOrc.adicionarItem(escudo);
        umOrc.adicionarItem(pocaoDeVida);
        
        umOrc.ordenarItens();
        
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<ItemDoInventario>();
        inventarioEsperado.add(escudo);
        inventarioEsperado.add(espada);
        inventarioEsperado.add(pocaoDeVida);
        
        ArrayList<ItemDoInventario> esperado = inventarioEsperado;
        
        assertEquals(esperado, umOrc.getInventario());
    }
    
    // TESTE DESAFIO 5
    @Test
    public void orcOrdenarItensQuandoOTerceiroForOMenor() {
        Orc umOrc = new Orc();
        ItemDoInventario espada = new ItemDoInventario("Espada", 3);
        ItemDoInventario escudo = new ItemDoInventario("Escudo", 2);
        ItemDoInventario pocaoDeVida = new ItemDoInventario("Poção de Vida", 1);
        
        umOrc.adicionarItem(pocaoDeVida);
        umOrc.adicionarItem(escudo);
        umOrc.adicionarItem(espada);
        
        umOrc.ordenarItens();
        
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<ItemDoInventario>();
        inventarioEsperado.add(pocaoDeVida);
        inventarioEsperado.add(escudo);
        inventarioEsperado.add(espada);
        
        ArrayList<ItemDoInventario> esperado = inventarioEsperado;
        
        assertEquals(esperado, umOrc.getInventario());
    }
    
    // TESTE DESAFIO 6
    @Test
    public void orcOrdenarItensQuandoOUltimoForOMenor() {
        Orc umOrc = new Orc();
        ItemDoInventario espada = new ItemDoInventario("Espada", 5);
        ItemDoInventario escudo = new ItemDoInventario("Escudo", 2);
        ItemDoInventario pocaoDeVida = new ItemDoInventario("Poção de Vida", 7);
        ItemDoInventario pocaoDeMana = new ItemDoInventario("Poção de Mana", 6);
        ItemDoInventario pedraPreciosa = new ItemDoInventario("Pedra Preciosa", 1);
        
        umOrc.adicionarItem(espada);
        umOrc.adicionarItem(escudo);
        umOrc.adicionarItem(pocaoDeVida);
        umOrc.adicionarItem(pocaoDeMana);
        umOrc.adicionarItem(pedraPreciosa);
        
        umOrc.ordenarItens();
        
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<ItemDoInventario>();
        inventarioEsperado.add(pedraPreciosa);
        inventarioEsperado.add(escudo);
        inventarioEsperado.add(espada);
        inventarioEsperado.add(pocaoDeMana);
        inventarioEsperado.add(pocaoDeVida);
        
        ArrayList<ItemDoInventario> esperado = inventarioEsperado;
        
        assertEquals(esperado, umOrc.getInventario());
    }
    
    // TESTE DESAFIO 7
    @Test
    public void orcOrdenarItensQuandoODoisItensTemAMesmaQuantidade() {
        Orc umOrc = new Orc();
        ItemDoInventario espada = new ItemDoInventario("Espada", 5);
        ItemDoInventario escudo = new ItemDoInventario("Escudo", 1);
        ItemDoInventario pocaoDeVida = new ItemDoInventario("Poção de Vida", 7);
        ItemDoInventario pocaoDeMana = new ItemDoInventario("Poção de Mana", 6);
        ItemDoInventario pedraPreciosa = new ItemDoInventario("Pedra Preciosa", 1);
        
        umOrc.adicionarItem(espada);
        umOrc.adicionarItem(escudo);
        umOrc.adicionarItem(pocaoDeVida);
        umOrc.adicionarItem(pocaoDeMana);
        umOrc.adicionarItem(pedraPreciosa);
        
        umOrc.ordenarItens();
        
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<ItemDoInventario>();
        inventarioEsperado.add(escudo);
        inventarioEsperado.add(pedraPreciosa);
        inventarioEsperado.add(espada);
        inventarioEsperado.add(pocaoDeMana);
        inventarioEsperado.add(pocaoDeVida);
        
        ArrayList<ItemDoInventario> esperado = inventarioEsperado;
        
        assertEquals(esperado, umOrc.getInventario());
    }
}