class Solution {
    public int[] arrayRankTransform(int[] arr) {
      int[] arr1 = Arrays.copyOf(arr,arr.length);

      Arrays.sort(arr1);
      int prev = Integer.MIN_VALUE;
      int rank =0;
      HashMap<Integer,Integer> map = new HashMap<>();
      for(int n : arr1){
        if(n > prev){ 
            rank++;   
        }
        map.put(n,rank);
        prev = n;
      } 

      int[] ans = new int[arr.length];
      for(int i=0;i<arr.length;i++){
        ans[i] = map.get(arr[i]);
      }

      return ans;
    }
}