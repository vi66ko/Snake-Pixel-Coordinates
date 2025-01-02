/**
 * Print information for debugging the game
 * @author Vladislav Stamenov
 * @version 1.0
 */

package debug;

public class Debug {
    private static boolean debug = true;

    /**
     * Set true/false to print debugging information
     * @param state Debugging true || false
     * @return The old state
     */
    public static synchronized boolean setState(boolean state) {
        boolean oldState = debug;
        debug = state;
        return oldState;
    }
}
