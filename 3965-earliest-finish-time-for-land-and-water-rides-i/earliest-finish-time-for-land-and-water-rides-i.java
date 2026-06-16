class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int len = Math.min(landStartTime.length , waterStartTime.length);
        int ans =Integer.MAX_VALUE;
        for(int i=0;i<landStartTime.length;i++){
            for(int j=0;j<waterStartTime.length;j++){
                int landTime = landStartTime[i]+landDuration[i];
                int waterTime = waterStartTime[j]+waterDuration[j];

                int case1=landTime+Math.max(0,waterStartTime[j] - landTime)+waterDuration[j];
                int case2 = waterTime+Math.max(0,landStartTime[i] - waterTime)+landDuration[i];

                int temp = Math.min(case1,case2);
                ans=Math.min(ans,temp);

            }

           
        }


       

        return ans ;
    }
}