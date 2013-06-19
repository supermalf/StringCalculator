package com.expedia.calculator.model;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unity test for the Binary Subtraction Operator.
 */
public class MinusBinaryOperatorTest {
  /*** Operand's Stack */
  private Stack<Integer> stack = new Stack<Integer>();
  /*** Minus operator */
  private MinusBinaryOperator operator = new MinusBinaryOperator();

  /**
   * Tests if x - y != y - x
   */
  @Test
  public void testOperandsOrder() {
    Assert.assertNotSame(minus(2, 3), minus(3, 2));
    Assert.assertEquals(minus(2, 3), 2 - 3);
    Assert.assertEquals(minus(2, -3), 2 - (-3));
  }

  /**
   * Tests the subtraction operation.
   * 
   * @param x Operand x
   * @param y Operand y
   * @return Operation's result
   */
  private int minus(int x, int y) {
    stack.add(y);
    stack.add(x);
    operator.execute(stack);
    return stack.pop();
  }
}
