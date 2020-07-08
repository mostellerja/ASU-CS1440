/**
 * TestEmployee.java
 */

//Put any imports below this line.
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 * Test WeatherMonth activity 1.
 * 
 * @author Joel Swanson
 * @version 03.14.2014
 */
public class TestEmployee
{
    
    /**
     * Check the no arg constructor.
     */
    @Test
    public void checkNoArgConstructor001()
    {   
        //Make sure the prelab is passing.
        TestPrelab testPrelab = new TestPrelab();
        testPrelab.checkAll();        
        
        String fb = "Error in Employee no-arg constructor.\n";
        fb += "shift should be initialized to DAY.\n";
        fb += "String fields must be empty strings.\n";
        fb += "None of the fields should be left null.\n";
        Employee employee = new Employee();
        
        assertNotNull(fb + "name is null.\n", 
            employee.getName());
        assertNotNull(fb + "idNumber is null.\n" , 
            employee.getIdNumber());
        assertNotNull(fb + "hireDate is null.\n" , 
            employee.getHireDate());
        assertNotNull(fb + "shift is null.\n" , 
            employee.getShift());
        
        assertEquals(fb + "name is wrong.\n" , "", 
            employee.getName());
        assertEquals(fb + "idumber is wrong.\n" , "", 
            employee.getIdNumber());
        assertEquals(fb + "hireDate is wrong.\n" , "", 
            employee.getHireDate());
        assertEquals(fb + "shift is wrong.\n" , 
            ShiftType.DAY, employee.getShift());
    }  
    
    /**
     * Check the arg constructor.
     */
    @Test
    public void checkArgConstructor002()
    {
        checkArgConstructor("Emma Watson", "123-A",
            "12/1/2012", ShiftType.DAY);
        checkArgConstructor("Keith Urban", "234-B",
            "11/4/2002", ShiftType.DAY);
        checkArgConstructor("Will Smith", "424-C",
            "3/21/2008", ShiftType.NIGHT);
        checkArgConstructor("Jennifer Lawrence", "864-Z",
            "4/2/2006", ShiftType.NIGHT);

    }
    
    /**
     * Check the toString method.
     */   
    @Test
    public void checkToString003()
    {
        Employee employee1 = new Employee("Emma Watson", "123-A",
            "12/1/2012", ShiftType.DAY);    
        Employee employee2 = new Employee("Keith Urban", "234-B",
            "11/4/2002", ShiftType.DAY);    
        Employee employee3 = new Employee("Will Smith", "424-C",
            "3/21/2008", ShiftType.NIGHT);
        Employee employee4 = new Employee("Jennifer Lawrence", "864-Z",
            "4/2/2006", ShiftType.NIGHT);

        String expected;
        String fb = "Error testing toString in Employee.\n";
        
        expected = "Name:Emma Watson ID:123-A Hired:12/1/2012 Shift:DAY";      
        assertEquals(fb,  expected, employee1.toString());

        expected = "Name:Will Smith ID:424-C Hired:3/21/2008 Shift:NIGHT";      
        assertEquals(fb,  expected, employee3.toString());
    }
    
    /**
     * Check the calculations for computing weekly pay.
     */
    @Test
    public void checkComputeWeeklyPay004()
    {
        Employee employee1 = new Employee("Emma Watson", "123-A",
            "12/1/2012", ShiftType.DAY);    
        Employee employee2 = new Employee("Keith Urban", "234-B",
            "11/4/2002", ShiftType.DAY);    
        Employee employee3 = new Employee("Will Smith", "424-C",
            "3/21/2008", ShiftType.NIGHT);
        Employee employee4 = new Employee("Jennifer Lawrence", "864-Z",
            "4/2/2006", ShiftType.NIGHT);        
        
        Employee employee;
        String fb = "Error testing computeWeeklyPay in Employee.\n";
        
        assertEquals(fb, 0.0, employee1.computeWeeklyPay(), 0.000001);
        assertEquals(fb, 0.0, employee3.computeWeeklyPay(), 0.000001);
    }
    
    /**
     * Check the arg constructor using parameters.
     * @param name Check constructor using this given value.
     * @param idNumber Check constructor using this given value.
     * @param hireDate Check constructor using this given value.
     * @param shift Check constructor using this given value.
     */    
    public void checkArgConstructor(String name, String idNumber, 
        String hireDate, ShiftType shift)
    {
        String fb = "Error in Employee argument constructor.\n";
        fb += "shift should be initialized to DAY.\n";
        fb += "String fields must be empty strings.\n";
        fb += "None of the fields should be left null.\n";
        Employee employee = new Employee(name, idNumber, 
            hireDate, shift);
        
        assertNotNull(fb + "name is null.\n", 
            employee.getName());
        assertNotNull(fb + "idNumber is null.\n" , 
            employee.getIdNumber());
        assertNotNull(fb + "hireDate is null.\n" , 
            employee.getHireDate());
        assertNotNull(fb + "shift is null.\n" , 
            employee.getShift());
        
        assertEquals(fb + "name is wrong.\n" , name, 
            employee.getName());
        assertEquals(fb + "idumber is wrong.\n" , idNumber, 
            employee.getIdNumber());
        assertEquals(fb + "hireDate is wrong.\n" , hireDate, 
            employee.getHireDate());
        assertEquals(fb + "shift is wrong.\n" , shift, 
            employee.getShift());
        
    }
    

}
