/** This is a tester skeleton and is INCOMPLETE
You MUST complete it by writing your own junit tests
 */

///////////////////////////////////////////////////////
//////////// START of DO NOT EDIT section /////////////
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import java.io.*;
import java.util.*;

public class E5Tester {
    /*Main method runs tests in this file*/
    public static void main(String args[])
    {
        org.junit.runner.JUnitCore.main("E5Tester");
    }

    static ByteArrayOutputStream localOut, localErr;
    static PrintStream sysOut, sysErr;
    static String [] empty = {};

    // Determine what the newline is on the running system
    String newline = System.getProperty("line.separator");

    @BeforeClass
    public static void setUp() throws Exception {
        sysOut = System.out;
        sysErr = System.err;
    }

    // Before every test is run, reset the streams to capture
    // stdout/stderr
    @Before
    public void setUpStreams() {
        localOut = new ByteArrayOutputStream();
        localErr = new ByteArrayOutputStream();
        System.setOut(new PrintStream(localOut));
        System.setErr(new PrintStream(localErr));
    }

    // After every test, restore stdout/stderr
    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
        System.setOut(sysOut);
        System.setErr(sysErr);
    }

    ///////////// END of DO NOT EDIT section //////////////
    ///////////////////////////////////////////////////////
    /////////// you can edit BELOW this line //////////////

    /**
    tests if all enum fields have been declared
     */
    @Test public void test1() {
        // code here
        assertEquals("Fields have not been declared.",4,Quadrant.values().length);
    }

    /**
    tests that no extra fields have been declared
     */
    @Test public void test2() {
        // code here
        assertFalse("Too many fields.", Quadrant.values().length > 4);
    }

    /**
    tests if method xPositive works correctly
     */
    @Test public void test3(){
        // code here
        Quadrant quad1 = Quadrant.fromInts(1,2);
        Quadrant quad2 = Quadrant.fromInts(-1,2);
        Quadrant quad3 = Quadrant.fromInts(-1,-2);
        Quadrant quad4 = Quadrant.fromInts(1,-2);

        assertTrue("xPositive failed for Q1", quad1.xPositive());
        assertFalse("xPositive failed for Q2", quad2.xPositive());
        assertFalse("xPositive failed for Q3", quad3.xPositive());
        assertTrue("xPositive failed for Q4", quad4.xPositive());

    }

    /**
    tests if method yPositive works correctly
     */
    @Test public void test4(){
        // code here
        Quadrant quad1 = Quadrant.fromInts(1,2);
        Quadrant quad2 = Quadrant.fromInts(-1,2);
        Quadrant quad3 = Quadrant.fromInts(-1,-2);
        Quadrant quad4 = Quadrant.fromInts(1,-2);

        assertTrue("yPositive failed for Q1", quad1.yPositive());
        assertTrue("yPositive failed for Q2", quad2.yPositive());
        assertFalse("yPositive failed for Q3", quad3.yPositive());
        assertFalse("yPositive failed for Q4", quad4.yPositive());
    }

    /**
    tests if method flipX works correctly
     */
    @Test public void test5(){
        // code here
        Quadrant quad1 = Quadrant.fromInts(1,2);
        Quadrant quad2 = Quadrant.fromInts(-1,2);

        assertEquals("flipX method failed",Quadrant.Q2,quad1.flipX());
        assertEquals("flipX method failed",Quadrant.Q1,quad2.flipX());
    }

    /**
    tests if method signPair works correctly
     */
    @Test public void test6(){
        // code here

        assertEquals("Incorrect signPair", "(+,+)", Quadrant.Q1.signPair());
        assertEquals("Incorrect signPair", "(-,+)", Quadrant.Q2.signPair());
        assertEquals("Incorrect signPair", "(-,-)", Quadrant.Q3.signPair());
        assertEquals("Incorrect signPair", "(+,-)", Quadrant.Q4.signPair());
    }

    /**
    tests if method fromInts works correctly
     */
    @Test public void test7(){
        // code here
        Quadrant quad1 = Quadrant.fromInts(1,2);
        Quadrant quad2 = Quadrant.fromInts(-1,2);
        Quadrant quad3 = Quadrant.fromInts(-1,-2);
        Quadrant quad4 = Quadrant.fromInts(1,-2);

        assertEquals("fromInts failure",Quadrant.Q1,quad1);
        assertEquals("fromInts failure",Quadrant.Q2,quad2);
        assertEquals("fromInts failure",Quadrant.Q3,quad3);
        assertEquals("fromInts failure",Quadrant.Q4,quad4);

    }

    /**
    tests if main method works correctly for cases with empty/incomplete arguments
     */
    @Test public void test8(){
        // Contrary to tests 1-7, when testing the actual output to the terminal
        // we need to do some extra work to capture the system streams.
        // Everything is provided though, just follow the steps below:

        setUpStreams(); // do not remove this line

        String args[] = {}; // create an array with the command line arguments you want to test

        Quadrant.main(args); // call Quadrant's main method and pass the command line arguments
        String output = localOut.toString(); // capture the main method's output

        assertEquals("Main method failure", "",output);// test the output, e.g. use an assert or any other way you want

        cleanUpStreams(); // do not remove this line
    }

    /**
    tests if main method works correctly for cases with one pair only
     */
    @Test public void test9(){
        // similar to test8

        setUpStreams(); // do not remove this line

        String args[] = {"1","2"}; // create an array with the command line arguments you want to test

        Quadrant.main(args); // call Quadrant's main method and pass the command line arguments
        String output = localOut.toString(); // capture the main method's output

        assertEquals("Main method failure", "(1,2) has signs (+,+) and is in Q1" + newline,output);// test the output, e.g. use an assert or any other way you want
        
        cleanUpStreams(); // do not remove this line
    }

    /**
    tests if main method works correctly for cases with multiple pairs
     */
    @Test public void test10(){
        // similar to test8

        setUpStreams(); // do not remove this line

        String args[] = {"1","2","-3","4"}; // create an array with the command line arguments you want to test

        Quadrant.main(args); // call Quadrant's main method and pass the command line arguments
        String output = localOut.toString(); // capture the main method's output

        assertEquals("Main method failure", "(1,2) has signs (+,+) and is in Q1" + newline + "(-3,4) has signs (-,+) and is in Q2" + newline,output);// test the output, e.g. use an assert or any other way you want
        
        cleanUpStreams(); // do not remove this line

        // HINT:
        // To avoid any OS-related differences, when you create a multi-line
        // string you should use the variable newline that's declared in line 29
        // example: String s = "this is the first line"+newline+"this is the second line";
    }
    /**
     * Tests if main method works for words input in the arguments
     */
    @Test public void test11(){
        // similar to test8

        setUpStreams(); // do not remove this line

        String args[] = {"1","2","-3","four"}; // create an array with the command line arguments you want to test

        Quadrant.main(args); // call Quadrant's main method and pass the command line arguments
        String output = localOut.toString(); // capture the main method's output

        assertEquals("Main method failure", "(1,2) has signs (+,+) and is in Q1" + newline + "Invalid Input" + newline,output);// test the output, e.g. use an assert or any other way you want
        
        cleanUpStreams(); // do not remove this line
    }

    /**
     * Tests if main method works for words input in the arguments part two
     */
    @Test public void test12(){
        // similar to test8

        setUpStreams(); // do not remove this line

        String args[] = {"one","two","-3","4"}; // create an array with the command line arguments you want to test

        Quadrant.main(args); // call Quadrant's main method and pass the command line arguments
        String output = localOut.toString(); // capture the main method's output

        assertEquals("Invalid Input" + newline,output);// test the output, e.g. use an assert or any other way you want
        
        cleanUpStreams(); // do not remove this line

    }
    /**
     * tests if main method works for an odd number of numbers in the argument
     */
    @Test public void test13(){
        // similar to test8

        setUpStreams(); // do not remove this line

        String args[] = {"1","2","3","4","5"}; // create an array with the command line arguments you want to test

        Quadrant.main(args); // call Quadrant's main method and pass the command line arguments
        String output = localOut.toString(); // capture the main method's output

        assertEquals("(1,2) has signs (+,+) and is in Q1" + newline + "(3,4) has signs (+,+) and is in Q1" + newline,output);// test the output, e.g. use an assert or any other way you want
        
        cleanUpStreams(); // do not remove this line

    }

    /**
     * Tests if the main method works if the last argument in an odd amount of arguments is a word
     */
    @Test public void test14(){
        // similar to test8

        setUpStreams(); // do not remove this line

        String args[] = {"1","2","3","4","five"}; // create an array with the command line arguments you want to test

        Quadrant.main(args); // call Quadrant's main method and pass the command line arguments
        String output = localOut.toString(); // capture the main method's output

        assertEquals("(1,2) has signs (+,+) and is in Q1" + newline + "(3,4) has signs (+,+) and is in Q1" + newline,output);// test the output, e.g. use an assert or any other way you want
        
        cleanUpStreams(); // do not remove this line

    }
    /**
     * tests main method for each quadrant
     */
    @Test public void test15(){
        // similar to test8

        setUpStreams(); // do not remove this line

        String args[] = {"1","2","-3","4","-5","-6","7","-8"}; // create an array with the command line arguments you want to test

        Quadrant.main(args); // call Quadrant's main method and pass the command line arguments
        String output = localOut.toString(); // capture the main method's output

        assertEquals("(1,2) has signs (+,+) and is in Q1" + newline + 
                     "(-3,4) has signs (-,+) and is in Q2" + newline +
                     "(-5,-6) has signs (-,-) and is in Q3" + newline +
                     "(7,-8) has signs (+,-) and is in Q4" + newline
                     ,output);// test the output, e.g. use an assert or any other way you want
        
        cleanUpStreams(); // do not remove this line

    }
    
}
