fun main() = with(System.`in`.bufferedReader()){
    val hashMap = HashMap<String, Int>()
    val input = readLine().toCharArray()
    
    for(i in input){
        val key = i.toString().lowercase()
        if(!hashMap.containsKey(key)){
            hashMap.put(key, 1)
        }else{
            val curVal = hashMap.get(key)!!
            hashMap.put(key, curVal+1)
        }
    }
    val sortedMap = hashMap.toList().sortedBy{it.second}
    val sortedMapLen = sortedMap.size
    if(sortedMapLen == 1){
        print((sortedMap[sortedMapLen-1].first).uppercase())
    }
    else if(sortedMap[sortedMapLen-1].second != sortedMap[sortedMapLen-2].second) print((sortedMap[sortedMapLen-1].first).uppercase())
    else print("?")

}