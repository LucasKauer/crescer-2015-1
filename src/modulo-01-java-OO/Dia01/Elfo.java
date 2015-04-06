/**
 * Define o  objeto Elfo
 * 
 * @author Lucas Kauer
 */
public class Elfo {
    // Versão correção do tema!!
    
    private String nome;
    private int flechas, experiencia;
 
    // type initializer
    {
        flechas = 42;
    }
    
    /**
     * Cria objetos Elfo (construtor)
     * 
     * @param umNome Nome que o elfo receberá
     * @param flechas Quantidade inicial de flechas
     */
    
    public Elfo(String nome, int flechas) {
        this(nome);
        // this.nome = nome;
        this.flechas = flechas;
    }
    
    /**
     * Cria objetos Elfo (construtor) que recebe nome e usa a quantidade de flechas padrão
     * 
     * @param nome Nome a ser dado para o Elfo.
     */
    
    public Elfo(String nome) {
        this.nome = nome;
    }
    
    /**
     * Atira uma flecha em um Orc e perde uma unidade de flechas.
     * @param umOrc Orc que receberá uma flechada.
     */
    public void atiraFlecha(Orc umOrc) {
        flechas--;
        //flechas = flechas - 1;
        experiencia++;
        // experiencia = experiencia + 1;
        umOrc.recebeFlecha();
    }
   
    /*public void setFlechas(int novaQtdFlechas) {
        if (novaQtdFlechas > flechas) {
            flechas = novaQtdFlechas;
        }
    }*/
    
    // camelCase: public void atirarFlechaDourada
    // PascalCase: public void AtirarFlechaDourada
    
    public String getNome() {
        return this.nome;
    }
    
    public int getFlechas() {
        return this.flechas;
    }
    
    public int getExperiencia() {
        return this.experiencia;
    }
    
    public void getAtirarFlecha() {
        Orc umOrc = new Orc();
        atiraFlecha(umOrc);
    }
    
    public int getPerdeFlecha() {
        getAtirarFlecha();
        return flechas;
    }
    
    public int getGanhaExperiencia() {
        getAtirarFlecha();
        return experiencia;
    }
    
    /**
     * Imprime a vida, as flechas e a experiencia atual do Elfo.
     * 
     * @return String com a vida atual do elfo
     * @return Int com as flechas atual do elfo
     * @return Int com a experiência atual do elfo
     * Ex: "Légolas possui 10 flechas e 2 níveis de experiência."
     */
    
    public String toString() {
        return this.nome + " possui " + this.flechas + " flechas e " + this.experiencia + " níveis de experiência.";
    }
}
