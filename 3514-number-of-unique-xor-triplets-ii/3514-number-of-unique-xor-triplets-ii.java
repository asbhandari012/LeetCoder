class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        

        boolean[] pairXor = new boolean[2048];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                pairXor[nums[i] ^ nums[j]] = true;
            }
        }
        

        Set<Integer> uniqueNums = new HashSet<>();
        for (int num : nums) {
            uniqueNums.add(num);
        }
        

        boolean[] tripletXor = new boolean[2048];
        for (int p = 0; p < 2048; p++) {
            if (pairXor[p]) {
                for (int num : uniqueNums) {
                    tripletXor[p ^ num] = true;
                }
            }
        }
        

        int count = 0;
        for (boolean present : tripletXor) {
            if (present) {
                count++;
            }
        }
        
        return count;
    }
}