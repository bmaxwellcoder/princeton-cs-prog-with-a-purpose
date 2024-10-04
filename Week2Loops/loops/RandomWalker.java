public class RandomWalker {

    public static void main(String[] args) {
        // Parse the first command line argument as the distance r
        int r = Integer.parseInt(args[0]);

        // Initialize the starting position (x, y) and step count
        int x = 0;
        int y = 0;
        int stepCount = 0;
        // Print the initial position
        System.out.println("(" + x + "," + y + ")");

        while(Math.abs(x) + Math.abs(y) != r) {
            // Continue walking until the Manhattan distance from the origin equals r
            // Generate a random value between 0.0 inclusive and 1.0 exclusive
            double randomVal = Math.random();
            // Move in one of the four possible directions based on the random value
            if (randomVal < 0.25) {
                // Move left
                x++;
            } else if (randomVal < 0.5) {
                // Move right
                x--;
            } else if (randomVal < 0.75) {
                // Move up
                y++;
            } else {
                // Move down
                y--;
            }
            // Increment step count
            stepCount++;
            // Print the current position
            System.out.println("(" + x + ", " + y + ")");
        }
        // Print the total number of steps taken
        System.out.println("steps = " + stepCount);
    }
}
