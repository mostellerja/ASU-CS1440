/**
 * Employee.java
 * 
 */


//Put any imports below this line.
 
 
/**
 * Short, one-line description of Employee class here.
 * 
 * Optionally, include a paragraph that provides a more 
 * detailed description.
 *
 * @author (Aaron Mosteller) 
 * @version (11/29/2018)
 */
public class Employee
{
    //Put instance variables below this line.  
    
    private String name;
    private String idNumber;
    private String hireDate;
    private ShiftType shift;
    /**
     * No parameter constructor for objects of class Employee.
     */
    public Employee()
    {
        ShiftType shift = ShiftType.DAY;
        name = "";
        idNumber = "";
        hireDate = "";
        if (this.name == null)
        { 
            this.name = "";
        }
        if (this.idNumber == null)
        {
            this.idNumber = "";
        }
        
        if (this.hireDate == null)
        { 
            this.hireDate = "";
        }
        if (this.shift == null)
        {
            this.shift = shift;
        }
    }
    
    /**
     *  Parameter constructor for objects of class Employee.
     *  @param name **name**
     *  @param idNumber **id number**
     *  @param hireDate **hire date**
     *  @param shift **shift**
     * 
     */
    public Employee(String name, String idNumber,
        String hireDate, ShiftType shift)
    {
        
        this.name = name;
        this.idNumber = idNumber;
        this.hireDate = hireDate;
        this.shift = shift;
        
        if (this.name == null)
        { 
            this.name = "";
        }
        if (this.idNumber == null)
        {
            this.idNumber = "";
        }
        
        if (this.hireDate == null)
        { 
            this.hireDate = "";
        }
        if (this.shift == null)
        {
            this.shift = shift;
        }
    }
    /**
     * Method getName.
     * @return name
     * 
     */
    public String getName()
    {
        return name;
    
    }
    /**
     * Method setName.
     * 
     * @param  name  **name**
     * 
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * Method getIdNumber.
     * @return idNumber
     * 
     */
    public String getIdNumber()
    {
        return idNumber;
    
    }
    /**
     * Method setIdNumber.
     * 
     * @param  idNumber  **id number**
     * 
     */
    public void setIdNumber(String idNumber)
    {
        this.idNumber = idNumber;
    }

    /**
     * Method getHireDate.
     * @return hireDate
     * 
     */
    public String getHireDate()
    {
        return hireDate;
    
    }
    /**
     * Method setHireDate.
     * 
     * @param  hireDate  **hireDate**
     * 
     */
    public void setHireDate(String hireDate)
    {
        this.hireDate = hireDate;
    }

    /**
     * Method getShift.
     * @return shift
     * 
     */
    public ShiftType getShift()
    {
        return shift;
    
    }
    /**
     * Method setShift.
     * 
     * @param  shift  **shift**
     * 
     */
    public void setShift(ShiftType shift)
    {
        this.shift = shift;
    }
    /**
     * Method toString.
     * @return str
     */
    public String toString()
    {
        String str = "Name:" + getName() + " " + "ID:" + getIdNumber() 
            + " " + "Hired:" + getHireDate() + " " + "Shift:" + getShift();
        
        
        return str;
    }
    /**
     * Method computeWeeklyPay.
     * @return 0
     */
    public double computeWeeklyPay()
    {
        System.out.println("Other than when testing," 
            + "this method should never be called.");
        
        return 0;
    }
}
