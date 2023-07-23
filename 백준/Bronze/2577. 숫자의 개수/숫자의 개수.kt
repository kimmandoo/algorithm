fun main()=with(System.`in`.bufferedReader()){
    var mt = readLine().toInt()
    for(i in 0..1){
        mt *= readLine().toInt()
    }
    val input = (mt.toString()).toCharArray()
    val number = IntArray(10) // 0~9
    for(i in input){
        val idx = Character.getNumericValue(i)
        number[idx] += 1
    }
    for(i in number){
        println(i)
    }
}