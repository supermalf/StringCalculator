package com.expedia.calculator.model;

import java.util.Stack;

/**
 * Interface that represents a mathematical operation. <br>
 * An operation is an action or procedure which produces a new value from one or
 * more input values (operands).
 */
public interface IOperator {
  /**
   * Verify if this is a unary operator.
   * 
   * @return {@code true} if this operator is unary, otherwise it's a binary
   *         operator.
   */
  boolean isUnary(); // OOP

  /**
   * Gets the operator token symbol.
   * 
   * @return Operator token
   */
  Character getToken();

  /**
   * Evaluate the appropriate operation.
   * 
   * @param s Operand's stack
   */
  void execute(Stack<Integer> s); //Breaks isolation
}
