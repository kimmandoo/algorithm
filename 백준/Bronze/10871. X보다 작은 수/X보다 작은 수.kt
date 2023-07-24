fun main()=with(System.`in`.bufferedReader()){
    val input = readLine().split(" ").map{it.toInt()}.toIntArray()
    val n = input[0]
    val target = input[1]
    val resArray = ArrayList<Int>()
    val input2 = readLine().split(" ").map{it.toInt()}.toIntArray()
    for(i in input2){
        if(i<target) resArray.add(i)
    }
    for(i in resArray){
        print("$i ")
    }
}