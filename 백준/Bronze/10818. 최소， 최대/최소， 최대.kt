fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val input = readLine().split(" ").map{ it.toInt() }.toIntArray()
    val min = input.min()
    val max = input.max()
    println("$min $max")
}