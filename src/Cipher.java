import java.util.Arrays;
import java.util.Scanner;

public class Cipher {
    private static final char[] alfabeto = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private String MensajeCifrado = " ";

    public static int clave() {
        System.out.println( "Ingrese la clave de encriptacion: " );
        Scanner claveEncript = new Scanner( System.in );
        int clave = claveEncript.nextInt();
        if (clave < 0) {
            throw new NumeroNegativoException( "El numero ingresado debe ser positivo" );
        }
        return clave;
    }

    public static String encriptar(String MensajeCifrado, int clave) {
        //Esto funciona para recorrer la ubicacion del alfabeto, no asigna las ubicaciones ni valores nuevos
        char[] nuevoAlfabeto = new char[26];
        for (int u = 0; u < alfabeto.length; u++) {

            //TODO agregar excepcion para manejo de numeros negativos
            int nuevaPosicion = (u + clave - 1) % alfabeto.length;
            if (nuevaPosicion > 25) {
                nuevaPosicion = nuevaPosicion - 25;
            }
            nuevoAlfabeto[nuevaPosicion] = alfabeto[u];

            //   System.out.println( Arrays.toString( nuevoAlfabeto ).toUpperCase() );
        }

        /**Lo de arriba es para ver que funcione el nuevo alfabeto**/
        //Aquí deberían asignarse las nuevas posiciones a las letras del mensaje que se ingresa

        char[] mensajeEnChar = MensajeCifrado.toCharArray();
        char[] mensajeEncriptado = new char[mensajeEnChar.length];
        for (int i = 0; i < mensajeEnChar.length; i++) {
            int ubicacion = Arrays.binarySearch( alfabeto, mensajeEnChar[i] );
            if (ubicacion < 0) {
                mensajeEncriptado[i] = mensajeEnChar[i];
                continue;
            }

            mensajeEncriptado[i] = nuevoAlfabeto[ubicacion];
            //Este de abajo es el mensaje encriptado posición por posición, sirve como referencia unicamente, no se imprimirá en la versión final
            //System.out.println( mensajeEncriptado[i] );
        }
        String mensajeYaEncriptado = String.valueOf( mensajeEncriptado );
        System.out.println( mensajeYaEncriptado );

        return mensajeYaEncriptado;

    }

    public static String desencriptar(String mensajeCifrado) {

        return mensajeCifrado;
    }

}


