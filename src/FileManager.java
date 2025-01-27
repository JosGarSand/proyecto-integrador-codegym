import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileManager {
    public static String readFile() throws IOException {
        //Path archivoEncriptado = Path.of( "M:\\Documentos\\MensajeAEncriptar.txt" );


        File documentoCifrado = new File( "Prueba.txt" );
        if (documentoCifrado.createNewFile()) {
            System.out.println( documentoCifrado + " Se ha creado el documento. Escriba su mensaje en el documento" );
        }
        String mensaje = Files.readString( documentoCifrado.toPath() );
        System.out.println( mensaje );

        return mensaje.toUpperCase();
    }

    public static String writeFile(String mensajeFinal) {
        return null;
    }


}


//"M:\Documentos"