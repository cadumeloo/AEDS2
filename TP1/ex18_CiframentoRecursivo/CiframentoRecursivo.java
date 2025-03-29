import java.util.*;

public class CiframentoRecursivo {

    public static boolean Letra(char c) {
        return (c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z');
    }

    public static boolean Especial(char c) {
        return ((c >= 32 && c <= 47) || (c >= 58 && c <= 64) || (c >= 91 && c <= 96) || (c >= 123 && c <= 127));
    }

    public static boolean Numero(char c) {
        return (c >= '0' && c <= '9');
    }

    public static String CaesarCipher(String str, int pos) {
        
		if (pos == str.length()) {
            return "";
        }

        char Original = str.charAt(pos);
        char Novo;

        if (Letra(Original) || Especial(Original) || Numero(Original)) {
            Novo = (char) (Original + 3);
        }
		else {
            Novo = Original;
        }

        return Novo + CaesarCipher(str, pos + 1);
    }

    public static void main(String[] args) {
      
		String str;
        
		Scanner sc = new Scanner(System.in);

        while (!(str = sc.nextLine()).equals("FIM")) {
        
			String StringCodificada = CaesarCipher(str, 0);
            
			System.out.println(StringCodificada);
        }
    }
}

