class Solution {
    public int findPeakElement(int[] nums) {

        if(nums.length == 1) return 0;

        int max = 0;

        for(int i = 1; i < nums.length; i++){
            if(nums[i]> nums[i-1]){
                

                max = Math.max(max, i);
            }
        }
        return max;
    }
}