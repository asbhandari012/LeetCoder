class Solution {
    public List<Integer> findMissingElements(int[] nums) {

        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[nums.length-1];

        List<Integer> list = new ArrayList<>();

        for(int num : nums){
            list.add(num);
        }

        List<Integer> result = new ArrayList<>();

        for(int i = min; i <= max; i++){
            if(!list.contains(i)){
                result.add(i);
            }
        }
        return result;
    }
}