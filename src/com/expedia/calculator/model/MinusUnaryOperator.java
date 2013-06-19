package com.expedia.calculator.model;

/**
 * Represents the Unary Subtraction Operator.
 */
public class MinusUnaryOperator extends AbstractUnaryOperator {

  /**
   * Constructor.
   */
  public MinusUnaryOperator() {
    super('-');
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected int execute(int operand) {
    return - operand;
  }
}
