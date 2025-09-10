# Java Version - 8

# File Structure

lib - The testing libraries - Junit and Hamcrest.

src - The main program files and interface.

test - The unit test files.

# Unit Testing Commands

The following commands must be executed at the root folder.

// compile the test classes

$ javac -cp .;lib\junit-4.13.2.jar;lib\hamcrest-core-1.3.jar src\numberrangesummarizer\NumberRangeSummarizer.java src\Summarizer.java test\SummarizerUnitTest.java

// execute or run the test classes

$ java -cp .;src;test;lib\junit-4.13.2.jar;lib\hamcrest-core-1.3.jar org.junit.runner.JUnitCore SummarizerUnitTest

# How to test ?

Run the "Demo.java" file to execute the program. The "Demo.java" file is the file with the main method for execution and "Summarizer.java" file implements the logic.

# Thank you! Happy Reviewing ...
