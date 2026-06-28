class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {

        Arrays.sort(arr);
        int x = 1;

        for(int i = 0; i < arr.length; i++){
            if(i == 0 && arr[i] != x){
                arr[0] = x;
            }

            if(arr[i] == x){
                continue;
            }else if(arr[i] == x + 1){
                x++;
            }else{
                x =x+1;
            }
        }
        return x;
    }
}