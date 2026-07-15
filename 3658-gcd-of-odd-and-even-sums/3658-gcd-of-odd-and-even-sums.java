class Solution {
    public int gcdOfOddEvenSums(int n) {

        int oddSum = 0;
        int evenSum = 0;

        for(int i = 1; i <= n*2; i++){
            if(i % 2 != 0){
                oddSum+= i;
            }else{
                evenSum += i;
            }
        }


        int min = oddSum < evenSum ? oddSum : evenSum;

        for(int i = min; i >= 1; i--){
            if(oddSum % i == 0 && evenSum % i == 0){
                return i;
            }
        }
        return 1;
    }
}