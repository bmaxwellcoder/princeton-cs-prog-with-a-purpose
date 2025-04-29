package Week6_Recursion.suppwork;

public class LIS {

    public static int LIS(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int[] subLISArr = new int[arr.length];

        // Initialize all elements to 1
        for (int i = 0; i < arr.length; i++) {
            subLISArr[i] = 1;
        }

        // For each element, find the longest increasing subsequence ending at that
        // element
        for (int i = 1; i < arr.length; i++) {
            int maxSubproblem = 0;

            // Check all previous elements
            for (int j = 0; j < i; j++) {
                // If current element is greater than previous element
                if (arr[j] < arr[i]) {
                    // Update maxSubproblem if needed
                    maxSubproblem = Math.max(maxSubproblem, subLISArr[j]);
                }
            }

            // Update the LIS ending at index i
            subLISArr[i] = 1 + maxSubproblem;
        }

        // Find the maximum value in subLISArr
        int maxLIS = 0;
        for (int i = 0; i < subLISArr.length; i++) {
            maxLIS = Math.max(maxLIS, subLISArr[i]);
        }

        return maxLIS;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 2, 8, 6, 3, 6, 9, 3 };
        System.out.println(LIS(arr));
    }
}
