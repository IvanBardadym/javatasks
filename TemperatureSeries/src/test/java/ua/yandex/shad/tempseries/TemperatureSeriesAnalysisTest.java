package ua.yandex.shad.tempseries;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import static org.junit.Assert.*;
import org.junit.Test;

public class TemperatureSeriesAnalysisTest {

	private double precision = 0.00001;
	
	@Test(expected = IllegalTemperatureValueException.class)
	public void testIllegalTemperatureValues(){
		double[] temperatureSeries = { -278.0, -5.0, 1.0 };
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(
				temperatureSeries);
	}
	
	@Test
	public void testCalcAverageTemp() {

		double[] temperatureSeries = { 1.0, -5.0, 1.0 };
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(
				temperatureSeries);
		double expResult = -1.0;
		double actualResult = seriesAnalysis.calcAverageTemp();
		assertEquals(expResult, actualResult, precision);
	}

	
	public void testCalcTempDeviation()  {
		double[] temperatureSeries = { 2.0, -3.0, 5.0, 7.0, -4.0 };
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(
				temperatureSeries);
		double expResult = 23.30;
		double actualResult = seriesAnalysis.calcTempDeviation();
		assertEquals(expResult, actualResult, precision);
	}

	
	@Test
	public void testFindTesmClosestToZero() {
		double[] temperatureSeries = { 1.05, -0.05, 5.0, 7.0, -4.0 };
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(
				temperatureSeries);
		double expResult = -0.05;
		double actualResult = seriesAnalysis.findTempClosestToZero();
		assertEquals(expResult, actualResult, precision);
	}

	@Test
	public void testFindTesmClosestToZeroSymetric(){
		double[] temperatureSeries = { 1.05, -0.05, 0.05, 7.0, -4.0 };
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(
				temperatureSeries);
		double expResult = 0.05;
		double actualResult = seriesAnalysis.findTempClosestToZero();
		assertEquals(expResult, actualResult, 0.00001);
	}

	
	@Test
	public void testFindTempClosestToValue(){
		double[] temperatureSeries = { 1.0, 1.0, 4.0, 5.0 };
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(
				temperatureSeries);
		double expResult = 1.0;
		double actualResult = seriesAnalysis.findTempClosestToValue(2.0);
		assertEquals(expResult, actualResult, precision);
	}

		@Test
	public void findTempClosestToValueSymetricTest(){

		double[] temperatureSeries = { 1.0, 2.0, 2.2, 4.0, 5.0 };
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(
				temperatureSeries);
		double expResult = 2.2;
		double actualResult = seriesAnalysis.findTempClosestToValue(2.1);
		assertEquals(expResult, actualResult, precision);
	}

	@Test
	public void testfindTempsLessThen(){

		double[] temperatureSeries = { 1.0, 2.0, 2.2, 4.0, 5.0 };
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(
				temperatureSeries);
		double[] expResult = new double[]{1.0, 2.0, 2.2};
		double[] actualResult = seriesAnalysis.findTempsLessThen(3.0);
		assertArrayEquals(expResult, actualResult, precision);
		
	}

	@Test
	public void testfindTempsLessThenNoElements(){
		
		double[] temperatureSeries = { 1.0, 2.0, 2.2, 4.0, 5.0 };
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(
				temperatureSeries);
		double[] expResult = new double[]{0};
		double[] actualResult = seriesAnalysis.findTempsLessThen(-2.0);
		assertArrayEquals(expResult, actualResult, precision);
		
	}
	
	
	@Test
	public void testfindTempsGreaterThen(){
		
		double[] temperatureSeries = { 1.0, 2.0, 2.2, 4.0, 5.0 };
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(
				temperatureSeries);
		double[] expResult = new double[]{4.0, 5.0};
		double[] actualResult = seriesAnalysis.findTempsGreaterThen(2.5);
		assertArrayEquals(expResult, actualResult, precision);
		
	}

	
	@Test
	public void testfindTempsGerateThenNoElements(){
		double[] temperatureSeries = { 1.0, 2.0, 2.2, 4.0, 5.0 };
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(
				temperatureSeries);
		double[] expResult = new double[]{0};
		double[] actualResult = seriesAnalysis.findTempsGreaterThen(6.0);
		assertArrayEquals(expResult, actualResult, precision);
	}
	
}
