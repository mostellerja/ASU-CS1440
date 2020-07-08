/**
 * TestProductionWorker.java
 */

//Put any imports below this line.
import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Test ProductionWorker activity 1.
 * 
 * @author Joel Swanson
 * @version 04.04.2014
 */
public class TestProductionWorker
{
    public static final double DELTA = 0.01;
   
    /**
     * Check the no arg constructor.
     */
    @Test
    public void checkNoArgConstructor001()
    {   
        //Make sure the prelab is passing.
        TestPrelab testPrelab = new TestPrelab();
        testPrelab.checkAll();  
        
        String fb = "Error in ProductionWorker no-arg constructor.\n";
        ProductionWorker productionWorker = new ProductionWorker();

        assertNotNull(fb + "name is null.\n", 
            productionWorker.getName());
        assertNotNull(fb + "idNumber is null.\n" , 
            productionWorker.getIdNumber());
        assertNotNull(fb + "hireDate is null.\n" , 
            productionWorker.getHireDate());
        assertNotNull(fb + "shift is null.\n" , 
            productionWorker.getShift());
        
        assertEquals(fb + "name is wrong.\n" , "", 
            productionWorker.getName());
        assertEquals(fb + "idumber is wrong.\n" , "", 
            productionWorker.getIdNumber());
        assertEquals(fb + "hireDate is wrong.\n" , "", 
            productionWorker.getHireDate());
        assertEquals(fb + "shift is wrong.\n" , 
            ShiftType.DAY, productionWorker.getShift());                
        assertEquals(fb + "hourlyPayRate is wrong.\n" , 7.25, 
            productionWorker.getHourlyPayRate(), DELTA);
        assertEquals(fb + "hoursWorked is wrong.\n" , 40.0, 
            productionWorker.getHoursWorked(), DELTA);
    }  
    
    /**
     * Check the arg constructor.
     */
    @Test
    public void checkArgConstructor002()
    {
        checkArgConstructor("Emma Watson", "123-A",
            "12/1/2012", ShiftType.DAY, 7.25, 20);
        checkArgConstructor("Keith Urban", "234-B",
            "11/4/2002", ShiftType.DAY, 8.0, 50);
        checkArgConstructor("Will Smith", "424-C",
            "3/21/2008", ShiftType.NIGHT, 10.0, 40);
        checkArgConstructor("Jennifer Lawrence", "864-Z",
            "4/2/2006", ShiftType.NIGHT, 13.0, 52);            
                       
        String method = getMethodFromFile("ProductionWorker.java", 
            "public", "", "ProductionWorker", "String", "String", 
            "String", "ShiftType", "double", "double");
        
        String fb = "Error in arg constructor in ProductionWorker.\n";

        assertTrue(fb + "Cannot find argument constructor.\n",
            !method.equals(""));        
        
        fb += "DO NOT USE MUTATORS HERE.  Use super instead.\n";
        assertFound(fb + "super not found.", method, "super\\(");
        assertNotFound(fb + "Don't use setName.", method, "setName\\(");
        assertNotFound(fb + "Don't use setIdNumber.", method, "setIdNumber\\(");
        assertNotFound(fb + "Don't use setHireDate.", method, "setHireDate\\(");
        assertNotFound(fb + "Don't use setShift.", method, "setShift\\(");
    }
    
    
    /**
     * Check the toString method.
     */   
    @Test
    public void checkToString003()
    {
        ProductionWorker productionWorker;
        String expected;
        String fb = "Error testing toString in ProductionWorker.\n";

        ProductionWorker productionWorker1 = new ProductionWorker(
            "Emma Watson", "123-A", "12/1/2012", ShiftType.DAY, 7.25, 20.0);    
        ProductionWorker productionWorker2 = new ProductionWorker(
            "Keith Urban", "234-B", "11/4/2002", ShiftType.DAY, 8.0, 50.0);    
        ProductionWorker productionWorker3 = new ProductionWorker(
            "Will Smith", "424-C", "3/21/2008", ShiftType.NIGHT, 10.0, 40.0);
        ProductionWorker productionWorker4 = new ProductionWorker(
            "Jennifer Lawrence", "864-Z", "4/2/2006", ShiftType.NIGHT,
            13.0, 52.0);        

        expected = "Name:Emma Watson ID:123-A Hired:12/1/2012" 
            + " Shift:DAY Payrate:7.25 Hours:20.0";      
        assertEquals(fb,  expected, productionWorker1.toString());

        expected = "Name:Keith Urban ID:234-B Hired:11/4/2002" 
            + " Shift:DAY Payrate:8.00 Hours:50.0";      
        assertEquals(fb,  expected, productionWorker2.toString());

        expected = "Name:Will Smith ID:424-C Hired:3/21/2008" 
            + " Shift:NIGHT Payrate:10.00 Hours:40.0";      
        assertEquals(fb,  expected, productionWorker3.toString());

        expected = "Name:Jennifer Lawrence ID:864-Z Hired:4/2/2006" 
            + " Shift:NIGHT Payrate:13.00 Hours:52.0";      
        assertEquals(fb,  expected, productionWorker4.toString());
        
        String method = getMethodFromFile("ProductionWorker.java", 
            "public", "String", "toString");
        
        fb += "DO NOT USE MUTATORS HERE.  Use super.toString() instead.\n";
        assertFound(fb, method, "super.toString()");
        assertNotFound(fb, method, "getName()");
        assertNotFound(fb, method, "getIdNumber()");
        assertNotFound(fb, method, "getHireDate()");
        assertNotFound(fb, method, "getShift()");        
    }
    
    /**
     * Check the calculations for computing weekly pay.
     */
    @Test
    public void checkComputeWeeklyPay004()
    {
        String fb = "Error testing computeWeeklyPay in ProductionWorker.\n";
        
        ProductionWorker productionWorker1 = new ProductionWorker(
            "Emma Watson", "123-A", "12/1/2012", ShiftType.DAY, 7.25, 20.0);    
        ProductionWorker productionWorker2 = new ProductionWorker(
            "Keith Urban", "234-B", "11/4/2002", ShiftType.DAY, 8.0, 50.0);    
        ProductionWorker productionWorker3 = new ProductionWorker(
            "Will Smith", "424-C", "3/21/2008", ShiftType.NIGHT, 10.0, 40.0);
        ProductionWorker productionWorker4 = new ProductionWorker(
            "Jennifer Lawrence", "864-Z", "4/2/2006", ShiftType.NIGHT,
            13.0, 52.0);
                
        assertEquals(fb, 145.0, productionWorker1.computeWeeklyPay(), DELTA); 
        assertEquals(fb + "Do not modify the hoursWorked field.\n", 20.0, 
            productionWorker1.getHoursWorked(), DELTA); 
        assertEquals(fb, 440.0, productionWorker2.computeWeeklyPay(), DELTA);
        assertEquals(fb + "Do not modify the hoursWorked field.\n", 50.0, 
            productionWorker2.getHoursWorked(), DELTA); 
        assertEquals(fb, 400.0, productionWorker3.computeWeeklyPay(), DELTA);
        assertEquals(fb + "Do not modify the hoursWorked field.\n", 40.0, 
            productionWorker3.getHoursWorked(), DELTA); 
        assertEquals(fb, 754.0, productionWorker4.computeWeeklyPay(), DELTA);
        assertEquals(fb + "Do not modify the hoursWorked field.\n", 52.0, 
            productionWorker4.getHoursWorked(), DELTA); 
    }
    
    
    /**
     * Check the arg constructor to ensure it does not
     * allow out of bounds data.  
     */    
    @Test
    public void checkMutatorLimits005()
    {
        String fb = "Error in ProductionWorker mutator.\n";
        double rate = 0;
        double hours = 0;
        ProductionWorker productionWorker = null;
        
        productionWorker = new ProductionWorker("", "", "",
            ShiftType.DAY,  8.0, 2.0); 
        productionWorker.setHourlyPayRate(7.25);
        productionWorker.setHoursWorked(0);        
        rate = productionWorker.getHourlyPayRate();
        hours = productionWorker.getHoursWorked();
        
        assertTrue(fb + "Set hourly pay to 8.0 then changed to 7.25.\n"
            + "Expected: 7.25  Your value: " + rate + "\n",  
            rate >= 7.25 && rate < 7.25001);

        assertTrue(fb + "Set hours worked to 2.0 then changed to 0.0.\n"
            + "Expected: 0.0  Your value: " + hours + "\n",  
            hours >= 0 && hours < 0.00001);            
            
        productionWorker = new ProductionWorker("", "", "",
            ShiftType.DAY, 23.0, 68.0);                
        productionWorker.setHourlyPayRate(25.0);
        productionWorker.setHoursWorked(70);
        rate = productionWorker.getHourlyPayRate();
        hours = productionWorker.getHoursWorked();       
     
        assertTrue(fb + "Set pay rate to 23.0 then changed to 25.0.\n"
            + "Expected: 25.0  Your value: " + rate + "\n",  
            rate > 24.99999 && rate <= 25.0);

        assertTrue(fb + "Set hours worked to 68.0 then changed to 70.0.\n"
            + "Expected: 70.0  Your value: " + hours + "\n",  
            hours > 69.99999 && hours <= 70.0);                            
            
        productionWorker = new ProductionWorker("", "", "", ShiftType.DAY,
            7.25, 0.0);                
        productionWorker.setHourlyPayRate(7.24);
        productionWorker.setHoursWorked(-0.1);   
        rate = productionWorker.getHourlyPayRate();
        hours = productionWorker.getHoursWorked();        
       
        assertTrue(fb + "Set pay rate to 7.24.\n"
            + "Expected: 7.25  Your value: " + rate + "\n",  
            rate >= 7.25 && rate < 7.25001);

        assertTrue(fb + "Set hours worked to -0.1.\n"
            + "Expected: 0.0  Your value: " + hours + "\n",  
            hours >= 0 && hours < 0.00001);    
            
        productionWorker = new ProductionWorker("", "", "", ShiftType.DAY,
            25.0, 70.0);                
        productionWorker.setHourlyPayRate(25.1);
        productionWorker.setHoursWorked(70.1);          
        rate = productionWorker.getHourlyPayRate();
        hours = productionWorker.getHoursWorked();        

        assertTrue(fb + "Set pay rate to 25.1.\n"
            + "Expected: 25.0  Your value: " + rate + "\n",  
            rate > 24.99999 && rate <= 25.0);

        assertTrue(fb + "Set hours worked to 70.1.\n"
            + "Expected: 70.0  Your value: " + hours + "\n",  

            hours > 69.99999 && hours <= 70.0);                         
    }
    
    /**
     * Check the arg constructor to ensure it does not
     * allow out of bounds data.  
     */    
    @Test
    public void checkConstructorLimits006()
    {
        String fb = "Error in ProductionWorker arg constructor.\n";
        double rate = 0;
        double hours = 0;
        ProductionWorker productionWorker = null;
        
        productionWorker = new ProductionWorker("", "", "", ShiftType.DAY,
            7.25, 0);                
        rate = productionWorker.getHourlyPayRate();
        hours = productionWorker.getHoursWorked();
        
        assertTrue(fb + "Set hourly pay to 7.25.\n"
            + "Expected: 7.25  Your value: " + rate + "\n",  
            rate >= 7.25 && rate < 7.25001);

        assertTrue(fb + "Set hours worked to 0.0.\n"
            + "Expected: 0.0  Your value: " + hours + "\n",  
            hours >= 0 && hours < 0.00001);            
            
        productionWorker = new ProductionWorker("", "", "", ShiftType.DAY,
            25.0, 70.0);                
        rate = productionWorker.getHourlyPayRate();
        hours = productionWorker.getHoursWorked();
        
        assertTrue(fb + "Set pay rate to 25.0.\n"
            + "Expected: 25.0  Your value: " + rate + "\n",  
            rate > 24.99999 && rate <= 25.0);

        assertTrue(fb + "Set hours worked to 70.0.\n"
            + "Expected: 70.0  Your value: " + hours + "\n",  
            hours > 69.99999 && hours <= 70.0);                            
            
        productionWorker = new ProductionWorker("", "", "", ShiftType.DAY,
            7.24, -0.1);                
        rate = productionWorker.getHourlyPayRate();
        hours = productionWorker.getHoursWorked();
        
        assertTrue(fb + "Set pay rate to 7.24.\n"
            + "Expected: 7.25  Your value: " + rate + "\n",  
            rate >= 7.25 && rate < 7.25001);

        assertTrue(fb + "Set hours worked to -0.1.\n"
            + "Expected: 0.0  Your value: " + hours + "\n",  
            hours >= 0 && hours < 0.00001);    
            
        productionWorker = new ProductionWorker("", "", "", ShiftType.DAY,
            25.1, 70.1);                
        rate = productionWorker.getHourlyPayRate();
        hours = productionWorker.getHoursWorked();
        
        assertTrue(fb + "Set pay rate to 25.1.\n"
            + "Expected: 25.0  Your value: " + rate + "\n",  
            rate > 24.99999 && rate <= 25.0);

        assertTrue(fb + "Set hours worked to 70.1.\n"
            + "Expected: 70.0  Your value: " + hours + "\n",  
            hours > 69.99999 && hours <= 70.0);                         
    }
       
    /**
     * Check the arg constructor using parameters.
     * @param name The value to use when checking the constructor.
     * @param idNumber The value to use when checking the constructor.
     * @param hireDate The value to use when checking the constructor.
     * @param shift The value to use when checking the constructor.
     * @param hourlyPayRate The value to use when checking the constructor.
     * @param hoursWorked The value to use when checking the constructor.
     */    
    public void checkArgConstructor(String name, String idNumber, 
        String hireDate, ShiftType shift, double hourlyPayRate,
        double hoursWorked)
    {
        String fb = "Error in ProductionWorker arg constructor.\n";
        ProductionWorker productionWorker = new ProductionWorker(name,
            idNumber, hireDate, shift, hourlyPayRate, hoursWorked);
        
        assertNotNull(fb + "name is null.\n", 
            productionWorker.getName());
        assertNotNull(fb + "idNumber is null.\n" , 
            productionWorker.getIdNumber());
        assertNotNull(fb + "hireDate is null.\n" , 
            productionWorker.getHireDate());
        assertNotNull(fb + "shift is null.\n" , 
            productionWorker.getShift());
        
        assertEquals(fb + "name is wrong.\n" , name, 
            productionWorker.getName());
        assertEquals(fb + "idumber is wrong.\n" , idNumber, 
            productionWorker.getIdNumber());
        assertEquals(fb + "hireDate is wrong.\n" , hireDate, 
            productionWorker.getHireDate());
        assertEquals(fb + "shift is wrong.\n" , shift, 
            productionWorker.getShift());        
        assertEquals(fb + "hourlyPayRate is wrong.\n" , hourlyPayRate, 
            productionWorker.getHourlyPayRate(), DELTA);        
        assertEquals(fb + "hoursWorked is wrong.\n" , hoursWorked, 
            productionWorker.getHoursWorked(), DELTA);        
    }
    /**
     * Searches a given string for a particular
     * substring.  Causes a fail if the substring 
     * is not found.
     * @param errorMessage Print this message on a fail.
     * @param stringToSearch Search this string for a value.
     * @param valueToFind Find this value in a string.
     */    
    public void assertFound(String errorMessage, 
        String stringToSearch, String valueToFind)
    {        
        Pattern pattern = Pattern.compile(valueToFind);
        Matcher matcher = pattern.matcher(stringToSearch);
        if (!matcher.find()) 
        {
            fail(errorMessage);
        }                
    }

    /**
     * Searches a given string for a particular
     * substring.  Causes a fail if the substring 
     * is found.
     * @param errorMessage Print this message on a fail.
     * @param stringToSearch Search this string for a value.
     * @param valueToFind Find this value in a string.
     */  
    public void assertNotFound(String errorMessage,
        String stringToSearch, String valueToFind)
    {
        Pattern pattern = Pattern.compile(valueToFind);
        Matcher matcher = pattern.matcher(stringToSearch);
        if (matcher.find()) 
        {
            fail(errorMessage);
        }  
    }    

    /**
     * Get a method signature and body from a file in string format.
     * @param filename The name of the java file with the method inside.
     * @param modifier The access modifier of the method.
     * @param returnType The return type of the method.  Leave this blank
     * for constructors.
     * @param methodName The name of the method to find.
     * @param parameters A string array of parameter types.
     * @return Returns the entire method signature and body as found in
     * the file.
     */
    public String getMethodFromFile(String filename, 
        String modifier, String returnType, String methodName,
        String... parameters)   
    {
        String method = "";
        try 
        {
            java.io.File file = new java.io.File(filename);
            Scanner filescan = new Scanner(file);
            if (file.exists())
            {
                do
                {
                    method = getNextMethod(filescan, modifier,
                        returnType, methodName);
                }
                while (!method.equals("") 
                    && !parameterMatch(method, parameters));
            }
        }
        catch (Exception e)
        {
            method = "";
        }
        
        return method;
    }
    
    /**
     * Given a method as a string and a list of parameters, make sure 
     * the method given has the parameters listed.  This method allows
     * the parameter list to be on multiple lines.
     * @param method The method to check for match.
     * @param parameters The given parameter types to search.
     * @return returns true if the method parameter types match the
     * given list.  Returns false if the method parameter types do
     * not match the given list.
     */
    public boolean parameterMatch(String method, String[] parameters)
    {
        boolean same = true;
        
        String methodParams = method.substring(method.indexOf("(") 
            + 1, method.indexOf(")"));
        methodParams = methodParams.replaceAll("\r\n", "\n");
        methodParams = methodParams.replaceAll("\r", "\n");
        methodParams = methodParams.replaceAll("\n", " ");
        while (methodParams.contains("  "))
        {
            methodParams = methodParams.replaceAll("  ", " ");
        }
        
        String[] newParams = methodParams.split(", ");
        
        if (parameters.length == 0)
        {
            parameters = new String[]{""};
        }
        
        if (newParams.length != parameters.length)
        {
            same = false;
        }
        else
        {
        
            for (int i = 0; i < newParams.length; i++)
            {
                String methodParam = newParams[i].trim();
                String expectedParam = parameters[i];
                if (!methodParam.startsWith(expectedParam))
                {
                    same = false;
                }
            }
        }        
        return same;
    }
    
    /**
     * Search through a java file and find and return the text of a
     * specified method.  
     * @param filescan The scanner from which file data will be read.
     * @param modifier The access modifier of the method to be found.
     * @param returnType The return type of the method to be found.
     * @param methodName The name of the method to be found.
     * @return Returns the text of the entire method if found.  
     * Returns an empty string if not found.
     */
    public String getNextMethod(Scanner filescan, 
        String modifier, String returnType, String methodName)   
    {
        boolean found = false;
        boolean done = false;
        int openBracketCount = 0;
        String methodString = "";
        String methodExpression = "";
        methodExpression += "^\\s*" + modifier; 
        methodExpression += "\\s*" + returnType;
        methodExpression += "\\s*" + methodName + "\\s*\\(.*$";

        while (!done && filescan.hasNext())
        {
            String input = filescan.nextLine();
            if (input.matches(methodExpression))
            {
                methodString += input + "\n";
                found = true;
                while (!input.contains("{"))
                {
                    //Read until { is found
                    input = filescan.nextLine();
                    methodString += input + "\n";                    
                }                        
                openBracketCount = 1;
            }
            else if (found)
            {
                methodString += input + "\n";
                if (input.contains("{"))
                {
                    openBracketCount++;
                }
                else if (input.contains("}"))
                {
                    openBracketCount--;
                }
                if (openBracketCount == 0)
                {
                    done = true;                            
                }                        
            }
        }
        return methodString;
    } 
    
}
