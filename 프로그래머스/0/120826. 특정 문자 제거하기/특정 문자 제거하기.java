class Solution {
    public String solution(String my_string, String letter) {
        char[] arr = my_string.toCharArray();
        char target = letter.charAt(0);
        String ans = "";
        for(char c : arr) {
            if(c != target) ans += c;
        }
        
        return ans;
    }
}