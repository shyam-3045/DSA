class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
    List<Integer> l1 = new ArrayList<>();
    List<Integer> l2 = new ArrayList<>();
    int[] ans = new int[nums.length];

    int c =0 ;

    for(int i=0 ;i<nums.length;i++){
        if(nums[i] < pivot){
            l1.add(nums[i]);
        }
        else if(nums[i] > pivot){
            l2.add(nums[i]);
        }
        else if( nums[i] == pivot){
            c++;
        }
    }
    int idx = 0;

    for(int i=0;i<l1.size();i++){
        ans[idx]=l1.get(i);
        idx++;
    }

    for(int i=0;i<c;i++)
    {
        ans[idx]=pivot;
        idx++;
    }

    for(int i=0;i<l2.size();i++)
    {
       ans[idx]=l2.get(i);
       idx++;
    }

    return ans ;

    }
}