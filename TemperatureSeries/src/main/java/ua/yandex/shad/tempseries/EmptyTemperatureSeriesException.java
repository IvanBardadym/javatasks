package ua.yandex.shad.tempseries;

public class EmptyTemperatureSeriesException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public EmptyTemperatureSeriesException() {
    }
	
	public EmptyTemperatureSeriesException(String message) {
        super(message);
    }

    public EmptyTemperatureSeriesException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
