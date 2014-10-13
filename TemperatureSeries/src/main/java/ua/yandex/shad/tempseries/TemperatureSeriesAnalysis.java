package ua.yandex.shad.tempseries;

public class TemperatureSeriesAnalysis {

	private final double[] temperatureSeries;

	public TemperatureSeriesAnalysis(double[] temperatureSeries)
			throws IllegalTemperatureValueException {
		double absoluteZero = -273.0;
		for (double d : temperatureSeries) {
			if (d <= absoluteZero)
				throw (new IllegalTemperatureValueException(
						"Illegal Temperature value"));
		}
		this.temperatureSeries = temperatureSeries;

	}

	public double calcAverageTemp() throws EmptyTemperatureSeriesException {
		
		if (temperatureSeries.length == 0) {
			throw (new EmptyTemperatureSeriesException("Empty Series Array!"));
		}

		double sum = 0;
		for (double d : temperatureSeries)
			sum += d;
		return sum / temperatureSeries.length;
	}

	public double calcTempDeviation() throws EmptyTemperatureSeriesException {
		if (temperatureSeries.length <= 1) {
			throw (new EmptyTemperatureSeriesException(
					"Lenth of temperature series less then 2!"));
		}
		double sum = 0;
		double averageValue = calcAverageTemp();
		for (double d : temperatureSeries) {
			sum += Math.pow(d - averageValue, 2);
		}
		return sum / (temperatureSeries.length - 1);
	}

	public double findTempClosestToZero() {
		return findTempClosestToValue(0);
	}

	public double findTempClosestToValue(double tempValue) {

		int targetIndex = 0;
		double targetDeviation = Math.abs(temperatureSeries[targetIndex]
				- tempValue);
		for (int i = 1; i < temperatureSeries.length; i++) {

			double currentDeviation = Math
					.abs(temperatureSeries[i] - tempValue);
			if (currentDeviation < targetDeviation) {

				targetIndex = i;
				targetDeviation = currentDeviation;
			}
			if (currentDeviation == targetDeviation) {

				if (temperatureSeries[i] - tempValue > temperatureSeries[targetIndex]
						- tempValue) {

					targetIndex = i;
				}
			}
		}
		return temperatureSeries[targetIndex];
	}

	public double[] findTempsLessThen(double tempValue) {

		double[] result = new double[] {};

		for (double d : temperatureSeries) {
			if (d < tempValue) {
				double[] tmp = new double[result.length + 1];
				System.arraycopy(result, 0, tmp, 0, result.length);
				result = tmp;
				result[result.length - 1] = d;
			}
		}

		if (result.length == 0) {
			result = new double[] { 0 };
		}
		return result;
	}

	public double[] findTempsGreaterThen(double tempValue) {

		double[] result = new double[] {};

		for (double d : temperatureSeries) {
			if (d > tempValue) {
				double[] tmp = new double[result.length + 1];
				System.arraycopy(result, 0, tmp, 0, result.length);
				result = tmp;
				result[result.length - 1] = d; // last element
			}
		}

		if (result.length == 0) {
			result = new double[] { 0 };
		}
		return result;
	}

	public double[] forecatsTemp(double tempValue) {
		return new double[] {};
	}
}
