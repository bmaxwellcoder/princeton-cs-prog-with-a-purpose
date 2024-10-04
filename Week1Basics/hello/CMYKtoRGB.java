public class CMYKtoRGB {
    public static void main(String[] args) {

        // Parse command-line arguments for CMYK values
        double cyan = Double.parseDouble(args[0]);
        double magenta = Double.parseDouble(args[1]);
        double yellow = Double.parseDouble((args[2]));
        double black = Double.parseDouble((args[3]));

        // Calculate the white component
        double white = 1 - black;

        // Convert CMYK to RGB values
        int red = (int) Math.round((255 * white * (1 - cyan)));
        int green = (int) Math.round((255 * white * (1 - magenta)));
        int blue = (int) Math.round((255 * white * (1 - yellow)));

        // Print the RGB values
        System.out.println("red   = " + red);
        System.out.println("green = " + green);
        System.out.println("blue  = " +  blue);
    }
}
