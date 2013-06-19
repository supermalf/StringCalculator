package com.expedia.calculator.model;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.expedia.calculator.model.MathExpressionTokenizer.Token;

/**
 * Performs all the tests for the String Calculator.
 */
public class MathExpressionTokenizerTest {
  /*** Text tokenizer */
  private MathExpressionTokenizer tokenizer;

  /**
   * It guarantees that a MathExpressionTokenizer is propelly created before
   * each test.
   */
  @Before
  public void setUp() {
    tokenizer = new MathExpressionTokenizer();
  }

  /**
   * Test the UNKNOWN classification.
   */
  @Test
  public void testUnknownOperators() {
    Token[] tokens;

    tokens = tokenizer.run("!@#$%&*()-=+<>?");
    for (Token t : tokens) {
      Assert.assertEquals(t.getCategory(), Token.Category.UNKNOWN);
    }

    tokens = tokenizer.run("+ - * / %&!~$");
    for (Token t : tokens) {
      Assert.assertEquals(t.getCategory(), Token.Category.UNKNOWN);
    }

    tokens = tokenizer.run("-1+-2-+3-4+5");
    for (Token t : tokens) {
      Assert.assertTrue(t.getCategory() == Token.Category.UNKNOWN
        || t.getCategory() == Token.Category.OPERAND);
    }

    tokens = tokenizer.run("- 100 + - 992 - + 344    - 24   + 45 ");
    for (Token t : tokens) {
      Assert.assertTrue(t.getCategory() == Token.Category.UNKNOWN
        || t.getCategory() == Token.Category.OPERAND);
    }
  }

  /**
   * Test the OPERAND classification.
   */
  @Test
  public void testOperands() {
    Token[] tokens;
    tokenizer.addBinaryOperator('+');
    tokenizer.addBinaryOperator('-');
    tokenizer.addUnaryOperator('+');
    tokenizer.addUnaryOperator('-');

    tokens = tokenizer.run("1 22 333 444");
    for (Token t : tokens) {
      Assert.assertEquals(t.getCategory(), Token.Category.OPERAND);
    }
  }

  /**
   * Test the BINARY_OPERATOR classification.
   */
  @Test
  public void testBinaryOperators() {
    Token[] tokens;
    tokenizer.addBinaryOperator('+');
    tokenizer.addBinaryOperator('-');
    tokenizer.addBinaryOperator('/');
    tokenizer.addBinaryOperator('*');

    tokens = tokenizer.run("1+2-3*4/5-622+44");
    for (Token t : tokens) {
      Assert.assertTrue(t.getCategory() == Token.Category.BINARY_OPERATOR
        || t.getCategory() == Token.Category.OPERAND);
    }

    tokens = tokenizer.run("  1778  - 254 - 3 * 4 / 5 + 622 + 44");
    for (Token t : tokens) {
      Assert.assertTrue(t.getCategory() == Token.Category.BINARY_OPERATOR
        || t.getCategory() == Token.Category.OPERAND);
    }
  }

  /**
   * Test the UNARY_OPERATOR classification.
   */
  @Test
  public void testUnaryOperators() {
    Token[] t;

    t = tokenizer.run("-1-+2");
    Assert.assertEquals(t[0].getCategory(), Token.Category.UNKNOWN);
    Assert.assertEquals(t[3].getCategory(), Token.Category.UNKNOWN);

    tokenizer.addUnaryOperator('+');
    tokenizer.addUnaryOperator('-');

    t = tokenizer.run("-1-+2+3+-4--5++6---7");
    Assert.assertEquals(t[0].getCategory(), Token.Category.UNARY_OPERATOR);
    Assert.assertNotSame(t[1].getCategory(), Token.Category.UNARY_OPERATOR);
    Assert.assertNotSame(t[2].getCategory(), Token.Category.UNARY_OPERATOR);
    Assert.assertEquals(t[3].getCategory(), Token.Category.UNARY_OPERATOR);
    Assert.assertNotSame(t[4].getCategory(), Token.Category.UNARY_OPERATOR);
    Assert.assertNotSame(t[5].getCategory(), Token.Category.UNARY_OPERATOR);
    Assert.assertNotSame(t[6].getCategory(), Token.Category.UNARY_OPERATOR);
    Assert.assertNotSame(t[7].getCategory(), Token.Category.UNARY_OPERATOR);
    Assert.assertEquals(t[8].getCategory(), Token.Category.UNARY_OPERATOR);
    Assert.assertNotSame(t[9].getCategory(), Token.Category.UNARY_OPERATOR);
    Assert.assertNotSame(t[10].getCategory(), Token.Category.UNARY_OPERATOR);
    Assert.assertEquals(t[11].getCategory(), Token.Category.UNARY_OPERATOR);
    Assert.assertNotSame(t[12].getCategory(), Token.Category.UNARY_OPERATOR);
    Assert.assertNotSame(t[13].getCategory(), Token.Category.UNARY_OPERATOR);
    Assert.assertEquals(t[14].getCategory(), Token.Category.UNARY_OPERATOR);
    Assert.assertNotSame(t[15].getCategory(), Token.Category.UNARY_OPERATOR);
    Assert.assertNotSame(t[16].getCategory(), Token.Category.UNARY_OPERATOR);
    Assert.assertEquals(t[17].getCategory(), Token.Category.UNARY_OPERATOR);
    Assert.assertEquals(t[18].getCategory(), Token.Category.UNARY_OPERATOR);
    Assert.assertNotSame(t[19].getCategory(), Token.Category.UNARY_OPERATOR);
  }
}
