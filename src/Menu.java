import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static void iniciarPrograma() {
        Scanner entrada = new Scanner( System.in );
        System.out.println( "Bienvenido al programa de cifrado Cesar" );

        boolean opcionValida = false;
        while (!opcionValida) {
            try {
                System.out.println( "Selecciona una de las siguientes opciones: " );
                System.out.println( "\n1 Encriptar un mensaje \n2 Desencriptar un mensaje \n3 Desencriptar usando fuerza bruta \n0 salir del programa" );
                System.out.println( " " );
                System.out.println( "Seleccione su opción: " );
                int opcion = entrada.nextInt();
                entrada.nextLine();
                switch (opcion) {
                    case 1 -> {
                        System.out.println( "Ha seleccionado encriptar un mensaje" );
                        System.out.println( "Por favor ingresa el nombre del archivo que deseas encriptar: " );
                        String mensajeAhoraSiFinal = Cipher.encriptar( FileManager.readFile( entrada.nextLine() ), Cipher.key() );
                        /**Llamar al validador, pero dentro de la clase encriptar**/
                        FileManager.writeFile( mensajeAhoraSiFinal );
                        System.out.println("Se ha creado un archivo con su mensaje cifrado");
                        System.out.println("Nombre del archivo 'Mensaje Cifrado.txt'");
                        opcionValida = true;

                    }
                    case 2 -> {
                        System.out.println( "Ha seleccionado desencriptar un mensaje" );
                        System.out.println( "Ingrese el nombre del archivo a desencriptar" );
                        Cipher.desencriptar( FileManager.readFile( entrada.nextLine() ), Cipher.key() );
                        int clave = entrada.nextInt();
                        opcionValida = true;
                    }
                    case 3 -> {
                        System.out.println( "Ha seleccionado desencriptar usando fuerza bruta" );
                        opcionValida = true;

                    }
                    case 0 -> {
                        System.out.println( "Ha seleccionado salir del programa. Hasta luego!" );
                        opcionValida = true;

                    }
                    default -> System.out.println( "Ha ingresado una opción no valida. Por favor, vuelva a intentarlo." );
                }
            } catch (InputMismatchException e ) {
                System.out.println( "Ha ingresado una opcion no valida, intente nuevamente" );
                entrada.nextLine();
            } catch (IOException e ){
                System.out.println("El archivo ingresado no se encontró, por favor verifique el nombre del archivo");
            }
        }
    }
}

