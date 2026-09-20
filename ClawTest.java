// Virginia Tech Honor Code Pledge:
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Kunwoo Kim (kkunwoo)

// LLM Statement:
// I have not used any assistance for the assignment beyond course resources and
// staff.

import junit.framework.TestCase;

/**
 * A test class for claw.
 * @author Kunwoo Kim, Armaan Ali, Jonathan Elliott
 * @version 2026.09.20
 */
public class ClawTest extends TestCase {
    //~ Fields ................................................................
    private Claw claw;
    //~ Constructors ..........................................................
    /**
     * Creating a setUp for testing.
     */
    protected void setUp() {
        claw = new Claw();
    }
    //~Public  Methods ........................................................
    /**
     * Testing whether the constructor was correctly made.
     */
    public void testConstructor() {
        assertEquals(0, claw.getX());
        assertEquals(0, claw.getY());
    }
    /**
     * Testing setX()
     */
    public void testSetX() {
        claw.setX(3);
        assertEquals(3, claw.getX());
    }
    /**
     * Testing setY()
     */
    public void testSetY() {
        claw.setY(4);
        assertEquals(4, claw.getY());
    }
    /**
     * Testing reset()
     */
    public void testReset() {
        claw.setX(3);
        claw.setY(4);
        claw.reset();
        assertEquals(0, claw.getX());
        assertEquals(0, claw.getY());
    }
    /**
     * Testing location()
     */
    public void testLocation(){
        claw.setX(3);
        claw.setY(4);
        claw.location(); //for code coverage. Tested through strLocation().
        assertEquals("The current claw location: (3, 4)", claw.strLocation());
        assertFalse(claw.strLocation().equals("The current claw location: (2, 4)"));
    }
    /**
     * Testing move() starting from origin.
     */
    public void testMove() {
        // w
        claw.move("w");
        assertEquals(0, claw.getX());
        assertEquals(1, claw.getY());

        // d
        claw.move("d");
        assertEquals(1, claw.getX());
        assertEquals(1, claw.getY());

        // s
        claw.move("s");
        assertEquals(1, claw.getX());
        assertEquals(0, claw.getY());

        // a
        claw.move("a");
        assertEquals(0, claw.getX());
        assertEquals(0, claw.getY());
        
        //h → modified in main
        claw.move("h");
        assertEquals(0, claw.getX());
        assertEquals(0, claw.getY());

        // space → reset
        claw.move(" ");
        assertEquals(0, claw.getX());
        assertEquals(0, claw.getY());
    }
    /**
     * Testing edge cases of move()
     */
    public void testMoveEdgeCases() {
        // Left boundary: (0, 0) -> "a" should not move
        claw.move("a");
        assertEquals(0, claw.getX());
        assertEquals(0, claw.getY());

        // Bottom boundary: (0, 0) -> "s" should not move
        claw.move("s");
        assertEquals(0, claw.getX());
        assertEquals(0, claw.getY());

        // Top boundary: (0, 4) -> "w" should not move
        claw.move("w");
        claw.move("w");
        claw.move("w");
        claw.move("w");
        claw.move("w");
        assertEquals(0, claw.getX());
        assertEquals(4, claw.getY());

        // Right boundary: (4, 4) -> "d" should not move
        claw.move("d");
        claw.move("d");
        claw.move("d");
        claw.move("d");
        claw.move("d");
        assertEquals(4, claw.getX());
        assertEquals(4, claw.getY());

        // Bottom boundary: (4, 0) -> "s" should not move
        claw.move("s");
        claw.move("s");
        claw.move("s");
        claw.move("s");
        claw.move("s");
        assertEquals(4, claw.getX());
        assertEquals(0, claw.getY());

        // Left boundary: (0, 0) -> "a" should not move
        claw.move("a");
        claw.move("a");
        claw.move("a");
        claw.move("a");
        claw.move("a");
        assertEquals(0, claw.getX());
        assertEquals(0, claw.getY());
        
        //Outside of cases
        claw.move("c");
        claw.move("Hello");
        claw.move("12345");
        assertEquals(0, claw.getX());
        assertEquals(0, claw.getY());
    }
}
