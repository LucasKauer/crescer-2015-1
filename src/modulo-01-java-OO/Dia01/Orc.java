import java.util.*;
// IONIC!!! OLHAR ;DDD 10/04
/**
 * Define o objeto Orc
 * 
 * @author Lucas Kauer
 */
public class Orc extends Personagem {
    // final não deixa que o valor atribuído a variável seja alterado posteriormente.
    private final int NUMERO_SORTE = 3481;
    
    // C#
    // public Status StatusOrc { get; set }
    
    /**
     * Cria objetos Orc (construtor)
     * 
     * @param nome Nome que o elfo receberá
     */
    public Orc(String nome) {
        super(nome, 110);
    }
    
    /**
     * Cria objetos Orc (construtor) com novo vazio (empty)
     */
    public Orc() {
        this("");
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
                    super.status = Status.FERIDO;
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