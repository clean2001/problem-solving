import java.util.*;

class Solution {
    public int solution(int N, int number) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i=0; i<=8; ++i) {
            map.put(i, new HashSet<>());
        }
        
        int n = N;
        for(int i=1; i<=8; ++i) {
            map.get(i).add(n);
            n = n * 10 + N;
        }
        for(int i=2; i<=8; ++i) {
            Set<Integer> cur = map.get(i);
            for(int j=1; j<=i; ++j) {
                Set<Integer> p1 = map.get(i-j);
                Set<Integer> p2 = map.get(j);
                for(int n1 : p1) {
                    for(int n2 : p2) {
                        cur.add(n1 + n2);
                        cur.add(Math.abs(n1 - n2));
                        cur.add(n1 * n2);
                        
                        if(n1 > 0 && n2 > 0) {
                            cur.add(n1 / n2);
                            cur.add(n2 / n2);
                        }
                    }
                }
            }
        }
        
        for(int i=1; i<=8; ++i) {
            if(map.get(i).contains(number)) return i;
        }
        
        return -1;
    }
}