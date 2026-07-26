class Solution {
    public boolean validPalindrome(String s) {

        char arr[] = s.toCharArray();

        int left = 0;
        int right = arr.length-1;

        while(left < right){
            if(arr[left] == arr[right]){
                left++;
                right--;
            }else{
                return isPalindrome(arr, left + 1, right) || isPalindrome(arr, left, right-1);
            }
        }
        return true;
        
    }

    public static boolean isPalindrome(char[] arr, int left, int right){
        while(left < right){
            if(arr[left] != arr[right]){
                return false;
            }
            else{
                left++;
                right--;
            }
        }
        return true;
    }
}