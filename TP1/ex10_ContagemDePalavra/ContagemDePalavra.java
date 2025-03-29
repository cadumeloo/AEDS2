/*
 *	Carlos Eduardo de Melo Sabino - 856290
 *
 *	TP01Q10 - Contagem de Palavras
 *	
*/


import java.util.*;

public class ContagemDePalavra {

	/*
	 *	Conta quantos caracteres de espaço existem na string
	 *	@param str para receber a string
	 *	@return quantidade de palavras
	 *
	*/


	public static int ContarPalavra(String str) {

		int count = 0;

		for (int i=0; i<str.length(); i++) {
		
			if( str.charAt(i) == 32) {
				count ++;
			}
		}
			
		// Contador "extra" pois sempre há uma palavra a mais do que ' '
		count++;

		return count;
	}


	public static void main (String[] args) {

		String entrada = "";

		Scanner sc = new Scanner(System.in);

		while( !(entrada = sc.nextLine()).equals("FIM") ) {
			
			System.out.println("" + ContarPalavra(entrada));

		}
	
		sc.close();
	}

}
