/**
 * TestShiftSupervisor.java
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
 * Test ShiftSupervisor activity 1.
 * 
 * @author Joel Swanson
 * @version 04.04.2014
 */
public class TestShiftSupervisor
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
                
        String fb = "Error in ShiftSupervisor no-arg constructor.\n";
        ShiftSupervisor shiftSupervisor = new ShiftSupervisor();

        assertNotNull(fb + "name is null.\n", 
            shiftSupervisor.getName());
        assertNotNull(fb + "idNumber is null.\n" , 
            shiftSupervisor.getIdNumber());
        assertNotNull(fb + "hireDate is null.\n" , 
            shiftSupervisor.getHireDate());
        assertNotNull(fb + "shift is null.\n" , 
            shiftSupervisor.getShift());
        
        assertEquals(fb + "name is wrong.\n" , "", 
            shiftSupervisor.getName());
        assertEquals(fb + "idumber is wrong.\n" , "", 
            shiftSupervisor.getIdNumber());
        assertEquals(fb + "hireDate is wrong.\n" , "", 
            shiftSupervisor.getHireDate());
        assertEquals(fb + "shift is wrong.\n" , ShiftType.DAY, 
            shiftSupervisor.getShift());                
        assertEquals(fb + "annualSalary is wrong.\n" , 25000.0, 
            shiftSupervisor.getAnnualSalary(), DELTA);
        assertEquals(fb + "annualBonus is wrong.\n" , 1200.0, 
            shiftSupervisor.getAnnualBonus(), DELTA);            
    }  
    
    /**
     * Check the arg constructor.
     */
    @Test
    public void checkArgConstructor002()
    {
        String fb = "Error in arg constructor in ShiftSupervisor.\n";
        
        checkArgConstructor("Robert Downey Jr.", "345-D",
            "3/1/2010", ShiftType.NIGHT, 32000, 2000);
        checkArgConstructor("Gwyneth Paltrow", "843-E",
            "5/1/2008", ShiftType.DAY, 28000, 4000);
        checkArgConstructor("Daniel Day-Lewis", "732-H",
            "7/9/2006", ShiftType.NIGHT, 41000, 5000);
        checkArgConstructor("Tommy Lee Jones", "822-P",
            "4/8/2003", ShiftType.DAY, 27000, 2000);
            
        String method = getMethodFromFile("ShiftSupervisor.java", 
            "public", "", "ShiftSupervisor", "String", "String", 
            "String", "ShiftType", "double", "double");            

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

        String expected;
        String fb = "Error testing toString in ShiftSupervisor.\n";

        ShiftSupervisor shiftSupervisor1 = new ShiftSupervisor(
            "Robert Downey Jr.", "345-D",
            "3/1/2010", ShiftType.NIGHT, 32000, 2000);    
        ShiftSupervisor shiftSupervisor2 = new ShiftSupervisor(
            "Gwyneth Paltrow", "843-E",
            "5/1/2008", ShiftType.DAY, 28000, 4000);    
        ShiftSupervisor shiftSupervisor3 = new ShiftSupervisor(
            "Daniel Day-Lewis", "732-H",
            "7/9/2006", ShiftType.NIGHT, 41000, 5000);
        ShiftSupervisor shiftSupervisor4 = new ShiftSupervisor(
            "Tommy Lee Jones", "822-P",
            "4/8/2003", ShiftType.DAY, 27000, 2000);        

        expected = "Name:Robert Downey Jr. ID:345-D Hired:3/1/2010" 
            + " Shift:NIGHT Salary:32000.00 Bonus:2000.00";      
        assertEquals(fb,  expected, shiftSupervisor1.toString());
  
        expected = "Name:Gwyneth Paltrow ID:843-E Hired:5/1/2008" 
            + " Shift:DAY Salary:28000.00 Bonus:4000.00";      
        assertEquals(fb,  expected, shiftSupervisor2.toString());

        expected = "Name:Daniel Day-Lewis ID:732-H Hired:7/9/2006" 
            + " Shift:NIGHT Salary:41000.00 Bonus:5000.00";      
        assertEquals(fb,  expected, shiftSupervisor3.toString());

        expected = "Name:Tommy Lee Jones ID:822-P Hired:4/8/2003" 
            + " Shift:DAY Salary:27000.00 Bonus:2000.00";      
        assertEquals(fb,  expected, shiftSupervisor4.toString());
        
        String method = getMethodFromFile("ShiftSupervisor.java", 
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
        String fb = "Error testing computeWeeklyPay in ShiftSupervisor.\n";
        
        ShiftSupervisor shiftSupervisor1 = new ShiftSupervisor(
            "Robert Downey Jr.", "345-D",
            "3/1/2010", ShiftType.NIGHT, 32000, 2000);    
        ShiftSupervisor shiftSupervisor2 = new ShiftSupervisor(
            "Gwyneth Paltrow", "843-E",
            "5/1/2008", ShiftType.DAY, 28000, 4000);    
        ShiftSupervisor shiftSupervisor3 = new ShiftSupervisor(
            "Daniel Day-Lewis", "732-H",
            "7/9/2006", ShiftType.NIGHT, 41000, 5000);
        ShiftSupervisor shiftSupervisor4 = new ShiftSupervisor(
            "Tommy Lee Jones", "822-P",
            "4/8/2003", ShiftType.DAY, 27000, 2000);
                
        assertEquals(fb, 653.85, shiftSupervisor1.computeWeeklyPay(), 0.01); 
        assertEquals(fb + "Do not modify the annualSalary field.\n", 32000.0, 
            shiftSupervisor1.getAnnualSalary(), DELTA); 
        assertEquals(fb + "Do not modify the annualBonus field.\n", 2000.0, 
            shiftSupervisor1.getAnnualBonus(), DELTA); 

        assertEquals(fb, 615.38, shiftSupervisor2.computeWeeklyPay(), 0.01); 
        assertEquals(fb + "Do not modify the annualSalary field.\n", 28000.0, 
            shiftSupervisor2.getAnnualSalary(), DELTA); 
        assertEquals(fb + "Do not modify the annualBonus field.\n", 4000.0, 
            shiftSupervisor2.getAnnualBonus(), DELTA); 

            
        assertEquals(fb, 884.62, shiftSupervisor3.computeWeeklyPay(), 0.01); 
        assertEquals(fb + "Do not modify the annualSalary field.\n", 41000.0, 
            shiftSupervisor3.getAnnualSalary(), DELTA); 
        assertEquals(fb + "Do not modify the annualBonus field.\n", 5000.0, 
            shiftSupervisor3.getAnnualBonus(), DELTA); 

        assertEquals(fb, 557.69, shiftSupervisor4.computeWeeklyPay(), 0.01); 
        assertEquals(fb + "Do not modify the annualSalary field.\n", 27000.0, 
            shiftSupervisor4.getAnnualSalary(), DELTA); 
        assertEquals(fb + "Do not modify the annualBonus field.\n", 2000.0, 
            shiftSupervisor4.getAnnualBonus(), DELTA);             
 
    }

    /**
     * Check the arg constructor to ensure it does not
     * allow out of bounds data.  
     */    
    @Test
    public void checkMutatorLimits005()
    {
        String fb = "Error in ShiftSupervisor mutator.\n";
        double annualSalary = 0;
        double annualBonus = 0;
        ShiftSupervisor shiftSupervisor = null;
        
        shiftSupervisor = new ShiftSupervisor("", "", "", ShiftType.DAY,
            2.0, 2.0); 
        shiftSupervisor.setAnnualSalary(0.0);
        shiftSupervisor.setAnnualBonus(0.0);        
        annualSalary = shiftSupervisor.getAnnualSalary();
        annualBonus = shiftSupervisor.getAnnualBonus();
        
        assertTrue(fb + "Set annual salary to 2.00 then changed to 0.0.\n"
            + "Expected: 0.0  Your value: " + annualSalary + "\n",  
            annualSalary >= 0.0 && annualSalary < 0.00001);

        assertTrue(fb + "Set annual bonus to 2.0 then changed to 0.0.\n"
            + "Expected: 0.0  Your value: " + annualBonus + "\n",  
            annualBonus >= 0 && annualBonus < 0.00001);            
            
        shiftSupervisor = new ShiftSupervisor("", "", "", ShiftType.DAY,
            49999.0, 9999.0);                
        shiftSupervisor.setAnnualSalary(50000.0);
        shiftSupervisor.setAnnualBonus(10000.0);
        annualSalary = shiftSupervisor.getAnnualSalary();
        annualBonus = shiftSupervisor.getAnnualBonus();       
     
        assertTrue(fb 
            + "Set annual salary to 49999.0 then changed to 50000.0.\n"
            + "Expected: 50000.0  Your value: " + annualSalary + "\n",  
            annualSalary > 49999.99999 && annualSalary <= 50000.0);

        assertTrue(fb + "Set annual bonus to 9999.0 then changed to 10000.0.\n"
            + "Expected: 10000.0  Your value: " + annualBonus + "\n",  
            annualBonus > 9999.99999 && annualBonus <= 10000.0);
            
        shiftSupervisor = new ShiftSupervisor("", "", "", ShiftType.DAY,
             0.0, 0.0);                
        shiftSupervisor.setAnnualSalary(-0.1);
        shiftSupervisor.setAnnualBonus(-0.1);   
        annualSalary = shiftSupervisor.getAnnualSalary();
        annualBonus = shiftSupervisor.getAnnualBonus();        
       
        assertTrue(fb + "Set annual salary to -0.1.\n"
            + "Expected: 0.0  Your value: " + annualSalary + "\n",  
            annualSalary >= 0.0 && annualSalary < 0.00001);

        assertTrue(fb + "Set annual bonus to -0.1.\n"
            + "Expected: 0.0  Your value: " + annualBonus + "\n",  
            annualBonus >= 0 && annualBonus < 0.00001);    
            
        shiftSupervisor = new ShiftSupervisor("", "", "", ShiftType.DAY,
             50000.0, 10000.0);                
        shiftSupervisor.setAnnualSalary(50000.1);
        shiftSupervisor.setAnnualBonus(10000.1);          
        annualSalary = shiftSupervisor.getAnnualSalary();
        annualBonus = shiftSupervisor.getAnnualBonus();        

        assertTrue(fb + "Set annual salary to 50000.1.\n"
            + "Expected: 50000.0  Your value: " + annualSalary + "\n",  
            annualSalary > 49999.99999 && annualSalary <= 50000.0);

        assertTrue(fb + "Set annual bonus to 10000.1.\n"
            + "Expected: 10000.0  Your value: " + annualBonus + "\n",  
            annualBonus > 9999.99999 && annualBonus <= 10000.0);
    }    
    
    /**
     * Check the arg constructor to ensure it does not
     * allow out of bounds data.  
     */    
    @Test
    public void checkConstructorLimits006()
    {
        String fb = "Error in ShiftSupervisor arg constructor.\n";
        double annualSalary = 0;
        double annualBonus = 0;
        ShiftSupervisor shiftSupervisor = null;
        
        shiftSupervisor = new ShiftSupervisor("", "", "", ShiftType.DAY,
            0, 0);                
        annualSalary = shiftSupervisor.getAnnualSalary();
        annualBonus = shiftSupervisor.getAnnualBonus();
        
        assertTrue(fb + "Set annual salary to 0.0.\n"
            + "Expected: 0.0  Your value: " + annualSalary + "\n",  
            annualSalary >= 0.0 && annualSalary < 0.00001);

        assertTrue(fb + "Set annual bonus to 0.0.\n"
            + "Expected: 0.0  Your value: " + annualBonus + "\n",  
            annualBonus >= 0 && annualBonus < 0.00001);            
            
        shiftSupervisor = new ShiftSupervisor("", "", "", ShiftType.DAY,
            50000.0, 10000.0);                
        annualSalary = shiftSupervisor.getAnnualSalary();
        annualBonus = shiftSupervisor.getAnnualBonus();
        
        assertTrue(fb + "Set annual salary to 50000.0.\n"
            + "Expected: 50000.0  Your value: " + annualSalary + "\n",  
            annualSalary > 49999.99999 && annualSalary <= 50000.0);

        assertTrue(fb + "Set annual bonus to 10000.0.\n"
            + "Expected: 10000.0  Your value: " + annualBonus + "\n",  
            annualBonus > 9999.99999 && annualBonus <= 10000.0);
            
        shiftSupervisor = new ShiftSupervisor("", "", "", ShiftType.DAY,
            -0.1, -0.1);                
        annualSalary = shiftSupervisor.getAnnualSalary();
        annualBonus = shiftSupervisor.getAnnualBonus();
        
        assertTrue(fb + "Set annual salary to -0.1.\n"
            + "Expected: 0.0  Your value: " + annualSalary + "\n",  
            annualSalary >= 0.0 && annualSalary < 0.00001);

        assertTrue(fb + "Set annual bonus to -0.1.\n"
            + "Expected: 0.0  Your value: " + annualBonus + "\n",  
            annualBonus >= 0.0 && annualBonus < 0.00001);    
            
        shiftSupervisor = new ShiftSupervisor("", "", "", ShiftType.DAY,
             50000.1, 10000.1);                
        annualSalary = shiftSupervisor.getAnnualSalary();
        annualBonus = shiftSupervisor.getAnnualBonus();
        
        assertTrue(fb + "Set annual salary to 50000.1.\n"
            + "Expected: 50000.0  Your value: " + annualSalary + "\n",  
            annualSalary > 49999.99999 && annualSalary <= 50000.0);

        assertTrue(fb + "Set annual bonus to 10000.1.\n"
            + "Expected: 10000.0  Your value: " + annualBonus + "\n",  
            annualBonus > 9999.99999 && annualBonus <= 10000.0);
    }    
    
    /**
     * Check the arg constructor using parameters.
     * @param name The value to use when checking the constructor.
     * @param idNumber The value to use when checking the constructor.
     * @param hireDate The value to use when checking the constructor.
     * @param shift The value to use when checking the constructor.
     * @param annualSalary The value to use when checking the constructor.
     * @param annualBonus The value to use when checking the constructor.
     */  
    public void checkArgConstructor(String name, String idNumber, 
        String hireDate, ShiftType shift, double annualSalary,
        double annualBonus)
    {
        String fb = "Error in ShiftSupervisor no-arg constructor.\n";
        fb += "shift should be initialized to DAY.\n";
        fb += "String fields must be empty strings.\n";
        fb += "None of the fields should be left null.\n";
        ShiftSupervisor shiftSupervisor = new ShiftSupervisor(name, idNumber, 
            hireDate, shift, annualSalary, annualBonus);
        
        assertNotNull(fb + "name is null.\n", 
            shiftSupervisor.getName());
        assertNotNull(fb + "idNumber is null.\n" , 
            shiftSupervisor.getIdNumber());
        assertNotNull(fb + "hireDate is null.\n" , 
            shiftSupervisor.getHireDate());
        assertNotNull(fb + "shift is null.\n" , 
            shiftSupervisor.getShift());
        
        assertEquals(fb + "name is wrong.\n" , name, 
            shiftSupervisor.getName());
        assertEquals(fb + "idumber is wrong.\n" , idNumber, 
            shiftSupervisor.getIdNumber());
        assertEquals(fb + "hireDate is wrong.\n" , hireDate, 
            shiftSupervisor.getHireDate());
        assertEquals(fb + "shift is wrong.\n" , shift, 
            shiftSupervisor.getShift());        
        assertEquals(fb + "annualSalary is wrong.\n" , annualSalary, 
            shiftSupervisor.getAnnualSalary(), DELTA);        
        assertEquals(fb + "annualBonus is wrong.\n" , annualBonus, 
            shiftSupervisor.getAnnualBonus(), DELTA);        
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
