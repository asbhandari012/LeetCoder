class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int totalOnes = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                totalOnes++;
            }
        }

        String t = "1" + s + "1";

        List<Integer> lengths = new ArrayList<>();
        List<Character> types = new ArrayList<>();

        int n = t.length();
        int i = 0;
        while (i < n) {
            char ch = t.charAt(i);
            int count = 0;
            while (i < n && t.charAt(i) == ch) {
                count++;
                i++;
            }
            lengths.add(count);
            types.add(ch);
        }

        int maxGain = 0;
        for (int j = 1; j < types.size() - 1; j++) {
            if (types.get(j) == '1') {
                if (types.get(j - 1) == '0' && types.get(j + 1) == '0') {
                    int gain = lengths.get(j - 1) + lengths.get(j + 1);
                    maxGain = Math.max(maxGain, gain);
                }
            }
        }

        return totalOnes + maxGain;
    }
}