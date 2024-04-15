fun main()=with(System.`in`.bufferedReader()){
    val input = readLine()
    val idx = readLine().toInt()
    print(input.get(idx-1))
}