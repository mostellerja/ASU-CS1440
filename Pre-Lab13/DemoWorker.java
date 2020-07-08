/**
 * DemoWorker.java
 * 
 */



 
import java.util.ArrayList;

/**
 * Short, one-line description of DemoWorker class here.
 * 
 * Optionally, include a paragraph that provides a more 
 * detailed description.
 *
 * @author (Aaron Mosteller) 
 * @version (11/29/2018)
 */
public class DemoWorker
{
    //Put instance variables below this line.  
    
    private ArrayList<Employee> employees;
    
    
    
    
    /**
     * No parameter constructor for objects of class DemoWorker.
     */
    public DemoWorker()
    {
        employees = new ArrayList<Employee>();
        
        employees.add(new ProductionWorker(
            "Emma Watson", "123-A", 
            "12/1/12", ShiftType.DAY, 7.25, 20));
        employees.add(new ShiftSupervisor(
            "Robert Downey Jr.", "345-D",
            "3/1/2010", ShiftType.NIGHT, 32000, 2000));
        employees.add(new TeamLeader(
            "Morgan Freeman", "867-T",
            "2/1/2001", ShiftType.DAY, 17.25, 
            40, 10, 82.00));
        
        for (int i = 0; i < employees.size(); i++)
        {
            System.out.println(employees.get(i).toString());
            
        }
        for (int i = 0; i < employees.size(); i++)
        {
            System.out.println(String.format("%s:%s:$%.2f",
                employees.get(i).getName(),
                employees.get(i).getIdNumber(),
                employees.get(i).computeWeeklyPay()));
        
        }
    } 
    
    /**
     * Main Methos.
     * @param args **allows args**
     */
    public static void main(String[] args)
    {
        new DemoWorker();
    }
    /**
     * @return employees
     */
    public ArrayList<Employee>getEmployees()
    {
        return employees;
    }
    
    /**
     * setEmployees.
     * 
     * @param employees **employees**
     * 
     */
    public void setEmployees(ArrayList<Employee> employees)
    {
        this.employees = employees;
    }

}
