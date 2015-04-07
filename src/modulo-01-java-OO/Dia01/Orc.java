
/**
 * Define o objeto Orc
 * 
 * @author Lucas Kauer
 */

public class Orc {
    private int vida, experiencia;
    private String nome;
    private Status status = Status.VIVO;
    
    {
        vida = 110;
    }
    
    /**
     * Construtor para objetos da classe Orc
     */
    public Orc(String nome) {
        // vida = 110
        this.nome = nome;
    }
    
    public Orc() {
    }
    
    public void orcMorto() {
        if(this.vida == 0) {
            this.status = Status.MORTO;
        }
    }
    
    /**
     * Faz o Orc sofrer um ataque
     * Atualmente 10 de dano será decrementado
     */
    
    public void recebeFlecha() {
        if (vida>0){
                double numeroGerado = gerarNumero();
                    if (numeroGerado < 0){
                        this.experiencia += 2;
                        return;
                    }else if (numeroGerado > 100) {
                        int danoVida = 10;
                        if (this.vida >= danoVida) {
                            this.vida -= danoVida;
                            this.status = Status.FERIDO;
                        }
                    }
            }else {
                this.status = Status.MORTO;
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
    
    public void setStatus(Status novoStatus) {
        this.status = novoStatus;
    }
    
    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
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
    
    private double gerarNumero() {
        double numeroGerado = 0.0;
        
        // A. Se o orc possuir nome e o mesmo tiver mais de 5 letras, some 65 ao número.
        // Caso contrário, subtraia 60.
        boolean possuiNomeComMaisDe5Caracteres = (this.nome != null && this.nome.length() > 5);
        if(possuiNomeComMaisDe5Caracteres) {
            numeroGerado += 65;
        } else {
            numeroGerado -= 60;
        }
        
        // B. Se o orc possuir vida entre 30 e 60, multiple o número por dois,
        // senão se a vida for menor que 20 multiplique por 3.
        boolean possuiVidaEntre30e60 = (this.vida >= 30 && this.vida <=60);
        if (possuiVidaEntre30e60) {
            numeroGerado *= 2;
        } else if (this.vida < 20) {
            numeroGerado *= 3;
        }
        
        // C. Se o orc estiver fugindo, divida o número por 2. Senão se o orc estiver caçando
        // ou dormindo adicione 1 ao número.
        boolean estaFugindo = (this.status == Status.FUGINDO);
        boolean estaCacandoOuDormindo = ((this.status == Status.CAÇANDO) || (this.status == Status.DORMINDO));
        if (estaFugindo) {
            numeroGerado /= 2;
        } else if (estaCacandoOuDormindo){
            numeroGerado += 1;
        }
        
        // D. Se a experiência do orc for par, eleve o número ao cubo. 
        // Se for ímpar e o orc tiver mais que 2 de experiência, eleve o número ao quadrado.
        boolean experienciaEPar = this.experiencia % 2 == 0;
        if (experienciaEPar) {
            // numeroGerado = numeroGerado * numeroGerado * numeroGerado;
            Math.pow(numeroGerado, 3);
        } else if (this.experiencia > 2){
            // numeroGerado = numeroGerado * numeroGerado;
            Math.pow(numeroGerado, 2);
        }
        
        return numeroGerado;
    }
}