import java.io.*;
import java.util.*;

class B5430 {
    static int T;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            String cmd = br.readLine();
            int len = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), ",");
            Deque<Integer> dq = new LinkedList<>();

            for(int i=0; i<len; ++i) {
                String s = st.nextToken();
                s = s.replace("[", "");
                s = s.replace("]", "");

                dq.add(Integer.parseInt(s));
            }

            boolean flag = false;
            boolean error = false;
            for(int i=0; i<cmd.length(); ++i) {
                if(cmd.charAt(i) == 'R') {
                    flag = !flag;
                } else { // D
                    if(dq.isEmpty()) {
                        error = true;
                        break;
                    } else if(!flag) {
                        dq.removeFirst();
                    } else dq.removeLast();

                }
            }

            if(error) {
                bw.write("error\n"); continue;
            }

            if(flag) {
                bw.write("[");
                while(!dq.isEmpty()) {
                    bw.write(Integer.toString(dq.pollLast()));
                    if(!dq.isEmpty()) bw.write(",");
                }
                bw.write("]\n");
            } else {
                bw.write("[");
                while(!dq.isEmpty()) {
                    bw.write(Integer.toString(dq.pollFirst()));
                    if(!dq.isEmpty()) bw.write(",");
                }
                bw.write("]\n");
            }


        }

        bw.flush();
    }
}