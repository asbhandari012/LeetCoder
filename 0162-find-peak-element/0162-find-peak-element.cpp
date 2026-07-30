class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int max_idx = 0;

        // 1. Changed .length() to .size()
        for(int i = 1; i < nums.size(); i++) {
            if(nums[i] > nums[i-1]) {
                // 2. Changed Math.max to std::max
                max_idx = std::max(max_idx, i);
            }
        }        
        return max_idx;
    }
};