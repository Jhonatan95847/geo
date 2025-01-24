package co.com.colcomercio.geo.exceptions;

public class TesseractExceptions extends RuntimeException {
    public static final String LOCATION_FAILURE  =  "Cannot locate tesseract path";

    public TesseractExceptions(String message, Throwable cause) {
        super(message, cause);
    }
}
