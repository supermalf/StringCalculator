package com.expedia.calculator.model;

/**
 * Represents the Binary Subtraction Operator.
 */
public class MinusBinaryOperator extends AbstractBinaryOperator {

  /**
   * Constructor.
   */
  public MinusBinaryOperator() {
    super('-');
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected int execute(int minuend, int subtrahend) {
    return minuend - subtrahend;
  }
}
