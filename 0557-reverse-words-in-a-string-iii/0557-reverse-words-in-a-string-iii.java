class Solution {
    public String reverseWords(String s) {

        String arr[] = s.split(" ");

        for(int i = 0; i  < arr.length; i++){
            arr[i]= new StringBuilder(arr[i]).reverse().toString();
        }

        String result = String.join(" ", arr);
        return result;
    }
}