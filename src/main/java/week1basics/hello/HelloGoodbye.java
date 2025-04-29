package week1basics.hello;

/**
 * This program takes two command-line arguments (names) and prints a hello
 * message to both names in the order they are given, followed by a goodbye
 * message to both names in reverse order.
 * 
 * Usage: java HelloGoodbye <name1> <name2>
 * 
 * @author Bryan Williamson
 */
public class HelloGoodbye {

    /**
     * Main method that prints hello and goodbye messages using two names.
     * 
     * @param args Command line arguments:
     *             args[0]: first name
     *             args[1]: second name
     */
    public static void main(String[] args) {
        // Store the names from command-line arguments for better readability
        String firstName = args[0];
        String secondName = args[1];

        // Print a greeting message using the names in the given order
        System.out.println("Hello " + firstName + " and " + secondName + ".");

        // Print a goodbye message using the names in reverse order
        System.out.println("Goodbye " + secondName + " and " + firstName + ".");
    }
}
