/*
 *	Carlos Eduardo de Melo Sabino - 856290
 *
 *	TP01Q21 - Inversão de Stirng Recursiva em C
 *
*/

#include <stdio.h>
#include <string.h>

/*
*	Função para inverter string
*	@param str receber a string
*	@return string invertida
*/

void inversao(char *str, int inicio, int fim) {
    if (inicio >= fim) {
        return;
    }
    
    // Troca dos caracteres
    char temp = str[inicio];
    str[inicio] = str[fim];
    str[fim] = temp;
    
    // Chamada recursiva
    inversao(str, inicio + 1, fim - 1);
}

int main() {
    
    char entrada[100];
    
    fgets(entrada, sizeof(entrada), stdin);
    
    // Remove a quebra de linha
    entrada[strcspn(entrada, "\n")] = 0;


    while (strcmp(entrada, "FIM") != 0) {
        
        inversao(entrada, 0, strlen(entrada) - 1);
        
        printf("%s\n", entrada);
        
        fgets(entrada, sizeof(entrada), stdin);
        
	entrada[strcspn(entrada, "\n")] = 0;
    }
    
    return 0;
}
