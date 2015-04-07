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
public class OrcTest
{
    @Test
    public void orcNasceComNomeInformado(){
        String nomeEsperado = "Tom";
        Orc umOrc = new Orc(nomeEsperado);
        assertEquals(nomeEsperado, umOrc.getNome());
    }
    
    @Test
    public void orcNasceComNomeVazio(){
        String nomeEsperado = "";
        Orc umOrc = new Orc(nomeEsperado);
        assertEquals(nomeEsperado, umOrc.getNome());
    }
    
    @Test
    public void orcNasceComNomeNulo(){
        String nomeEsperado = null;
        Orc umOrc = new Orc(nomeEsperado);
        assertEquals(nomeEsperado, umOrc.getNome());
    }
    
    @Test
    public void orcNasceVivo(){
        Orc umOrc = new Orc();
        Status esperado = Status.VIVO;
        assertEquals(esperado, umOrc.getStatus());
    }
    
	@Test
    public void orcRecebeUmAtaque(){
		Orc umOrc = new Orc("Nome Grande Aqui");
		umOrc.recebeFlecha();
		int esperado = 100;
		int resultadoObtido = umOrc.getVida();
		assertEquals(esperado, resultadoObtido);
	}

	@Test
	public void orcFericoAposReceberAtaque(){
	    Orc umOrc = new Orc("Nome Grande Aqui");
	    umOrc.recebeFlecha();
	    Status statusEsperado = Status.FERIDO;
	    assertEquals(statusEsperado, umOrc.getStatus());
	}
	
	@Test
	public void orcRecebeDoisAtaques(){
		Orc umOrc = new Orc("Nome Grande Aqui");
		umOrc.recebeFlecha();
		umOrc.recebeFlecha();
		int esperado = 90;
		int resultadoObtido = umOrc.getVida();
		assertEquals(esperado, resultadoObtido);
	}

	@Test
	public void orcRecebeCincoAtaques(){
		Orc umOrc = new Orc("Nome Grande Aqui");
		umOrc.recebeFlecha();
		umOrc.recebeFlecha();
		umOrc.recebeFlecha();
		umOrc.recebeFlecha();
		umOrc.recebeFlecha();
		int esperado = 60;
		int resultadoObtido = umOrc.getVida();
		assertEquals(esperado, resultadoObtido);
	}

	@Test
	public void orcToStringAposRecebeDozeAtaques(){
		Orc umOrc = new Orc("Nome Grande Aqui");
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
		String esperado = "Vida atual: 0";
		String resultadoObtido = umOrc.toString();
		assertEquals(esperado, resultadoObtido);
	}
	@Test
	public void orcMorreAoZerarVida(){
	    Orc umOrc = new Orc("Nome Grande Aqui");
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
		Status statusEsperado = Status.MORTO;
		assertEquals(statusEsperado, umOrc.getStatus());
	}
	
	@Test
	public void orcToStringVidaPadrao(){
		Orc umOrc = new Orc();
		String esperado = "Vida atual: 110";
		String resultadoObtido = umOrc.toString();
		assertEquals(esperado, resultadoObtido);
	}

	@Test
	public void orcToStringAposRecebeAtaque(){
		Orc umOrc = new Orc();
	    umOrc.recebeFlecha();
		String esperado = "Vida atual: 110";
		String resultadoObtido = umOrc.toString();
		assertEquals(esperado, resultadoObtido);
	}
	
	@Test
	public void orcToStringAposReceberDozeAtaques() {
	    Orc umOrc = new Orc("Nome Grande Aqui");
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
		String esperado = "Vida atual: 0";
		String resultadoObtido = umOrc.toString();
		assertEquals(esperado, resultadoObtido);
	}
	
	@Test
	public void orcRecebeAtaqueComNumeroGeradoMenorQueZero(){
	    Orc umOrc = new Orc("Tom");
        umOrc.recebeFlecha();
	    int vidaEsperada = 110;
	    int experienciaEsperada = 2;
	    assertEquals(vidaEsperada, umOrc.getVida());
	    assertEquals(experienciaEsperada, umOrc.getExperiencia());
	}
	
	@Test
	public void orcRecebeAtaqueComNumeroEntre0E100(){
	    Orc umOrc = new Orc("Nome Grande Aqui");
	    umOrc.setExperiencia(1);
        umOrc.recebeFlecha();
	    int vidaEsperada = 100;
	    int experienciaEsperada = 1;
	    assertEquals(vidaEsperada, umOrc.getVida());
	    assertEquals(experienciaEsperada, umOrc.getExperiencia());
	}
	
	@Test
	public void orcRecebeAtaqueComNumeroMaiorQue100(){
	    Orc umOrc= new Orc("Tomzinho");
	    umOrc.setExperiencia(2);
        umOrc.recebeFlecha();
	    int vidaEsperada = 100;
	    int experienciaEsperada = 2;
	    assertEquals(vidaEsperada, umOrc.getVida());
	    assertEquals(experienciaEsperada, umOrc.getExperiencia());
	}
}