package com.expedia.calculator.model;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unity test for the Abstract Unary Operator.
 */
public class AbstractUnaryOperatorTest {
  /*** A Dummy token */
  private static final Character OPERATOR_TOKEN = 'a';
  /*** A Dummy operator instance */
  private DummyUnaryOperator operator;

  /**
   * SetUp
   */
  @Before
  public void setUp() {
    operator = new DummyUnaryOperator(OPERATOR_TOKEN);
  }

  /**
   * Simple test to avaliate the getToken method.
   */
  @Test
  public void testGetOperatorToken() {
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
   * Test the execute method.
   */
  @Test
  public void testExecute() {
    int operand1 = 1;
    int operand2 = 2;

    Stack<Integer> s = new Stack<Integer>();
    s.add(operand2);
    s.add(operand1);

    // Test operands order
    operator.execute(s);
    Assert.assertEquals(operator.getOperand(), operand1);
    s.pop();

    // Test stack state after call to execute
    Assert.assertEquals(s.size(), 1);
    Assert.assertEquals(s.peek().intValue(), operand2);
  }

  /**
   * Simple Dummy Unary Operator.
   */
  static class DummyUnaryOperator extends AbstractUnaryOperator {
    /**
     * Constructor.
     * 
     * @param operatorToken Token
     */
    public DummyUnaryOperator(Character operatorToken) {
      super(operatorToken);
    }

    /*** right dummy operand */
    private int operand;

    /**
     * {@inheritDoc}
     */
    @Override
    protected int execute(int operand) {
      this.operand = operand;
      return 0;
    }

    /**
     * @return operand
     */
    public int getOperand() {
      return operand;
    }
  }
}
