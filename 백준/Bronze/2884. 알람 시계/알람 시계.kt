fun main()=with(System.`in`.bufferedReader()){
    val input = readLine().split(" ").map{it.toInt()}.toIntArray()
    val h = input[0]
    val m = input[1]
    // 분으로 환산해서 -로 가면 0을 (시*60+분)으로 바꾼다.
    val resultM = if(h==0 && m<45){
        24*60 + m - 45
    }else{
        h*60 + m - 45
    }
    print("${resultM/60} ${resultM%60}")
}