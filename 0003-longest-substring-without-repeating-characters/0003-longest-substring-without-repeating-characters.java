class Solution {
    public int lengthOfLongestSubstring(String s) {

        int length = 0;
        String str = "";
        int maxlength =0;
        for(int i = 0; i < s.length(); i++){
            while(str.contains(String.valueOf(s.charAt(i)))){
                str = str.substring(1);
                length--;
            }

            str += s.charAt(i);
            length++;
            maxlength = Math.max(maxlength, length);
        }
        return maxlength;
    }
}