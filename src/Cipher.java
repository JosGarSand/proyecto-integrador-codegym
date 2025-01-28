import java.util.Arrays;
import java.util.Scanner;

public class Cipher {
    private static final char[] alfabeto = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private String MensajeCifrado = " ";

    /*public static int clave() {
        System.out.println( "Ingrese la clave de encriptacion: " );
        Scanner claveEncript = new Scanner( System.in );
        int clave = claveEncript.nextInt();
        return clave;
    }*/

    public static String encriptar(String mensajeCifrado, int clave) {
        //Esto funciona para recorrer la ubicacion del alfabeto, no asigna las ubicaciones ni valores nuevos
        char[] nuevoAlfabeto = new char[26];
        for (int u = 0; u < alfabeto.length; u++) {

            //TODO agregar excepcion para manejo de numeros negativos
           /* int nuevaPosicion = ((u + clave - 1) % alfabeto.length);
            if (nuevaPosicion > 25) {
                nuevaPosicion = (nuevaPosicion - 25);
            }
            nuevoAlfabeto[nuevaPosicion] = alfabeto[u];*/
            int nuevaPosicion = ((u + clave) % alfabeto.length);
            nuevaPosicion = (nuevaPosicion + alfabeto.length) % alfabeto.length;
            nuevoAlfabeto[nuevaPosicion] = alfabeto[u];


            //   System.out.println( Arrays.toString( nuevoAlfabeto ).toUpperCase() );
        }

        /**Lo de arriba es para ver que funcione el nuevo alfabeto**/
        //Aquí deberían asignarse las nuevas posiciones a las letras del mensaje que se ingresa

        //char[] mensajeEnChar = MensajeCifrado.toCharArray();
        //char[] mensajeEncriptado = new char[mensajeCifrado.length()];
        StringBuilder cipherMessage = new StringBuilder();
        for (int i = 0; i < mensajeCifrado.length(); i++) {
            int ubicacion = Arrays.binarySearch( alfabeto, mensajeCifrado.charAt(i));
            if (ubicacion < 0) {
                //mensajeEncriptado[i] = mensajeCifrado.charAt( i );
                cipherMessage.append( mensajeCifrado.charAt( i ));
                continue;
            }

           // mensajeEncriptado[i] = nuevoAlfabeto[ubicacion];
            cipherMessage.append( nuevoAlfabeto[ubicacion]);
            //Este de abajo es el mensaje encriptado posición por posición, sirve como referencia unicamente, no se imprimirá en la versión final
            //System.out.println( mensajeEncriptado[i] );
        }
        String mensajeYaEncriptado = cipherMessage.toString(); //String.valueOf( mensajeEncriptado );
        System.out.println( mensajeYaEncriptado );

        return mensajeYaEncriptado;

    }

    public static String desencriptar(String mensajeCifrado, int clave) {
        String mensajeDesencriptado = encriptar( mensajeCifrado, -clave );
        System.out.println( mensajeDesencriptado );
        return mensajeDesencriptado;

    }

}


