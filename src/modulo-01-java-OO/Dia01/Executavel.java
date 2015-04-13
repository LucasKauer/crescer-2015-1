
/**
 * Escreva a descrição da classe Executavel aqui.
 * 
 * @author Lucas Kauer
 */
public class Executavel {
    public static void main(String[] args) {
        ElfoNoturno legolas = new ElfoNoturno("Légolas");
        Orc umOrc = new Orc();
        // JOptionPane.showMessageDialog(null, legolas.getVida());
        System.out.println("Vida: " + legolas.getVida());
        legolas.atiraFlecha(umOrc);
        System.out.println("Vida: " + legolas.getVida());
    }
}
