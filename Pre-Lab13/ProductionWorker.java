/**
 * ProductionWorker.java
 * 
 */


//Put any imports below this line.
 
 
/**
 * Short, one-line description of ProductionWorker class here.
 * 
 * Optionally, include a paragraph that provides a more 
 * detailed description.
 *
 * @author (Aaron Mosteller) 
 * @version (11/29/2018)
 */
public class ProductionWorker extends Employee
{
    //Put instance variables below this line.  
    
    private double hourlyPayRate;
    private double hoursWorked;
    /**
     * No parameter constructor for objects of class ProductionWorker.
     */
    public ProductionWorker()
    {
        hourlyPayRate = 7.25;
        hoursWorked = 40;
    }
    
    /**
     *  Parameter constructor for objects of class ProductionWorker.
     *  @param name **name**
     *  @param idNumber **id number**
     *  @param hireDate **hire date**
     *  @param shift **shift**
     *  @param hourlyPayRate **hourlyPayRate**
     *  @param hoursWorked **hours worked**
     */
    public ProductionWorker(String name, String idNumber,
        String hireDate, ShiftType shift,
        double hourlyPayRate, double hoursWorked)
    {
        
        super(name, idNumber, hireDate, shift);
        if (hourlyPayRate < 7.25)
        {
            hourlyPayRate = 7.25;
        }
        if (hourlyPayRate > 25)
        {
            hourlyPayRate = 25;
        }
        if (hoursWorked < 0)
        {
            hoursWorked = 0;
        }
        if (hoursWorked > 70)
        {
            hoursWorked = 70;
        }
        this.hourlyPayRate = hourlyPayRate;
        this.hoursWorked = hoursWorked;
        
    }
    /**
     * Method getHourlyPayRate.
     * @return hourlyPayRate
     * 
     */
    public double getHourlyPayRate()
    {
        return hourlyPayRate;
    
    }
    /**
     * Method setHourlyPayRate.
     * 
     * @param  hourlyPayRate  **hourlyPayRate**
     * 
     */
    public void setHourlyPayRate(double hourlyPayRate)
    {
        
        
        if (hourlyPayRate < 7.25)
        {
            hourlyPayRate = 7.25;
        }
        if (hourlyPayRate > 25)
        {
            hourlyPayRate = 25;
        }
        
        
        
        this.hourlyPayRate = hourlyPayRate;
    }
    
    /**
     * Method getHoursWorked.
     * @return hoursWorked
     * 
     */
    public double getHoursWorked()
    {
        return hoursWorked;
    
    }
    /**
     * Method setHoursWorked.
     * 
     * @param  hoursWorked  **id number**
     * 
     */
    public void setHoursWorked(double hoursWorked)
    {
        if (hoursWorked < 0)
        {
            hoursWorked = 0;
        }
        if (hoursWorked > 70)
        {
            hoursWorked = 70;
        }
        this.hoursWorked = hoursWorked;
    }
    
    /**
     * Method toString.
     * @return str
     */
    public String toString()
    {
        String str = String.format(" Payrate:%.2f Hours:%.1f", 
            getHourlyPayRate(), getHoursWorked());
        
        return super.toString() + str;
    }
    /**
     * Method computeWeeklyPay.
     * @return 0
     */
    public double computeWeeklyPay()
    {
        double weeklyPay = 0;
        double overTime = hoursWorked - 40;
        if (hoursWorked > 40)
        {
            weeklyPay = (hourlyPayRate * 1.5 * overTime) + 40 * hourlyPayRate;
            
            return weeklyPay;
        }
        if (hoursWorked <= 40)
        {
            weeklyPay = hourlyPayRate * hoursWorked;
        
            return weeklyPay;
        }
        return weeklyPay;
    }

}
