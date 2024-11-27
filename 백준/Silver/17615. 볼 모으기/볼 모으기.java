import java.io.*;
import java.util.*;

class Main {
    static int N;
    static String S;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        S = br.readLine();

        int n1 = 0, n2 = 0, n3 = 0, n4 = 0;

        // R, 왼
        boolean flag;
        if(S.charAt(0) == 'R') flag = false; // R
        else flag = true; // B
        for(int i=1; i<N; ++i) {
            if (S.charAt(i) == 'R' && flag) {
                n1++;
            } else if(S.charAt(i) == 'B' && !flag) {
                flag = true;
            }
        }

        // R, 오
        if(S.charAt(N-1) == 'R') flag = false; // R
        else flag = true; // B
        for(int i=N-2; i>=0; --i) {
            if (S.charAt(i) == 'R' && flag) {
                n2++;
            } else if(S.charAt(i) == 'B' && !flag) {
                flag = true;
            }
        }

        // B, 왼
        if(S.charAt(0) == 'B') flag = false; // B
        else flag = true; // R
        for(int i=1; i<N; ++i) {
            if (S.charAt(i) == 'B' && flag) {
                n3++;
            } else if(S.charAt(i) == 'R' && !flag) {
                flag = true;
            }
        }

        // B, 오
        if(S.charAt(N-1) == 'B') flag = false; // B
        else flag = true; // R
        for(int i=N-2; i>=0; --i) {
            if (S.charAt(i) == 'B' && flag) {
                n4++;
            } else if(S.charAt(i) == 'R' && !flag) {
                flag = true;
            }
        }

//        System.out.println(n1 + " " + n2 + " " + n3 + " " + n4);
        int ans = Math.min(n1, n2);
        ans = Math.min(ans, n3);
        ans = Math.min(ans, n4);

        System.out.println(ans);

    }
}