/*
 *	Carlos Eduardo de Melo Sabino - 856290
 *
 * 	TP01Q17 - Palindromo Recursivo C
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <wchar.h>
#include <wctype.h>
#include <locale.h>

bool ePalindromo(wchar_t str[], int inicio, int fim) {

    if (inicio >= fim) {
        return true;
    }

    if (str[inicio] != str[fim]) {
        return false;
    }

    return ePalindromo(str, inicio + 1, fim - 1);
}

int main(void) {
   
	setlocale(LC_ALL, "");
    
	wchar_t string[100];

    do {
        wint_t str;
        int length = 0;

        while ((str = getwchar()) != '\n') {
            if (length < 100) {
                string[length++] = str;
            }
        }

        string[length] = L'\0';

        if (wcscmp(string, L"FIM") == 0) {
            break;
        }

        ePalindromo(string, 0, length - 1) ? wprintf(L"SIM\n") : wprintf(L"NAO\n");

    } while (wcscmp(string, L"FIM") != 0);

    return 0;
}

/*
 * Caso estejam lendo, ao fazer o código recusivo reparei que na primeira questão
 * escrevi "lenght" no lugar de "length", relevem por favor.
 *
 */
