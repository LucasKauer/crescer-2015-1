package filmator;

public class CreateReport {
	// gera um relatorio
	public static void createReport() {
		
		// passando, atraves do metodo values, todos os "enum's" para dentro de um arraiii de "enum's"
		Gender[] gender = Gender.values();
			
		// forEach que percorre todo o araiii de generos
		for(Gender g : gender){
				
			System.out.println(g);
				
		}
	}
}
