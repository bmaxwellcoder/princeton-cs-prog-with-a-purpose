package Week6_Recursion.suppwork;

public class LCS {
    public static void main(String[] args) {
        String s = "cg";
        String t = "tacg";
        int M = s.length();
        int N = t.length();
        int[][] opt = new int[M + 1][N + 1];
        for (int i = M - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                if (s.charAt(i) == t.charAt(j)) {
                    opt[i][j] = opt[i + 1][j + 1] + 1;
                } else {
                    opt[i][j] = Math.max(opt[i + 1][j], opt[i][j + 1]);
                }
            }
        }
        System.out.println(opt[0][0]);
    }
}
