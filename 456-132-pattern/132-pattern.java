class Solution {
    public boolean find132pattern(int[] nums) {
     Stack<int[]> st = new Stack<>();
     int min = nums[0];

     for(int i=1;i<nums.length;i++)
     {
        while(!st.isEmpty() && st.peek()[0] < nums[i])
        {
            st.pop();
        }
        if(!st.isEmpty() && st.peek()[0] > nums[i] && st.peek()[1] < nums[i])
        {
            return true ;
        }

        st.push(new int[]{nums[i],min});
        min = Math.min(min,nums[i]);

     }

     return false ;

    
    }
}