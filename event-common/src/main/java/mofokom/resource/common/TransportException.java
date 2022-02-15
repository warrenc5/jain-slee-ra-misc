package mofokom.resource.common;

public class TransportException extends Exception {

    public TransportException(Throwable cause) {
        super(cause);
    }

    public TransportException(String message, Throwable cause) {
        super(message, cause);
    }

    public TransportException(String message) {
        super(message);
    }

    public TransportException() {
    }

    

}
