/**
 * TestDemoWorker.java
 */

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

/**
 * Describe TestDemoWorker here.
 *
 * @author (Your name here)
 * @version (Date or version number)
 */
public class TestDemoWorker
{
    /**
     * Default constructor for test class TestDemoWorker.
     */
    public TestDemoWorker()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    /**
     * Check the number of items in employees.
     */
    @Test
    public void checkEmployeeSize001()
    {
        //Make sure the prelab is passing.
        TestPrelab testPrelab = new TestPrelab();
        testPrelab.checkAll();  
        
        String fb = "Error in DemoWorker no-arg constructor.\n";
        DemoWorker demoWorker = new DemoWorker();
        ArrayList<Employee> employees = demoWorker.getEmployees();
        
        assertEquals(fb + "Incorrect number of objects in employees.\n",
            3, employees.size());       
    }   
    
    /**
     * Check the types of objects stored.  Mostly to make sure
     * no employee obects were created.
     */
    @Test
    public void checkEmployeeTypes002()
    {   
        //Make sure the prelab is passing.
        TestPrelab testPrelab = new TestPrelab();
        testPrelab.checkAll();  
        
        int pwCount = 0;
        int ssCount = 0;
        int tlCount = 0;
        
        String fb = "Error in DemoWorker no-arg constructor.\n";
        DemoWorker demoWorker = new DemoWorker();
        ArrayList<Employee> employees = demoWorker.getEmployees();
        
        assertEquals(fb + "Incorrect number of objects in employees.\n",
            3, employees.size());    
        
        for (Employee e : employees)
        {
            if (e instanceof TeamLeader)
            {
                tlCount++;
            }
            else if (e instanceof ShiftSupervisor)
            {
                ssCount++;
            }
            else if (e instanceof ProductionWorker) 
            {
                pwCount++;
            }  
            else
            {
                fb += "Found an object in the ArrayList that was not\n";
                fb += "A ProductionWorker, ShiftSupervisor, or TeamLeader.\n";
                fb += "All objects in employees should be one of these" 
                    + " types.\n";
                fail(fb);
            }
        }
        if (pwCount != 1 || ssCount != 1 || tlCount != 1)
        {
            fb += "You should have one ProductionWorker. You have " 
                + pwCount + ".\n";
            fb += "You should have one ShiftSupervisor. You have " 
                + ssCount + ".\n";
            fb += "You should have one TeamLeader. You have " 
                + tlCount + ".\n";                
            fail(fb);
        }
        
    }  
    
    /**
     * Check the types of objects stored.  Mostly to make sure
     * no employee obects were created.
     */
    @Test
    public void checkCorrectEmployees003()
    {   
        //Make sure the prelab is passing.
        TestPrelab testPrelab = new TestPrelab();
        testPrelab.checkAll();  
        
        String fb = "Error in DemoWorker no-arg constructor.\n";
        DemoWorker demoWorker = new DemoWorker();
        ArrayList<Employee> employees = demoWorker.getEmployees();
        
        assertEquals(fb + "Incorrect number of objects in employees.\n",
            3, employees.size());    
        
        findEmployee(employees, "Emma Watson", ProductionWorker.class);
        findEmployee(employees, "Robert Downey Jr.", ShiftSupervisor.class);
        findEmployee(employees, "Morgan Freeman", TeamLeader.class);
    }  
    
    /**
     * Test DemoWorker output.
     */
    @Test
    public void checkOutput()
    {        
        String fb = "Error in DemoWorker no arg constructor.\n";
        String[] student = capture();
        assertTrue(fb + "No output detected.\n", student.length != 0);

        assertEquals(fb + "You should have printed exactly 6 lines.\n",
            6, student.length);
            
        assertTrue(fb + "Emma Watson line from step 4 malformed or" 
            + " not found.\n",
            findInOutput(student, "Name:Emma", "Hours:20.0"));
        assertTrue(fb + "Robert Downey Jr. line from step 4 malformed" 
            + " or not found.\n",
            findInOutput(student, "Name:Robert", "Bonus:2000.00"));
        assertTrue(fb + "Morgan Freeman line from step 4 malformed or" 
            + " not found.\n",
            findInOutput(student, "Name:Morgan", "Bonus:82.00"));
        assertTrue(fb + "Emma Watson line from step 5 malformed or not found.\n"
            + "Make sure weekly pay has two decimal points.",
            findInOutput(student, "Emma", 145.00));
        assertTrue(fb + "Robert Downey Jr. line from step 5 malformed" 
            + " or not found.\n"
            + "Make sure weekly pay has two decimal points.",
            findInOutput(student, "Robert", 653.85));
        assertTrue(fb + "Morgan Freeman line from step 5 malformed or" 
            + " not found.\n"
            + "Make sure weekly pay has two decimal points.",
            findInOutput(student, "Morgan", 772.00));        
    }
    
    /**
     * Find a line in the output array that starts with and ends with a
     * particular string. The end string is a dollar amount which is 
     * calculated and therefore needs to allow for rounding errors.
     * @param output Array of strings which contains each line of the
     * students output.
     * @param start String that should be the start of one of the lines
     * of output.
     * @param end The amount of the string that should end the output line
     * that starts with the starting string.  This double is converted into
     * a string.  
     * @return Returns true if one single line of the students output starts
     * with the starting string and ends with the dollar amount given plus
     * or minus one cent. Returns false if a string matching that pattern
     * is not found.
     */
    public boolean findInOutput(String[] output, String start, double end)
    {
        String money1 = String.format("$%.2f", end);
        String money2 = String.format("$%.2f", end - 0.01);
        String money3 = String.format("$%.2f", end + 0.01);

        return findInOutput(output, start, money1)
            || findInOutput(output, start, money2)
            || findInOutput(output, start, money3);
    }
    
    /**
     * Find a single line in the output array that starts and ends with a
     * particular given set of strings. 
     * @param output Array of strings which contains each line of the
     * students output.
     * @param start The beginning of the string.
     * @param end The end of the string. 
     * @return Returns true if one single line of the students output starts
     * with the starting string and that same line matches the end string. 
     * Returns false if a string matching that pattern is not found.
     */    
    public boolean findInOutput(String[] output, String start, String end)
    {
        for (String s : output)
        {
            if (s.startsWith(start) && s.endsWith(end))
            {
                return true;
            }
        }        
        return false;        
    }
    
    /**
     * Find a single employee object in the array list with the given
     * name and class type.
     * @param employees The ArrayList of employee objects to search.
     * @param name The name of the employee to find.
     * @param myClass The name of the subclass that this employee should be
     * if the student did the work properly.
     * @return Returns true if the employee is found and is the correct type.
     */
    public boolean findEmployee(ArrayList<Employee> employees, String name,
        Class myClass)
    {
        for (Employee employee : employees)
        {
            if (employee.getName().equals(name) 
                && (employee.getClass().equals(myClass)))
            {
                return true;
            }
        }
        return false;
    }
        
    /**
     * Capture student output.
     * @return Returns the output of the student data as an array of strings.
     */
    public String[] capture()
    {
        
        //terminal now prints to the Terminal Window like this
        //      terminal.println("Hello");
        PrintStream terminal = System.out;

        //Set up System to print to a byte array
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        
        //Create a new demoWorker and capture 
        //the resulting output.
        DemoWorker demoWorker = new DemoWorker();
        
        System.out.flush();

        //Print user output to terminal
        terminal.println(output);
        
        //Restore printing
        System.setOut(terminal);

        //Replace all crnl with nl
        //Replace all cr with nl
        //Only nl should remain
        String studentData = output.toString();
        studentData = studentData.replaceAll("\r\n", "\n");
        studentData = studentData.replaceAll("\r", "\n");

        //Split the lines into an array of strings
        return studentData.split("\n");          
    }
}
