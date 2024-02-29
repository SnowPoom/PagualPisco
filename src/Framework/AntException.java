package Framework;

public class AntException extends Exception{

    public AntException(String e, String clase, String metodo) {
        System.out.println("[ERROR EN PoliTinder para el log] " + clase + "." + metodo + " : " + e);
    }
}
