
/**
 * Write a description of class Sales here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sales
{
    static void main(String [] args)
    {
        System.out.println("Enter a purchase amount: ");
        double purchaseAmount = Given.getDouble();
        double stateTax= purchaseAmount*.05;
        double countyTax= purchaseAmount*.03;
        double totalTax= stateTax+countyTax;
        double totalPrice= totalTax+purchaseAmount;

        System.out.println("Amount of Purchase:" + '\t'+"$" + purchaseAmount + '\n' + "State Sales Tax Paid:" + '\t'+"$" +stateTax + '\n' + "County Sales Tax Paid:" + '\t'+"$" + countyTax + '\n' + "Total Sales Tax Paid:"+ '\t'+"$" + totalTax + '\n' + "Total Sales Price:" + '\t'+"$"+ totalPrice);
    }
}
