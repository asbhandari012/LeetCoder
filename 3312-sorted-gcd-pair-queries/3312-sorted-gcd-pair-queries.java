import java.util.Arrays;

class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        int[] freq = new int[maxVal + 1];
        for (int num : nums) {
            freq[num]++;
        }

        long[] countDivisible = new long[maxVal + 1];
        for (int i = 1; i <= maxVal; i++) {
            for (int j = i; j <= maxVal; j += i) {
                countDivisible[i] += freq[j];
            }
        }

        long[] exactGcdPairs = new long[maxVal + 1];
        for (int i = maxVal; i >= 1; i--) {
            long totalPairsWithDivisorI = countDivisible[i] * (countDivisible[i] - 1) / 2;
            exactGcdPairs[i] = totalPairsWithDivisorI;
            
            for (int j = 2 * i; j <= maxVal; j += i) {
                exactGcdPairs[i] -= exactGcdPairs[j];
            }
        }

        long[] prefixSums = new long[maxVal + 1];
        for (int i = 1; i <= maxVal; i++) {
            prefixSums[i] = prefixSums[i - 1] + exactGcdPairs[i];
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long target = queries[i];
            answer[i] = binarySearch(prefixSums, target);
        }

        return answer;
    }

    private int binarySearch(long[] prefixSums, long target) {
        int low = 1, high = prefixSums.length - 1;
        int ans = high;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (prefixSums[mid] > target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}