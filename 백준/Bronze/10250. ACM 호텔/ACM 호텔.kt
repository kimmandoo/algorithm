fun main()=with(System.`in`.bufferedReader()){
    val T = readLine().toInt()
    for (tc in 0..T-1) {
        val (H, W, N) = readLine().split(" ").map { it.toInt() }
        if (N % H == 0) {
            val tmpxx = (N/H).toString()
            val XX = if ( tmpxx.length == 1) '0' + tmpxx else tmpxx
            val YY = H.toString()
            println(YY+XX)

        } else {
            val tmpxx = ((N/H)+1).toString()
            val XX = if(tmpxx.length == 1) '0' + tmpxx else tmpxx
            val YY = (N%H).toString()
            println(YY+XX)
        }
    }
}