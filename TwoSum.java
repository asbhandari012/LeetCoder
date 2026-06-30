import java.util.*;

public class TwoSum{


    public static int[] solution(int nums[], int target){

        HashMap<Integer , Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int need = target - nums[i];
            if(map.containsKey(need)){
                return new int[]{map.get(need), i};
            }else{
                map.put(nums[i], i);
            }
        }

        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        Scanner ui = new Scanner(System.in);

        int n = ui.nextInt();

        int nums[] = new int[n];

        for(int i = 0; i < n; i++){
            nums[i] = ui.nextInt();
        }
        int target = ui.nextInt();

        int result[] = solution(nums, target);

        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }
    }
}