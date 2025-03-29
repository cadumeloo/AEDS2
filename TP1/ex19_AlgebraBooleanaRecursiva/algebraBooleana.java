/*
 *	Carlos Eduardo de Melo - 856290
 *
 *	TP01Q19 - Algebra Booleana Recursiva
 */

import java.util.*;

public class algebraBooleana {

    public static String Simplificar( String entrada ) {
        
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

    public static String valorEq( String eq ) {
        
		char op = eq.charAt(0);
        
		boolean resultado;

        switch (op) {
            
			case 'a': 
				// True se ambos forem '1'
				resultado = !eq.contains("0");
                break;

            case 'o': 
				// True se qualquer caractere for '1'
                resultado = eq.contains("1");
                break;
            
			case 'n': 
				// Invertido então depende apenas do segundo caractere
                resultado = eq.charAt(2) == '0'; 
                break;
            
			default:
                return "";
        }
        return resultado ? "1" : "0";
    }

    public static String resolverExpressao( String eq ) {
   
		if (!eq.contains("(")) {
            return eq;
        }

        int left = eq.lastIndexOf("(");
        
		int right = eq.indexOf(")", left);

        String subEquac = eq.substring(left - 1, right + 1); 
        
		String resultadoSubExp = valorEq(subEquac);

        String novaEquacao = eq.substring(0, left-1) + resultadoSubExp + eq.substring(right + 1);

		return resolverExpressao(novaEquacao);
    }

    public static boolean ResolucaoFinal( String entrada ) {
     
		String eq = Simplificar(entrada);
        
		String resultado = resolverExpressao(eq);
        
		return resultado.equals("1");
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

