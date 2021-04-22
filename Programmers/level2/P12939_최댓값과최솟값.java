package D4;

import java.util.*;

public class P12939_최댓값과최솟값 {
	
	class Solution {
	    public String solution(String s) {        
	        StringTokenizer st = new StringTokenizer(s, " ");
	        int max = -123456789, min = 123456789;
	        int num;
	        while(st.hasMoreTokens()){
	            num = Integer.parseInt(st.nextToken());
	            max = Math.max(max,num);
	            min = Math.min(min,num);
	        }
	        
	        return min + " " + max;
	    }
	}

}
