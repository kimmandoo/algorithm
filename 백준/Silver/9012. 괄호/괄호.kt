fun main()=with(System.`in`.bufferedReader()){
    val size = readLine().toInt()
    val writer = System.out.bufferedWriter()
    for(i in 0 until size){
        val input = readLine().toCharArray()
        var closed = 0 // ( = ++, ) = --
        for(j in input){
            if(j == '(') closed++
            else{
                closed--
                if(closed<0){
                    break
                }
            }
        }
        if(closed==0) writer.write("YES\n") else writer.write("NO\n")
    }

    writer.flush()
    writer.close()
    close()
}