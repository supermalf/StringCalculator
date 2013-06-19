package com.expedia.calculator.model;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * Performs all the tests for the String Calculator.
 */
public class StringCalculatorTest {
  /*** String calculator instance */
  private StringCalculator calc;

  /**
   * It guarantees that a StringCalculator is propelly created before each test.
   */
  @Before
  public void setUp() {
    calc = new StringCalculator();
    calc.addOperator(new PlusBinaryOperator());
    calc.addOperator(new PlusUnaryOperator());
    calc.addOperator(new MinusBinaryOperator());
    calc.addOperator(new MinusUnaryOperator());
  }

  /**
   * Simple test that uses a null pointer as input for the calculator.
   */
  @Test(expected = NullPointerException.class)
  public void testNullString() {
    calc.evaluate(null);
  }

  /**
   * Simple test that uses a empty string as input for the calculator.
   */
  @Test
  public void testEmptyString() {
    Assert.assertEquals(calc.evaluate(""), 0);
  }

  /**
   * Test that verifies when the calculator only recieves a String with one
   * operand.
   */
  @Test
  public void testOneValueString() {
    Assert.assertEquals(calc.evaluate("0"), 0);
    Assert.assertEquals(calc.evaluate("5"), 5);
    Assert.assertEquals(calc.evaluate("-5"), -5);
    Assert.assertEquals(calc.evaluate(" - 5 "), -5);
    Assert.assertEquals(calc.evaluate("12345"), 12345);
    Assert.assertEquals(calc.evaluate(" 9"), 9);
    Assert.assertEquals(calc.evaluate("  9"), 9);
    Assert.assertEquals(calc.evaluate("   9   "), 9);
    Assert.assertEquals(calc.evaluate("9     "), 9);
    Assert.assertEquals(calc.evaluate("   9   "), 9);
    Assert.assertEquals(calc.evaluate("  65464  "), 65464);
    Assert.assertEquals(calc.evaluate("      65464"), 65464);
    Assert.assertEquals(calc.evaluate("65464        "), 65464);
  }

  /**
   * Tests the sign of expressions with unary operators.
   */
  @Test
  public void testExpressionsSign() {
    Assert.assertEquals(calc.evaluate("1 + 2"), 1 + 2);
    Assert.assertEquals(calc.evaluate("1 - 2"), 1 - 2);
    Assert.assertEquals(calc.evaluate("1 + -2"), 1 + (-2));
    Assert.assertEquals(calc.evaluate("1 - -2"), 1 - (-2));
    Assert.assertEquals(calc.evaluate("1+--2"), 1 + (-(-2)));
    Assert.assertEquals(calc.evaluate("1+--2"), 1 + (-(-2)));
    Assert.assertEquals(calc.evaluate("-1+---2"), -1 + (-(-(-2))));
  }

  /**
   * Tests if invalid expressions are throwing exceptions.
   */
  @Test
  public void testIllegalArgumentException() {
    // Illegal Argument Exceptions
    Assert.assertTrue(verifyIllegalArgumentException("$"));
    Assert.assertTrue(verifyIllegalArgumentException("    #     "));
    Assert.assertTrue(verifyIllegalArgumentException("$@#$@#$@#$"));
    Assert.assertTrue(verifyIllegalArgumentException("1+2$"));
    Assert.assertTrue(verifyIllegalArgumentException("556/1+2"));
    Assert.assertTrue(verifyIllegalArgumentException("  1 + 2  *  "));
    Assert.assertTrue(verifyIllegalArgumentException("100+99-5487+56*4"));
    Assert.assertTrue(verifyIllegalArgumentException("100+99-5487+5.6"));

    // Illegal State Exceptions
    Assert.assertTrue(verifyIllegalStateException("+"));
    Assert.assertTrue(verifyIllegalStateException("-"));
    Assert.assertTrue(verifyIllegalStateException(" 9 - "));
    Assert.assertTrue(verifyIllegalStateException("111  -  "));
    Assert.assertTrue(verifyIllegalStateException("1 2"));
    Assert.assertTrue(verifyIllegalStateException("+ 1 2"));
    Assert.assertTrue(verifyIllegalStateException("1 2 +"));
    Assert.assertTrue(verifyIllegalStateException("1+2+"));
  }

  /**
   * Test that verifies simple string expressions.
   */
  @Test
  public void testSimpleExpressions() {
    Assert.assertEquals(calc.evaluate("1 + 3 - 5"), -1);
    Assert.assertEquals(calc.evaluate("1+2"), 3);
    Assert.assertEquals(calc.evaluate("99+123"), 222);
    Assert.assertEquals(calc.evaluate(" 99    +   123     "), 222);
    Assert.assertEquals(calc.evaluate(" 123+  99     "), 222);
    Assert.assertEquals(calc.evaluate(" 123 +99"), 222);
    Assert.assertEquals(calc.evaluate("2-1"), 1);
    Assert.assertEquals(calc.evaluate("1-2"), -1);
    Assert.assertEquals(calc.evaluate("111 -222"), -111);
    Assert.assertEquals(calc.evaluate("55555555 -1"), 55555554);
    Assert.assertEquals(calc.evaluate("55555555 -0"), 55555555);
    Assert.assertEquals(calc.evaluate("0-55555555-0+1+4"), -55555550);
    Assert.assertEquals(calc.evaluate("55555555 -  55555555  "), 0);
    Assert.assertEquals(calc.evaluate("  12345 -12345+789  +22+ 33 -844  "), 0);
  }

  /**
   * Test that verifies chain operations and big numbers.
   */
  @Test
  public void testExpressions() {
    Assert.assertEquals(calc.evaluate("1+2+3+4+5+6+7+8+9+10+11+12+13+14"), 105);
    Assert.assertEquals(calc.evaluate("100+ 5+999999999+56+4-999999999"), 165);
    Assert.assertEquals(calc
      .evaluate("999999999+99999999+999-999999999-99999999-999"), 0);
  }

  /**
   * Verify if an illegal argument was used to invoke the calculator evaluate
   * method.
   * 
   * @param txt String to be evaluated
   * @return True if a exception was caught, False otherwise
   */
  private boolean verifyIllegalArgumentException(String txt) {
    try {
      calc.evaluate(txt);
      return false;
    }
    catch (IllegalArgumentException e) {
      return true;
    }
  }

  /**
   * Verify if the application is in an incorrect state when invoking the
   * calculator evaluate method.
   * 
   * @param txt String to be evaluated
   * @return True if a exception was caught, False otherwise
   */
  private boolean verifyIllegalStateException(String txt) {
    try {
      calc.evaluate(txt);
      return false;
    }
    catch (IllegalStateException e) {
      return true;
    }
  }
}
