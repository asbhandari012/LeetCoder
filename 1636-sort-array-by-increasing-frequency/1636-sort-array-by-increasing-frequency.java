class Solution {
    public int[] frequencySort(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num , 0) + 1);
        }
        
        List<Map.Entry<Integer, Integer>> list =
        new ArrayList<>(map.entrySet());

        list.sort((a, b) -> {
            if (a.getValue().equals(b.getValue())) {
                return b.getKey() - a.getKey();
            }
            return a.getValue() - b.getValue();
        });

        int index = 0;

         for (Map.Entry<Integer, Integer> entry : list) {

            int num = entry.getKey();
            int freq = entry.getValue();

            while (freq-- > 0) {
                nums[index++] = num;
            }
        }

        return nums;
    }
}