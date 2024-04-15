import java.util.*

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    for(i in 0 until n){
        val st = StringTokenizer(readLine())
        val rep = st.nextToken().toInt()
        val inputString = st.nextToken().toCharArray()
        val sb = StringBuilder()
        for(i in inputString){
            for(j in 0 until rep){
                sb.append(i)
            }
        }
        println(sb)
    }
}