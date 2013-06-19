package com.expedia.calculator.model;

/**
 * Represents the Binary Addition Operator.
 */
public class PlusBinaryOperator extends AbstractBinaryOperator {

  /**
   * Constructor.
   */
  public PlusBinaryOperator() {
    super('+');
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected int execute(int firstOperand, int secondOperand) {
    return firstOperand + secondOperand;
  }
}
