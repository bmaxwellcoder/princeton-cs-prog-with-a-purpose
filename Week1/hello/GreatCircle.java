public class GreatCircle {
    public static void main(String[] args) {

        double x1 = Math.toRadians(Double.parseDouble(args[0]));
        double y1 = Math.toRadians(Double.parseDouble(args[1]));
        double x2 = Math.toRadians(Double.parseDouble(args[2]));
        double y2 = Math.toRadians(Double.parseDouble(args[3]));

        int radius = 6_371;
        double addendOne = Math.sin((x2 - x1) / 2) * Math.sin((x2 - x1) / 2);
        double addendTwo = Math.cos(x1) * Math.cos(x2) *
                Math.sin((y2 - y1) / 2) * Math.sin((y2 - y1) / 2);
        double distance = 2 * radius *
                Math.asin(Math.sqrt(addendOne  + addendTwo));

        System.out.println(distance + " kilometers");
    }
}
