/*
 * 	Carlos Eduardo de Melo Sabino - 856290
 *
 *	TP01Q21 - Validação de Senhas
 */

import java.util.*;

public class ValidacaoDeSenha {

	/*
	 * Inicio funções para verificar caracteres
	 */

	public static boolean Letra ( char c ) {
		return (c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z');	
	}

	public static boolean LetraMaiuscula ( char c ) {
		return (c >= 'A' && c <= 'Z');
	}

	public static boolean LetraMinuscula ( char c ) {
		return (c >= 'a' && c <= 'z');
	}

	public static boolean Especial ( char c ) {
		return ( (c >= 32 && c <= 47) || (c >= 58 && c <= 64) || (c >= 91 && c <= 96) || (c >= 123 && c <= 127) );
	} 
	public static boolean Numero ( char c )	{
		return ( c >= '0' && c <= '9' );
	}
	// Fim funções para verificar caracteres

	public static boolean VerificarSenha ( String senha ){

		boolean eMaiuscula = false;
		boolean eMinuscula = false;
		boolean eEspecial  = false;
		boolean eNumero    = false;
	

		if ( senha.length() >= 8 ) {
			
			for (int i=0; i < senha.length(); i++) {
				
				char c = senha.charAt(i);

				if ( LetraMaiuscula(c) ) {
           			eMaiuscula = true;
            	}
				else if ( LetraMinuscula(c) ) {
                	eMinuscula = true;
            	}
				else if ( Numero(c) ) {
                	eNumero = true;
            	}
				else if ( Especial(c) ) {
                	eEspecial = true;
            	}
        	}
		}
		return eMaiuscula && eMinuscula && eNumero && eEspecial;
	}
	

	public static void main (String[] args) {

		String entrada = "";

        Scanner sc = new Scanner(System.in);

        while (!(entrada = sc.nextLine()).equals("FIM")) {

            if (VerificarSenha(entrada)) {
               	MyIO.println("SIM");
            } 
			else {
				MyIO.println("NAO");
            }

        }
    	sc.close();

	
	}

}
