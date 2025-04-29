package Week6_Recursion.suppwork;

public class Main {

    public static void main(String[] args) {
        System.out.println(Q5(8));
    }

    public static int Q5(int n)
    {
        int[] b = new int[n+1];
        b[0] = 1;
        for (int i = 2;	i <=n; i++)
        {
            b[i] = 0;
            for	(int j = 0; j <	i; j++)
                b[i] += b[j];
        }
        return b[n];
    }
}
