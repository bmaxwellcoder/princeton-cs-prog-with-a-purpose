package Week6_Recursion.suppwork;

public class GridPaths {

    public static int gridPathTopLeftToBottomRightRecursive(int n, int m) {

        if (n == 1 || m == 1) {
            return  1;
        }

        return gridPathTopLeftToBottomRightRecursive(n, m - 1) + gridPathTopLeftToBottomRightRecursive(n - 1, m);
    }
    public static void main(String[] args) {
        int n = 3;
        int m = 2;
        System.out.println(gridPathTopLeftToBottomRightRecursive(n, m));

    }
}
