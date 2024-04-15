fun main()=with(System.`in`.bufferedReader()){
    val input = readLine().split(" ").map{it.toLong()}.toLongArray()
    print(input[0]+input[1]+input[2])
    close()
}