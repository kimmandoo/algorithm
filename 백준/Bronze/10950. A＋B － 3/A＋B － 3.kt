fun main()=with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    for(i in 0 until n){
        val input = readLine().split(" ").map{it.toInt()}.toIntArray()
        println(input[0]+input[1])
    }
}