import java.util.*

fun main()=with(System.`in`.bufferedReader()){
    val output = System.out.bufferedWriter()
    var s: String?
    while(readLine().also{ s = it} != null){
        val st = StringTokenizer(s)
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        output.write("${a+b}\n")
    }
    output.flush()
    output.close()
    close()
}