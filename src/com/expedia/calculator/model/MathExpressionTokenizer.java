package com.expedia.calculator.model;

import java.util.HashSet;
import java.util.Set;

import com.expedia.calculator.model.MathExpressionTokenizer.Token;

/**
 * Used to break a mathematical expression into {@link Token.Category
 * categorized} {@link Token tokens}.
 */
public class MathExpressionTokenizer {

  /**
   * Allowed unary operators.
   */
  private Set<Character> unaryOperators;
  /**
   * Allowed binary operators.
   */
  private Set<Character> binaryOperators;

  /**
   * Constructor.
   */
  public MathExpressionTokenizer() {
    this.unaryOperators = new HashSet<Character>();
    this.binaryOperators = new HashSet<Character>();
  }

  /**
   * Adds an unary operator representation.
   * 
   * @param operator an unary operator representation.
   * @return this instance to make easier adding new operators.
   */
  public MathExpressionTokenizer addUnaryOperator(char operator) {
    unaryOperators.add(operator);
    return this;
  }

  /**
   * Adds a binary operator representation.
   * 
   * @param operator a binary operator representation.
   * 
   * @return this instance to make easier adding new operators.
   */
  public MathExpressionTokenizer addBinaryOperator(char operator) {
    binaryOperators.add(operator);
    return this;
  }

  /**
   * Breaks a mathematical expression into {@link Token.Category categorized}
   * {@link Token tokens}.
   * 
   * @param expression Expression to be tokenized.
   * 
   * @return an array of {@link Token.Category categorized} {@link Token tokens}
   */
  public Token[] run(String expression) {
    String[] values =
      expression.replaceAll("(\\d+|\\D)", " $1 ").trim().split("\\s+");

    Token[] tokens = new Token[values.length];

    for (int inx = 0; inx < tokens.length; inx++) {
      // Test if it's an operand
      if (values[inx].length() > 1) {
        tokens[inx] = new Token(values[inx], Token.Category.OPERAND);
        continue;
      }
      char c = values[inx].charAt(0);
      if (Character.isDigit(c)) {
        tokens[inx] = new Token(values[inx], Token.Category.OPERAND);
        continue;
      }

      // Test if it is BINARY_OPERATOR, UNARY_OPERATOR or UNKONWN
      Token.Category type = Token.Category.UNKNOWN;
      if (inx > 0 && tokens[inx - 1].category == Token.Category.OPERAND) {
        if (binaryOperators.contains(c)) {
          type = Token.Category.BINARY_OPERATOR;
        }
      }
      else if (unaryOperators.contains(c)) {
        type = Token.Category.UNARY_OPERATOR;
      }
      tokens[inx] = new Token(values[inx], type);
    }

    return tokens;
  }

  /**
   * A segment of text that represents a meaningful unity.
   */
  public static class Token {
    /**
     * Enum that represents the states from the String Calculator's FSM. It
     * represents a infix notation for the binary operators: addition and
     * subtraction.
     */
    public enum Category {
      /** The value represents an operand */
      OPERAND,
      /** The value represents a binary operator */
      UNARY_OPERATOR,
      /** The value represents a unary operator */
      BINARY_OPERATOR,
      /** The value category is unknown */
      UNKNOWN
    }

    /**
     * A meaningful segment of text.
     */
    private final String value;
    /**
     * Values category.
     */
    private final Category category;

    /**
     * Constructor.
     * 
     * @param value a meaningful segment of text.
     * @param category values category.
     */
    public Token(String value, Category category) {
      this.value = value;
      this.category = category;
    }

    /**
     * Getter for this tokens value.
     * 
     * @return this tokens value.
     */
    public String getValue() {
      return value;
    }

    /**
     * Getter for this token category.
     * 
     * @return this token category.
     */
    public Category getCategory() {
      return category;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
      return "Token [value=" + value + ", category=" + category + "]";
    }
  }
}
