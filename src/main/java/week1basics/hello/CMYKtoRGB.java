package week1basics.hello;

/**
 * This program converts CMYK (Cyan, Magenta, Yellow, Black) color values
 * to RGB (Red, Green, Blue) color values.
 * 
 * Usage: java CMYKtoRGB <cyan> <magenta> <yellow> <black>
 * where all values are between 0.0 and 1.0
 * 
 * @author Bryan Williamson
 */
public class CMYKtoRGB {

    /**
     * Main method that converts CMYK color values to RGB values.
     * 
     * @param args Command line arguments:
     *             args[0]: cyan value (0.0 to 1.0)
     *             args[1]: magenta value (0.0 to 1.0)
     *             args[2]: yellow value (0.0 to 1.0)
     *             args[3]: black value (0.0 to 1.0)
     */
    public static void main(String[] args) {
        // Parse command-line arguments for CMYK values (values between 0.0 and 1.0)
        double cyan = Double.parseDouble(args[0]);
        double magenta = Double.parseDouble(args[1]);
        double yellow = Double.parseDouble(args[2]);
        double black = Double.parseDouble(args[3]);

        // Calculate the white component (inverse of black)
        double white = 1 - black;

        // Convert CMYK to RGB values using the standard conversion formula:
        // R = 255 × (1-C) × (1-K)
        // G = 255 × (1-M) × (1-K)
        // B = 255 × (1-Y) × (1-K)
        int red = (int) Math.round(255 * white * (1 - cyan));
        int green = (int) Math.round(255 * white * (1 - magenta));
        int blue = (int) Math.round(255 * white * (1 - yellow));

        // Print the resulting RGB values (each between 0 and 255)
        System.out.println("red   = " + red);
        System.out.println("green = " + green);
        System.out.println("blue  = " + blue);
    }
}
