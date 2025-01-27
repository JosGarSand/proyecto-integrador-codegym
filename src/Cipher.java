import java.util.Arrays;
import java.util.Scanner;

public class Cipher {
    private static final char[] alfabeto = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private String MensajeCifrado = " ";

    public Cipher() {
        System.out.println( "Ingrese la clave de encriptacion: " );
        Scanner claveEncript = new Scanner( System.in );

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
            System.out.println( mensajeEncriptado[i] );
        }
        String mensajeYaEncriptado = String.valueOf( mensajeEncriptado );
        System.out.println( mensajeYaEncriptado );

        return MensajeCifrado;
    }

    //for (int i = 0; i < MensajeCifrado.length(); i++) {
    // alfabeto[i] = (alfabeto[i] + clave);
    //  System.out.println(alfabeto[i]);
    //}

    // return null;
}


