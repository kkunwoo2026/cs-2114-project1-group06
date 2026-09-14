// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Kunwoo Kim (kkunwoo)

// LLM Statement:
// I have not used any assistance for the assignment beyond course resources and
// staff.

/**
 * Creating a claw class that allows users to move claw along the coordinates.
 * @author Kunwoo Kim
 * @version 2026.09.14 
 */
public class Claw {
    //~ Fields ................................................................
    private int x;
    private int y;
    //~ Constructors ..........................................................
    
    //~Public  Methods ........................................................
    /**
     * A getter method for x.
     */
    public int getX() {
        return x;
    }
    /**
     * A setter method for x.
     * @param x = A new value to set for x.
     */
    public void setX(int x) {
        this.x = x;
    }
    /**
     * A getter method for y.
     */
    public int getY() {
        return y;
    }
    /**
     * A setter method for y.
     * @param y = A new value to set for y.
     */
    public void setY(int y) {
        this.y = y;
    }   
}
