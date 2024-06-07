class Solution {
    public String solution(String my_string, String letter) {
        String ans = "";
        int milestone = 0;
        for(int i=0; i<my_string.length(); ++i) {
            if(my_string.substring(i, i+1).equals(letter)) {
                ans += my_string.substring(milestone, i);
                milestone = i+1;
            }
        }
        
        if(milestone < my_string.length())
            ans += my_string.substring(milestone);
        
        return ans;
    }
}