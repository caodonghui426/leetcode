package workspace;

public class AgeIllegalRuntimeException extends RuntimeException{
    public AgeIllegalRuntimeException() {

    }

    public AgeIllegalRuntimeException(String msg) {
        super(msg);
    }
}