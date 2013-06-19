package com.expedia.calculator.model;

import java.util.Stack;

/**
 * Abstract Class that represents a mathematical unary operation. One operation
 * must receives only one operand to return the appropriate result.
 */
public abstract class AbstractUnaryOperator implements IOperator {
  /*** Operator token */
  private Character operatorToken;

  /**
   * Constructor.
   * 
   * @param operatorToken Operator token
   */
  public AbstractUnaryOperator(Character operatorToken) {
    this.operatorToken = operatorToken;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isUnary() {
    return true;
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

    if (s.size() < 1) {
      throw new IllegalStateException("Operation is missing operands.");
    }

    int result = execute(s.pop());
    s.push(result);
  }

  /**
   * Evaluates a mathematical unary operation.
   * 
   * @param operand operand
   * @return The operation's result
   */
  protected abstract int execute(int operand);
}
