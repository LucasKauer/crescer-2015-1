
/**
 * Objeto que sabe contar números em ordem!
 * 
 * @author CWI Software
 */
public class ContadorDeNumeros {
    public void contarAte3() {
        for (int i = 0; i < 3; i++) {
            // execute tudo que tem aqui dentro
            System.out.println(i + 1);
        }
    }
    
    public void contarAte(int numero) {
        for (int i = 0; i < numero; i++) {
            System.out.println(i + 1);
        }
    }
    
    public void contarRegressivamente (int numero) {
       for (int i = numero; i > 0; i--) {
            System.out.println(i);
        } 
    }
}