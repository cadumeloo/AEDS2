/*
	Carlos Eduardo de Melo Sabino - 856290

	Trabalho Prático 1 - Questão 1 - Palindromo
*/


import java.util.*;

public class TP01Q01 {


	// Função boleana para verificar se a string é um palindromo

    public static boolean ePalindromo(String str) { // Recebe a string como parametro
    
		for(int i = 0; i < str.length() / 2; i++) {
			
			/*
				Compara os caracteres do inicio até o meio e do
				final até o meio
			*/ 
            if( str.charAt(i) != str.charAt(str.length() - i - 1) ) {
                return false;
            }
        }
	
		return true;
    } 

    public static void main (String [] args) {

		String str;

    	Scanner sc = new Scanner(System.in);

		while( !(str = sc.nextLine()).equals("FIM")) {
	
			if(ePalindromo(str) == true) {

				System.out.println("SIM");

			}
			else {

				System.out.println("NAO");

			}
	
		
		}
		sc.close();
	} 			
}
