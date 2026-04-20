import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();

        int[] hashmap = new int[256];

    
        for (int i = 0; i < n; i++) {
            hashmap[t.charAt(i)]++;
        }

        int l = 0, r = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int startIdx = -1;

        while (r < m) {
            // include current char
            if (hashmap[s.charAt(r)] > 0) {
                count++;
            }
            hashmap[s.charAt(r)]--;

            // shrink window
            while (count == n) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    startIdx = l;
                }

                hashmap[s.charAt(l)]++;

                if (hashmap[s.charAt(l)] > 0) {
                    count--;
                }

                l++;
            }

            r++;
        }

        return startIdx == -1 ? "" : s.substring(startIdx, startIdx + minLen);
    }
}