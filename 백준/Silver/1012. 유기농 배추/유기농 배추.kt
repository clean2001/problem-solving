import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

private val dx = intArrayOf(0, 1, 0, -1)
private val dy = intArrayOf(1, 0, -1, 0)

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`));
    val t = br.readLine().toInt();

    for(u in 1.. t) {
        var st = StringTokenizer(br.readLine());

        val m = st.nextToken().toInt()
        var n = st.nextToken().toInt()
        var k = st.nextToken().toInt()

        val array = Array(m) { Array(n) { 0 } };

        for(i in 1..k) {
            st = StringTokenizer(br.readLine())
            val x = st.nextToken().toInt()
            val y = st.nextToken().toInt()

            array[x][y] = 1;
        }

        var ans = 0
        for(i in 0 ..m-1) {
            for(j in 0 ..n-1) {
                if(array[i][j] == 1) {
                    bfs(i, j, array, m ,n)
                    ans += 1
                }
            }
        }

        println(ans);
    }
    br.close();
}

fun bfs(x: Int, y:Int, array: Array<Array<Int>>, m:Int, n:Int) {
    array[x][y] = 2
    val q: Queue<IntArray> = LinkedList();
    q.add(intArrayOf(x, y))
    while(q.isNotEmpty()) {
        val cur = q.poll();

        for(dir in 0 ..3) {
            val nx = cur[0] + dx[dir];
            val ny = cur[1] + dy[dir];

            if(nx < 0 || nx  >= m || ny < 0 || ny >= n || array[nx][ny] != 1){
                continue
            }

            array[nx][ny] = 2
            q.add(intArrayOf(nx, ny))
        }
    }
}