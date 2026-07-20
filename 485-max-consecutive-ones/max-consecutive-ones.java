class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int c =0;
        for(int n : nums){
            if(n == 0){
                c =0;
                continue;
            }
            c +=1;
            max = Math.max(max , c);
        }

        return max;
    }
}