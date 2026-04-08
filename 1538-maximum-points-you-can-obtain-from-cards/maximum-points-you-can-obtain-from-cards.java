class Solution {
    public int maxScore(int[] a, int k) {
        int leftSum=0;
        int rightSum=0;
        int maxSum=0;
        int n=a.length;

        for(int i=0;i<k;i++ )
        {
            leftSum = leftSum+a[i];
        }

        maxSum=leftSum;
        int rightIdx = n-1;
        for(int i=k-1;i>=0;i--)
        {
            leftSum=leftSum-a[i];
            rightSum=rightSum+a[rightIdx];
            rightIdx=rightIdx-1;
            maxSum=Math.max(maxSum,leftSum+rightSum);
        }

        return maxSum;
    }
}