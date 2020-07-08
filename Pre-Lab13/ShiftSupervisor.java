/**
 * ShiftSupervisor.java
 * 
 */


//Put any imports below this line.
 
 
/**
 * Short, one-line description of ShiftSupervisor class here.
 * 
 * Optionally, include a paragraph that provides a more 
 * detailed description.
 *
 * @author (Aaron Mosteller) 
 * @version (11/29/2018)
 */
public class ShiftSupervisor extends Employee
{
    //Put instance variables below this line.  
    
    private double annualSalary;
    private double annualBonus;
    /**
     * No parameter constructor for objects of class ShiftSupervisor.
     */
    public ShiftSupervisor()
    {
        annualSalary = 25000;
        annualBonus = 1200;
    }
    /**
     *  Parameter constructor for objects of class ShiftSupervisor.
     *  @param name **name**
     *  @param idNumber **id number**
     *  @param hireDate **hire date**
     *  @param shift **shift**
     *  @param annualSalary **annualSalary**
     *  @param annualBonus **annualBonus**
     */
    public ShiftSupervisor(String name, String idNumber,
        String hireDate, ShiftType shift,
        double annualSalary, double annualBonus)
    {
        super(name, idNumber, hireDate, shift);
         
        if (annualSalary < 0)
        {
            annualSalary = 0;
        }
        if (annualSalary > 50000)
        {
            annualSalary = 50000;
        }
        if (annualBonus < 0)
        {
            annualBonus = 0;
        }
        if (annualBonus > 10000)
        {
            annualBonus = 10000;
        }
         
        this.annualSalary = annualSalary;
        this.annualBonus = annualBonus;
    }
    /**
     * Method getAnnualSalary.
     * @return annualSalary
     * 
     */
    public double getAnnualSalary()
    {
        return annualSalary;
    
    }
    /**
     * Method setAnnualSalary.
     * 
     * @param  annualSalary  **annualSalary**
     * 
     */
    public void setAnnualSalary(double annualSalary)
    {
        if (annualSalary < 0)
        {
            annualSalary = 0;
        }
        if (annualSalary > 50000)
        {
            annualSalary = 50000;
        }
        this.annualSalary = annualSalary;
    }
    
    /**
     * Method getAnnualBonus.
     * @return annualBonus
     * 
     */
    public double getAnnualBonus()
    {
        return annualBonus;
    
    }
    /**
     * Method setAnnualBonus.
     * 
     * @param  annualBonus  **annualBonus**
     * 
     */
    public void setAnnualBonus(double annualBonus)
    {
        if (annualBonus < 0)
        {
            annualBonus = 0;
        }
        if (annualBonus > 10000)
        {
            annualBonus = 10000;
        }
        this.annualBonus = annualBonus;
    }
    
    /**
     * Method toString.
     * @return str
     */
    public String toString()
    {
        String str = String.format(" Salary:%.2f Bonus:%.2f", 
            getAnnualSalary(), getAnnualBonus());
        
        return super.toString() + str;
    }
    /**
     * Method computeWeeklyPay.
     * @return 0
     */
    public double computeWeeklyPay()
    {
        double weeklyPay = annualSalary + annualBonus;
        
        return weeklyPay / 52;
    }

}
