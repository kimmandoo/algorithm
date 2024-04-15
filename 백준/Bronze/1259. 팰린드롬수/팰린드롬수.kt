fun main()=with(System.`in`.bufferedReader()){
    val writer = System.out.bufferedWriter()
    while(true){
        val input = readLine().map{Character.getNumericValue(it)}.toIntArray()
        val n = input.size - 1
        var res = "no"
        if(input[0]==0) break
        else{
            val rv = input.reversedArray()
            for((idx, i) in input.withIndex()){
                if(i==rv[idx]){
                    res = "yes"
                }else{
                    res = "no"
                    break
                }
            }
            writer.write("$res\n")
        }
    }

    writer.flush()
    writer.close()
    close()
}