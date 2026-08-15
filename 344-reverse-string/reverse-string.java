class Solution {

    private void rev(int l,int r,char[] s){
        if(l >= r) return ;

        char temp = s[l];
        s[l]=s[r];
        s[r]=temp;

        rev(l+1,r-1,s);

    }
    public void reverseString(char[] s) {
        rev(0,s.length -1,s );        
    }
    
}