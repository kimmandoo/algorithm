fun main()=with(System.`in`.bufferedReader()){
    val input = readLine().toInt()
    var res = 0
    for(i in 1 .. input){
        res += i
    }
    print(res)
}