/**
 * PayStub.java
 * 
 */

import java.util.Scanner;
/**
 * ActivityPayStub class is part of Lab 3 and
 * creates a simple pay stub.
 *
 * @author (Aaron Mosteller)
 * @version 0.1 (9/28/2018)
 */
public class PayStub
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
     * This method contains the field to use all basic "steps" to make paystub.
     * @param keyboard **this is the id of scanner**
     */
    public PayStub(Scanner keyboard)
    {        
        getInput(keyboard);
        keyboard.nextLine();
        calculate();
    }    

    /**
     * It all starts with the main method.
     *
     * @param args command-line arguments (not used)
     *
     */
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        PayStub aaron = new PayStub(keyboard);
        aaron.printPayStub();
        PayStub gracie = new PayStub(keyboard);
        gracie.printPayStub();
        gracie.setHourlyRate(20.0);
        gracie.calculate();
        gracie.printPayStub(); 
        System.out.printf("New gross pay: $%-8.2f\n", gracie.getgrossPay());
        PayStub andrew = new PayStub(keyboard);
        andrew.printPayStub();
    }            

    /**
     * This method contains an accessor to get overHours.
     * @return **this is id of returning overHours**
     */
    public int getoverHours()
    {
        return overHours;
    }

    /**This contains the accessor for grossPay.
     * @return **this returns grossPay value**
     * 
     */
    public double getgrossPay()
    {
        return grossPay;
    }

    /**This is a mutator for overHours.
     * @param newValue **this is the id for mutator of overHours**
     */
    public void setoverHours(int newValue)
    {
        if (newValue >= 0)
        {
            overHours = newValue;
            calculate();
        }
    }

    /**This method sets the pay for the three users.
     * @param newValue **this is the id of the parameter**
     * 
     * 
     */
    public void setgrossPay(int newValue)
    {
        if (newValue >= 0)
        {
            grossPay = newValue;
            calculate();
        }
    }    

    /**
     * This method grabs the user input from the scanner.
     * @param keyboard **this is id of scanner**
     * 
     */
    private void getInput(Scanner keyboard)        
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

    private void calculate()
    {
        regPay = regHours * hourlyRate;                
        overRate = hourlyRate * OVERTIME_RATE;        
        overPay = overHours * OVERTIME_RATE * hourlyRate;
        grossPay = regPay + overPay;
        ssWith = grossPay * SS_WITHHOLDING; 
        fedTax = (grossPay - ssWith) * FEDERAL_TAX; 
        netPay = grossPay - ssWith - fedTax;      
    }    

    /**This mutator sets a newRate for hourlyRate.
     * @param newRate **this is the id for mutator of hourlyRate**
     */

    public void setHourlyRate(double newRate)
    {
        if (newRate >= 0)
        {
            hourlyRate = newRate;

        }
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

