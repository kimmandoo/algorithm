fun main() = with(System.`in`.bufferedReader()){
    val arr = mutableListOf<Int>()
    for(i in 1..9){
       arr.add(readLine().toInt())
    }
    
    val max = arr.max()
    val maxIdx = arr.indexOf(max)+1
    println(max)
    println(maxIdx)
    close()
}