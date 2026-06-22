import java.util.*;

public class MaximumDistanceInArrays {

    public static int maxDistance(List<List<Integer>> arrays) {

        int distance = 0;

        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);

        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> arr = arrays.get(i);

            int currentMin = arr.get(0);
            int currentmax = arr.get(arr.size() - 1);

            distance = Math.max(distance, Math.max(currentmax - min, max - currentMin));

            min = Math.min(min, currentMin);
            max = Math.max(max, currentmax);
        }

        return distance;
    }

    public static void main(String[] args) {
        Scanner ui = new Scanner(System.in);

        List<List<Integer>> list = new ArrayList<>();

        list.add(Arrays.asList(1, 2, 3));
        list.add(Arrays.asList(4, 5));
        list.add(Arrays.asList(1, 2, 3));

        System.out.println(maxDistance(list));
    }
}
