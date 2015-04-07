
/**
 * Define o objeto Orc
 * 
 * @author Lucas Kauer
 */

public class Orc {
    private String nome;
    private int vida, experiencia;
    private double numero;
    private Status status;
    
    {
        vida = 110;
        status = Status.VIVO;
    }
    
    public Orc(String nome) {
        this.nome = nome;
    }
    
    public Orc() {
    }
    
    /**
     * Recebe uma flechada e perde 10 unidades de vida.
     */
    
    public void recebeFlecha() {
        if(gerarNumero() < 0) {
            this.experiencia += 2;
        } else if (gerarNumero() > 0 && gerarNumero() < 100) {
            // Orc não recebe flecha e não recebe experiência
        } else {
            vida = vida - 10;
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
    public int getRecebeFlecha() {
        recebeFlecha();
        return vida;
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
    
    public Status setStatus() {
        return this.status;
    }
    
    private double gerarNumero() {
        // A
        if((this.nome != null) && (this.nome.length() > 5)) {
            numero += 65;
        } else {
            numero -= 60;
        }
        
        //B
        if (this.vida > 30 && this.vida < 60) {
            this.numero *= 2;
        } else if (this.vida < 20) {
            this.numero *= 3;
        }
        
        //C
        if (setStatus() == Status.FUGINDO) {
            this.numero /= 2;
        } else if (setStatus() == Status.CAÇANDO || setStatus() == Status.DORMINDO){
            this.numero += 1;
        }
        
        //D
        if (this.experiencia % 2 == 0) {
            Math.pow(numero, 3);
        } else if ((this.experiencia % 2 != 0) && (this.experiencia > 2)){
            Math.pow(numero, 2);
        }
        
        return numero;
    }
}