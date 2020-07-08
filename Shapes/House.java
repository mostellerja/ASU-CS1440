
/**
 * House.java.
 * 
 * @author (Aaron) 
 * @version (10/2/2018)
 */
public class House
{    
    private Square wall;
    private Triangle roof;
    private Square window;
    /**
     * Constructor for objects of class House.
     */
    public House()
    {
        wall = new Square();
        wall.makeVisible();   
        wall.changeSize(100);
        wall.moveVertical(150);
        wall.moveHorizontal(40);
        roof = new Triangle();
        roof.makeVisible();
        roof.setWidth(140);
        roof.setHeight(50);
        roof.moveVertical(135);
        roof.moveHorizontal(100);
        roof.changeColor("black");
        window = new Square();
        window.makeVisible();
        window.moveHorizontal(50);
        window.moveVertical(170);
        window.changeColor("blue");
        
    }
    /**This method changes roof color.
     * @param changeColor **this parameter allows roof to change color**
     */
    public void changeRoofColor(String changeColor)
    {
        roof.changeColor(changeColor);
    }
    
    /**This method changes wall color.
     * @param changeColor **this parameter allows wall to change color**
     */
    public void changeWallColor(String changeColor)
    {
        wall.changeColor(changeColor);   
    }
    /**This method changes window color.
     * @param changeColor **this parameter allows window to change color**
     */
    public void changeWindowColor(String changeColor)
    {
        window.changeColor(changeColor);
    }
    /**This method changes house horizontal distance.
     * @param distance **this parameter moves the house horizontally**
     */
    public void moveHorizontal(int distance)
    {
        wall.moveHorizontal(distance);
        roof.moveHorizontal(distance);
        window.moveHorizontal(distance);               
    }
    /**This method changes house vertical distance.
     * @param distance **this parameter moves the house vertically**
     */
    public void moveVertical(int distance)
    {
        wall.moveVertical(distance);
        roof.moveVertical(distance);
        window.moveVertical(distance);
    }
    /**This method makes the house invisble.
     * @param makeInvisible **this parameter turns house invisible**
     */
    public void makeInvisible(String makeInvisible)
    {
        wall.makeInvisible();
        roof.makeInvisible();
        window.makeInvisible();
    }    
    /**This method makes the house visble.
     * @param makeVisible **this parameter turns house visible**
     */
    public void makeVisible(String makeVisible)
    {
        wall.makeVisible();
        roof.makeVisible();
        window.makeVisible();
    }
    
    /**Main method for making the House method.
     * @param args **allows methods to be passed**
     */
    public static void main(String[]args)
    {
        House house = new House();
    }
    
}
