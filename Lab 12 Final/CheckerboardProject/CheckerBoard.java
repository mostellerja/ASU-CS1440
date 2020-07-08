import java.util.ArrayList;

/**
 * CheckerBoard class.
 * @author Aaron Mosteller
 * @version 11/27/2018
 */
public class CheckerBoard
{
    private ArrayList<Row> rowList;

    /**
     * No-arg constructor.
     */
    public CheckerBoard()
    {
        rowList = new ArrayList<Row>();   
        for (int i = 0; i < 8; i++)
        {
            rowList.add(new Row(i));
        }

        reverseColors();
    }

    /**
     * Method reverses color of squares.
     */
    public void reverseColors()
    {
        for (int i = 0; i < rowList.size(); i++)
        {    
            if (i % 2 == 1)
            {
                rowList.get(i).reverseColors();
            }
            
        }
    }

    /**
     * Method for delaying.
     * @param waitAmountMillis **delay time amount**
     */
    public void delay(long waitAmountMillis)
    {

    }

    /**
     * Extra Credit Method.
     */
    public void extraCreditAnimation()
    {

    }

    /**
     * Accessor for getRowList.
     * @return rowList
     */
    public ArrayList<Row> getRowList()
    {
        return rowList;
    }

    /**
     * Mutator for setRowList.
     * @param rowList **row list**
     */
    public void setRowList(ArrayList<Row> rowList)
    {
        this.rowList = rowList;
    }
}
