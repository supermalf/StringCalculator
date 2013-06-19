package com.expedia.calculator.model;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unity test for the Binary Addition Operator.
 */
public class PlusBinaryOperatorTest {
  /*** Operand's Stack */
  private Stack<Integer> stack = new Stack<Integer>();
  /*** Plus operator */
  private PlusBinaryOperator operator = new PlusBinaryOperator();

  /**
   * Tests if x + y = y + x
   */
  @Test
  public void testExecute() {
    Assert.assertEquals(plus(2, 3), plus(3, 2));
    Assert.assertEquals(plus(2, 3), 2 + 3);
    Assert.assertEquals(plus(2, -3), 2 + (-3));
  }

  /**
   * Tests the addition operation.
   * 
   * @param x Operand x
   * @param y Operand y
   * @return Operation's result
   */
  private int plus(int x, int y) {
    stack.add(y);
    stack.add(x);
    operator.execute(stack);
    return stack.pop();
  }
}
