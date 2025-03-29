/*
	Carlos Eduardo de Melo Sabino 856290
	TP01Q06 - Is
*/

public class Is {

	/*
	 * Funções para verificar os caracteres da string
	 * @param c o caractere a ser verificado
	*/

	public static boolean Letra ( char c ) {
		return (c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z');	
	}

	public static boolean Especial ( char c ) {
		return ( (c >= 32 && c <= 47) || (c >= 58 && c <= 64) || (c >= 91 && c <= 96) || (c >= 123 && c <= 127) );
	} 
	
	public static boolean Numero ( char c )	{
		return ( c >= '0' && c <= '9' );
	}
		
	public static boolean Vogal (char c) {
		c = Character.toLowerCase(c);
		return ( c == 'a' || c == 'e' || c == 'i' ||
			 c == 'o' || c == 'u' );
	}

	// end funções para verificar os caracteres
	
	public static boolean apenasVogal (String str) {
		str.toLowerCase();

		for (int i=0; i<str.length(); i++) {
			if( !Letra(str.charAt(i)) || !Vogal(str.charAt(i)) ) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean apenasConsoante (String str) {
		str.toLowerCase();
		
		for (int i=0; i<str.length(); i++) {
			if( !Letra(str.charAt(i)) || Vogal(str.charAt(i)) ) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean eInteiro (String str) {
	
		for (int i=0; i<str.length(); i++) {
			if ( !Numero(str.charAt(i)) ) {
				return false;
			}
		}
		return true;
	}

	/*
	 * Tentativa alternativa
	 *
	public static boolean possivelReal( char c ) {
			
		if ( Numero(c) || c == ',' || c == '.' ) {
			return true;
		}

		return false;
	}
	*/

	public static boolean eReal (String str) {

		int count = 0;

		for (int i=0; i<str.length(); i++) {
			/*
			if ( str.charAt(i) == ',' || str.charAt(i) == '.' ) {
				count++;
			}
			*/
			if ( !Numero(str.charAt(i)) ) {
				if ( (str.charAt(i) == ',' || str.charAt(i) == '.') && count == 0) {
					count = 1;
				}
				else {
					return false;
				}
			}
		}
		return true;
	}

	public static void main (String[] args) {

		String entrada = "";

		entrada = MyIO.readLine();

		do {
			
			System.out.printf("%s %s %s %s%n",
					   apenasVogal( entrada ) ? "SIM" : "NAO",
					   apenasConsoante( entrada ) ? "SIM" : "NAO",
					   eInteiro( entrada ) ? "SIM" : "NAO",
					   eReal( entrada ) ? "SIM" : "NAO"
					 );
			entrada = MyIO.readLine();

		} while ( !(entrada.equals("FIM")) );

	}
	
}
