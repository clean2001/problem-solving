import java.util.*;

class Solution {
    static String[] nums;
    static int len;
    static int ans = 0;
    static boolean[] vis;
    static boolean[] isCom;
    static Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        nums = numbers.split("");
        len = numbers.length();
        vis = new boolean[len];
        
        
        perm(0, new StringBuilder());
        return set.size();
    }
    
    private void perm(int depth, StringBuilder sb) {
        if(depth == len && sb.length() == 0) return;
        if(depth == len) {
            int result = Integer.parseInt(sb.toString());
            if(result > 1 && isPrime(result)) {
                // System.out.println(result);
                set.add(result);
            }
            return;
        }
        
        for(int i=0; i<len; ++i) {
            if(vis[i]) continue;
            vis[i] = true;
            sb.append(nums[i]);
            perm(depth+1, sb);
            sb.delete(sb.length()-1, sb.length());
            vis[i] = false;
            perm(depth+1, sb);
        }
    }
    private static boolean isPrime(int num) {
        int k = (int)Math.sqrt(num);
        for(int i=2; i<=k; i++) {
            if(num % i == 0) return false;
        }
        
        return true;
    }
}