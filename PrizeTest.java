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
 * A test class for prize.
 * @author Kunwoo Kim, Armaan Ali, Jonathan Elliott
 * @version 2026.09.20
 */
public class PrizeTest extends TestCase {
    //~ Fields ................................................................
    private Prize prize;
    //~ Constructors ..........................................................
    public void setUp() {
        prize = new Prize();
    }
    //~Public  Methods ........................................................
    /**
     * testing setPrize()
     */
    public void testSetPrize()
    {
        prize.setPrize(2, 3);
        assertEquals(2, prize.getXCoord());
        assertEquals(3, prize.getYCoord());
        assertEquals(30, prize.getPercentage());
    }
    /**
     * testing getXCoord()
     */
    public void testGetXCoord()
    {
        prize.setXCoord(4);
        assertEquals(4, prize.getXCoord());
    }
    /**
     * testing getYCoord()
     */
    public void testGetYCoord()
    {
        prize.setYCoord(4);
        assertEquals(4, prize.getYCoord());
    }
    /**
     * testing setYCoord()
     */
    public void testSetXCoord()
    {
        prize.setXCoord(2);
        assertEquals(2, prize.getXCoord());
    }
    /**
     * testing setYCoord()
     */
    public void testSetYCoord()
    {
        prize.setYCoord(3);
        assertEquals(3, prize.getYCoord());
    }
    /**
     * testing generateRandomNumber()
     * Tested 20 times to ensure that it is within range.
     */
    public void testGenerateRandomNumber()
    {
        for (int i = 0; i < 100; i++) {
            int number = prize.generateRandomNumber(1, 100);
            assertTrue(number >= 1);
            assertTrue(number <= 100);
        }    
    }
    /**
     * Testing setPercentage()
     */
    public void testSetPercentage() {
        prize.setPercentage(50);
        assertEquals(50, prize.getPercentage());
    }
    /**
     * Testing tryPrize()
     */
    public void testTryPrize()
    {
        prize.setPercentage(101);
        assertTrue(prize.tryPrize());
        prize.setPercentage(0);
        assertFalse(prize.tryPrize());
    } 
}
