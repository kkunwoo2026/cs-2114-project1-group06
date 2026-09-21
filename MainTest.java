// Virginia Tech Honor Code Pledge:
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Kunwoo Kim (kkunwoo)

// LLM Statement:
// I have not used any assistance for the assignment beyond course resources and
// staff.

import junit.framework.TestCase;
import java.util.List;

/**
 * A test class for Main.
 * @author Kunwoo Kim, Armaan Ali, Jonathan Elliott
 * @version 2026.09.20
 */
public class MainTest extends TestCase {

    //~ Fields ................................................................
    private Main main;
    //~ Constructors ..........................................................
    /**
     * A setUp()
     */
    protected void setUp()
    {
        main = new Main();
        main.setClaw();
        main.setPrizeList();
    }
    //~Public  Methods ........................................................
    /**
     * A test class for setClaw()
     */
    public void testSetClaw()
    {
        assertNotNull(main.getClaw());
    }
    /**
     * A test class for setPrizeList()
     */
    public void testSetPrizeList()
    {
        assertNotNull(main.getPrizeList());
        assertEquals(3, main.getPrizeList().size());
    }
    /**
     * A test class for howManyPrizeLeft()
     */
    public void testHowManyPrizeLeft()
    {
        assertEquals(3, main.howManyPrizeLeft());
        main.getPrizeList().set(2, null);
        assertEquals(2, main.howManyPrizeLeft());
        main.getPrizeList().set(1, null);
        assertEquals(1, main.howManyPrizeLeft());
        main.getPrizeList().set(0, null);
        assertEquals(0, main.howManyPrizeLeft());
    }
    /**
     * A test class for whatPrizeHere() 
     */
    public void testWhatPrizeHere()
    {
        main.getPrizeList().get(1).setXCoord(3);
        main.getPrizeList().get(1).setYCoord(3);
        main.getClaw().setX(3);
        main.getClaw().setY(3);
        assertEquals(1, main.whatPrizeHere());
        main.getClaw().setX(6);
        assertEquals(-1, main.whatPrizeHere());
        main.getClaw().setX(3);
        main.getClaw().setY(6);
        assertEquals(-1, main.whatPrizeHere());
        main.getPrizeList().set(0, null);
        assertEquals(-1, main.whatPrizeHere());
    }
    /**
     * A test class for hasPrize() 
     */
    public void testHasPrize()
    {
        main.getPrizeList().get(0).setXCoord(2);
        main.getPrizeList().get(0).setYCoord(1);
        main.getClaw().setX(2);
        main.getClaw().setY(0);
        assertFalse(main.hasPrize());
        main.getClaw().setY(1);
        assertTrue(main.hasPrize());
        main.getPrizeList().set(0, null);
        assertFalse(main.hasPrize());
    }
    /**
     * A test class for generateRandomNumber() 
     */
    public void testGenerateRandomNumber()
    {
        for (int i = 0; i < 100; i++)
        {
            int number = main.generateRandomNumber(1, 100);
            assertTrue(number >= 1 && number <= 100);
        }
    }
    /**
     * A test class for prizeListCreation()
     */
    public void testPrizeListCreation()
    {
        List<Prize> prizes = main.prizeListCreation();

        assertNotNull(prizes);
        assertEquals(3, prizes.size());

        for (int i = 0; i < prizes.size(); i++)
        {
            Prize prize = prizes.get(i);

            assertNotNull(prize);
            assertTrue(prize.getXCoord() >= 0 && prize.getXCoord() <= 4);
            assertTrue(prize.getYCoord() >= 0 && prize.getYCoord() <= 4);
        }
        assertTrue(prizes.get(0).getXCoord() != prizes.get(1).getXCoord() || prizes.get(0).getYCoord() != prizes.get(1).getYCoord());
    }

    /**
     * Testing printHelp() method.
     */
    public void testPrintHelp() {
        main.printHelp();
    }
}
