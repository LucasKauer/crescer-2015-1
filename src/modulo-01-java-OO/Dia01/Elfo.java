/**
 * Define objetos Elfo
 * 
 * @author Lucas Kauer
 */
public class Elfo extends Personagem {
    protected int flechas;
    private static int contadorElfosCriados;
 
    // type initializer
    {
        flechas = 42;
        Elfo.contadorElfosCriados++;
    }
    
    /**
     * Cria objetos Elfo (construtor)
     * 
     * @param nome Nome que o elfo receberá
     * @param flechas Quantidade inicial de flechas
     */
    
    public Elfo(String nome, int flechas) {
        this(nome);
        this.flechas = flechas;
    }
    
    /**
     * Cria objetos Elfo (construtor) que recebe nome e usa a quantidade de flechas padrão
     * 
     * @param nome Nome a ser dado para o Elfo.
     */
    
    public Elfo(String nome) {
        super(nome, 100);
    }
    
    /**
     * Atira uma flecha em um Orc e perde uma unidade de flechas.
     * @param umOrc Orc que receberá uma flechada.
     */
    public void atiraFlecha(Orc umOrc) {
        this.flechas--;
        //flechas = flechas - 1;
        super.experiencia++;
        // experiencia = experiencia + 1;
        umOrc.recebeAtaque();
        super.status = Status.ATACANDO;
    }
   
    /*public void setFlechas(int novaQtdFlechas) {
        if (novaQtdFlechas > flechas) {
            flechas = novaQtdFlechas;
        }
    }*/
    
    // camelCase: public void atirarFlechaDourada
    // PascalCase: public void AtirarFlechaDourada
    
    public int getFlechas() {
        return this.flechas;
    }
    
    // 07/04: OS TRÊS MÉTODOS ABAIXO DEVEM SER VERIFICADOS.
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
    
    public static int getContadorElfosCriados() {
        return contadorElfosCriados;
    }
    
    public static void resetarContadorElfosCriados() {
        contadorElfosCriados = 0;
    }
    
    /**
     * Retorna o nome do elfo, sua quantidade de flechas e seus níveis de experiência.
     * 
     * @return Informações gerais sobre o elfo, ex:
     * 
     * "Legolas possui 42 flechas e 0 níveis de experiência."
     */
    public String toString() {
        // Método pedreiro (StringBuilder)
        // Poderia remover o StringBuild quando usa String.format
        StringBuilder builder = new StringBuilder();
        
        // Operador terneiro (ternário)
        /* String textoFlechas = this.flechas == 1 ? "flecha" : "flechas";
        String textoNiveis = this.experiencia == 1 ? "nível" : "níveis"; */
        
        // substitui builder.append por return
        builder.append(
            String.format("%s possui %d %s e %d %s de experiência.",
                this.nome,
                this.flechas,
                // ternerio (in line) na linha
                this.flechas == 1 ? "flecha" : "flechas",
                this.experiencia,
                // ternerio (in line) na linha
                this.experiencia == 1 ? "nível" : "níveis"
                )
        );
        
        /* builder.append(this.nome);
        builder.append(" possui");
        builder.append(this.flechas);
        builder.append(" ");
        builder.append(textoFlechas);
        builder.append(" e ");
        builder.append(this.experiencia);
        builder.append(" ");
        builder.append(textoNiveis);
        builder.append("de experiência"); */
        
        return builder.toString();
        
        // Ruby ou CoffeeScript:
        // "#{nome} possui #{flechas} #{textoFlechas} e #{experiencia} #{textoNiveis} de experiência."
        // C# null-coalsing:
        // String texto = this.nome ?? "Sem Nome";
        
        /*if (this.flechas == 1) {
            textoFlechas = "flecha";
        } else {
            textoFlechas = "flechas";
        }*/
        
        /* return this.nome + " possui "
        + this.flechas + " "
        + textoFlechas + " e "
        + this.experiencia + " "
        + textoNiveis + "de experiência."; */
    }
    
    @Override
    public boolean equals(Object outro) {
        // return ((Elfo)outro).getNome().equals(this.nome);
        
        Elfo outroElfo = (Elfo) outro;
        
        boolean saoIguais = this.nome.equals(outroElfo.getNome());
        
        return saoIguais;
    }
}