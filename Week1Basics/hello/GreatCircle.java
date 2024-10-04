public class GreatCircle {
    public static void main(String[] args) {

        // Convert command-line arguments from degrees to radians
        double x1 = Math.toRadians(Double.parseDouble(args[0]));
        double y1 = Math.toRadians(Double.parseDouble(args[1]));
        double x2 = Math.toRadians(Double.parseDouble(args[2]));
        double y2 = Math.toRadians(Double.parseDouble(args[3]));

        // Earth's radius in kilometers
        int radius = 6_371;

        // Calculate the components of the Haversine formula
        // Haversine formula: distance = 2 * r *
        // arcsin(sqrt(sin^2(x2 - x1) + cos(x1) * cos(x2) * sin^2(y2 - y1)))
        double addendOne = Math.sin((x2 - x1) / 2) * Math.sin((x2 - x1) / 2);
        double addendTwo = Math.cos(x1) * Math.cos(x2) *
                Math.sin((y2 - y1) / 2) * Math.sin((y2 - y1) / 2);

        // Calculate the great-circle distance using the Haversine formula
        double distance = 2 * radius *
                Math.asin(Math.sqrt(addendOne  + addendTwo));

        // Print the distance in kilometers
        System.out.println(distance + " kilometers");
    }
}
