fun main(){
    val n = 2; //size
    val arr = readLine()!!.split(" ").map{it.toInt()}.toIntArray()
    
    println(arr[0]/(arr[1].toDouble()))
}