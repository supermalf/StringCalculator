package com.expedia.calculator.model;

/**
 * Represents the Unary Addition Operator.
 */
public class PlusUnaryOperator extends AbstractUnaryOperator {

  /**
   * Constructor.
   */
  public PlusUnaryOperator() {
    super('+');
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected int execute(int operand) {
    return operand;
  }
}
