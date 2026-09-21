import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * // -------------------------------------------------------------------------
/**
 *  Tests the token class
 * 
 *  @author Jonathan Elliott
 *  @version Sep 21, 2026
 */
class PlayerTest
{

    /**
     * tests the token methods
     * @Test
     */
    public void testTokens()
    {
        Player testPlayer = new Player(20);
        assertTrue(testPlayer.getTokens() == 20);
        testPlayer.useTokens();
        assertTrue(testPlayer.getTokens() == 10);
    }
}
