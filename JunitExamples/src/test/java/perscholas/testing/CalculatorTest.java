package perscholas.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {


@Test
public void subtractionTest() {
	Calculator c =new Calculator();
	Assertions.assertEquals(5.0, c.subtract(10.0,5.0));
}
@ParameterizedTest
@CsvSource({ "5,5,10","10,10,20","5.5,5.5,11"})
public void additionTest(double a, double b, double expected) {
	Calculator c =new Calculator();
	double actual = c.add(a, b);
	
	Assertions.assertEquals(expected,actual);
}
}
