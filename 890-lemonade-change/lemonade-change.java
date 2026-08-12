class Solution {
    public boolean lemonadeChange(int[] bills) {

        if(bills[0] != 5) return false;
       int bill5=0;
       int bill10=0;

       

       for(int n : bills)
       {
        if(n == 5){
            bill5++;
        }

        else if(n == 10)
        {
            if(bill5 < 1) return false;
            
                bill5 --;
                bill10++;
            
        }
        else if(n==20)
        {
            if(bill10 >= 1 && bill5 >= 1) {
                bill5--;
                bill10--;
            }
            else if(bill5 >= 3 ){
                bill5 -= 3;
            }
            else{
                return false;
            }   
        }
       } 

       return true;
    }
}