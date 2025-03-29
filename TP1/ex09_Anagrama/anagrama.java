/*
 * 	Carlos Eduardo de Melo Sabino - 856290
 *
 * 	TP01Q09 - Anagrama
 */

import java.text.Normalizer;
import java.util.*;

public class anagrama {
    
	public static String Padronizar(String str) {

        return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("\\p{M}", "").toLowerCase();
    }

    public static boolean Anagrama(String str1, String str2) {
    
		str1 = Padronizar(str1).trim();
        
		str2 = Padronizar(str2).trim();
        
		char[] str1ToArray = str1.toCharArray();
        
		char[] str2ToArray = str2.toCharArray();
        
		Arrays.sort(str1ToArray);
        
		Arrays.sort(str2ToArray);

		if ( Arrays.equals( str1ToArray , str2ToArray) ) {
			return true;
		}

        return false;
    }

    public static void main(String[] args) {

		String entrada = "";

    	Scanner sc = new Scanner(System.in);

		while (!(entrada = sc.nextLine()).equals("FIM")) {

			String[] PossiveisAnagramas = entrada.split(" - ");

            if (PossiveisAnagramas.length == 2) {
              
				MyIO.println(Anagrama( PossiveisAnagramas[0], PossiveisAnagramas[1]) ? "SIM" : "NÃO");
            }

        }
		sc.close();
    }
}
