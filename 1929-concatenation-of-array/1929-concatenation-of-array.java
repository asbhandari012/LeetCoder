class Solution {
    public int[] getConcatenation(int[] nums) {
        

        int ans[] = new int[nums.length * 2];

        int left = 0;
        int right = nums.length-1;
        int i = 0;

        while(left <= right){
            ans[left] = nums[left];
            left++;
        }

        left = nums.length;
        right = ans.length-1;

        while(left <= right && i < nums.length){
            ans[left++] = nums[i++];
        }
        return ans;
    }
}