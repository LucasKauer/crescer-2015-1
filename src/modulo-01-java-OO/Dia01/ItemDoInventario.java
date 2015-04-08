
/**
 * Define objetos ItemDoInventário
 * 
 * @author Lucas Kauer
 */
public class ItemDoInventario
{
    private String descricao;
    private int quantidade;
    
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
    
    public void setDescricao(String novaDescricao) {
        this.descricao = novaDescricao;
    }
    public void setQuantidade(int novaQuantidade) {
        this.quantidade = novaQuantidade;
    }
}
