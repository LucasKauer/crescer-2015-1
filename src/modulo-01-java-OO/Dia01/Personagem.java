import java.util.*;
/**
 * Escreva a descrição da classe Personagem aqui.
 * 
 * @author Lucas Kauer
 */
// C#:
// public sealed class Personagem
// public final class Personagem
public class Personagem {
    protected Status status = Status.VIVO;
    protected int vida = 0;
    protected String nome;
    protected int experiencia;
    protected ArrayList<ItemDoInventario> inventario = new ArrayList<ItemDoInventario>();
    
    protected Personagem (String nome, int vida) {
        this.nome = nome;
        this.vida = vida;
    }
    
    public void atualizarStatus() {
        if(this.vida <= 0) {
            this.status = Status.MORTO;
        }
    }
    
    protected Status getStatus() {
        return this.status;
    }
    
    protected int getVida() {
        return this.vida;
    }
    
    protected String getNome() {
        return this.nome;
    }
    
    protected int getExperiencia() {
        return this.experiencia;
    }
    
    protected ArrayList<ItemDoInventario> getInventario() {
        return this.inventario;
    }
    
    protected int getTamanhoDoInventario() {
        return this.inventario.size();
    }
    
    // Tema: Permitir que Orcs ganhem e percam itens (ArrayList)
    // Método para adicionar itens ao inventário.
    /**
     * Adiciona um item ao inventário.
     * 
     * @param item Item a ser adicionado.
     */
    protected void adicionarItem(ItemDoInventario i) {
        inventario.add(i);
    }
    
    // Método para remover itens ao inventário.
    /**
     * Remove o item do inventário do orc.
     * 
     * @param item Item a ser perdido do inventário.
     */
    protected void perderItem(ItemDoInventario i) {
        if(inventario.size() > 0){
            inventario.remove(i);
        }
    }
    
    /**
     * Concatena as descrições dos itens, separados por vírgulas
     * 
     * SEM ESPAÇO ENTRE AS VÍRGULAS E SEM PONTO FINAL
     * 
     * @return Descrições. Ex:
     * 
     * "Adaga,Escudo,Bracelete"
     */
    /* It's mine!
     * 
     * public String getDescricoesInventario() {
     *  String descricoesInventario = null;
     *  for (int i = 0; i <= inventario.size(); i++) {
     *      // Lembrar de separar os algoritmos por parte para não se confundir!
     *      // ItemDoInventario (Construtor)
     *      // itemAtual (Nome Informado ao Construtor)
     *      // inventario.get(i) (Item Atual);
     *      ItemDoInventario itemAtual = inventario.get(i);
     *      if (i == inventario.size()) {
     *          descricoesInventario = itemAtual.getDescricao();
     *          break;
     *      } else {
     *          descricoesInventario = itemAtual.getDescricao() + ",";
     *      }
     *  }
     *  return descricoesInventario;
     *  }
     */
    protected String getDescricoesItens() {
        StringBuilder builder = new StringBuilder();
        
        /* int numeroDeItens = this.inventario.size();
        
         for (int i = 0; i < numeroDeItens; i++) {
           ItemDoInventario itemAtual = this.inventario.get(i);
             
           boolean eUltimoIndice = i == numeroDeItens - 1;
           
           builder.append(
               eUltimoIndice ?
               itemAtual.getDescricao() :
               itemAtual.getDescricao() + ","
           );
        } */
        
        // C#
        // foreach (ItemDoInventario item in this.itens) { }
        
        /*
         * Utilizando foreach
           for (ItemDoInventario itemAtual : this.inventario) {
            int i = this.inventario.indexOf(itemAtual);
            int numeroDeItens = this.inventario.size();
            boolean eUltimoIndice = i == numeroDeItens - 1;
            
            builder.append(
                eUltimoIndice ?
                itemAtual.getDescricao() :
                itemAtual.getDescricao() + ","
            );
        }
        */
        
        int i = 0;
        int numeroDeItens = this.inventario.size();
        
        // JavaScript
        // for (var i = 0, numeroDeItens = this.inventario.size(); i < numeroDeItens; i++) {
        // }
        
        /* while (i < numeroDeItens) {
            ItemDoInventario itemAtual = this.inventario.get(i);
            boolean eUltimoIndice = i == numeroDeItens - 1;
            
            builder.append(
                eUltimoIndice ?
                itemAtual.getDescricao() :
                itemAtual.getDescricao() + ","
            );
            i++;
        } */
        
        do {
            if (numeroDeItens > 0) {
                ItemDoInventario itemAtual = this.inventario.get(i);
                boolean eUltimoIndice = i == numeroDeItens - 1;
                // boolean eUltimoIndice = true
                
                builder.append(
                    eUltimoIndice ?
                    itemAtual.getDescricao() :
                    itemAtual.getDescricao() + ","
                );
            }
            i++;
        } while (i < numeroDeItens);
        
        return builder.toString();
    }
    
    // metódo responsável por testar se o método recebeFlecha está sendo executado corretamente
    /* public int getRecebeFlecha() {
        recebeFlecha();
        return vida;
    } */
    
    protected ItemDoInventario getItemComMaiorQuantidade() {
        int maiorQuantidade = 0;
        ItemDoInventario itemComMaiorQuantidade = null;
            for(int i = 0; i < inventario.size(); i++) {
                ItemDoInventario itemAtual = this.inventario.get(i);
                if(maiorQuantidade < itemAtual.getQuantidade()) {
                    maiorQuantidade = itemAtual.getQuantidade();
                    itemComMaiorQuantidade = inventario.get(i);
                }           
            }
        
        // Exemplo: Bernardo
        /* boolean temItens = !this.inventario.isEmpty();
        if (temItens) {
            itemMaiorQuantidade = this.inventario.get(0)
            
            for (int i = 1; i < this.inventario.size(); i++) {
                ItemDoInventario itemAtual = this.inventario.get(i);
                boolean encontreiAMaiorQuantidade =
                    itemAtual.getQuantidade > itemMaiorQuantidade();
                    
                if (encontreiAMaiorQuantidade) {
                    // autalizar a minha referência para o maior parcial
                    itemMaiorQuantidade = itemAtual;
                }
            }
        } */
            
        return itemComMaiorQuantidade;
    }
    
    // http://pt.wikipedia.org/wiki/Selection_sort
    // www.sorting-algoritthms.com
    /**
     * Ordena os itens do inventário por quantidade ascendente.
     */
    protected void ordenarItens() {
        if (inventario.size() > 0) {
            for (int x = 0; x < inventario.size() - 1; x++) {
                int j = x;
                ItemDoInventario itemComMenorQuantidade = this.inventario.get(x);
                int menorQuantidade = this.inventario.get(x).getQuantidade();

                for (int i = j + 1; i < inventario.size(); i++) {
                    
                    ItemDoInventario itemAtual = this.inventario.get(i);
                    ItemDoInventario itemAnterior = this.inventario.get(i - 1);
                    
                    if (menorQuantidade > itemAtual.getQuantidade()) {
                        // inventario.set(nova posição, elemento);
                        // .set adiciona o elemento a posição informada,
                        // mas não troca a posição do item que ocupava a posição anteriormente.
                        inventario.set(j, itemAtual);
                        inventario.set(i, itemComMenorQuantidade);
                        
                        itemComMenorQuantidade = itemAtual;
                        menorQuantidade = itemAtual.getQuantidade();
                    }
                }
            }
        }
        
        /* Collections.sort(this.itens, new Comparator<ItemDoInventario>() {
            public int compare(ItemDoInventario item, ItemDoInventario outroItem) {
                return Integer.compare(item.getQuantidade(), outroItem.getQuantidade());
            }
        }); */
        
        // C#:
        // return this.itens.OrderBy(x => x.getQuantidade());
        
        // Ruby:
        // this.itens.sort_by { |x| x.get_quantidade }
        
        
        // Algoritmo: Bubblesort
        /* for (int i = 0; i < this.itens.size(); i++) {
            for (int j = 0; j < this.itens.size() - 1; j++) {
                ItemDoInventario itemAtual = this.itens.get(j);
                ItemDoInventario proximo = this.itens.get(j + 1);
                
                boolean precisaTrocar = 
                    itemAtual.getQuantidade() > proximo.getQuantidade();
                
                if (precisaTrocar) {
                    this.itens.set(j, proximo);
                    this.itens.set(j + 1, itemAtual);
                }
            }
        } */
    }
}