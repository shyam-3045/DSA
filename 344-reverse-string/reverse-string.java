class Solution {

    // private void rev(int l,int r,char[] s){
    //     if(l >= r) return ;

    //     char temp = s[l];
    //     s[l]=s[r];
    //     s[r]=temp;

    //     rev(l+1,r-1,s);

    // }
    private void rev(int i ,char[] s){
        if( i>s.length /2 -1) return ;

        char temp = s[i];
        s[i]=s[s.length -i-1];
        s[s.length -i-1]=temp;

        rev(i+1,s);
    }

    public void reverseString(char[] s) {
        rev(0,s );        
    }
    
}