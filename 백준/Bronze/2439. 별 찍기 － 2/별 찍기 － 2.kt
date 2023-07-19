fun main()=with(System.`in`.bufferedReader()){
    val input = readLine().toInt()
    val str = StringBuilder()
    for(i in 1..input){
        if(i == input) str.append("*")
        else str.append(" ")
    }
    for(i in 1..input){
        println(str)
        str.deleteCharAt(0)
        str.append("*")
    }
}