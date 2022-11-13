fun main(args: Array<String>) {
    println("안녕하세요, Shoppi 에 오신 것을 환영합니다!")
    println("쇼핑을 계속하시려면 이름을 입력해주세요 :)")

    val name = readLine()
    println("""
        감사합니다. 반갑습니다, $name 님
        원하시는 카테고리를 입력해주세요
        ***============================***
    """.trimIndent())

  //  loopText()
    val matrix = arrayOf(intArrayOf(1,2,3), intArrayOf(4,5,6))

    for(row in matrix){
        for(col in row){
            //if(col ==2) break
            print("$col")
        }
        println()
    }
}
//isNullOrEmpty() : null이면 false를 반환
//isNullOrBlank() : null과 공백 모두 false를 반환환

