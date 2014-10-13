package ua.yandex.shad.tempseries;

public class IllegalTemperatureValueException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public IllegalTemperatureValueException() {
    }
	
	public IllegalTemperatureValueException(String message) {
        super(message);
    }

    public IllegalTemperatureValueException(String message, Throwable throwable) {
        super(message, throwable);
    }

}

