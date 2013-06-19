package com.expedia.calculator.model;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unity test for the Abstract Binary Operator.
 */
public class AbstractBinaryOperatorTest {
  /*** A Dummy token */
  private static final Character OPERATOR_TOKEN = 'a';
  /*** A Dummy operator instance */
  private DummyBinaryOperator operator;

  /**
   * SetUp
   */
  @Before
  public void setUp() {
    operator = new DummyBinaryOperator(OPERATOR_TOKEN);
  }

  /**
   * Simple test to avaliate the getToken method.
   */
  @Test
  public void testGetToken() {
    Assert.assertEquals(operator.getToken(), OPERATOR_TOKEN);
  }

  /**
   * Simple test with a null input stack.
   */
  @Test(expected = NullPointerException.class)
  public void testExecuteWithNullStack() {
    operator.execute(null);
  }

  /**
   * Simple test with a empty input stack.
   */
  @Test(expected = IllegalStateException.class)
  public void testExecuteWithEmptyStack() {
    operator.execute(new Stack<Integer>());
  }

  /**
   * Simple test with a input stack with missing operands.
   */
  @Test(expected = IllegalStateException.class)
  public void testExecuteWithStackSize1() {
    Stack<Integer> s = new Stack<Integer>();
    s.add(1);
    operator.execute(s);
  }

  /**
   * Test the execute method.
   */
  @Test
  public void testExecute() {
    int leftOperand = 1;
    int rightOperand = 2;
    int other = 3;

    Stack<Integer> s = new Stack<Integer>();
    s.add(other);
    s.add(rightOperand);
    s.add(leftOperand);

    operator.execute(s);

    // Test operands order
    Assert.assertEquals(operator.getLeftOperand(), leftOperand);
    Assert.assertEquals(operator.getRightOperand(), rightOperand);

    // Remove the dummy result
    s.pop();

    // Test stack state after call to execute
    Assert.assertEquals(s.size(), 1);
    Assert.assertEquals(s.peek().intValue(), other);
  }

  /**
   * Simple Dummy Binary Operator.
   */
  static class DummyBinaryOperator extends AbstractBinaryOperator {
    /**
     * Constructor.
     * 
     * @param operatorToken Token
     */
    public DummyBinaryOperator(Character operatorToken) {
      super(operatorToken);
    }

    /*** left dummy operand */
    private int leftOperand;
    /*** right dummy operand */
    private int rightOperand;

    /**
     * {@inheritDoc}
     */
    @Override
    protected int execute(int leftOperand, int rightOperand) {
      this.leftOperand = leftOperand;
      this.rightOperand = rightOperand;
      return 0;
    }

    /**
     * @return LeftOperand
     */
    public int getLeftOperand() {
      return leftOperand;
    }

    /**
     * @return Right operand
     */
    public int getRightOperand() {
      return rightOperand;
    }
  }
}
