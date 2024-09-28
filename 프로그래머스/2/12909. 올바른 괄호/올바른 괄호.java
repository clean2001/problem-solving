import java.util.*;

class Solution {
    boolean solution(String s) {
        Deque<Character> dq = new LinkedList<>();
        
        for(int i=0; i< s.length(); ++i) {
            char c = s.charAt(i);
            if(!dq.isEmpty() && c == ')' && dq.peekFirst() == '(') {
                dq.pollFirst();
            } else if(c == '(') {
                dq.addFirst(c);
            } else {
                return false;
            }
        }
        
        if(dq.isEmpty()) return true;
        return false;
    }
}