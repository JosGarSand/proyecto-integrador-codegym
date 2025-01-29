import java.util.Arrays;
import java.util.Scanner;

public class Cipher {
    private static final char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private final String cipheredMessage = " ";

    public static int key() {
        System.out.println( "Ingrese la clave de encriptacion: " );
        Scanner claveEncript = new Scanner( System.in );
        int key = claveEncript.nextInt();
        return key;
    }

    public static String encriptar(String mensajeCifrado, int key) {
        char[] newAlphabet = new char[26];
        for (int u = 0; u < alphabet.length; u++) {

            int newPosition = (u + key ) % alphabet.length;
            if (newPosition > 25) {
                newPosition = (newPosition - 25);
            }

            newPosition = (newPosition + alphabet.length) % alphabet.length;
            newAlphabet[newPosition] = alphabet[u];

        }

        char[] encryptedMessage = new char[mensajeCifrado.length()];
        //StringBuilder cipherMessage = new StringBuilder();
        for (int i = 0; i < mensajeCifrado.length(); i++) {
            int ubicacion = Arrays.binarySearch( alphabet, mensajeCifrado.charAt( i ) );
            if (ubicacion < 0) {
                encryptedMessage[i] = mensajeCifrado.charAt( i );
                //cipherMessage.append( mensajeCifrado.charAt( i ));
                continue;
            }

            encryptedMessage[i] = newAlphabet[ubicacion];
            // cipherMessage.append( newAlphabet[ubicacion]);
            //Este de abajo es el mensaje encriptado posición por posición, sirve como referencia unicamente, no se imprimirá en la versión final
            //System.out.println( encryptedMessage[i] );
        }
        //encryptedMessage.toString();
        String mensajeYaEncriptado = String.valueOf( encryptedMessage );
        System.out.println( "Este es su mensaje " + mensajeYaEncriptado );
        //System.out.println( "Se ha creado un nuevo archivo con su mensaje encriptado" );

        return mensajeYaEncriptado;

    }

    public static String desencriptar(String mensajeCifrado, int clave) {
        String mensajeDesencriptado = encriptar( mensajeCifrado, - clave );
        //System.out.println( mensajeDesencriptado );
        return mensajeDesencriptado;

    }

}
