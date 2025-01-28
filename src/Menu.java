import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static void iniciarPrograma() {
        Scanner entrada = new Scanner( System.in );
        System.out.println( "Bienvenido al programa de cifrado Cesar" );
        /**Agregar las llamadas a los respectivos métodos en cada case**/

        boolean opcionValida = false;
        while (!opcionValida) {
            try {
                System.out.println( "Selecciona una de las siguientes opciones: " );
                System.out.println( "\n1 Encriptar un mensaje \n2 Desencriptar un mensaje \n3 Desencriptar usando fuerza bruta \n0 salir del programa" );
                System.out.println( " " );
                System.out.println( "Seleccione su opción: " );
                int opcion = entrada.nextInt();
                switch (opcion) {
                    case 1 -> {

                        System.out.println( "Ha seleccionado encriptar un mensaje" );
                        opcionValida = true;
                        //Cipher.encriptar( FileManager.readFile(), Cipher.clave() );
                        //Agregar nextline para capturar el archivo que se desea encriptar
                        //Agregar impresión de solicitud
                        System.out.println( "Por favor ingresa el nombre del archivo que deseas encriptar: " );
                        String fileContent = FileManager.readFile( entrada.nextLine() );
                        System.out.println( "Ingrese la clave de encriptacion: " );
                        int clave = entrada.nextInt();
                        /**Llamar al validador, pero dentro de la clase encriptar**/
                        String mensajeAhoraSiFinal = Cipher.encriptar( fileContent, clave );
                        FileManager.writeFile( mensajeAhoraSiFinal );


                    }
                    case 2 -> {
                        System.out.println( "Ha seleccionado desencriptar un mensaje" );
                        opcionValida = true;
                        System.out.println( "Ingrese la clave de desencriptado" );
                        //String mensajeDesencriptado = Cipher.encriptar(Cipher.encriptar(FileManager.readFile(), Cipher.clave() ), Cipher.clave());
                        /**String mensajeDesencriptado = Cipher.desencriptar( mensajeADescifrar, Cipher.clave() );**/
                        //System.out.println(mensajeDesencriptado);
                        //Cipher.desencriptar( FileManager.readFile() )

                    }
                    case 3 -> {
                        System.out.println( "Ha seleccionado desencriptar usando fuerza bruta" );
                        opcionValida = true;

                    }
                    case 0 -> {
                        System.out.println( "Ha seleccionado salir del programa. Hasta luego!" );
                        opcionValida = true;

                    }
                    default -> {
                        System.out.println( "Ha ingresado una opción no valida. Por favor, vuelva a intentarlo." );

                    }
                }
            } catch (InputMismatchException e) {
                System.out.println( "Error: necesita ingresar un numero en el menú. Intente nuevamente." );
                entrada.nextLine();
            } catch (IOException e) {
                throw new RuntimeException( e );
            }
        }
    }
    //private encryptFileContent(){

}
