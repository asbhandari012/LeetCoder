class Solution {
    public String reverseVowels(String s) {

        String str = "aeiouAEIOU";

        char arr[] = s.toCharArray();

        int left = 0;
        int right = arr.length-1;

        while(left < right){
            if(str.contains(String.valueOf(arr[left])) &&
             str.contains(String.valueOf(arr[right]))){
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++; right--;
            }else if(!str.contains(String.valueOf(arr[left]))){
                left++;
            }else{
                right--;
            }
        }
        return String.valueOf(arr);
        
    }
}