/**
 * TestTeamLeader.java
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
 * Test TeamLeader activity 1.
 * 
 * @author Joel Swanson
 * @version 04.04.2014
 */
public class TestTeamLeader
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
        
        String fb = "Error in TeamLeader no-arg constructor.\n";
        TeamLeader teamLeader = new TeamLeader();

        assertNotNull(fb + "name is null.\n", 
            teamLeader.getName());
        assertNotNull(fb + "idNumber is null.\n" , 
            teamLeader.getIdNumber());
        assertNotNull(fb + "hireDate is null.\n" , 
            teamLeader.getHireDate());
        assertNotNull(fb + "shift is null.\n" , 
            teamLeader.getShift());
        
        assertEquals(fb + "name is wrong.\n" , "", 
            teamLeader.getName());
        assertEquals(fb + "idumber is wrong.\n" , "", 
            teamLeader.getIdNumber());
        assertEquals(fb + "hireDate is wrong.\n" , "", 
            teamLeader.getHireDate());
        assertEquals(fb + "shift is wrong.\n" , ShiftType.DAY, 
            teamLeader.getShift());                
        assertEquals(fb + "trainingHours is wrong.\n" , 10, 
            teamLeader.getTrainingHours());
        assertEquals(fb + "weeklyBonus is wrong.\n" , 50.0, 
            teamLeader.getWeeklyBonus(), DELTA);            
    }  
    
    /**
     * Check the arg constructor.
     */
    @Test
    public void checkArgConstructor002()
    {
        String fb = "Error in arg constructor in ProductionWorker.\n";        

        checkArgConstructor("Morgan Freeman", "867-T", "2/1/2001", 
            ShiftType.DAY, 17.25, 40, 10, 82.00);
        checkArgConstructor("Kristen Stewart", "352-J", "10/4/1999",
            ShiftType.DAY, 19.25, 40, 5, 45.00);
        checkArgConstructor("Dakota Fanning", "562-R", "12/25/2005",
            ShiftType.NIGHT, 22.00, 38, 20, 34.00);
        checkArgConstructor("Halle Berry", "734-K", "11/11/2011",
            ShiftType.NIGHT, 21.50, 42, 12, 193.00);
            
        String method = getMethodFromFile("TeamLeader.java", 
            "public", "", "TeamLeader", "String", "String", 
            "String", "ShiftType", "double", "double", "int", "double");
        
        assertTrue(fb + "Cannot find argument constructor.\n",
            !method.equals(""));
            
        fb += "DO NOT USE MUTATORS HERE.  Use super instead.\n";
        assertFound(fb + "super not found.", method, "super\\(");
        assertNotFound(fb + "Don't use setName.", method, "setName\\(");
        assertNotFound(fb + "Don't use setIdNumber.", method, "setIdNumber\\(");
        assertNotFound(fb + "Don't use setHireDate.", method, "setHireDate\\(");
        assertNotFound(fb + "Don't use setShift.", method, "setShift\\(");
        assertNotFound(fb + "Don't use setHireDate.", method,
            "setHourlyPayRate\\(");
        assertNotFound(fb + "Don't use setShift.", method,
            "setHoursWOrked\\("); 
    }
    
    /**
     * Check the toString method.
     */   
    @Test
    public void checkToString003()
    {
        TeamLeader teamLeader;
        String expected;
        String fb = "Error testing toString in TeamLeader.\n";

        TeamLeader teamLeader1 = new TeamLeader(
            "Morgan Freeman", "867-T", "2/1/2001", 
            ShiftType.DAY, 17.25, 40, 10, 82.00);    
        TeamLeader teamLeader2 = new TeamLeader(
            "Kristen Stewart", "352-J", "10/4/1999",
            ShiftType.DAY, 19.25, 40, 5, 45.00);    
        TeamLeader teamLeader3 = new TeamLeader(
            "Dakota Fanning", "562-R", "12/25/2005",
            ShiftType.NIGHT, 22.00, 38, 20, 34.00);
        TeamLeader teamLeader4 = new TeamLeader(
            "Halle Berry", "734-K", "11/11/2011",
            ShiftType.NIGHT, 21.50, 42, 12, 193.00);        





            
        expected = "Name:Morgan Freeman ID:867-T Hired:2/1/2001 Shift:DAY"
            + " Payrate:17.25 Hours:40.0 Training Hours:10 Bonus:82.00";
        assertEquals(fb,  expected, teamLeader1.toString());
  
        expected = "Name:Kristen Stewart ID:352-J Hired:10/4/1999 Shift:DAY" 
            + " Payrate:19.25 Hours:40.0 Training Hours:5 Bonus:45.00";      
        assertEquals(fb,  expected, teamLeader2.toString());

        expected = "Name:Dakota Fanning ID:562-R Hired:12/25/2005 Shift:NIGHT" 
            + " Payrate:22.00 Hours:38.0 Training Hours:20 Bonus:34.00";      
        assertEquals(fb,  expected, teamLeader3.toString());

        expected = "Name:Halle Berry ID:734-K Hired:11/11/2011 Shift:NIGHT" 
            + " Payrate:21.50 Hours:42.0 Training Hours:12 Bonus:193.00";      
        assertEquals(fb,  expected, teamLeader4.toString());
        
        String method = getMethodFromFile("TeamLeader.java", 
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
        String fb = "Error testing computeWeeklyPay in TeamLeader.\n";
        
        TeamLeader teamLeader1 = new TeamLeader(
            "Morgan Freeman", "867-T", "2/1/2001", 
            ShiftType.DAY, 17.25, 40, 10, 82.00);    
        TeamLeader teamLeader2 = new TeamLeader(
            "Kristen Stewart", "352-J", "10/4/1999",
            ShiftType.DAY, 19.25, 40, 5, 45.00);    
        TeamLeader teamLeader3 = new TeamLeader(
            "Dakota Fanning", "562-R", "12/25/2005",
            ShiftType.NIGHT, 22.00, 38, 20, 34.00);
        TeamLeader teamLeader4 = new TeamLeader(
            "Halle Berry", "734-K", "11/11/2011",
            ShiftType.NIGHT, 21.50, 42, 12, 193.00); 
                
        assertEquals(fb, 772.00, teamLeader1.computeWeeklyPay(), 0.01); 
        assertEquals(fb + "Do not modify the trainingHours field.\n", 10, 
            teamLeader1.getTrainingHours()); 
        assertEquals(fb + "Do not modify the weeklyBonus field.\n", 82.00, 
            teamLeader1.getWeeklyBonus(), DELTA); 

        assertEquals(fb, 815.00, teamLeader2.computeWeeklyPay(), 0.01); 
        assertEquals(fb + "Do not modify the trainingHours field.\n", 5, 
            teamLeader2.getTrainingHours()); 
        assertEquals(fb + "Do not modify the weeklyBonus field.\n", 45.00, 
            teamLeader2.getWeeklyBonus(), DELTA); 

            
        assertEquals(fb, 870.00, teamLeader3.computeWeeklyPay(), 0.01); 
        assertEquals(fb + "Do not modify the trainingHours field.\n", 20, 
            teamLeader3.getTrainingHours()); 
        assertEquals(fb + "Do not modify the weeklyBonus field.\n", 34.00, 
            teamLeader3.getWeeklyBonus(), DELTA); 

        assertEquals(fb, 1117.50, teamLeader4.computeWeeklyPay(), 0.01); 
        assertEquals(fb + "Do not modify the trainingHours field.\n", 12, 
            teamLeader4.getTrainingHours()); 
        assertEquals(fb + "Do not modify the weeklyBonus field.\n", 193.00, 
            teamLeader4.getWeeklyBonus(), DELTA); 
 
    }
    
    /**
     * Check the arg constructor to ensure it does not
     * allow out of bounds data.  
     */    
    @Test
    public void checkMutatorLimits005()
    {
        String fb = "Error in TeamLeader mutator.\n";
        int trainingHours = 0;
        double weeklyBonus = 0;
        TeamLeader teamLeader = null;
        
        teamLeader = new TeamLeader("", "", "", ShiftType.DAY, 0.0, 0.0,
            2, 2.0); 
        teamLeader.setTrainingHours(0);
        teamLeader.setWeeklyBonus(0.0);        
        trainingHours = teamLeader.getTrainingHours();
        weeklyBonus = teamLeader.getWeeklyBonus();
        
        assertTrue(fb + "Set training hours to 2 then changed to 0.\n"
            + "Expected: 0  Your value: " + trainingHours + "\n",  
            trainingHours == 0);

        assertTrue(fb + "Set weekly bonus to 2.0 then changed to 0.0.\n"
            + "Expected: 0.0  Your value: " + weeklyBonus + "\n",  
            weeklyBonus >= 0 && weeklyBonus < 0.00001);            
            
        teamLeader = new TeamLeader("", "", "", ShiftType.DAY, 0.0, 0.0,
            39, 999.0);                
        teamLeader.setTrainingHours(40);
        teamLeader.setWeeklyBonus(1000.0);
        trainingHours = teamLeader.getTrainingHours();
        weeklyBonus = teamLeader.getWeeklyBonus();       
     
        assertTrue(fb + "Set training hours to 39 then changed to 40.\n"
            + "Expected: 40  Your value: " + trainingHours + "\n",  
            trainingHours == 40);

        assertTrue(fb + "Set weekly bonus to 999.0 then changed to 1000.0.\n"
            + "Expected: 10000.0  Your value: " + weeklyBonus + "\n",  
            weeklyBonus > 999.99999 && weeklyBonus <= 1000.0);
            
        teamLeader = new TeamLeader("", "", "", ShiftType.DAY, 0.0, 0.0,
            0, 0.0);                
        teamLeader.setTrainingHours(-1);
        teamLeader.setWeeklyBonus(-0.1);   
        trainingHours = teamLeader.getTrainingHours();
        weeklyBonus = teamLeader.getWeeklyBonus();        
       
        assertTrue(fb + "Set training hours to -1.\n"
            + "Expected: 0  Your value: " + trainingHours + "\n",  
            trainingHours == 0);

        assertTrue(fb + "Set weekly bonus to -0.1.\n"
            + "Expected: 0.0  Your value: " + weeklyBonus + "\n",  
            weeklyBonus >= 0 && weeklyBonus < 0.00001);    
            
        teamLeader = new TeamLeader("", "", "", ShiftType.DAY, 0.0, 0.0,
            40, 1000.0);                
        teamLeader.setTrainingHours(41);
        teamLeader.setWeeklyBonus(1000.1);          
        trainingHours = teamLeader.getTrainingHours();
        weeklyBonus = teamLeader.getWeeklyBonus();        

        assertTrue(fb + "Set training hours to 41.\n"
            + "Expected: 40  Your value: " + trainingHours + "\n",  
            trainingHours == 40);

        assertTrue(fb + "Set weekly bonus to 1000.1.\n"
            + "Expected: 1000.0  Your value: " + weeklyBonus + "\n",  
            weeklyBonus > 999.99999 && weeklyBonus <= 1000.0);
    }
    
    /**
     * Check the arg constructor to ensure it does not
     * allow out of bounds data.  
     */    
    @Test
    public void checkConstructorLimits006()
    {
        String fb = "Error in TeamLeader arg constructor.\n";
        int trainingHours = 0;
        double weeklyBonus = 0;
        TeamLeader teamLeader = null;
        
        teamLeader = new TeamLeader("", "", "", ShiftType.DAY, 0.0, 0.0,
            0, 0.0);                
        trainingHours = teamLeader.getTrainingHours();
        weeklyBonus = teamLeader.getWeeklyBonus();
        
        assertTrue(fb + "Set training hours to 0.\n"
            + "Expected: 0  Your value: " + trainingHours + "\n",  
            trainingHours == 0);
            
        assertTrue(fb + "Set weekly bonus to 0.0.\n"
            + "Expected: 0.0  Your value: " + weeklyBonus + "\n",  
            weeklyBonus >= 0 && weeklyBonus < 0.00001);            
            
        teamLeader = new TeamLeader("", "", "", ShiftType.DAY, 0.0, 0.0,
            40, 1000.0);                
        trainingHours = teamLeader.getTrainingHours();
        weeklyBonus = teamLeader.getWeeklyBonus();
        
        assertTrue(fb + "Set training hours to 40.\n"
            + "Expected: 40  Your value: " + trainingHours + "\n",  
            trainingHours == 40);

        assertTrue(fb + "Set weekly bonus to 1000.0.\n"
            + "Expected: 1000.0  Your value: " + weeklyBonus + "\n",  
            weeklyBonus > 999.99999 && weeklyBonus <= 1000.0);
            
        teamLeader = new TeamLeader("", "", "", ShiftType.DAY, 0.0, 0.0,
            -1, -0.1);                
        trainingHours = teamLeader.getTrainingHours();
        weeklyBonus = teamLeader.getWeeklyBonus();
        
        assertTrue(fb + "Set training hours to -1.\n"
            + "Expected: 0  Your value: " + trainingHours + "\n",  
            trainingHours == 0);

        assertTrue(fb + "Set weekly bonus to -0.1.\n"
            + "Expected: 0.0  Your value: " + weeklyBonus + "\n",  
            weeklyBonus >= 0.0 && weeklyBonus < 0.00001);    
            
        teamLeader = new TeamLeader("", "", "", ShiftType.DAY, 0.0, 0.0,
            41, 1000.1);                
        trainingHours = teamLeader.getTrainingHours();
        weeklyBonus = teamLeader.getWeeklyBonus();
        
        assertTrue(fb + "Set training hours to 41.\n"
            + "Expected: 40  Your value: " + trainingHours + "\n",  
            trainingHours == 40);

        assertTrue(fb + "Set weekly bonus to 1000.1.\n"
            + "Expected: 1000.0  Your value: " + weeklyBonus + "\n",  
            weeklyBonus > 999.99999 && weeklyBonus <= 1000.0);
    }    
    
    
    /**
     * Check the arg constructor using parameters.
     * @param name The value to use when checking the constructor.
     * @param idNumber The value to use when checking the constructor.
     * @param hireDate The value to use when checking the constructor.
     * @param shift The value to use when checking the constructor.
     * @param hourlyPayRate The value to use when checking the constructor.
     * @param hoursWorked The value to use when checking the constructor.
     * @param trainingHours The value to use when checking the constructor.
     * @param weeklyBonus The value to use when checking the constructor.
     */    
    public void checkArgConstructor(
        String name, String idNumber, String hireDate,
        ShiftType shift, double hourlyPayRate, double hoursWorked,
        int trainingHours, double weeklyBonus)
    {
        String fb = "Error in TeamLeader no-arg constructor.\n";
        fb += "shift should be initialized to DAY.\n";
        fb += "String fields must be empty strings.\n";
        fb += "None of the fields should be left null.\n";
        TeamLeader teamLeader = new TeamLeader(name, idNumber, 
            hireDate, shift, hourlyPayRate, hoursWorked, 
            trainingHours, weeklyBonus);
        
        assertNotNull(fb + "name is null.\n", 
            teamLeader.getName());
        assertNotNull(fb + "idNumber is null.\n" , 
            teamLeader.getIdNumber());
        assertNotNull(fb + "hireDate is null.\n" , 
            teamLeader.getHireDate());
        assertNotNull(fb + "shift is null.\n" , 
            teamLeader.getShift());
        
        assertEquals(fb + "name is wrong.\n" , name, 
            teamLeader.getName());
        assertEquals(fb + "idumber is wrong.\n" , idNumber, 
            teamLeader.getIdNumber());
        assertEquals(fb + "hireDate is wrong.\n" , hireDate, 
            teamLeader.getHireDate());
        assertEquals(fb + "shift is wrong.\n" , shift, 
            teamLeader.getShift());        
        assertEquals(fb + "hourlyPayRate is wrong.\n" , hourlyPayRate, 
            teamLeader.getHourlyPayRate(), DELTA);        
        assertEquals(fb + "hoursWorked is wrong.\n" , hoursWorked, 
            teamLeader.getHoursWorked(), DELTA);   
        assertEquals(fb + "trainingHours is wrong.\n" , trainingHours, 
            teamLeader.getTrainingHours());        
        assertEquals(fb + "weeklyBonus is wrong.\n" , weeklyBonus, 
            teamLeader.getWeeklyBonus(), DELTA);            
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
