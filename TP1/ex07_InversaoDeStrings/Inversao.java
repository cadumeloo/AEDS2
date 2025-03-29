/*
 *	Carlos Eduardo de Melo Sabino - 856290
 *
 *	TP01Q07 - Inversão de Strings
*/

public class Inversao {

	/*
	 *	Função para inverter string
	 *	@param str receber a string
	 *	@return string invertida
	*/


	public static String inversao (String str) {

		StringBuilder sb = new StringBuilder(str);

		int tamanho = str.length();

		for (int i=0; i<tamanho/2 ;i++) {
		

			// Para a troca de caracteres
			char temp = sb.charAt(i);

			sb.setCharAt(i, sb.charAt(tamanho - i - 1));
			sb.setCharAt(tamanho - i - 1, temp);

		}
		return sb.toString();	
	}


	public static void main (String[] args) {

		String entrada = "";

		entrada = MyIO.readLine();

		do {

			MyIO.println(inversao(entrada));

			entrada = MyIO.readLine();

		} while ( !(entrada.equals("FIM")) );

	}


}

