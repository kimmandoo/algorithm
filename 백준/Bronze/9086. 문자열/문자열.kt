fun main()=with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    for(i in 0 until n){
        val input = readLine().toCharArray()
        println("${input[0]}${input[input.size-1]}")
    }
}