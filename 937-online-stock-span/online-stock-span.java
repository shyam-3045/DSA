import java.util.*;

class StockSpanner {

    private Stack<int[]> st;
    private int idx;

    public StockSpanner() {
        st = new Stack<>();
        idx = -1;
    }
    
    public int next(int price) {
        idx++;

        while (!st.isEmpty() && st.peek()[0] <= price) {
            st.pop();
        }

        int ans = idx - (st.isEmpty() ? -1 : st.peek()[1]);
        st.push(new int[]{price, idx});

        return ans;
    }
}