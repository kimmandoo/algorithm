fun main() = with(System.`in`.bufferedReader()){
    val input = readLine().toInt()
    for(i in 1..9){
        val res = input*i
        println("$input * $i = $res")
    }
    close()
}