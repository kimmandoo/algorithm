fun main()=with(System.`in`.bufferedReader()){
    val writer = System.out.bufferedWriter()
    while(true){
        val input = readLine().split(" ").map{it.toInt()}.toIntArray().sorted()
        if(input[0]==0 && input[1]==0 && input[2]==0) break;
        else{
            val result = if(input[2]*input[2] == input[1]*input[1]+input[0]*input[0]) "right"
                         else "wrong"
            writer.write("$result\n")
        }
    }
    writer.flush()
    writer.close()
    close()
}