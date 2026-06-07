public class ValidPalindrome2 {

    public static boolean isPalindrome(char[] arr, int left, int right) {
        if (arr[left] != arr[right]) {
            return false;
        }
        return true;
    }

    public static boolean validPalindrome(String s) {

        char[] arr = s.toCharArray();

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (arr[left] != arr[right]) {
                return isPalindrome(arr, left + 1, right) ||
                        isPalindrome(arr, left, right - 1);
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        String s = "aba";

        System.out.println(validPalindrome(s));

    }

}
