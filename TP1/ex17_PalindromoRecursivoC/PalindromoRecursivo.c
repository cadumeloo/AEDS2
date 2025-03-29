/*
 *	Carlos Eduardo de Melo Sabino - 856290
 *	
 *	TP01Q17 - Palindromo Recursiovo em C
 */


#include <stdio.h>
#include <string.h>
#include <stdbool.h>


// Função recursiva para verificar se a string é um palindromo

bool ePalindromo(char str[], int i, int tamanho) {

	if ( i >= tamanho) {
        return true;
    }
    if (str[i] != str[tamanho]) {
        return false;
    }
    
	return ePalindromo(str, i + 1, tamanho - 1);
}

int main(void) {

	char str[1000];

	/*
	 * Não gosto de usar while e break mas foi o único
	 * jeito que encontrei e funcionou
	 */
	while (true) {

        scanf(" %[^\n]", str);

        if (strcmp(str, "FIM") == 0) {
            break;
        }
		else {
            
			int tamanho = strlen(str);
            
			if (ePalindromo(str, 0, tamanho - 1)) {
                printf("SIM\n");
            }
			else {
                printf("NAO\n");
            }
        }
    }
    return 0;
}
