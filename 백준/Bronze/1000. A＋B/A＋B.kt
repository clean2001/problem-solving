import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`));
    val st = StringTokenizer(br.readLine());

    val a = Integer.parseInt(st.nextToken());
    val b = Integer.parseInt(st.nextToken());

    println(a + b);
    br.close();
}