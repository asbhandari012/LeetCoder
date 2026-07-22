class Solution {
    static class Group {
        int start, length;
        Group(int start, int length) { this.start = start; this.length = length; }
    }

    static class SparseTable {
        int[][] st;
        SparseTable(int[] nums) {
            int n = nums.length;
            int logN = 32 - Integer.numberOfLeadingZeros(Math.max(n, 1));
            st = new int[logN + 1][n];
            System.arraycopy(nums, 0, st[0], 0, n);
            for (int i = 1; i <= logN; i++)
                for (int j = 0; j + (1 << i) <= n; j++)
                    st[i][j] = Math.max(st[i - 1][j], st[i - 1][j + (1 << (i - 1))]);
        }
        int query(int l, int r) {
            int k = 31 - Integer.numberOfLeadingZeros(r - l + 1);
            return Math.max(st[k][l], st[k][r - (1 << k) + 1]);
        }
    }

    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int n = s.length();
        int ones = 0;
        for (int i = 0; i < n; i++) if (s.charAt(i) == '1') ones++;

        List<Group> zg = new ArrayList<>();
        int[] zIdx = new int[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                if (i > 0 && s.charAt(i - 1) == '0') zg.get(zg.size() - 1).length++;
                else zg.add(new Group(i, 1));
            }
            zIdx[i] = zg.size() - 1;
        }

        List<Integer> ans = new ArrayList<>(queries.length);
        if (zg.isEmpty()) {
            for (int[] q : queries) ans.add(ones);
            return ans;
        }

        int m = zg.size();
        int[] mergeLens = new int[Math.max(m - 1, 0)];
        for (int i = 0; i < m - 1; i++) mergeLens[i] = zg.get(i).length + zg.get(i + 1).length;
        SparseTable st = mergeLens.length > 0 ? new SparseTable(mergeLens) : null;

        for (int[] q : queries) {
            int l = q[0], r = q[1];
            int lIdx = zIdx[l], rIdx = zIdx[r];

            int left = (lIdx == -1) ? -1 : (zg.get(lIdx).length - (l - zg.get(lIdx).start));
            int right = (rIdx == -1) ? -1 : (r - zg.get(rIdx).start + 1);

            int rAdj = (s.charAt(r) == '1') ? rIdx : rIdx - 1;
            int startAdj = lIdx + 1;
            int endAdj = rAdj - 1;

            int activeSections = ones;

            if (s.charAt(l) == '0' && s.charAt(r) == '0' && lIdx + 1 == rIdx) {
                activeSections = Math.max(activeSections, ones + left + right);
            } else if (st != null && startAdj <= endAdj) {
                activeSections = Math.max(activeSections, ones + st.query(startAdj, endAdj));
            }

            if (s.charAt(l) == '0' && lIdx + 1 <= rAdj) {
                activeSections = Math.max(activeSections, ones + left + zg.get(lIdx + 1).length);
            }
            if (s.charAt(r) == '0' && lIdx < rIdx - 1) {
                activeSections = Math.max(activeSections, ones + right + zg.get(rIdx - 1).length);
            }

            ans.add(activeSections);
        }
        return ans;
    }
}