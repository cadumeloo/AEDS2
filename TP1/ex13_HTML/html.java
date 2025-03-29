/*
 *	Carlos Eduardo de Melo Sabino - 856290
 *
 *	TP01Q13 - Leitura de página HTML
 */

import java.io.*;
import java.net.*;

public class html {

    static int[] vogais;

    static final char[] vogaisEspeciais = {
      225, 233, 237, 243, 250, 224, 232, 236, 242,
	  249, 227, 245, 226, 234, 238, 244, 251  
    };

    public static void printVariaveis() {
        System.out.printf("a(%s) " , vogais[0]);
        System.out.printf("e(%s) " , vogais[1]);
        System.out.printf("i(%s) " , vogais[2]);
        System.out.printf("o(%s) " , vogais[3]);
        System.out.printf("u(%s) " , vogais[4]);
        System.out.printf("%c(%s) ", vogaisEspeciais[0], vogais[5]);
        System.out.printf("%c(%s) ", vogaisEspeciais[1], vogais[6]);
        System.out.printf("%c(%s) ", vogaisEspeciais[2], vogais[7]);
        System.out.printf("%c(%s) ", vogaisEspeciais[3], vogais[8]);
        System.out.printf("%c(%s) ", vogaisEspeciais[4], vogais[9]);
        System.out.printf("%c(%s) ", vogaisEspeciais[5], vogais[10]);
        System.out.printf("%c(%s) ", vogaisEspeciais[6], vogais[11]);
        System.out.printf("%c(%s) ", vogaisEspeciais[7], vogais[12]);
        System.out.printf("%c(%s) ", vogaisEspeciais[8], vogais[13]);
        System.out.printf("%c(%s) ", vogaisEspeciais[9], vogais[14]);
        System.out.printf("%c(%s) ", vogaisEspeciais[10], vogais[15]);
        System.out.printf("%c(%s) ", vogaisEspeciais[11], vogais[16]);
        System.out.printf("%c(%s) ", vogaisEspeciais[12], vogais[17]);
        System.out.printf("%c(%s) ", vogaisEspeciais[13], vogais[18]);
        System.out.printf("%c(%s) ", vogaisEspeciais[14], vogais[19]);
        System.out.printf("%c(%s) ", vogaisEspeciais[15], vogais[20]);
        System.out.printf("%c(%s) ", vogaisEspeciais[16], vogais[21]);
    }

	public static boolean eVogalEspecial( char c ) {

		for (int i=0; i < vogaisEspeciais.length; i++) {
            
			if ( c == vogaisEspeciais[i] ) {
                return true;
            } 
        } 
        return false;
    } 
	
	public static void contarVogais( String html ) {
    
		vogais = new int[23];
   
		for (int i=0; i < html.length(); i++) {
      	
			char letra = html.charAt(i);
      	
			if (letra == 'a')
        		vogais[0]++;
      		else if ( letra == 'e' )
        		vogais[1]++;
      		else if ( letra == 'i' )
        		vogais[2]++;
      		else if ( letra == 'o' )
        		vogais[3]++;
      		else if ( letra == 'u' )
        		vogais[4]++;
      		else if ( eVogalEspecial(letra) ) {
        	
				for (int j=0; j < vogaisEspeciais.length; j++) {
          		
					if (letra == vogaisEspeciais[j]) {
            			vogais[j + 5]++;
            			break;
        			}
        		}
      		}
    	}
	}

	public static int contarConsoantes( String html ) {
    	
		int resultado = 0;
    	
		String consoantes = "bcdfghjklmnpqrstvwxyz";
    	
		for (int i=0; i < consoantes.length(); i++) {
      		
			char letraConsoante = consoantes.charAt(i);
      		
			for (int j=0; j < html.length(); j++) {
        		
				char htmlLetra = html.charAt(j);
        		
				if (htmlLetra == letraConsoante) {
          			resultado++;
        		}
      		}
    	}
    	return resultado;
  	}

	public static int contarBr( String html ) {
    	
		int resultado = 0;
    	
		for (int i=0; i < html.length() - 4; i++) {
      		
			if ( html.substring(i, i + 4).equals("<br>") ) {
        		resultado++;
      		}
    	}
    	return resultado;
  	}

	public static int contarTable( String html ) {
    	
		int resultado = 0;
    	
		for (int i=0; i < html.length() - 7; i++) {
      		
			if (html.substring(i, i + 7).equals("<table>")) {
        		resultado++;
      		}
    	}	 
    	return resultado;
  	}	 

	
	public static void main(String[] args) {

		String nome;
    	String endereco;
    	String html = "";

	    int qtdConsoantes = 0;
		int qtdBr = 0;
		int qtdTable = 0;

		do {
    		nome = MyIO.readLine();
      		
			if ( !nome.equals("FIM") ) {
        	
				endereco = MyIO.readLine();
	        	html = getHtml(endereco);
        		contarVogais(html);
        		qtdConsoantes = contarConsoantes(html);
    	    	qtdBr = contarBr(html);
	        	qtdTable = contarTable(html);

	         	vogais[0] -= qtdTable;
	         	vogais[1] -= qtdTable;
         		qtdConsoantes -= (2 * qtdBr + 3 * qtdTable);
                              

	    	    printVariaveis();
    		    System.out.printf("consoante(%s) ", qtdConsoantes);
	        	System.out.printf("<br>(%s) ", qtdBr);
		        System.out.printf("<table>(%s) ", qtdTable);
	        	System.out.printf("%s\n", nome);
      		}

		} while ( !nome.equals("FIM") );
  	}
    
    public static String getHtml( String endereco ) {

		URL url;
	    InputStream is = null;
    	BufferedReader br;
	    String resposta = "", linha;

    	try {
        	url = new URL(endereco);
	        is = url.openStream();  
    	    br = new BufferedReader( new InputStreamReader(is) );

        	while ( (linha = br.readLine()) != null ) {
          		resposta += linha + "\n";
        	}
      	}
		catch ( IOException ioe ) {
        	ioe.printStackTrace();
      	}

      	try {

        	assert is != null;
        	is.close();
      	} 
	  	catch ( IOException ioe ) {
      
      	}

    	return resposta;
	}
}

