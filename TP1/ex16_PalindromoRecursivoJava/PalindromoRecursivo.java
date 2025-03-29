/*
 *		Carlos Eduardo de Melo Sabino - 856290
 *
 *		TP01Q16 - Palindromo Recursivo Java
 */

import java.util.*;

public class PalindromoRecursivo {

    // Função recursiva para verificar se a string é um palindromo
    public static boolean ePalindromo(String str, int i) { 
    
    	if (i >= str.length() / 2) {
        	return true;
    	}
         
    	/*
			Compara os caracteres do inicio até o meio e do
			final até o meio
		*/
    	if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
        	 return false;
    	}
        
       // Chama a função recursivamente para comparar os proximos caracteres
       return ePalindromo(str, i + 1);
    } 

	public static void main(String[] args) {

        String str = "";

        Scanner sc = new Scanner(System.in);

        while (!(str = sc.nextLine()).equals("FIM")) {

            if (ePalindromo(str, 0)) {
                System.out.println("SIM");
            } 
			else {
                System.out.println("NAO");
            }

        }
    	sc.close();
    }
}	
