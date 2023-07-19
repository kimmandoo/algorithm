fun main() = with(System.`in`.bufferedReader()){
    val nums = readLine().split(" ").map{it.toInt()}.toIntArray()
    val result = when{
        nums[0]>nums[1] -> ">"
        nums[1]>nums[0] -> "<"
        else -> "=="
    }
    print(result)
}