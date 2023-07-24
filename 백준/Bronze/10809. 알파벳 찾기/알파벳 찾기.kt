fun main()=with(System.`in`.bufferedReader()){
    val input = readLine()
    val alphabet = mutableListOf<Int>()// indexOf는 false값이 -1이라 이게 필요없긴함
    // ascii 97~
    for(i in 0 until 26){
        val tochar = (i+97).toChar()
        alphabet.add(input.indexOf(tochar))
    }
    for(i in alphabet){
        print("$i ")
    }
}