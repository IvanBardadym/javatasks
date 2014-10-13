package ua.yandex.shad.tempseries;

public class NotEnoughValuesToForecastException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NotEnoughValuesToForecastException() {
    }
	
	public NotEnoughValuesToForecastException(String message) {
        super(message);
    }

    public NotEnoughValuesToForecastException(String message, Throwable throwable) {
        super(message, throwable);
    }

	
	
}
