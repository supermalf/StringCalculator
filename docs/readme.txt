--------------------------
Readme - String Calculator
--------------------------
    
    This application was based in the following business requirement:
_______________________________________________________________________________

"Develop a Calculator that takes a string as input and outputs its calculated 
result. The operations the calculator should support are plus and minus. The 
Calculator should return an Integer that represents the correctly calculated 
operation. For example: when the calculator is given the string '1 + 3 - 5' as 
input it should return the integer -1. The calculator does not need to cater for 
more than 4 parameters and the characters in the input it need to be able to 
handle numbers (integers up to 1000) and the characters '+' and '-'. The 
calculator handling whitespaces (ignoring them) is optional."
_______________________________________________________________________________

    A solution to solve this business requirement could be developed in several 
different ways, from a simple one method application to a OOP design with a GUI
interface. The implemented solution could seem sophisticated related to the 
business requirement at first sight. Although, at the same time the selected 
design and implementation to this application had the main objective to develop 
the best software possible in the available time (2 to 5 days). Also, was taken 
in consideration that it was a test, giving some space to show design and 
programming knowledge.
    In conclusion, the development followed the principles:
    
    - Provides the Necessary Functionality to the business requirement;
    - Object-oriented programming principles;
    - Extensibility;
    - Reusability;
    - Minimize complexity;
    - Ease Of Maintenance;
    - Well Documented;
    - Well Tested;

    The enunciation doesn't explicit details about the input string. Therefore, 
the string parser and tokenization could vary in different levels of complexity.
For this solutions, some assumptions were made:

    1. The Calculator does not need to cater for more than 4 parameters. Each 
supplied number for the calculator is counted as a parameter, and each supplied 
operator isn't. Thus, the calculator must handle a string with up to 4 numbers.
The fact that the Calculator doesn't need to handle more than 4 parameters, 
doesn't mean that is constraint. Therefore, was decided that the cost of 
implement a solution that could handle any amount of parameters was low. Thus,
this StringCalculator supports any amount of parameters.

    2. Negative numbers are permitted in the input string.
    
    3. Unary and Binary operations (Addition/Subtraction) are allowed.

    4. Based on the given example, the Calculator expects a string with a infix 
notation. Another notation will throw an exception.

    5. The calculator need to be able to handle numbers (integers up to 1000). 
It is also able to handle number as the Java signed int size (-2,147,483,648 to 
+ 2,147,483,647). Although, its easily extensible to operands with decimal parts.

    6. The underflow and overflow number operation won't be a problem, and 
wasn't taken under consideration.

    7. The calculator can handle whitespaces.
    
    8. Any invalid or unknown characters will throw an exception. Although,
easily extensible to add other operators, such as: multiplication, division,
factorial, sin, cos, among others;


------------
Packing List
------------

    The sample includes the following files and directories:

    . [docs]: A directory containing the documentation files.
    . [src]: A directory containing the source code.
    . [test]: A directory containing the test code.
    . [readme.txt]: This file.
    . [StringCalculatorDemo.java]: Simple demo applicationt.
    . [AbstractBinaryOperator.java]: Represents a mathematical binary operation. 
    . [AbstractUnaryOperator.java]: Represents a mathematical unary operation. 
    . [IOperator.java]: Interface that represents a mathematical operation.
    . [MathExpressionTokenizer.java]: Breaks an expression into categorized tokens.
    . [MinusBinaryOperator.java]: Represents the Binary Subtraction Operator.
    . [MinusUnaryOperator.java]: Represents the Unary Subtraction Operator.
    . [PlusBinaryOperator.java]: Represents the Binary Addition Operator.
    . [PlusUnaryOperator.java]: Represents the Unary Addition Operator.
    . [StringCalculator.java]: Implements the Calculator.
    . [TestSuit.java: Responsible to run all unity tests for the StringCalculator.
    . [AbstractBinaryOperatorTest.java]: Unity test for the Abstract Binary Operator.
    . [AbstractUnaryOperatorTest.java]: Unity test for the Abstract Unary Operator.
    . [MathExpressionTokenizerTest.java]: Unity test for the tokenizer.
    . [MinusBinaryOperatorTest.java]: Unity test for the Binary Subtraction Operator.
    . [MinusUnaryOperatorTest.java]: Unity test for the Unary Subtraction Operator.
    . [PlusBinaryOperatorTest.java]: Unity test for the Binary Addition Operator.
    . [PlusUnaryOperatorTest.java]: Unity test for the Unary Addition Operator.
    . [StringCalculatorTest.java]: Unity test for the StringCalculator.
    . [Calculator Tests.lauch]: Run file responsible to build and run all unity tests.
    . [Calculator.lauch]: Run file responsible to build and run the simple calculator demo.
    
-------------------------
Importing the Application
-------------------------

    The application was developed with the following technologies:
    
    . Eclipse Juno with the SDK 4.2.0;
    . JavaSE-1.6 (jre7);
    . JUnit v.4;

    To import the project into Eclipse project from the zipped archive file, 
follow these steps:

    1. In the Eclipse, go to the menu File, the click in the Import option;
    2. In the following dialog select the option General / Existing Projects into Workspace;
    3. Click the radio button next to Select archive file and click the Browse button;
    4. Find the expedia_techtest.zip file on your hard disk. Click Open to select it;
    5. The calculator project name will appear in the box 'Projects', already checked;
    6. Click Finish to perform the import;
    7. The project should now appear in the Project Explorer view;

    
-----------------------
Running the Application
-----------------------

    After importing the application, the files Calculator Tests.lauch and 
Calculator.lauch those files are responsible to Run to build and run all unity 
tests and the simple calculator demo reespectively.
    To run each application, simply click with the right mouse button in each 
file and select the option 'Run as' followed the application name.
    


