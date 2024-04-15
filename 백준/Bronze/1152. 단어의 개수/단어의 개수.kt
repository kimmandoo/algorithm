import java.util.*
import java.io.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = StringTokenizer(br.readLine())
    println(input.countTokens())
}