import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import java.util.function.ToDoubleFunction

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`));
    val st = StringTokenizer(br.readLine())

    val a = st.nextToken().toInt()
    val b = st.nextToken().toInt()

    println(a.toDouble() / b);
    br.close();
}