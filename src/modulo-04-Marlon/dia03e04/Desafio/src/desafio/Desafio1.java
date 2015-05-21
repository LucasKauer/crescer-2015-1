package desafio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Desafio1 {

	public static List<Integer> retornaOIndiceDasLetrasMaiusculas(String str) {
		List<Integer> indiceMaisculas = new ArrayList<>();
		
		for (int i = 0; i < str.length(); i++) {
			char strPosition = str.charAt(i);
			boolean isLetraMaiuscula = Character.isUpperCase(strPosition);

			if (isLetraMaiuscula) {
				indiceMaisculas.add(i);
			}
		}

		return indiceMaisculas;
	}
	
	public static void main(String[] args) {
		String str;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Informe uma String: ");
		str = input.next();
		System.out.println(retornaOIndiceDasLetrasMaiusculas(str));
	}
}