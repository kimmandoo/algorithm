fun main()=with(System.`in`.bufferedReader()){
    val input = readLine().split(" ").map{it.toInt()}.toIntArray()
    print(input[0]*input[1])
}