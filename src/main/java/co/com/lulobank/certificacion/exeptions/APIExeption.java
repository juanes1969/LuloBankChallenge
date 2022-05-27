package co.com.lulobank.certificacion.exeptions;

public class APIExeption extends AssertionError {

    public APIExeption(String message, Throwable cause) {
        super(message, cause);
    }
}
