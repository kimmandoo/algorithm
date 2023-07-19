fun main()=with(System.`in`.bufferedReader()){
    val input = readLine().toInt()
    val str = StringBuilder()
    val stars = "*"
    for(i in 1..input){
        str.append(stars)
        println(str)
    }
}