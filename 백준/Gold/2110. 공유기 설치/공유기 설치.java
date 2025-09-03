import java.util.*;
import java.io.*;

class Main {

    static int N, C;
    static int[] arr;

    static boolean can(int cur) {
        int cnt = 1;
        int prev = arr[0];
        int present = 0;

        for(int i=1; i<N; ++i) {
            present = arr[i];

            if(present-prev >= cur) {
                prev = present;
                cnt++;
            }
        }
        if(cnt >= C) return true;
        else return false;

    }
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for(int i=0; i<N; ++i) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int s = 1, e = 1000000001;
        int mid = 0, ans = 0;
        while(s <= e) {
            mid = (s+e+1)/2;

            if(can(mid)) {
                s = mid+1;
                ans = Math.max(mid, ans);
            } else {
                e = mid-1;
            }
        }

        bw.write(ans + "\n"); bw.flush();
    }
}