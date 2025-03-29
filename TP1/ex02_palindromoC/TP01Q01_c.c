/*
	Carlos Eduardo de Melo Sabino - 856290

	Trabalho Prático 1 - Questtão 1 - Palindromo
*/


#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <wchar.h>
#include <wctype.h>
#include <locale.h>


bool ePalindromo(wchar_t str[], int length) {

	for(int i=0; i<length/2; i++) {

		if(str[i] != str[length - i - 1]) {

			return false;
		}

	}
	return true;
}

int main (void) {

	// char str[100];

	setlocale(LC_ALL, "");

	wchar_t string[100];


    
	do {
	
    	wint_t str;
    	int lenght = 0;

       	while ((str = getwchar()) != '\n') {
           	if (lenght < 100) {
           	    string[lenght++] = str;
           	}
    	 }
    
		// Adiciona o \0 ao final
		string[lenght] = L'\0'; 

	
        if (wcscmp(string, L"FIM") == 0) {
            break;
        }

        ePalindromo(string, lenght) ? wprintf(L"SIM\n") : wprintf(L"NAO\n");

	} while (wcscmp(string, L"FIM") != 0); 
	
	
	/*
	while ( fgets(str, sizeof(str), stdin) && !stringCompare(str, "FIM\n") ) {

		str[strcspn(str, "\n")] = '\0';
	

	}
	*/
  
return 0;
}
