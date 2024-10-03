public class RightTriangle {
    public static void main(String[] args) {

        // Parse command-line arguments for the lengths of the triangle's sides
        int sideOne = Integer.parseInt(args[0]);
        int sideTwo = Integer.parseInt(args[1]);
        int sideThree = Integer.parseInt(args[2]);

        // Check if all sides are positive
        boolean allPositive = (sideOne > 0) && (sideTwo > 0) && (sideThree > 0);

        // Check if the sides form a right triangle using the Pythagorean theorem
        boolean optionOne = sideOne * sideOne + sideTwo * sideTwo ==
                sideThree * sideThree;
        boolean optionTwo = sideOne * sideOne + sideThree * sideThree ==
                sideTwo * sideTwo;
        boolean optionThree = sideTwo * sideTwo + sideThree * sideThree ==
                sideOne * sideOne;

        // Determine if the triangle is a right triangle
        boolean isRightTriangle = (allPositive) &&
                (optionOne || optionTwo || optionThree);

        // Print the result
        System.out.println(isRightTriangle);

        // Another option to determine if the triangle is a right triangle
        /*
        isRightTriangle = (sideOne > 0) && (sideTwo > 0) && (sideThree > 0) &&
                ((sideOne * sideOne + sideTwo * sideTwo) ==
                        (sideThree * sideThree)
                        || (sideOne * sideOne + sideThree * sideThree) ==
                        (sideTwo * sideTwo)
                        || (sideThree * sideThree + sideTwo * sideTwo) ==
                        (sideOne * sideOne));
         */
    }
}
