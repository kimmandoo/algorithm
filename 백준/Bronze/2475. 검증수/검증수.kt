fun main()=with(System.`in`.bufferedReader()){
    val input = readLine().split(" ").map{ it.toInt() }.toIntArray()
    var res = 0;
    for(i in input){
        res += i*i
    }
    print(res%10)
}