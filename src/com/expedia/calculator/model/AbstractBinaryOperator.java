package com.expedia.calculator.model;

import java.util.Stack;

/**
 * Abstract Class that represents a mathematical binary operation. One operation
 * must receives two operands to return the appropriate result.
 * 
 */
public abstract class AbstractBinaryOperator implements IOperator {
  /*** Operator token */
  private Character operatorToken;

  /**
   * Constructor.
   * 
   * @param operatorToken Operator token
   */
  public AbstractBinaryOperator(Character operatorToken) {
    this.operatorToken = operatorToken;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isUnary() {
    return false;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Character getToken() {
    return operatorToken;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void execute(Stack<Integer> s) {
    if (s == null) {
      throw new NullPointerException("Operator's Stack is null.");
    }

    if (s.size() < 2) {
      throw new IllegalStateException("Operation is missing operands.");
    }

    int firstOperand = s.pop();
    int secondOperand = s.pop();
    int result = execute(firstOperand, secondOperand);
    s.push(result);
  }

  /**
   * Evaluates a mathematical binary operation.
   * 
   * @param firstOperand First operand
   * @param secondOperand Second operand
   * @return The operation's result
   */
  protected abstract int execute(int firstOperand, int secondOperand);
}
