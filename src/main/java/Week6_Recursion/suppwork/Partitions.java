package Week6_Recursion.suppwork;

public class Partitions {

    public static int countPartitionsRecursive(int n, int m) {
        if (n == 0) {
            return 1;
        }


        if (m == 0 || n < 0) {
            return 0;
        }




        return countPartitionsRecursive(n - m, n) + (countPartitionsRecursive(n, m - 1));
    }

    public static void main(String[] args) {
        int n = 0;
        int m = 0;

        System.out.println(countPartitionsRecursive(n, m));
    }

}
