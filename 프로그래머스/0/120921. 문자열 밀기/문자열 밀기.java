class Solution {
    public int solution(String A, String B) {
        StringBuilder sb = new StringBuilder(A);
        if(A.equals(B)) return 0;
        
        for(int i=0; i<A.length(); ++i) {
            char c = A.charAt(A.length() - 1 - i);
            sb.delete(A.length()-1, A.length());
            sb.insert(0, c);
            
            System.out.println(sb);
            if(B.equals(sb.toString())) {
                return i+1;
            }
        }
        
        return -1;
    }
}