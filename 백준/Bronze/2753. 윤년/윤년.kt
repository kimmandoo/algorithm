fun main()=with(System.`in`.bufferedReader()){
    val input = readLine().toInt()
    // 4배수면서 100배수가 아니거나, 400배수면 윤년
    val result = if(input%400 == 0){
        1
    }else if(input%4 == 0 && input%100 != 0){
        1
    }else{
        0
    }
    print(result)
}