import java.util.Arrays;

public class BoatsToSavePeople881 {

    public static int numRescueBoats(int[] people, int limit) {

        Arrays.sort(people);

        int count = 0;

        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            count++;
            right--;

        }
        return count;
    }

    public static void main(String[] args) {
        int nums[] = { 3, 5, 3, 4 };
        int limit = 5;

        System.out.println(numRescueBoats(nums, limit));
    }
}
