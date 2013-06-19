package com.expedia.calculator.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import com.expedia.calculator.model.MathExpressionTokenizer.Token;

/**
 * Implements a generic calculator that evaluates an expression given as a
 * String.
 */
public class StringCalculator {
  /** Unary operators given their token. */
  private Map<Character, IOperator> unaryOperatorsByToken;
  /** Binary operators given their token. */
  private Map<Character, IOperator> binaryOperatorsByToken;
  /** Text tokenizer */
  private MathExpressionTokenizer tokenizer;

  /**
   * Constructor.
   */
  public StringCalculator() {
    unaryOperatorsByToken = new HashMap<Character, IOperator>();
    binaryOperatorsByToken = new HashMap<Character, IOperator>();
    tokenizer = new MathExpressionTokenizer();
  }

  /**
   * Adds a operation to the Calculator.
   * 
   * @param operator Operator
   */
  public void addOperator(IOperator operator) {
    if (operator.isUnary()) {
      unaryOperatorsByToken.put(operator.getToken(), operator);
      tokenizer.addUnaryOperator(operator.getToken());
    }
    else {
      binaryOperatorsByToken.put(operator.getToken(), operator);
      tokenizer.addBinaryOperator(operator.getToken());
    }
  }

  /**
   * Evaluates a new String and process within the calculator.
   * 
   * @param expression Expression to be evaluated
   * 
   * @return The calculated result
   */
  public int evaluate(String expression) {
    if (expression == null) {
      throw new NullPointerException("Null expression");
    }

    if (expression.trim().isEmpty()) {
      return 0;
    }

    Stack<Integer> operands = new Stack<Integer>();
    Stack<IOperator> binaryOperators = new Stack<IOperator>();

    Token[] tokens = tokenizer.run(expression);
    for (int inx = tokens.length - 1; inx >= 0; inx--) {
      Token aToken = tokens[inx];

      switch (aToken.getCategory()) {
        case UNARY_OPERATOR:
          char unaryOperatorToken = aToken.getValue().charAt(0);
          IOperator unaryOperator =
            unaryOperatorsByToken.get(unaryOperatorToken);
          unaryOperator.execute(operands);
          break;
        case BINARY_OPERATOR:
          if (inx == tokens.length - 1) {
            throw new IllegalStateException("Operator " + aToken.getValue()
              + " missing operands");
          }
          char binaryOperatorToken = aToken.getValue().charAt(0);
          IOperator binaryOperator =
            binaryOperatorsByToken.get(binaryOperatorToken);
          binaryOperators.add(binaryOperator);
          break;
        case OPERAND:
          int operand = Integer.valueOf(aToken.getValue());
          operands.add(operand);
          break;
        case UNKNOWN:
          throw new IllegalArgumentException("Unknown operator "
            + aToken.getValue());
      }
    }

    if (operands.size() != binaryOperators.size() + 1) {
      throw new IllegalStateException("Binary operators missing operands.");
    }
    while (binaryOperators.size() > 0) {
      binaryOperators.pop().execute(operands);
    }

    return operands.pop();
  }
}
