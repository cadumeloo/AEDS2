	import java.util.*;

public class Ciframento_TP01Q03 {

	public static boolean Letra ( char c ) {
		return (c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z');	
	}

	public static boolean Especial ( char c ) {
		return ( (c >= 32 && c <= 47) || (c >= 58 && c <= 64) || (c >= 91 && c <= 96) || (c >= 123 && c <= 127) );
	} 
	public static boolean Numero ( char c )	{
		return ( c >= '0' && c <= '9' );
	}
	
	public static void  CaesarCipher (String str) {

		// StringBuilder para montar a nova string
			StringBuilder sb = new StringBuilder(str);

		// Percorrendo a string
		
		for(int i=0; i<sb.length(); i++) {
	
			char Original = sb.charAt(i);

			char Novo;

			if ( Letra(Original) || Especial(Original) || Numero(Original) ) {
				
				// Modifica o caractere para 3 à frente
				Novo = (char) (Original + 3);

			}
			else {
			
				Novo = Original;
			
			}

			// Monta a nova String
			sb.setCharAt(i, Novo);
		
		}
	
		String StringCodificada = sb.toString();
	
		System.out.println("" + StringCodificada);
			
		/*
		String StringCodificada = "";

        int caractere = 0;

        for (int i = 0; i < str.length(); i++) {

			char charTest = str.charAt(i);

			if ()


            caractere = (int)str.charAt(i);

            StringCodificada += (char)(caractere + 3);
        }

		System.out.println("" + StringCodificada);
		*/

	}
	

	public static void main (String [] args) {
	
		String str;
			
		Scanner sc = new Scanner(System.in);

		while( ! (str = sc.nextLine()).equals("FIM") ) {

			CaesarCipher(str);	

		}
			
	} 
}
