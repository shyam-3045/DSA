class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length+nums2.length];
        int k =0;

        for(int i=0;i<nums1.length;i++){
            nums[k++]=nums1[i];
        }

        for(int i=0;i<nums2.length;i++){
            nums[k++]=nums2[i];
        }

        Arrays.sort(nums);

        if(nums.length % 2 == 1){
            return (double) nums[nums.length /2];
        }
        else{
            int num1 =nums[nums.length /2-1];
            int num2 =nums[nums.length /2];

            return ((double) num1 + (double) num2) / 2.0 ;
            

        }

    }
}