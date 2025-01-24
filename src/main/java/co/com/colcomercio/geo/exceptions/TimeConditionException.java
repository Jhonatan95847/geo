package co.com.colcomercio.geo.exceptions;

public class TimeConditionException extends RuntimeException{
    public static final String TEXT_IS_VISIBLE_IN_TIMEOUT  =  "The text condition was not met within the specified time ";
    public TimeConditionException(String message) {
        super(message);
    }
}
