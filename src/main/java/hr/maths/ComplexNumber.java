package hr.maths;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComplexNumber {

	private final double real;
	private final double imag;
	
	private final static Pattern PATTERN_WHITESPACE = Pattern.compile("\\s*");
	private final static Pattern PATTERN_COMPLEX_NUM = Pattern.compile("(-?\\d+|-?\\d+\\.\\d+)([\\+-]\\d+|[\\+-]\\d+\\.\\d+)i");
	
	public ComplexNumber() {
		this.real = 0;
		this.imag = 0;
	}
	
	public ComplexNumber(double real, double imag) {
		this.real = real;
		this.imag = imag;
	}

	public static ComplexNumber parseComplexNumber(String str) throws NumberFormatException {
		// step 1: remove ALL whitespaces
		Matcher whitespaces = PATTERN_WHITESPACE.matcher(str);
		String strWithoutSpaces = whitespaces.replaceAll("");
		// step 2: match a (potential) complex number
		Matcher m = PATTERN_COMPLEX_NUM.matcher(strWithoutSpaces);
		if(!m.find())
			// step 3a (if matching was unsuccessful): throw exception
			throw new NumberFormatException();
		// step 3b (if matching was successful): return new ComplexNumber
		return new ComplexNumber(Double.parseDouble(m.group(1)), Double.parseDouble(m.group(2)));
	}

	public static ComplexNumber fromReal(double real) {
		return new ComplexNumber(real, 0);
	}
	
	public static ComplexNumber fromImaginary(double imag) {
		return new ComplexNumber(0, imag);
	}
	
	public double getReal() {
		return real;
	}

	public double getImag() {
		return imag;
	}
	//not tested
	public ComplexNumber add(ComplexNumber c) {
		return new ComplexNumber(this.real + c.real, this.imag + c.imag);
	}
	//not tested
	public ComplexNumber sub(ComplexNumber c) {
		return new ComplexNumber(this.real - c.real, this.imag - c.imag);
	}
	//not tested
	public ComplexNumber mul(ComplexNumber c) {
		double realResult = this.real * c.real - this.imag * c.imag;
		double imagResult = this.imag * c.real + this.real * c.imag;
		return new ComplexNumber(realResult, imagResult);
	}
	
	
	public String toString() {
		if(this.real == 0 && this.imag == 0)
			return "0.0";
		StringBuilder str = new StringBuilder("");
		if(this.real != 0)
			str.append(this.real);
		if(this.imag != 0)
			str.append((this.imag > 0) ? "+" + this.imag + "i" : this.imag + "i");
		return str.toString();
	}
}
