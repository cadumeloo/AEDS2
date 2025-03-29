/*
 *	Carlos Eduardo de Melo Sabino - 856290
 *
 *	TP01Q14 - Arquivo Java
 */

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;


public class arquivo {
   

	public static void arqWrite( int qtd, String filename, Scanner sc ) {
        try {
        	
			RandomAccessFile arq = new RandomAccessFile( filename, "rw" );
            
			for (int i=0; i < qtd; i++) {
            
				double entrada = sc.nextDouble();
                
				arq.writeDouble(entrada);
            }
            arq.close();
        }
        catch( Exception e ) {
            
			e.printStackTrace();
        }
    }
 
	public static void arqReverse( int qtd, String filename ) {
        try {
            
			RandomAccessFile arq = new RandomAccessFile( filename, "rw" );
            
			long doubleSize = 8;
            
			for (int i = qtd-1; i >= 0; i--) {
                
				arq.seek( i * doubleSize );
                
				double saida = arq.readDouble();
                
				if ( saida == (int) saida ) {
                    System.out.println( (int) saida );
                }
				else {
                    System.out.println(saida);
                }
            }
        } 
		catch (IOException e) {

            throw new RuntimeException(e);
        }


    }

    public static void main(String[] args) {
       
		Scanner sc = new Scanner(System.in);

        int qtd = 0;

		qtd = sc.nextInt();
        
		String filename = "arquivo.txt";
        
		arqWrite(qtd, filename, sc);
        
		sc.close();

        arqReverse(qtd, filename);
    }
}
