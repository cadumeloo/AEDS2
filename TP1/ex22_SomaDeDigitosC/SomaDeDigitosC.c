/*
 *	Carlos Eduardo de Melo Sabino - 856290
 *
 *	TP01Q22 - Soma de Digitos em C
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/*
*	Função para somar os digitos
*	@param x numero a ser somado
*	Retorna ela mesma somando o resto da divisão
*/

int somarDigitos(int x) {
    
    if (x == 0) {
        return 0;
    }

    return (x % 10) + somarDigitos(x / 10);
}

int main() {
    
    char entrada[100];
    
    scanf("%s", entrada);
    
    while (strcmp(entrada, "FIM") != 0) {
    
	// Função atoi para converter o caractere da string em número inteiro
	int x = atoi(entrada);
    
	printf("%d\n", somarDigitos(x));
        
	scanf("%s", entrada);
    }
    
    return 0;
}

