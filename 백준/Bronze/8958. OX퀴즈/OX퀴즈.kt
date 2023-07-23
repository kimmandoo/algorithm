fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    for(i in 0 until n){
        val input = readLine().toCharArray()
        var count = 1
        var sum = 0
        for((idx, j) in input.withIndex()){
            val jString = j.toString()
            if(jString.equals("O")){
                if(idx>0){
                    if(jString.equals(input[idx-1].toString())){
                        count++
                        sum += count
                    } else {
                        count = 1
                        sum += count
                    }
                }else{
                    sum += count
                }
            }
        }
        println(sum)
    }
}