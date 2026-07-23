class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {

        int copy[] = nums.clone();
        Arrays.sort(copy);

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(copy[0], 0);


        for(int i = 1; i < nums.length; i++){
            if(copy[i] != copy[i - 1]){
                map.put(copy[i], i);
            }
        }
        
        for(int i = 0; i < nums.length; i++){
            copy[i] = map.get(nums[i]);
        }
        return copy;
    }
}