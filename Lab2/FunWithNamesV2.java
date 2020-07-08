
/**
 * Write a description of class FunWithNamesV2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FunWithNamesV2
{
    static void main(String[] args)
    {
        System.out.println("Enter your first name: ");
        String firstName = Given.getString();
        System.out.println("Enter your middle name: ");
        String middleName = Given.getString();
        System.out.println("Enter your last name: ");
        String lastName = Given.getString();
        String fullName = (firstName + " " +middleName + " " +lastName);
        int characterCount = (firstName.length() + middleName.length() + lastName.length());
        String login = (lastName.toLowerCase()+firstName.toLowerCase().charAt(0)+middleName.toLowerCase().charAt(0));
        System.out.println( "Name: " + fullName + '\n' + "Number of characters in full name: " + characterCount + '\n' + "Login id: " + login); 
    }
    }
