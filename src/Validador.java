public class Validador {
    public boolean validKey(int clave, char[] alfabeto) {
        {
            //Va antes que el metodo cipher y se encarga de verificar que la clave vaya entre 0 y alfabeto.length
        }
        return false;
    }

    public boolean isFileExists(String filePath){
        //Va antes que la llamada al metodo readfile, y se asegura que existe
        //NO SE ENCARGA DE CREARLO SI NO EXISTE, SOLO NOTIFICARLO
        return false;
    }

}