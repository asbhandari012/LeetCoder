class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int ans = 0;
        
        for (int i = 0; i < n; i++) {
            int targetCount = 0;
            int otherCount = 0;
            
            for (int j = i; j < n; j++) {
                if (nums[j] == target) {
                    targetCount++;
                } else {
                    otherCount++;
                }
                
                // Majority element means it appears strictly more than half the time
                if (targetCount > otherCount) {
                    ans++;
                }
            }
        }
        
        return ans;
    }
}