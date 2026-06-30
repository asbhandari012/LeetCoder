class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        

        int left = 0;
        int sum = 0;
        int mins = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];

            while(sum >= target){
                mins = Math.min(mins, i - left+1);
                sum-= nums[left];
                left++;


            }
        }
        return mins == Integer.MAX_VALUE ? 0 : mins;
    }
}