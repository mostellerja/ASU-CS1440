
/**
 * Write a description of class Scene here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scene
{
    private House house1;
    private House house2;
    private Circle sun;
    private Circle moon;
     
    
    
    /**
     * Constructor for objects of class Scene.
     */
    
    public Scene()
    {
        house1 = new House();                              
        house1.changeWallColor("red");                        
        house1.changeRoofColor("green");                                 
        house1.changeWindowColor("blue");  
        house1.moveHorizontal(-70);
        house2 = new House();                       
        house2.changeWallColor("blue");                                     
        house2.changeRoofColor("black");        
        house2.moveVertical(-60);
        house2.moveHorizontal(80);        
        house2.changeWindowColor("yellow");
         
        
        
        sun = new Circle();       
        sun.changeColor("yellow");
        sun.changeSize(50);
        sun.moveVertical(-50);
        sun.makeVisible();
        moon = new Circle();       
        moon.changeColor("blue");
        moon.changeSize(50);
        moon.moveVertical(-50);
        moon.moveHorizontal(-90);  
        moon.makeVisible();
    }    
    /**This is the main method for Scene class.
     * @param args **This allows methods to be called.**
     */
    public static void main(String[]args)
    {
        Scene scene = new Scene();
        scene.animate();                
    }   
    /**This method animates Scene.
     * 
     */
    public void animate()
    {
        sun.slowMoveHorizontal(300);
        moon.slowMoveHorizontal(280);        
    }        
}
