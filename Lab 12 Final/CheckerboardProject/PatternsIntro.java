/**
 * Patterns Intro class.
 * @author Aaron Mosteller
 * @version 11/27/2018
 */
public class PatternsIntro
{
    /**
     * No-arg Constructor for PatternsIntro Class.
     */
    public PatternsIntro()
    {
        tediousTenSquares();
        tenSquaresWhileLoop();
        tenSquaresForLoop();
        rowOfSquares(8, "black", 100, 300, 30, 20);
    }

    /**
     * Creates a row of 10 blue squares, each is 40x40 pixels, repeated every 50
     * pixels on the x-axis. The top-left corner of the row is at (x,y) =
     * (100,100)
     */
    public void tediousTenSquares() 
    {
        new Square(100, 100, 40, "blue");
        new Square(150, 100, 40, "blue");
        new Square(200, 100, 40, "blue");
        new Square(250, 100, 40, "blue");
        new Square(300, 100, 40, "blue");
        new Square(350, 100, 40, "blue");
        new Square(400, 100, 40, "blue");
        new Square(450, 100, 40, "blue");
        new Square(500, 100, 40, "blue");
        new Square(550, 100, 40, "blue");
    }

    /**
     * While Loop 10 squares.
     * 
     */
    public void tenSquaresWhileLoop()
    {
        int x = 100;
        int i = 0;
        while (i < 10)
        {
            new Square(x, 200, 20, "red");
            x += 50;
            i++;
        }
    }

    /**
     * For Loop 10 squares.
     * 
     */
    public void tenSquaresForLoop() 
    {
        int x = 100;
        for (int i = 0; i < 10; i++)
        {
            new Square(x, 250, 20, "green");
            x += 50;
        }
    }

    /**
     * Method has for loop for row of Squares.
     * @param numSquares **Number of Squares**
     * @param color **Color String**
     * @param x **X position**
     * @param y **Y position**
     * @param size **size of square**
     * @param spacing **space between squares**
     */
    public void rowOfSquares(int numSquares, String color,
        int x, int y, int size, int spacing)
    {
        for (int i = 0; i < numSquares; i++)
        {
            new Square(x, y, size, color);
            x += size + spacing;
        }
    }
}
