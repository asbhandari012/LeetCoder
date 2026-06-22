import java.util.*;

public class MinimumCostOfBuyingCandies2144 {

    public static int solution(int cost[]) {

        Arrays.sort(cost);

        int total = 0;
        int count = 0;

        for (int i = cost.length - 1; i >= 0; i--) {
            count++;
            if (count % 3 == 0) {
                continue;
            }
            total += cost[i];
        }

        return total;
    }

    public static void main(String args[]) {
        Scanner ui = new Scanner(System.in);

        int n = ui.nextInt();
        int cost[] = new int[n];

        for (int i = 0; i < n; i++) {
            cost[i] = ui.nextInt();
        }

        System.out.println(solution(cost));
    }

}
