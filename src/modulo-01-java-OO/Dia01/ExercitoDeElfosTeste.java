import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;

/**
 * Escreva a descrição da classe ExercitoDeElfosTeste aqui.
 * 
 * @author Lucas Kauer
 */
public class ExercitoDeElfosTeste {
    @Test
    public void alistarElfoBaseNãoAlista() {
        // Arrange
        Elfo umElfo = new Elfo("Legolas");
        HashMap<String, Elfo> exercitoEsperado = new HashMap<>();
        ExercitoDeElfos umExercito = new ExercitoDeElfos();
        // Act
        umExercito.alistarElfo(umElfo);
        // Assert
        HashMap<String, Elfo> obtido = umExercito.getExercito();
        assertEquals(exercitoEsperado, obtido);
    }
    
    @Test
    public void alistarDoisElfosBaseNãoAlistaNenhum() {
        // Arrange
        Elfo umElfo = new Elfo("Legolas");
        Elfo umElfo2 = new Elfo("Arwen");
        HashMap<String, Elfo> exercitoEsperado = new HashMap<>();
        ExercitoDeElfos umExercito = new ExercitoDeElfos();
        // Act
        umExercito.alistarElfo(umElfo);
        umExercito.alistarElfo(umElfo2);
        // Assert
        HashMap<String, Elfo> obtido = umExercito.getExercito();
        assertEquals(exercitoEsperado, obtido);
    }
    
    @Test
    public void alistarElfoVerdeAlista() {
        // Arrange
        Elfo umElfo = new ElfoVerde("Green Legolas");
        HashMap<String, Elfo> exercitoEsperado = new HashMap<>();
        exercitoEsperado.put(umElfo.getNome(), umElfo);
        ExercitoDeElfos umExercito = new ExercitoDeElfos();
        // Act
        umExercito.alistarElfo(umElfo);
        // Assert
        HashMap<String, Elfo> obtido = umExercito.getExercito();
        assertEquals(exercitoEsperado, obtido);
    }
    
    @Test
    public void alistarElfoNoturnoAlista() {
        // Arrange
        Elfo umElfo = new ElfoNoturno("Night Legolas");
        HashMap<String, Elfo> exercitoEsperado = new HashMap<>();
        exercitoEsperado.put(umElfo.getNome(), umElfo);
        ExercitoDeElfos umExercito = new ExercitoDeElfos();
        // Act
        umExercito.alistarElfo(umElfo);
        // Assert
        HashMap<String, Elfo> obtido = umExercito.getExercito();
        assertEquals(exercitoEsperado, obtido);
    }
    
    @Test
    public void alistarElfosVerdesENoturnosAlistaTodos() {
        // Arrange
        Elfo umElfo = new ElfoNoturno("Night Legolas");
        Elfo umElfo2 = new ElfoNoturno("Night Legolas 2");
        Elfo umElfo3 = new ElfoVerde("Green Legolas");
        HashMap<String, Elfo> exercitoEsperado = new HashMap<>();
        exercitoEsperado.put(umElfo.getNome(), umElfo);
        exercitoEsperado.put(umElfo2.getNome(), umElfo2);
        exercitoEsperado.put(umElfo3.getNome(), umElfo3);
        ExercitoDeElfos umExercito = new ExercitoDeElfos();
        // Act
        umExercito.alistarElfo(umElfo);
        umExercito.alistarElfo(umElfo2);
        umExercito.alistarElfo(umElfo3);
        // Assert
        HashMap<String, Elfo> obtido = umExercito.getExercito();
        assertEquals(exercitoEsperado, obtido);
    }
    
    @Test
    public void alistarElfosVerdesENoturnosAlistaTodosMenosBase() {
        // Arrange
        Elfo umElfo = new ElfoNoturno("Night Legolas");
        Elfo umElfo2 = new ElfoNoturno("Night Legolas 2");
        Elfo umElfo3 = new ElfoVerde("Green Legolas");
        Elfo umElfoBase = new Elfo("Normal Legolas");
        HashMap<String, Elfo> exercitoEsperado = new HashMap<>();
        exercitoEsperado.put(umElfo.getNome(), umElfo);
        exercitoEsperado.put(umElfo2.getNome(), umElfo2);
        exercitoEsperado.put(umElfo3.getNome(), umElfo3);
        ExercitoDeElfos umExercito = new ExercitoDeElfos();
        // Act
        umExercito.alistarElfo(umElfoBase);
        umExercito.alistarElfo(umElfo);
        umExercito.alistarElfo(umElfo2);
        umExercito.alistarElfo(umElfo3);
        // Assert
        HashMap<String, Elfo> obtido = umExercito.getExercito();
        assertEquals(exercitoEsperado, obtido);
    }
    
    @Test
    public void buscarElfoPeloNomeNãoAlistado() {
        // Arrange
        Elfo esperado = null;
        ExercitoDeElfos umExercito = new ExercitoDeElfos();
        // Act
        Elfo obtido = umExercito.buscarNomeDoElfo("John Elf Doe");
        // Assert
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void buscarElfoAlistado() {
        // Arrange
        String nomeElfo = "Legolas II";
        Elfo esperado = new ElfoVerde(nomeElfo);
        ExercitoDeElfos umExercito = new ExercitoDeElfos();
        umExercito.alistarElfo(esperado);
        // Act
        Elfo obtido = umExercito.buscarNomeDoElfo(nomeElfo);
        // Assert
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void buscarElfoAlistadoComVarios() {
        // Arrange
        String nomeElfo = "Legolas II";
        Elfo esperado = new ElfoVerde(nomeElfo);
        ExercitoDeElfos umExercito = new ExercitoDeElfos();
        umExercito.alistarElfo(esperado);
        umExercito.alistarElfo(new ElfoVerde("Green Elf"));
        umExercito.alistarElfo(new ElfoNoturno("Night Elf"));
        // Act
        Elfo obtido = umExercito.buscarNomeDoElfo(nomeElfo);
        // Assert
        assertEquals(esperado, obtido);
    }
}