import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class FileManager {
    public static String readFile() throws IOException {
        //Path archivoEncriptado = Path.of( "M:\\Documentos\\MensajeAEncriptar.txt" );

        File documentoporCifrar = new File( "MensajeAEncriptar.txt" );
        if (documentoporCifrar.createNewFile()) {
            System.out.println( documentoporCifrar + " Se ha creado el documento. Escriba su mensaje en el documento" );
        }
        String mensaje = Files.readString( documentoporCifrar.toPath() );
        System.out.println( mensaje );

        return mensaje.toUpperCase();
    }

    public static String writeFile(String mensajeFinal) throws IOException {
        File documentoCifrado = new File( "MensajeCifrado.txt" );
        if (documentoCifrado.createNewFile()) {
            System.out.println( documentoCifrado + "Se ha creado el documento cifrado" );
        }
        try {
            FileWriter writer = new FileWriter( "MensajeCifrado.txt" );
            writer.write( mensajeFinal );
            writer.close();

            System.out.println( "El mensaje se escribió correctamente" );
        } catch (IOException e) {
            System.out.println( "Ocurrió un error" );
        }
        return null;
    }

}


//"M:\Documentos"