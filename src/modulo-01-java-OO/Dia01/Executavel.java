// www.desculpadeprogramador.com.br
/**
 * Escreva a descrição da classe Executavel aqui.
 * 
 * @author Lucas Kauer
 */
public class Executavel {
    // Exemplo de UpCasting
    // Elfo umElfo = new ElfoVerde();
    // Object texto = "Um texto!";
    
    // Exemplo de DownCasting
    // String outroTexto = (String) texto;
    
    // No-Object
    // String a = "Lucas";
    // String b = "Lucas";
    // a == b
    // true (boolean)
    
    // Object
    // String a = new String("Lucas");
    // String b = new String("Lucas");
    // a == b
    // false (boolean)
    // or
    // a.equals(b)
    // true (boolean)
    
    // LIFO: Last In First Out (Stack)
    // FIFO: First In First Out (Queue)
    
    // HASHTABLE (ANTIGA)
    // HASHMAP (ATUAL)
    
    /* import java.util.Stack;
     * Stack<String> textos = new Stack<String>();
     * textos.empty()
     * true   (boolean)
     * textos.size()
     * 0   (int)
     * 
     * .push() = .add()
     * 
     * textos.push("Primeiro texto");
     * textos.push("Segundo texto");
     * textos
     * <object reference>   (Stack<String>)
     * 
     * .peek() retorna o último objeto adicionado
     * 
     * textos.peek()
     * "Segundo texto"   (String)
     * 
     * .pop() retira o último objeto adicionado
     * 
     * textos.pop()
     * "Segundo texto"   (String)
     * textos.peek()
     * "Primeiro texto"   (String)
     */
    
    /*
     * import java.util.PriorityQueue;
     * PriorityQueue<String> fila = new PriorityQueue<>();
     * fila
     * <object reference>   (PriorityQueue<String>)
     * fila.add("Primeiro texto");
     * fila.add("Segundo texto");
     * fila.peek()
     * "Primeiro texto"   (String)
     * fila.poll()
     * "Primeiro texto"   (String)
     * fila.poll()
     * "Segundo texto"   (String)
     * fila.poll()
     * null
     */
    
    public static void main(String[] args) {
        ElfoNoturno legolas = new ElfoNoturno("Légolas");
        Orc umOrc = new Orc();
        // JOptionPane.showMessageDialog(null, legolas.getVida());
        System.out.println("Vida: " + legolas.getVida());
        legolas.atiraFlecha(umOrc);
        System.out.println("Vida: " + legolas.getVida());
    }
    
    /*ElfoVerde ev = new ElfoVerde("Legolas");
     * 
     */
}
