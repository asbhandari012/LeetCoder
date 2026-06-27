import java.util.*;

class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Long, Integer> freq = new HashMap<>();

        for (int x : nums) {
            freq.put((long) x, freq.getOrDefault((long) x, 0) + 1);
        }

        int ans = 1;

        // Special case for number 1
        if (freq.containsKey(1L)) {
            int cnt = freq.get(1L);
            if (cnt % 2 == 0)
                ans = Math.max(ans, cnt - 1);
            else
                ans = Math.max(ans, cnt);
        }

        for (long x : freq.keySet()) {

            if (x == 1) continue;

            long cur = x;
            int len = 0;

            while (freq.containsKey(cur)) {

                int cnt = freq.get(cur);

                if (cnt >= 2) {
                    len += 2;

                    // Prevent overflow
                    if (cur > 1000000000L) break;

                    cur = cur * cur;
                } else {
                    len += 1;
                    break;
                }
            }

            if (len % 2 == 0) len--;

            ans = Math.max(ans, len);
        }

        return ans;
    }
}