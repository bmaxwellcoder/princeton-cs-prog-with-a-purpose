public class HelloGoodbye {
    public static void main(String[] args) {

        // Print a greeting message using the first and second command-line arguments
        System.out.println("Hello " + args[0] + " and " + args[1] + ".");

        // Print a goodbye message using the second and first command-line arguments
        System.out.println("Goodbye " + args[1] + " and " + args[0] + ".");
    }
}
