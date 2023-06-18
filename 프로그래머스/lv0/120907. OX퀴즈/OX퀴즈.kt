class Solution {
    fun solution(quiz: Array<String>): Array<String> {
        var answer: Array<String> = arrayOf<String>()
        for(i in quiz){
            //공백으로 나눔
            val array = i.split(" ")
            if(array[1].equals("-")){
                //뺼셈일때
                if(array[4].toInt() == array[0].toInt() - array[2].toInt()){answer += "O"}else{answer +="X"}
            }else{
                if(array[4].toInt() == array[0].toInt() + array[2].toInt()){answer += "O"}else{answer +="X"}
            }
        }
        return answer
    }
}