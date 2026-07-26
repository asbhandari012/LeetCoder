class Solution {
    public int maximumProduct(int[] nums) {

        Arrays.sort(nums);
        int n = nums.length-1;

        int min1 = nums[0];
        int min2 = nums[1];

        int max = nums[n];
        int max2 = nums[n-1];
        int max3 = nums[n-2];

        return Math.max(min1 * min2 * max, max * max3 * max2);
        
    }
}