import java.util.*;
  class Solution {
    boolean solution(String s) {
      Stack<Character> st = new Stack<>();
      boolean ans = true;
      for(int i = 0; i<s.length(); ++i) {
         char c = s.charAt(i);
        if(c == '(') {
          st.push(c);
        } else {
          if(!st.isEmpty() && st.peek() == '(') {
            st.pop();
          } else {
            st.push(c);
          }
        }
      }

      if(!st.isEmpty()) ans = false;
      return ans;
    }
  }