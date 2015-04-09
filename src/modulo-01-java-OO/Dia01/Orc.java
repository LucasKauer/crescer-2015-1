import java.util.*;
/**
 * Define o objeto Orc
 * 
 * @author Lucas Kauer
 */
public class Orc {
    private int vida, experiencia;
    private String nome;
    private Status status = Status.VIVO;
    private ArrayList<ItemDoInventario> inventario = new ArrayList<ItemDoInventario>();
    // final não deixa que o valor atribuído a variável seja alterado posteriormente.
    private final int NUMERO_SORTE = 3481;
    
    // C#
    // public Status StatusOrc { get; set }
    
    {
        vida = 110;
    }
    
    /**
     * Cria objetos Orc (construtor)
     * 
     * @param nome Nome que o elfo receberá
     */
    public Orc(String nome) {
        // vida = 110
        this.nome = nome;
    }
    
    /**
     * Cria objetos Orc (construtor) sem nome
     */
    public Orc() {
    }
           
    /**
     * Faz o Orc sofrer um ataque
     * Atualmente 10 de dano será decrementado
     */
    public void recebeAtaque() {
        // Caso o resultado seja menor que 0, o Orc não deverá receber a flecha e ainda
        // ganhará 2 pontos de experiência.
        // Senão se o número estiver entre 0 e 100 o Orc não recebe flechas e não recebe experiência. Caso contrário o Orc
        // receberá a flechada (como está hoje). 
        if (vida > 0) {
            
            double numeroGerado = gerarNumero();
            
            if (numeroGerado < 0) {
                this.experiencia += 2;
                return;
            } else if (numeroGerado > 100) {
                // FLUXO ATUAL:
            
                int danoVida = 10;
                
                if (this.vida >= danoVida) {
                    this.vida -= danoVida;
                    // this.vida = this.vida - 10;
                    this.status = Status.FERIDO;
                }
            }
        }
        else {
            this.status = Status.MORTO;
        }       
    }
    
    /**
     * Gera um número.
     * O número gerado vai ser passado para a classe recebeAtaque.
     */
    private double gerarNumero() {
        
        double numeroGerado = 0.0;
        
        // A. Se o orc possuir nome e o mesmo tiver mais de 5 letras, some 65 ao número.
        // Caso contrário, subtraia 60.
        boolean possuiNomeComMaisDe5Caracteres =
            this.nome != null && this.nome.length() > 5;
            
        if (possuiNomeComMaisDe5Caracteres) {
            numeroGerado += 65;
        } else {
            numeroGerado -= 60;
        }
        
        // B. Se o orc possuir vida entre 30 e 60, multiple o número por dois, 
        // senão se a vida for menor que 20 multiplique por 3. 
        boolean possuiVidaEntre30e60 =
            this.vida >= 30 && this.vida <= 60;
        //boolean vidaMenorQue20 = this.vida < 20;
            
        if (possuiVidaEntre30e60) {
            numeroGerado *= 2;
        } else if (this.vida < 20) {
            numeroGerado *= 3;
        }
        
        // Se o orc estiver fugindo, divida o número por 2.
        // Senão se o orc estiver caçando ou dormindo adicione 1 ao número. 
        boolean estaFugindo = this.status == Status.FUGINDO;
        boolean estaCaçandoOuDormindo =
            this.status == Status.CAÇANDO || this.status == Status.DORMINDO;
        
        if (estaFugindo) {
            numeroGerado /= 2;
            // #xatiado
        } else if (estaCaçandoOuDormindo) {
            numeroGerado += 1;
        }
        
        // Se a experiência do orc for par, eleve o número ao cubo.
        // Se for ímpar e o orc tiver mais que 2 de experiência, eleve o número ao quadrado.
        boolean experienciaÉPar = this.experiencia % 2 == 0;
        
        if (experienciaÉPar) {
            numeroGerado = numeroGerado * numeroGerado * numeroGerado;
            // numeroGerado = Math.pow(numeroGerado, 3);
        } else if (this.experiencia > 2) {
            numeroGerado = Math.pow(numeroGerado, 2);
        }
        
        return numeroGerado;
    }
    
    /**
     * Caso o Orc tenha sorte, adiciona 1000 quantidades para cada item do inventário.
     */
    public void tentarSorte() {
        // Exercício 5.2: um Orc pode tentarSorte() e
        // ganhar 1000 unidades de cada item em seu inventário
        // Como isso acontece? Caso um número sorteado seja 3481
        if (gerarNumero() == NUMERO_SORTE) {
            int numeroDeItens = this.inventario.size();
            for(int i = 0; i < numeroDeItens; i++) {
                ItemDoInventario itemAtual = this.inventario.get(i);
                itemAtual.setQuantidade(itemAtual.getQuantidade() + 1000);
            }
        }
    }
    
    // Tema: Permitir que Orcs ganhem e percam itens (ArrayList)
    // Método para adicionar itens ao inventário.
    /**
     * Adiciona um item ao inventário.
     * 
     * @param item Item a ser adicionado.
     */
    public void adicionarItem(ItemDoInventario i) {
        inventario.add(i);
    }
    
    // Método para remover itens ao inventário.
    /**
     * Remove o item do inventário do orc.
     * 
     * @param item Item a ser perdido do inventário.
     */
    public void perderItem(ItemDoInventario i) {
        if(inventario.size() > 0){
            inventario.remove(i);
        }
    }
    
    
    /*
     * auxiliar = get(i);  
     * elementos[cont2] = elementos[cont2+1];  
     * elementos[cont2+1] = aux;   
     */
    public void ordenarItens() {
        if (inventario.size() > 0) {
            ArrayList<ItemDoInventario> inventarioModificado;
            inventarioModificado = new ArrayList<ItemDoInventario>();
            int x = 0;
            for (x = 0; x < inventario.size(); x++) {
                ItemDoInventario itemComMenorQuantidade = this.inventario.get(x);
                int menorQuantidade = this.inventario.get(x).getQuantidade();
                for (int i = 1; i < inventario.size(); i++) {
                    //http://pt.wikipedia.org/wiki/Selection_sort
                ItemDoInventario itemAtual = this.inventario.get(i);
                ItemDoInventario itemAnterior = this.inventario.get(i - 1);
                
                if (menorQuantidade > itemAtual.getQuantidade()) {
                    
                    
                    
                    /*inventarioModificado.remove(itemAnterior);
                    inventarioModificado.add(itemAtual);
                    inventarioModificado.add(itemAnterior);
                    */
                    inventario.set(x, itemAtual);
                    inventario.set(i, itemComMenorQuantidade);
                    itemComMenorQuantidade = itemAtual;
                    menorQuantidade = itemAtual.getQuantidade();
                    x=i;
                }
                
                }
                
            }
            
        }
        
    }
    
    // metódo responsável por retornar o nome do Orc
    public String getNome() {
        return this.nome;
    }
    
    // metódo responsável por retornar a experência do Orc
    public int getExperiencia() {
        return this.experiencia;
    }
    
    // metódo responsável por testar se o Orc está nascendo com 110 de vida.
    public int getVida() {
        return this.vida;
    }
    
    // metódo responsável por testar se o método recebeFlecha está sendo executado corretamente
    /* public int getRecebeFlecha() {
        recebeFlecha();
        return vida;
    } */
    
    public Status getStatus() {
        return this.status;
    }
    
    public ArrayList<ItemDoInventario> getInventario() {
        return this.inventario;
    }
    
    public int getTamanhoDoInventario() {
        return inventario.size();
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
    public String getDescricoesItens() {
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
    
    public ItemDoInventario getItemComMaiorQuantidade() {
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
    
    public void setStatus(Status novoStatus) {
        this.status = novoStatus;
    }
    
    public void setExperiencia(int novaExperiencia) {
        this.experiencia = novaExperiencia;
    }
    
    /**
     * Imprime a vida atual do Orc.
     * 
     * @return String com a vida atual do orc
     * Ex: "Vida atual: " + this.vida
     */
    public String toString() {
        return "Vida atual: " + this.vida;
    }
}