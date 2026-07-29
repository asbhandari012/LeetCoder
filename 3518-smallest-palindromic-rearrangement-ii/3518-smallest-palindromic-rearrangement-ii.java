class Solution {
    public String smallestPalindrome(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        int halfLen = n / 2;
        int[] halfFreq = new int[26];
        for (int i = 0; i < 26; i++) {
            halfFreq[i] = freq[i] / 2;
        }

        long totalPerms = countCombinations(halfFreq, k);
        if (totalPerms < k) {
            return "";
        }

        char[] half = new char[halfLen];
        long targetK = k;

        for (int i = 0; i < halfLen; i++) {
            for (int c = 0; c < 26; c++) {
                if (halfFreq[c] == 0) continue;

                halfFreq[c]--;
                long ways = countCombinations(halfFreq, targetK);

                if (ways >= targetK) {
                    half[i] = (char) ('a' + c);
                    break;
                } else {
                    targetK -= ways;
                    halfFreq[c]++;
                }
            }
        }

        char[] result = new char[n];
        for (int i = 0; i < halfLen; i++) {
            result[i] = half[i];
            result[n - 1 - i] = half[i];
        }

        if (n % 2 == 1) {
            for (int c = 0; c < 26; c++) {
                if (freq[c] % 2 == 1) {
                    result[halfLen] = (char) ('a' + c);
                    break;
                }
            }
        }

        return new String(result);
    }

    private long countCombinations(int[] freq, long maxK) {
        int maxIdx = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] > freq[maxIdx]) {
                maxIdx = i;
            }
        }

        long res = 1;
        int sum = freq[maxIdx];

        for (int i = 0; i < 26; i++) {
            if (i == maxIdx || freq[i] == 0) continue;
            for (int j = 1; j <= freq[i]; j++) {
                sum++;
                res = res * sum / j;
                if (res > maxK) {
                    return maxK + 1;
                }
            }
        }

        return res;
    }
}