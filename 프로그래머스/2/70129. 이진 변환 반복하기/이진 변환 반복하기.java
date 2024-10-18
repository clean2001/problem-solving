class Solution {
    public int[] solution(String s) {
        int cnt = 0;
        int z = 0;
        while(!s.equals("1")) {
            cnt++;
            int zeros = 0;
            for(int i=0; i<s.length(); ++i) {
                char c = s.charAt(i);
                
                if(c == '0') {
                    zeros++;
                }
            }
            StringBuilder sb = new StringBuilder();
            int ones = s.length() - zeros;
            while(ones > 0) {
                int d = ones % 2;
                ones /= 2;
                
                if(d == 1) {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
            }
            
            s = sb.toString();
            z += zeros;
            
        }
        return new int[]{cnt, z};
    }
    
    
}