/*
 *	Carlos Eduardo de Melo Sabino - 856290
 *
 *	TP01Q08 - Soma de Digitos
*/

import java.util.*;

public class SomaDeDigitos {

	/*
	 *	Função para somar os digitos
	 *	@param x numero a ser somado
	 *	Retorna ela mesma somando o resto da divisão
	 */

        public static int SomarDigitos (int x) {
        
		if (x == 0) {
        		return 0;
        	}
        	
		return (x % 10) + SomarDigitos(x / 10);
    	}

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		String entrada = sc.nextLine();
	
		do {
        		int x = Integer.parseInt(entrada);
        		
			System.out.println(SomarDigitos(x));
        		
			entrada = sc.nextLine();
        	
		} while ( !(entrada.equals("FIM")) );

	sc.close();
    }

}
