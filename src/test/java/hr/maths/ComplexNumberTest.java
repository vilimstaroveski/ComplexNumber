package hr.maths;
import static org.junit.Assert.*;

import org.junit.Test;

public class ComplexNumberTest {

	public final static double DOUBLE_EQUALS_THRESHOLD = 0.0001;

	@Test
	public void complexNumberEmptyConstructorTest() {
		ComplexNumber c = new ComplexNumber();
		double expectedReal = 0;
		double expectedImag = 0;
		
		assertTrue(Math.abs(c.getReal() - expectedReal) < DOUBLE_EQUALS_THRESHOLD);
		assertTrue(Math.abs(c.getImag() - expectedImag) < DOUBLE_EQUALS_THRESHOLD);
	}
	
	@Test
	public void complexNumberParsingIntValues() {
		String[] strTest = {"1+2i", "1-2i", "-1+2i", "-1-2i"};
		double[] expectedReal = {1.0,  1.0, -1.0, -1.0};
		double[] expectedImag = {2.0, -2.0,  2.0, -2.0};
		ComplexNumber c;
		for(int i = 0; i < strTest.length; i++) {
			c = ComplexNumber.parseComplexNumber(strTest[i]);
			assertTrue(Math.abs(c.getReal() - expectedReal[i]) < DOUBLE_EQUALS_THRESHOLD);
			assertTrue(Math.abs(c.getImag() - expectedImag[i]) < DOUBLE_EQUALS_THRESHOLD);
		}
	}
	
	@Test
	public void complexNumberParsingWithWhiteSpaces() {
		String[] strTest = {"	1+   12.3	i", "1.6   -	2i", " - 1.12 + 2.01 i	", "   -   111  -  2.35  i  "};
		double[] expectedReal = { 1.0,  1.6, -1.12, -111.0};
		double[] expectedImag = {12.3, -2.0,  2.01,   -2.35};
		ComplexNumber c;
		for(int i = 0; i < strTest.length; i++) {
			c = ComplexNumber.parseComplexNumber(strTest[i]);
			assertTrue(Math.abs(c.getReal() - expectedReal[i]) < DOUBLE_EQUALS_THRESHOLD);
			assertTrue(Math.abs(c.getImag() - expectedImag[i]) < DOUBLE_EQUALS_THRESHOLD);
		}
	}
	@Test
	public void complexNumberParsingDoubleValues() {
		String[] strTest = {"1.3+2.43i", "1.111-2.33i", "-0.01+2.2i", "-1.111-0.202i"};
		double[] expectedReal = {1.3,   1.111, -0.01, -1.111};
		double[] expectedImag = {2.43, -2.33,   2.2,  -0.202};
		ComplexNumber c;
		for(int i = 0; i < strTest.length; i++) {
			c = ComplexNumber.parseComplexNumber(strTest[i]);
			assertTrue(Math.abs(c.getReal() - expectedReal[i]) < DOUBLE_EQUALS_THRESHOLD);
			assertTrue(Math.abs(c.getImag() - expectedImag[i]) < DOUBLE_EQUALS_THRESHOLD);
		}
	}
	
	@Test
	public void complexNumberFromReal() {
		double[] expectedReal = {2.43, -2.33,   2.2,  -0.202, 0, -1, 2};
		ComplexNumber c;
		for(int i = 0; i < expectedReal.length; i++) {
			c = ComplexNumber.fromReal(expectedReal[i]);
			assertTrue(Math.abs(c.getReal() - expectedReal[i]) < DOUBLE_EQUALS_THRESHOLD);
		}
	}
	
	@Test
	public void complexNumberFromImag() {
		double[] expectedImag = {2.43, -2.33,   2.2,  -0.202, 0, -1, 2};
		ComplexNumber c;
		for(int i = 0; i < expectedImag.length; i++) {
			c = ComplexNumber.fromImaginary(expectedImag[i]);
			assertTrue(Math.abs(c.getImag() - expectedImag[i]) < DOUBLE_EQUALS_THRESHOLD);
		}
	}
	
	@Test
	public void complexNumberGettersTest() {
		ComplexNumber[] testCases = {new ComplexNumber(), new ComplexNumber(0, 0), new ComplexNumber(1, 2), new ComplexNumber(-0.4, 3.2)};
		double[] expectedReal = {0.0, 0.0, 1.0, -0.4};
		double[] expectedImag = {0.0, 0.0, 2.0, 3.2};
		for(int i = 0; i < testCases.length; i++) {
			assertTrue(Math.abs(testCases[i].getReal() - expectedReal[i]) < DOUBLE_EQUALS_THRESHOLD);
			assertTrue(Math.abs(testCases[i].getImag() - expectedImag[i]) < DOUBLE_EQUALS_THRESHOLD);
		}
	}
	
	@Test
	public void complexNumberToStringTest() {
		ComplexNumber[] testCases = {new ComplexNumber(), new ComplexNumber(0, 0), 
									 new ComplexNumber(1, 2), new ComplexNumber(-0.4, 3.2),
									 new ComplexNumber(0, -2.2), new ComplexNumber(1, 0)};
		String[] expectedOutput = {"0.0", "0.0", "1.0+2.0i", "-0.4+3.2i", "-2.2i", "1.0"};
		for(int i = 0; i < testCases.length; i++) {
			assertTrue(testCases[i].toString().equals(expectedOutput[i]));
		}
	}
	
}
