/*
 *	Carlos Eduardo de Melo Sabino - 856290
 *
 *	TP01Q11 - Substring mais longa sem repetição
 */
import java.util.*;

public class Substring {

	public static int comprimento(String str) {
       
		int tamanho = str.length();
        
		int maxLength = 0;

		int count = 1; 

		int pos = 0; 
       
		// Armazena as posições dos caracteres não repetidos de acorodo com a tebela ASCII
		int[] ultimaPosicao = new int[128];

    	for (int i = 0; i < ultimaPosicao.length; i++) {

			ultimaPosicao[i] = -1;
        }
		
		for (int i = 0; i < tamanho; i++) {
        
			char c = str.charAt(i);
                      
			if (ultimaPosicao[c] >= pos) {
                              
				pos = ultimaPosicao[c] + 1;

                count = 1; 
			}
            
            ultimaPosicao[c] = i;
           
			// Calcula o tamanho maximo da maior substring atual
            count = i - pos + 1;

            // Atualiza a maior substring
        	maxLength = Math.max(maxLength, count);
		}

        return maxLength;
    }


	public static void main (String[] args) {

		Scanner sc = new Scanner(System.in);

		String str = "";

        while (!(str = sc.nextLine()).equals("FIM")) {
			
			System.out.println("" + comprimento(str));		

        }
    	sc.close();

	}


}
