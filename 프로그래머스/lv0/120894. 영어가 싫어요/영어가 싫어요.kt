class Solution {
    fun solution(numbers: String): Long {
        var answer: Long = 0
        var res: String = ""
        val numbersArray = arrayOf("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
        var tmp = ""
        val numbersCharArray = numbers.toCharArray()
        
        for(i in numbersCharArray){
            tmp += i
            if(tmp in numbersArray){
                if(tmp.equals("zero")) res += "0"
                if(tmp.equals("one")) res += "1"
                if(tmp.equals("two")) res += "2"
                if(tmp.equals("three")) res += "3"
                if(tmp.equals("four")) res += "4"
                if(tmp.equals("five")) res += "5"
                if(tmp.equals("six")) res += "6"
                if(tmp.equals("seven")) res += "7"
                if(tmp.equals("eight")) res += "8"
                if(tmp.equals("nine")) res += "9"
                
                tmp = ""
            }
        }
        
        answer = res.toLong()
        
        return answer
    }
}