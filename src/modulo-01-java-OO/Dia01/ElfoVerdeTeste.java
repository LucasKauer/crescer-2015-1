import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe de teste ElfoVerdeTeste.
 *
 * @author  Lucas Kauer
 */
public class ElfoVerdeTeste {
   @Test
    public void elfoVerdeNasceComNomeInformado() {
        // Arrange
        String esperado = "Celeborn";        
        // Act
        ElfoVerde umElfo = new ElfoVerde(esperado);
        // Assert
        assertEquals(esperado, umElfo.getNome());
    }
    
    @Test
    public void elfoVerdeNasceComNomeVazio() {
        // Arrange
        String esperado = "";        
        // Act
        ElfoVerde umElfo = new ElfoVerde(esperado);
        // Assert
        assertEquals(esperado, umElfo.getNome());
    }
    
    @Test
    public void elfoVerdeNasceComNomeNulo() {
        // Arrange
        String esperado = null;        
        // Act
        ElfoVerde umElfo = new ElfoVerde(esperado);
        // Assert
        assertEquals(esperado, umElfo.getNome());
    }
    
    @Test
    public void elfoVerdeNasceCom42FlechasPorPadrao() {
        // Arrange
        int esperado = 42;
        // Act
        ElfoVerde umElfo = new ElfoVerde("um nome qualquer");
        // Assert
        assertEquals(esperado, umElfo.getFlechas());
    }
    
    @Test
    public void elfoVerdeNasceComNomeEMuitasFlechasInformados() {
        // Arrange
        String nomeEsperado = "Robin";
        int flechasEsperadas = 567853;
        // Act
        ElfoVerde umElfo = new ElfoVerde(nomeEsperado, flechasEsperadas);
        // Assert
        assertEquals(nomeEsperado, umElfo.getNome());
        assertEquals(flechasEsperadas, umElfo.getFlechas());
    }
    
    @Test
    public void elfoVerdeGanhaODobroDeExperienciaQuandoAtira1Flecha() {
        // Arrange
        // Act
        ElfoVerde umElfo = new ElfoVerde("umNome");
        // Assert
        umElfo.atiraFlecha(new Orc());
        
        int esperado = 2;
        int resultadoObtido = umElfo.getExperiencia();
        assertEquals(resultadoObtido, esperado);
    }
    
    @Test
    public void elfoVerdeGanhaODobroDeExperienciaQuandoAtira5Flechas() {
        // Arrange
        // Act
        ElfoVerde umElfo = new ElfoVerde("umNome");
        // Assert
        umElfo.atiraFlecha(new Orc());
        umElfo.atiraFlecha(new Orc());
        umElfo.atiraFlecha(new Orc());
        umElfo.atiraFlecha(new Orc());
        umElfo.atiraFlecha(new Orc());
        
        int esperado = 10;
        int resultadoObtido = umElfo.getExperiencia();
        assertEquals(resultadoObtido, esperado);
    }
    
    @Test
    public void elfoVerdeGanhaODobroDeExperienciaQuandoAtira12Flechas() {
        // Arrange
        // Act
        ElfoVerde umElfo = new ElfoVerde("umNome");
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
        
        int esperado = 24;
        int resultadoObtido = umElfo.getExperiencia();
        assertEquals(resultadoObtido, esperado);
    }
    
    @Test
    public void elfoVerdeRecebeUmaEspadaDeAcoValiriano() {
        // Arrange
        ElfoVerde umElfo = new ElfoVerde("umNome");
        // Act
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<>();
        ItemDoInventario espadaDeAcoValiriano = new ItemDoInventario("Espada de aço valiriano", 2); 
        inventarioEsperado.add(espadaDeAcoValiriano);
        // Assert
        umElfo.adicionarItem(espadaDeAcoValiriano);
        
        assertEquals(inventarioEsperado, umElfo.getInventario());
    }
    
    @Test
    public void elfoVerdeRecebeUmArcoEFlechaDeVidro() {
        // Arrange
        ElfoVerde umElfo = new ElfoVerde("umNome");
        // Act
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<>();
        ItemDoInventario arcoEFlechaDeVidro = new ItemDoInventario("Arco e Flecha de vidro", 5); 
        inventarioEsperado.add(arcoEFlechaDeVidro);
        // Assert
        umElfo.adicionarItem(arcoEFlechaDeVidro);
        
        assertEquals(inventarioEsperado, umElfo.getInventario());
    }
    
    @Test
    public void elfoVerdeRecebeUmaEspadaDeAcoValirianoEUmArcoEFlechaDeVidro() {
        // Arrange
        ElfoVerde umElfo = new ElfoVerde("umNome");
        // Act
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<>();
        ItemDoInventario espadaDeAcoValiriano = new ItemDoInventario("Espada de aço valiriano", 2); 
        ItemDoInventario arcoEFlechaDeVidro = new ItemDoInventario("Arco e Flecha de vidro", 5); 
        inventarioEsperado.add(espadaDeAcoValiriano);
        inventarioEsperado.add(arcoEFlechaDeVidro);
        // Assert
        umElfo.adicionarItem(espadaDeAcoValiriano);
        umElfo.adicionarItem(arcoEFlechaDeVidro);
        
        assertEquals(inventarioEsperado, umElfo.getInventario());
    }
    
    @Test
    public void elfoVerdeRecebeAdagaEEscudo() {
        // Arrange
        ElfoVerde umElfo = new ElfoVerde("umNome");
        // Act
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<>();
        ItemDoInventario adaga = new ItemDoInventario("Adaga", 2); 
        ItemDoInventario escudo = new ItemDoInventario("Escudo", 5); 
        // Assert
        umElfo.adicionarItem(adaga);
        umElfo.adicionarItem(escudo);
        
        assertEquals(inventarioEsperado, umElfo.getInventario());
    }
}
