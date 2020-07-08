
/**
 * Write a description of class ShapeFun here.
 * 
 * @author (Aaron Mosteller) 
 * @version 0.1 (a version number or a date)
 */
public class ShapeFun
{

    /**
     * This is the main method, creates and interacts 
     * with shapes.
     * @param args **This allows methods to be passed**
     */
    public static void main(String[]args)
    {
        Square square = new Square();
        square.makeVisible();
        square.moveHorizontal(-60);
        square.moveVertical(-50);
        square.changeSize(300);
        square.changeColor("green");
        Circle circle = new Circle();
        circle.makeVisible();
        Triangle triangle = new Triangle();
        triangle.makeVisible();
        triangle.moveHorizontal(100);
        triangle.changeColor("orange");
    }    
}

