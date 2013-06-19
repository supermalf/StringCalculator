package com.expedia.calculator.model;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unity test for the Unary Addition Operator.
 */
public class PlusUnaryOperatorTest {
  /*** Operand's Stack */
  private Stack<Integer> stack = new Stack<Integer>();
  /*** Plus operator */
  private PlusUnaryOperator operator = new PlusUnaryOperator();

  /**
   * Tests the operand sign after a unary execution.
   */
  @Test
  public void testOperandSign() {
    Assert.assertNotSame(plus(2), -2);
    Assert.assertNotSame(plus(-2), 2);
    Assert.assertEquals(plus(999), 999);
  }

  /**
   * Tests the unary operation.
   * 
   * @param x Operand x
   * @return Operation's result
   */
  private int plus(int x) {
    stack.add(x);
    operator.execute(stack);
    return stack.pop();
  }
}
