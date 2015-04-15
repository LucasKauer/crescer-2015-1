import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

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
        try {
            umExercito.alistarElfo(umElfo);
        } catch (NaoPodeAlistarException error) {
            System.out.println(error);
        }
        
        finally {
            System.out.println("Finalmente último dia de Bluej!");
        }
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
        try {
            umExercito.alistarElfo(umElfo);
        } catch (NaoPodeAlistarException error) {
            System.out.println(error);
        }
        
        try {
            umExercito.alistarElfo(umElfo2);
        } catch (NaoPodeAlistarException error) {
            System.out.println(error);
        }
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
        try {
            umExercito.alistarElfo(umElfo);
        } catch (NaoPodeAlistarException error) {
            System.out.println(error);
        }
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
        try {
            umExercito.alistarElfo(umElfo);
        } catch (NaoPodeAlistarException error) {
            System.out.println(error);
        }
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
        try {
            umExercito.alistarElfo(umElfo);
        } catch (NaoPodeAlistarException error) {
            System.out.println(error);
        }
        
        try {
            umExercito.alistarElfo(umElfo2);
        } catch (NaoPodeAlistarException error) {
            System.out.println(error);
        }
        
        try {
            umExercito.alistarElfo(umElfo3);
        } catch (NaoPodeAlistarException error) {
            System.out.println(error);
        }
        
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
        try {
            umExercito.alistarElfo(umElfoBase);
        } catch (NaoPodeAlistarException error) {
            System.out.println(error);
        }
        
        try {
            umExercito.alistarElfo(umElfo);
        } catch (NaoPodeAlistarException error) {
            System.out.println(error);
        }
        
        try {
            umExercito.alistarElfo(umElfo2);
        } catch (NaoPodeAlistarException error) {
            System.out.println(error);
        }
        
        try {
            umExercito.alistarElfo(umElfo3);
        } catch (NaoPodeAlistarException error) {
            System.out.println(error);
        }
        // Assert
        HashMap<String, Elfo> obtido = umExercito.getExercito();
        assertEquals(exercitoEsperado, obtido);
    }
    
    
    // Novos!
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
        try {
            umExercito.alistarElfo(esperado);
        } catch (NaoPodeAlistarException error) {
            System.out.println(error);
        }
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
        
        try {
            umExercito.alistarElfo(new ElfoVerde("Legolas II"));
            umExercito.alistarElfo(new ElfoNoturno("Night Elf"));
        } catch (NaoPodeAlistarException error) {
            System.out.println(error);
        }
        // Act
        Elfo obtido = umExercito.buscarNomeDoElfo(nomeElfo);
        // Assert
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void agruparVariosElfosPorStatus() {
        // Arrange
        ElfoVerde elfoVivo1 = new ElfoVerde("Green 1");
        ElfoNoturno elfoVivo2 = new ElfoNoturno("Aa");
        ElfoVerde elfoVivo3 = new ElfoVerde("BB");
        ElfoVerde elfoAtacando1 = new ElfoVerde("Green 2");
        ElfoVerde elfoAtacando2 = new ElfoVerde("Green 3");
        elfoAtacando1.atiraFlecha(new Orc());
        elfoAtacando2.atiraFlecha(new Orc());
        HashMap<Status, ArrayList<Elfo>> esperado = new HashMap<>();
        esperado.put(Status.ATACANDO, new ArrayList<>(
            Arrays.asList(elfoAtacando1, elfoAtacando2)
        ));
        esperado.put(Status.VIVO, new ArrayList<>(
            Arrays.asList(elfoVivo2, elfoVivo3, elfoVivo1)
        ));
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        
        try {
            exercito.alistarElfo(elfoAtacando1);
        } catch (NaoPodeAlistarException error) {
            System.out.println(error);
        }
        
        try {
            exercito.alistarElfo(elfoAtacando2);
        } catch (NaoPodeAlistarException error) {
            System.out.println(error);
        }
        
        try {
            exercito.alistarElfo(elfoVivo1);
        } catch (NaoPodeAlistarException error) {
            System.out.println(error);
        }
        
       
        try {
            exercito.alistarElfo(elfoVivo2);
        } catch (NaoPodeAlistarException error) {
            System.out.println(error);
        }
       
               try {
            exercito.alistarElfo(elfoVivo3);
        } catch (NaoPodeAlistarException error) {
            System.out.println(error);
        }
        // Act
        exercito.agruparElfosPorStatus();
        HashMap<Status, ArrayList<Elfo>> resultado = exercito.getExercitoAgrupadoPorStatus();
        // Assert
        assertEquals(esperado, resultado);
    }
    
    @Test
    public void buscarPorStatusAtacandoComVariosElfos() {
        // Arrange
        ElfoVerde elfoVivo1 = new ElfoVerde("Green 1");
        ElfoNoturno elfoVivo2 = new ElfoNoturno("Aa");
        ElfoVerde elfoVivo3 = new ElfoVerde("BB");
        ElfoVerde elfoAtacando1 = new ElfoVerde("Green 2");
        ElfoVerde elfoAtacando2 = new ElfoVerde("Green 3");
        elfoAtacando1.atiraFlecha(new Orc());
        elfoAtacando2.atiraFlecha(new Orc());
        ArrayList<Elfo> esperado = new ArrayList<>(
            Arrays.asList(elfoAtacando1, elfoAtacando2)
        );
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        
        try {
            exercito.alistarElfo(elfoAtacando1);
        } catch (NaoPodeAlistarException error) {
            System.out.println(error);
        }
        
        try {
            exercito.alistarElfo(elfoAtacando2);
        } catch (NaoPodeAlistarException error) {
            System.out.println(error);
        }
        
        try {
            exercito.alistarElfo(elfoVivo1);
        } catch (NaoPodeAlistarException error) {
            System.out.println(error);
        }
       
        try {
            exercito.alistarElfo(elfoVivo2);
        } catch (NaoPodeAlistarException error) {
            System.out.println(error);
        }
        
        try {
            exercito.alistarElfo(elfoVivo3);
        } catch (NaoPodeAlistarException error) {
            System.out.println(error);
        }
        // Act
        ArrayList<Elfo> resultado = exercito.buscarElfosPorStatus(Status.ATACANDO);
        // Assert
        assertEquals(esperado, resultado);
    }
}