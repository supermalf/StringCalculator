package com.expedia.calculator;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.expedia.calculator.model.AbstractBinaryOperatorTest;
import com.expedia.calculator.model.AbstractUnaryOperatorTest;
import com.expedia.calculator.model.MathExpressionTokenizerTest;
import com.expedia.calculator.model.MinusBinaryOperatorTest;
import com.expedia.calculator.model.MinusUnaryOperatorTest;
import com.expedia.calculator.model.PlusBinaryOperatorTest;
import com.expedia.calculator.model.PlusUnaryOperatorTest;
import com.expedia.calculator.model.StringCalculatorTest;

/**
 * Test Suit that run all unity tests for the StringCalculator.
 */
@RunWith(Suite.class)
@SuiteClasses({ MathExpressionTokenizerTest.class,
    AbstractBinaryOperatorTest.class, AbstractUnaryOperatorTest.class,
    MinusBinaryOperatorTest.class, MinusUnaryOperatorTest.class,
    PlusBinaryOperatorTest.class, PlusUnaryOperatorTest.class,
    StringCalculatorTest.class })
public class TestSuite {
}
