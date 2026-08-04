class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        List<Integer> li =new ArrayList<>();

        for(int i=0;i < nums.length-1;i++){
            int j =i+1;
            
                if(nums[j] - nums[i] > 1 ){
                    for(int x = nums[i]+1 ;x<nums[j];x++){
                        li.add(x);
                    }
                }
            
        }

        return  li;
    }
}