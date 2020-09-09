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
}
