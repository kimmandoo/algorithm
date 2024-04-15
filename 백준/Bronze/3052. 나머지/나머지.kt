fun main()=with(System.`in`.bufferedReader()){
    val hashSet = mutableSetOf<Int>()
    for(i in 0..9){
        val input = readLine().toInt()
        hashSet.add(input%42)
    }
    print(hashSet.size)
}