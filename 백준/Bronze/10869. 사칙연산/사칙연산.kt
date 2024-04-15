fun main() = with(System.`in`.bufferedReader()){
    val input = readLine().split(" ").map{ it.toInt() }.toIntArray()
    val a = input[0]
    val b = input[1]
    println(a+b)
    println(a-b)
    println(a*b)
    println(a/b)
    println(a%b)
}