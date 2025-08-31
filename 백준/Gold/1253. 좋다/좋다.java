
import java.util.*;
import java.io.*;
class Main {
    static int[] nums;
    static int N;
    static boolean is_good(int num, int index) {
        int s = 0, e = N-1;

        while(s < e) {

            if(s == index) s++;
            if(e == index) e--;
            if(s == e) break;

            int sum = nums[s]+nums[e];
            if(sum == num) return true;

            if(sum > num) {
                e--;

            } else {
                s++;
            }
        }

        return false;

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; ++i) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int ans = 0;
        for(int i=0; i<N; ++i) {
//            System.out.println(nums[i]);
            if(is_good(nums[i], i)) {
                ans++;
            }
        }

        bw.write(ans + "\n"); bw.flush();

    }
}
