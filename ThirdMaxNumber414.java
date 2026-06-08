import java.util.*;

public class ThirdMaxNumber414 {
    public static int thirdMax(int nums[]) {
        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        int count = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] == nums[i + 1]) {
                continue;
            }
            count++;
            if (count == 3) {
                return nums[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {

        int nums[] = { 2, 1 };

        System.out.println(thirdMax(nums));
    }
}