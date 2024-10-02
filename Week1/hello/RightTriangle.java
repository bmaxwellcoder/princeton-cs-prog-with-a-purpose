public class RightTriangle {
    public static void main(String[] args) {

        int sideOne = Integer.parseInt(args[0]);
        int sideTwo = Integer.parseInt(args[1]);
        int sideThree = Integer.parseInt(args[2]);

        boolean allPositive = (sideOne > 0) && (sideTwo > 0) && (sideThree > 0);

        boolean optionOne = sideOne * sideOne + sideTwo * sideTwo ==
                sideThree * sideThree;
        boolean optionTwo = sideOne * sideOne + sideThree * sideThree ==
                sideTwo * sideTwo;
        boolean optionThree = sideTwo * sideTwo + sideThree * sideThree ==
                sideOne * sideOne;

        boolean isRightTriangle = (allPositive) &&
                (optionOne || optionTwo || optionThree);
        System.out.println(isRightTriangle);

        // Another option
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
