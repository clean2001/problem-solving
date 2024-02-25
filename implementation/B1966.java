import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class B1966 {
    static int T, N, M;

    static class Node{
        int idx;
        int val;

        Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            Queue<Node> pq = new LinkedList<>();
            PriorityQueue<Integer> check = new PriorityQueue<>(Collections.reverseOrder());

            int target = 0;
            for(int i=0; i<N; ++i) {
                int val = Integer.parseInt(st.nextToken());
                if(i == M) target = val;

                pq.add(new Node(i, val));
                check.add(val);
            }

            int num = 0;
            while(!pq.isEmpty()) {
                int cur_idx = pq.peek().idx;
                int cur_val = pq.peek().val;
                pq.remove();


//                System.out.println("line 58 " + check.peek());
                if(!check.isEmpty() && cur_val == check.peek()) {
                    num++;
                    // 맞으니까 break;
                    if(cur_idx == M) {
                        break;
                    }
                    check.remove();
                } else {
                    pq.add(new Node(cur_idx, cur_val));
                }

            }

            System.out.println(num);

        }

    }
}
