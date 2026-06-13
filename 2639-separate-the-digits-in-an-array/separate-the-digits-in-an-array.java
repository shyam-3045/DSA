class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> li = new ArrayList<>();
        for(int i=nums.length-1 ;i>=0 ;i--){
            while(nums[i] != 0){
                int val = nums[i]%10;
                li.add(val);
                nums[i] = nums[i]/10;
            }
        }

        int[] ans = new int[li.size()];
        int k = li.size()-1;
        for(int num : li){
            ans[k] = num;
            k--;
        }

        return ans;
    }
}