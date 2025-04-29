package Week6_Recursion.suppwork;

public class Sum {

    public static int iterativeSum(int n) {
        int result = 0;

        for (int i = 0; i <= n; i++) {
            result += i;
        }

        return result;
    }

    public static int recursiveSum(int n) {
        if (n == 0) {
            return 0;
        }


        return recursiveSum(n - 1) + n;
    }

    public static void main(String[] args) {
        int a = 5;
        System.out.println(iterativeSum(5));
        System.out.println(recursiveSum(a));

    }
}
