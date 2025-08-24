import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[] A;
    static Integer[] B;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        B = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; ++i) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; ++i) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A); Arrays.sort(B, Collections.reverseOrder());
        int ans = 0;
        for(int i=0; i<N; ++i) {
            ans += A[i]*B[i];
        }

        bw.write(ans + "\n");
        bw.flush();
    }
}