import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileManager.readFile();
        String mensaje = FileManager.readFile();
        Cipher.encriptar( mensaje, 3 );

        /**El metodo main solo debe ejecutar menú, debe hacerse limpieza de lo demás**/

        //FileManager.writeFile();
        //new Cipher();
        //Menu.iniciarPrograma();

        //Logica de menu
        //1.- Encriptar
        //2.- Desencriptar
        //3.- Fuerza bruta
        //4.- Análisis estadístico
        //0.- Salir

        //Ejemplo de llamar al metodo de encriptación
        //cipher.encrypt( "input.txt", "output.txt", 3 );

        // String frase = "Hola mundo, bienvenido al mundo de Java.";
        // char letra = 'm';
        //int indice = frase.indexOf( letra ) ;
        // System.out.println("El índice de la primera aparición de 'mundo' es:" + "" + indice);
    }
}
