/*
 *	Carlos Eduardo de Melo Sabino - 856290
 *
 *	TP01Q15 - Arquivo em C
 */

#include <stdio.h>
#include <stdlib.h>


void arqWrite(int qtd, const char *filename) {
    
	FILE *arq = fopen(filename, "wb");
    
	double entrada;

	for (int i=0; i < qtd; i++) {
    
		scanf("%lf", &entrada);
        
		fwrite(&entrada, sizeof(double), 1, arq);
    }

    fclose(arq);
}


void arqReverse(int qtd, const char *filename) {

	FILE *arq = fopen(filename, "rb");
    
	
	fseek(arq, 0, SEEK_END);
    
	long doubleSize = sizeof(double);
    
	for (int i = qtd-1; i >= 0; i--) {
        
		fseek(arq, i * doubleSize, SEEK_SET);
        
        double saida;
        
		fread(&saida, sizeof(double), 1, arq);

        if ( (int)saida == saida ) {

            printf("%d\n", (int)saida);
        }
		else {
            printf("%g\n", saida);
        }
    }

    fclose(arq);
}

int main() {

	int qtd;
    
	scanf("%d", &qtd);

    const char *filename = "arquivo.txt";

    arqWrite(qtd, filename);
    
	arqReverse(qtd, filename);

    return 0;
}

