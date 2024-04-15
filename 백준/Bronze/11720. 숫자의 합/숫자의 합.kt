fun main()=with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val input = readLine().toCharArray()
    var res = 0
    for(i in input){
        res += Character.getNumericValue(i)
    }
    print(res)
}