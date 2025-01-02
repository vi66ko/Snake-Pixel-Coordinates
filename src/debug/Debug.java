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
    public static synchronized boolean setState(boolean assert state) {
            boolean oldState = debug;
            debug = state;
            return oldState;
        }
    
        /**
         * Display text for debugging
         * @param fmt The same as printf etc;
         * @param args The parameters for the fmt
         * @return void
     */
    public static void trace(String fmt, Object... args) {
        if(debug){
            synchronized( Debug.class){
                System.out.printf(fmt, args);
                System.out.println();
            }
        }
    }
    
       /**
     * Display a fatal message if the assertion fails
     * @param ok true if all is ok
     * @param fmt The same as printf etc.
     * @param args The parameters for the fmt
     */
    public static void assertTrue(boolean ok, String fmt, Object... args){
        if(!ok){
            error("Assertion failed: " + fmt, args)
        }
    }

    /**
     * Display a fatal message
     * @param fmt The same as printf etc.
     * @param args The parameters for the fmt
     * @return void
     */
    public static synchronized void error(String fmt, Object... args){
        System.out.printf(fmt, args);
        System.out.println();
    }

}
