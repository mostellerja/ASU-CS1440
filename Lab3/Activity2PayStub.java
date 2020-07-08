/**
 * Activity2PayStub.java
 * 
 */


import java.util.Scanner;
/**
 * Activity2PayStub class is part of Lab 3 and
 * creates a simple pay stub.
 *
 * @author (Aaron Mosteller)
 * @version 0.1 (9/28/2018)
 */
public class Activity2PayStub
{
    public static final double OVERTIME_RATE = 1.5;
    public static final double SS_WITHHOLDING = .1;
    public static final double FEDERAL_TAX = .2;
    private String name;
    private String ssn;
    private int regHours;
    private int overHours;    
    private double hourlyRate;    
    private double regPay;                    
    private double overRate;      
    private double overPay; 
    private double grossPay;
    private double ssWith;  
    private double fedTax; 
    private double netPay;    
    /**
     * It all starts with the main method.
     *
     * @param args command-line arguments (not used)
     *
     */

    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        //Create an Activity2Paystub object
        //a2ps is an Activity2PayStub object
        Activity2PayStub a2ps = new Activity2PayStub();
        //call the methods inside of an Activity2PayStub object
        a2ps.getInput(keyboard);
        a2ps.calculate();
        a2ps.printPayStub();

    }
    /**
     * This method grabs the user input from the scanner.
     * @param keyboard **this is id of scanner**
     * 
     */
    public void getInput(Scanner keyboard)        
    {                       
        System.out.print("Enter your name: ");
        name = keyboard.nextLine();          
        System.out.print("Enter your SSN: ");
        ssn = keyboard.nextLine();
        System.out.print("Enter your regular hours: ");
        regHours = keyboard.nextInt(); 
        System.out.print("Enter your overtime hours: ");
        overHours = keyboard.nextInt();
        System.out.print("Hourly pay rate: $");
        hourlyRate = keyboard.nextDouble();            
    }
    /**This method calculates the output from the given input from the Scanner.
     * 
     */
      
   
    public void calculate()
    {
        double regPay = regHours * hourlyRate;                
        double overRate = hourlyRate * OVERTIME_RATE;        
        double overPay = overHours * OVERTIME_RATE * hourlyRate;
        double grossPay = regPay + overPay;
        double ssWith = grossPay * SS_WITHHOLDING; 
        double fedTax = (grossPay - ssWith) * FEDERAL_TAX; 
        double netPay = grossPay - ssWith - fedTax;      
    }
    /**This method prints the Pay Stub, which files in the data
     *  from the calculate() method.
     */
    public void printPayStub()
    {
        System.out.println("___________________________________________________"
            + "_________________");                   
        String format = "Name: %-37s SSN: %-11s\n";        
        System.out.printf(format, name, ssn);   
        format = "Regular Hours: %-8d Reg Rate: $%-8.2f Reg Pay: $%-8.2f\n";
        System.out.printf(format, regHours, hourlyRate, regPay); 
        format = "Overtime Hours: %-8dOT Rate: $%-8.2f  OT Pay: $%-8.2f\n";
        System.out.printf(format, overHours, overRate, overPay);        
        format = "Gross Pay: $%-8.2f\n";
        System.out.printf(format, grossPay);
        format = "SS Withholding: $%-8.2f\n";                      
        System.out.printf(format, ssWith);  
        format = "Federal Tax: $%-8.2f\n";                      
        System.out.printf(format, fedTax);
        format = "Net Pay: $%-8.2f\n";                                         
        System.out.printf(format, netPay);  
        System.out.println("___________________________________________________"
            + "_________________");
    }
}
