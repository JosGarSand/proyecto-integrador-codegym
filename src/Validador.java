import java.io.File;

public class Validador {

   // public boolean validKey(int clave, char[] alfabeto) {
      //  return clave >= 1 && clave <= alfabeto.length;
    //}

    public boolean isFileExists(String filePath){
        File file = new File( filePath );
        return file.exists() && file.isFile();
    }

}