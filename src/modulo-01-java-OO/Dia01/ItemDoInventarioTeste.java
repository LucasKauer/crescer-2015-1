import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe de teste do ItemDoInventarioTeste.
 *
 * @autor Lucas Kauer
 */
public class ItemDoInventarioTeste
{
    @Test
    public void criarItemComDescricaoEQuantidade() {
        // Arrange
        ItemDoInventario i = new ItemDoInventario("Espada", 2);
        // Act
        int quantidadeEsperada = 2;
        String descricaoEsperada = "Espada";
        // Assert
        assertEquals(quantidadeEsperada, i.getQuantidade());
        assertEquals(descricaoEsperada, i.getDescricao());
    }
    
}