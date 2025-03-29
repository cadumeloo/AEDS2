/*
	Carlos Eduardo de Melo Sabino - 856290

	TP01Q04 - Alteracao Aleatoria

*/

import java.util.*;

public class AlteracaoAleatoria {

	public static String alterar (String str, char a, char b) {
	
		if( a == b ) {

			return str;
		}
	

		StringBuilder sb = new StringBuilder(str);

		// Percorre a string e substitui o caractere a na string pelo b 
		for (int i=0; i<sb.length(); i++) {

			if ( sb.charAt(i) == a ) {
				sb.setCharAt(i,b); // Função para substituir os caracteres
			} 
			
			
		}	
		return sb.toString(); // Retorna a nova string
	}

	public static void main (String[] args) {
		
		Random gerador = new Random();
		gerador.setSeed(4);
			

		String entrada = "";

		entrada = MyIO.readLine();
	
		do {	
			
			char a = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
			char b = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
		
			
			MyIO.println(alterar(entrada, a, b));

			entrada = MyIO.readLine();
			
		} while( !(entrada.equals("FIM")) ); 

	}
	

}
