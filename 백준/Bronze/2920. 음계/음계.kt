fun main()=with(System.`in`.bufferedReader()){
    val asc = arrayListOf(1,2,3,4,5,6,7,8)
    val dsc = arrayListOf(8,7,6,5,4,3,2,1)
    val input = readLine().split(" ").map{it.toInt()}.toIntArray()
    var res = "mixed"
    for((idx, i) in input.withIndex()){
        if(i != asc[idx]){
            res = "mixed"
            break
        }else{
            res = "ascending"
        }
    }
    if(res.equals("mixed")){
        for((idx, i) in input.withIndex()){
            if(i != dsc[idx]){
                res = "mixed"
                break
            }
            res = "descending"
        }
    }
    
    print(res)
}