class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {

        int n = nums.length;

        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (nums[i] == target ? 1 : -1);
        }

        int[] all = prefix.clone();
        Arrays.sort(all);

        Fenwick bit = new Fenwick(n + 2);

        long ans = 0;

        for (int x : prefix) {
            int idx = lowerBound(all, x) + 1;
            ans += bit.query(idx - 1);
            bit.update(idx, 1);
        }

        return (int)ans;
    }

    private int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] < target)
                l = m + 1;
            else
                r = m;
        }
        return l;
    }

    class Fenwick {
        int[] bit;

        Fenwick(int n) {
            bit = new int[n + 1];
        }

        void update(int idx, int val) {
            while (idx < bit.length) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }

        int query(int idx) {
            int sum = 0;
            while (idx > 0) {
                sum += bit[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
        
    }
}