/**
 * Activity1PayStub.java
 * 
 */




import java.util.Scanner;
/**
 * Activity1PayStub class is part of Lab 3 and
 * creates a simple pay stub.
 *
 * @author (Aaron Mosteller)
 * @version 0.1 (9/20/2018)
 */
public class Activity1PayStub
{
    public static final double OVERTIME_RATE = 1.5;
    public static final double SS_WITHHOLDING = .1;
    public static final double FEDERAL_TAX = .2;

    /**
     * It all starts with the main method.
     *
     * @param args command-line arguments (not used)
     */

    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = keyboard.nextLine(); 
        System.out.print("Enter your SSN: ");
        String ssn = keyboard.nextLine();
        int regHours;
        System.out.print("Enter your regular hours: ");
        regHours = keyboard.nextInt(); 
        int overHours;         
        System.out.print("Enter your overtime hours: ");
        overHours = keyboard.nextInt();
        double hourlyRate;         
        System.out.print("Hourly pay rate: $");
        hourlyRate = keyboard.nextDouble();              
        double regPay = regHours * hourlyRate;                
        double overRate = hourlyRate * OVERTIME_RATE;        
        double overPay = overHours * OVERTIME_RATE * hourlyRate;
        double grossPay = regPay + overPay;
        double ssWith = grossPay * SS_WITHHOLDING; 
        double fedTax = (grossPay - ssWith) * FEDERAL_TAX; 
        double netPay = grossPay - ssWith - fedTax;                           
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

