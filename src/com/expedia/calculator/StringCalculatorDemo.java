package com.expedia.calculator;

import java.util.Scanner;

import com.expedia.calculator.model.MinusBinaryOperator;
import com.expedia.calculator.model.MinusUnaryOperator;
import com.expedia.calculator.model.PlusBinaryOperator;
import com.expedia.calculator.model.PlusUnaryOperator;
import com.expedia.calculator.model.StringCalculator;

/**
 * This is a simple demo application that expects a mathematical expression from
 * the keyboard and returns the appropriate result.
 */
public class StringCalculatorDemo {

  /**
   * Main method.
   * 
   * @param args Arguments
   */
  public static void main(String[] args) {
    StringCalculator calc = new StringCalculator();
    calc.addOperator(new PlusBinaryOperator());
    calc.addOperator(new PlusUnaryOperator());
    calc.addOperator(new MinusBinaryOperator());
    calc.addOperator(new MinusUnaryOperator());

    Scanner input = new Scanner(System.in);

    while (true) {
      System.out.print("\nEnter an expression or press ENTER to quit: ");
      try {
        String line = input.nextLine();
        if (line.trim().isEmpty()) {
          break;
        }
        int result = calc.evaluate(line);
        System.out.println("> " + result);
      }
      catch (Exception e) {
        System.out.println("Invalid expression");
      }
    }
    input.close();
    System.out.println("Bye");
    System.exit(0);
  }
}
