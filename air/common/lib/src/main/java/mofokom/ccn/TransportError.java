package mofokom.ccn;

public class TransportError extends Exception {

    public TransportError(Throwable cause) {
        super(cause);
    }

    public TransportError(String message, Throwable cause) {
        super(message, cause);
    }

    public TransportError(String message) {
        super(message);
    }

    public TransportError() {
    }

    

}
