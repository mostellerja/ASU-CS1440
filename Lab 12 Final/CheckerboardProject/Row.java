import java.util.ArrayList;

/**
 * Row class.
 * @author Aaron Mosteller
 * @version 11/27/2018
 */
public class Row
{
    private ArrayList<Square> sqList;

    /**
     * No-arg Constructor for Row.
     */
    public Row()
    {
        sqList = new ArrayList<Square>();
        delay(400);
        addSquaresToList();
        delay(400);
        changeSquareSize(48);
        delay(400);
        changeEvenToBlack();
        
    }

    /**
     * Arg Constructor for Row.
     * @param rowNumber **number of Rows**
     */
    public Row(int rowNumber)
    {                
        sqList = new ArrayList<Square>();
        addSquaresToList();
        changeSquareSize(48);
        changeEvenToBlack();
        moveVertically(50 * rowNumber);
    }

    /**
     * Adds Squares to List.
     */
    public void addSquaresToList()
    {

        int x = 0;
        int i = 0;
        while (i < 8)
        {
            sqList.add(new Square(x, 0, 50, "red"));
            x += 50;
            i++;
        }

    }

    /**
     * Method moves vertically.
     * @param amountToMove **amount to move**
     */
    public void moveVertically(int amountToMove)
    {

        int i = 0;
        while (i < 8)
        {

            Square sq = sqList.get(i);
            sq.setY(sq.getY() + amountToMove);

            i++;
        }
    }

    /**
     * Method changes Square size.
     * @param size **size of Square**
     */
    public void changeSquareSize(int size)
    {
        for (Square sq : sqList)
        {
            sq.setSize(size);
        }
    }

    /**
     * Changes Even squares to black.
     */
    public void changeEvenToBlack()
    {
        int i;
        for (i = 0; i < sqList.size(); i++)
        {
            if (i % 2 == 0)
            {
                sqList.get(i).setColor("black");
            }

        }
    }

    /**
     * Changes Odd squares to black. 
     */
    public void changeOddToBlack()
    {
        int i;
        for (i = 0; i < sqList.size(); i++)
        {
            if (i % 2 == 1)
            {
                sqList.get(i).setColor("black");
            }
        }

    }

    /**
     * Method reverses color of squares.
     */
    public void reverseColors()
    {
        for (int i = 0; i < sqList.size(); i++)
        {
            if (i % 2 == 1)
            {
                sqList.get(i).setColor("black");
            }
            if (i % 2 == 0)
            {
                sqList.get(i).setColor("red");
            }

        }
        
        
    }



    /**
     * Method for delaying.
     * @param waitAmountMillis **amount of time to wait**
     * 
     */
    public void delay(long waitAmountMillis)
    {

        double delay = waitAmountMillis;
        double endTime = System.currentTimeMillis() + delay;

        while (System.currentTimeMillis() < endTime)
        {
            System.currentTimeMillis();
        }

    }

    /**
     * Acessor for ArrayList<Square>.
     * @return sqList
     */
    public ArrayList<Square> getSqList()
    {
        return sqList;
    }

    /**
     * Mutator for ArrayList<Square>.
     * @param sqList **Sqaure ArrayList**
     */
    public void setSqList(ArrayList<Square> sqList)
    {
        this.sqList = sqList;
    }
}
