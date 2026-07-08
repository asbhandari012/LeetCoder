class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        final int MOD = 1_000_000_007;
        int n = s.length();

        int[] next = new int[n];
        int[] prev = new int[n];

        // previous non-zero position
        int last = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != '0') last = i;
            prev[i] = last;
        }

        // next non-zero position
        last = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) != '0') last = i;
            next[i] = last;
        }

        int[] posToIdx = new int[n];
        java.util.Arrays.fill(posToIdx, -1);

        java.util.ArrayList<Integer> digits = new java.util.ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != '0') {
                posToIdx[i] = digits.size();
                digits.add(s.charAt(i) - '0');
            }
        }

        int m = digits.size();

        long[] pow10 = new long[m + 1];
        pow10[0] = 1;
        for (int i = 1; i <= m; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        long[] prefixNum = new long[m + 1];
        int[] prefixSum = new int[m + 1];

        for (int i = 0; i < m; i++) {
            prefixNum[i + 1] = (prefixNum[i] * 10 + digits.get(i)) % MOD;
            prefixSum[i + 1] = prefixSum[i] + digits.get(i);
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int leftPos = next[l];
            int rightPos = prev[r];

            if (leftPos == -1 || rightPos == -1 || leftPos > rightPos) {
                ans[i] = 0;
                continue;
            }

            int L = posToIdx[leftPos];
            int R = posToIdx[rightPos];

            int len = R - L + 1;

            long number = (prefixNum[R + 1]
                    - prefixNum[L] * pow10[len] % MOD
                    + MOD) % MOD;

            long sum = prefixSum[R + 1] - prefixSum[L];

            ans[i] = (int) ((number * sum) % MOD);
        }

        return ans;
    }
}