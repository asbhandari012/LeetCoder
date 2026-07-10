import java.util.*;

class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        Integer[] sortedIndices = new Integer[n];
        for (int i = 0; i < n; i++) {
            sortedIndices[i] = i;
        }
        Arrays.sort(sortedIndices, (a, b) -> Integer.compare(nums[a], nums[b]));

        int[] sortedVals = new int[n];
        int[] posInSorted = new int[n];
        for (int i = 0; i < n; i++) {
            sortedVals[i] = nums[sortedIndices[i]];
            posInSorted[sortedIndices[i]] = i;
        }

        int[][] up = new int[18][n];
        for (int i = 0; i < n; i++) {
            int target = sortedVals[i] + maxDiff;
            int low = i, high = n - 1, ans = i;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                if (sortedVals[mid] <= target) {
                    ans = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            up[0][i] = ans;
        }

        for (int j = 1; j < 18; j++) {
            for (int i = 0; i < n; i++) {
                up[j][i] = up[j - 1][up[j - 1][i]];
            }
        }

        int[] answer = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int u = queries[q][0];
            int v = queries[q][1];

            if (u == v) {
                answer[q] = 0;
                continue;
            }

            int p1 = posInSorted[u];
            int p2 = posInSorted[v];

            if (p1 > p2) {
                int temp = p1;
                p1 = p2;
                p2 = temp;
            }

            int curr = p1;
            int steps = 0;
            for (int j = 17; j >= 0; j--) {
                if (up[j][curr] < p2) {
                    steps += (1 << j);
                    curr = up[j][curr];
                }
            }

            if (up[0][curr] >= p2) {
                answer[q] = steps + 1;
            } else {
                answer[q] = -1;
            }
        }

        return answer;
    }
}