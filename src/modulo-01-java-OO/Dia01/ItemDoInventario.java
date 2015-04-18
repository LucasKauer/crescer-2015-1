/**
 * Define objetos ItemDoInventário
 * 
 * @author Lucas Kauer
 */
public class ItemDoInventario
{
    private String descricao;
    private int quantidade;
    
    
    /**
     * Cria um item de inventário com a quantidade e descrição informadas.
     * 
     * @param quantidade Quantidade de unidades no inventário
     * @param descricao Descrição do item
     */
    public ItemDoInventario() {
    }
    
    public ItemDoInventario(String descricao, int quantidade) {
        this.descricao = descricao;
        this.quantidade = quantidade;
    }
    
    public int getQuantidade() {
        return this.quantidade;
    }
    
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setQuantidade(int novaQuantidade) {
        this.quantidade = novaQuantidade;
    }
}