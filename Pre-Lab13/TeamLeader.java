/**
 * TeamLeader.java
 * 
 */


//Put any imports below this line.
 
 
/**
 * Short, one-line description of TeamLeader class here.
 * 
 * Optionally, include a paragraph that provides a more 
 * detailed description.
 *
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TeamLeader extends ProductionWorker
{
    //Put instance variables below this line.  
    
    private int trainingHours;
    private double weeklyBonus;
    /**
     * No parameter constructor for objects of class TeamLeader.
     */
    public TeamLeader()
    {
        trainingHours = 10;
        weeklyBonus = 50;
    }
    
    /**
     *  Parameter constructor for objects of class TeamLeader.
     *  @param name **name**
     *  @param idNumber **id number**
     *  @param hireDate **hire date**
     *  @param shift **shift**
     *  @param hourlyPayRate **hourlyPayRate**
     *  @param hoursWorked **hours worked**
     *  @param trainingHours **trainingHours**
     *  @param weeklyBonus **weeklyBonus**
     */
    public TeamLeader(String name, String idNumber,
        String hireDate, ShiftType shift,
        double hourlyPayRate, double hoursWorked,
        int trainingHours, double weeklyBonus)
    {
        super(name, idNumber, hireDate, shift, 
            hourlyPayRate, hoursWorked);
        if (trainingHours < 0)
        {
            trainingHours = 0;
        }
        if (trainingHours > 40)
        {
            trainingHours = 40;
        }
        if (weeklyBonus < 0)
        {
            weeklyBonus = 0;
        }
        if (weeklyBonus > 1000)
        {
            weeklyBonus = 1000;
        }
        this.trainingHours = trainingHours;
        this.weeklyBonus = weeklyBonus;
    }
    /**
     * Method getTrainingHours.
     * @return trainingHours
     * 
     */
    public int getTrainingHours()
    {
        return trainingHours;
    
    }
    /**
     * Method setTrainingHours.
     * 
     * @param  trainingHours  **trainingHours**
     * 
     */
    public void setTrainingHours(int trainingHours)
    {
        if (trainingHours < 0)
        {
            trainingHours = 0;
        }
        if (trainingHours > 40)
        {
            trainingHours = 40;
        }
        this.trainingHours = trainingHours;
    }
    
    /**
     * Method getWeeklyBonus.
     * @return weeklyBonus
     * 
     */
    public double getWeeklyBonus()
    {
        return weeklyBonus;
    
    }
    /**
     * Method setWeeklyBonus.
     * 
     * @param  weeklyBonus  **weeklyBonus**
     * 
     */
    public void setWeeklyBonus(double weeklyBonus)
    {
        if (weeklyBonus < 0)
        {
            weeklyBonus = 0;
        }
        if (weeklyBonus > 1000)
        {
            weeklyBonus = 1000;
        }
        this.weeklyBonus = weeklyBonus;
    }
    
    /**
     * Method toString.
     * @return str
     */
    public String toString()
    {
        String str = String.format(" Training Hours:%1d Bonus:%.2f",
            getTrainingHours(), getWeeklyBonus());
        
        return super.toString() + str;
    }
    /**
     * Method computeWeeklyPay.
     * @return 0
     */
    public double computeWeeklyPay()
    {
        double weeklyPay = weeklyBonus;
        
        return super.computeWeeklyPay() + weeklyBonus;

    }
}
