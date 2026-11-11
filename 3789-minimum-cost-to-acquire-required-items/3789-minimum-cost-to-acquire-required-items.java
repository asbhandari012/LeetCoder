class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {

        long common = Math.min(need1, need2);

        long cost = common * Math.min(costBoth, (long) cost1 + cost2);


        cost += (need1 - common) * cost1;
        cost += (need2 - common) * cost2;

        long allBoth = (long)Math.max(need1, need2) * costBoth;

        return Math.min(allBoth, cost);
        
    }
}