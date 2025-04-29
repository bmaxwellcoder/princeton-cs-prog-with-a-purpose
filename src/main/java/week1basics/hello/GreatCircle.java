package week1basics.hello;

/**
 * A program that calculates the great-circle distance between two points on
 * Earth.
 * The program takes four command-line arguments: the latitude and longitude of
 * two points on Earth (in degrees) and computes the great-circle distance
 * between
 * them using the Haversine formula.
 * 
 * Usage: java GreatCircle x1 y1 x2 y2
 * 
 * @author Bryan Williamson
 */
public class GreatCircle {

    /**
     * Main method that calculates and displays the great-circle distance.
     * 
     * @param args Command line arguments:
     *             args[0]: latitude of first point (in degrees)
     *             args[1]: longitude of first point (in degrees)
     *             args[2]: latitude of second point (in degrees)
     *             args[3]: longitude of second point (in degrees)
     */
    public static void main(String[] args) {
        // Earth's radius in kilometers
        final int EARTH_RADIUS = 6_371;

        // Convert command-line arguments from degrees to radians
        // x1, x2 represent latitudes and y1, y2 represent longitudes
        double x1 = Math.toRadians(Double.parseDouble(args[0]));
        double y1 = Math.toRadians(Double.parseDouble(args[1]));
        double x2 = Math.toRadians(Double.parseDouble(args[2]));
        double y2 = Math.toRadians(Double.parseDouble(args[3]));

        // Calculate the components of the Haversine formula
        /*
         * Haversine formula:
         * distance = 2 * r * arcsin(sqrt(sin²((x2-x1)/2) + cos(x1) * cos(x2) *
         * sin²((y2-y1)/2)))
         * where r is the radius of the Earth
         */
        double deltaLatTerm = Math.sin((x2 - x1) / 2) * Math.sin((x2 - x1) / 2);
        double deltaLongTerm = Math.cos(x1) * Math.cos(x2) *
                Math.sin((y2 - y1) / 2) * Math.sin((y2 - y1) / 2);

        // Calculate the great-circle distance using the Haversine formula
        double distance = 2 * EARTH_RADIUS *
                Math.asin(Math.sqrt(deltaLatTerm + deltaLongTerm));

        // Print the distance in kilometers
        System.out.println(distance + " kilometers");
    }
}
