/*
 *	Carlos Eduardo de Melo Sabino - 856290
 *
 *	TP01Q05 - Algebra Booleana
 */

import java.util.*;

public class algebraBool {

    public static String Simplificar ( String entrada ) {

		int qtd = Character.getNumericValue(entrada.charAt(0));
        
		String equacao = entrada.replace(" ", "");

        equacao = equacao.replace("and", "a").replace("or", "o").replace("not", "n");
        
        for (int i=0; i < qtd; i++) {

            char letra = (char) ('A' + i);
            
			char valorDaLetra = equacao.charAt(i + 1);
            
			equacao = equacao.replace(letra, valorDaLetra);
        }
        return equacao.substring(qtd + 1);
    }

    public static String valorEq(String eq) {

		char op = eq.charAt(0);
        
		boolean result;

       	switch (op) {
        	case 'a':

            	// True se ambos forem '1'
            	result = !eq.contains("0");
				break;
        
			case 'o': 

            	// True se qualquer caractere for '1'
            	result = eq.contains("1");
            	break;
        
			case 'n': 

            	// Invertido então depende apenas do segundo caractere
            	result = eq.charAt(2) == '0';
            	break;

        	default:
            	return "";
    	}
	
		return result ? "1" : "0";
	}


	public static boolean ResolucaoFinal( String entrada ) {

		String eq = Simplificar(entrada);
		
		while ( eq.contains("(") ) {
		
			int left = eq.lastIndexOf("(");
			
			int right = eq.indexOf(")", left);
			
			String subEquac = eq.substring(left - 1, right + 1);
			
			String resultadoSubExp = valorEq(subEquac);
			
			eq = eq.substring(0, left - 1) + resultadoSubExp + eq.substring(right + 1);
		}
		return eq.equals("1");
	}


    public static void main(String[] args) {

		String entrada = "";

		Scanner sc = new Scanner(System.in);
        
		while (!(entrada = sc.nextLine()).equals("0")) {	
        	
		   	System.out.println(ResolucaoFinal(entrada) ? "1" : "0");
        }
	
		sc.close();
	}
}
