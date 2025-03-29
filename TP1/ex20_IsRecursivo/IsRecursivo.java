/*
	Carlos Eduardo de Melo Sabino 856290
	TP01Q20 - Is Recusivo
*/

public class IsRecursivo {

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
	 
	
	public static boolean apenasVogal(String str) {
        	return apenasVogal(str, 0);
	}

    	private static boolean apenasVogal(String str, int i) {
       		if (i == str.length()) { 
			return true;
		}

        	if (!Letra(str.charAt(i)) || !Vogal(str.charAt(i))) {
			return false;
		}

        	return apenasVogal(str, i + 1);
    	}

    	public static boolean apenasConsoante(String str) {
        	return apenasConsoante(str, 0);
    	}
    
    	private static boolean apenasConsoante(String str, int i) {
        	if (i == str.length()) {
			return true;
		}
        
		if (!Letra(str.charAt(i)) || Vogal(str.charAt(i))) {
			return false;
		}
        	
		return apenasConsoante(str, i + 1);
    	}

    	public static boolean eInteiro(String str) {
       		return eInteiro(str, 0);
    	}
    
    	private static boolean eInteiro(String str, int i) {
        	if (i == str.length()) {
			return true;
		}
        	
		if (!Numero(str.charAt(i))) {
			return false;
		}
        
		return eInteiro(str, i + 1);
    	}

	public static boolean eReal(String str) {
        	return eReal(str, 0, 0);
    	}
    
	private static boolean eReal(String str, int i, int count) {
        	
		if (i == str.length()) {
			return true; 
		}

       		char c = str.charAt(i);

    	    	if (!Numero(c)) {
        		if ((c == ',' || c == '.') && count == 0) {
                		return eReal(str, i + 1, count + 1);
        		}
			return false;
        	}
		return eReal(str, i + 1, count);
	}

	public static void main(String[] args) {
        	
		String entrada = "";
        
		while (!(entrada = MyIO.readLine()).equals("FIM")) {
            	
			System.out.printf("%s %s %s %s%n",
                			   apenasVogal(entrada) ? "SIM" : "NAO",
                			   apenasConsoante(entrada) ? "SIM" : "NAO",
                			   eInteiro(entrada) ? "SIM" : "NAO",
           				   eReal(entrada) ? "SIM" : "NAO"
					 );
        	}	
    	}
}
