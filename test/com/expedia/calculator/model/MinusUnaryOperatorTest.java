package com.expedia.calculator.model;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unity test for the Unary Subtraction Operator.
 */
public class MinusUnaryOperatorTest {
  /*** Operand's Stack */
  private Stack<Integer> stack = new Stack<Integer>();
  /*** Minus operator */
  private MinusUnaryOperator operator = new MinusUnaryOperator();

  /**
   * Tests the operand sign after a unary execution.
   */
  @Test
  public void testOperandSign() {
    Assert.assertEquals(minus(2), -2);
    Assert.assertEquals(minus(-2), 2);
    Assert.assertNotSame(minus(999), 999);
  }

  /**
   * Tests the unary operation.
   * 
   * @param x Operand x
   * @return Operation's result
   */
  private int minus(int x) {
    stack.add(x);
    operator.execute(stack);
    return stack.pop();
  }
}
