class Solution {
    public String solution(String number, int k) {
        int line = k;
        int left = 0;
        StringBuilder sb = new StringBuilder();
        while(line < number.length()) {
            // 최대값 구하기
            int maxVal = -1, idx = -1;
            for(int i=left; i<=line; ++i) {
                if(maxVal < number.charAt(i) - '0') {
                    maxVal = number.charAt(i) - '0';
                    idx = i;
                }
            }
            
            left = idx+1;
            line++;
            sb.append(Integer.toString(maxVal));
        }
        
        return sb.toString();
    }
}