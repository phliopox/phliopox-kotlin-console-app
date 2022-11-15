import screen.ShoppingHome

fun main(args: Array<String>) {

    val shoppingHome = ShoppingHome()
    shoppingHome.start()

}

//isNullOrEmpty() : null이면 false를 반환
//isNullOrBlank() : null과 공백 모두 false를 반환환

//반복문
/*
fun loopText(){

    //  loopText()
    val matrix = arrayOf(intArrayOf(1,2,3), intArrayOf(4,5,6))

    for(row in matrix){
        for(col in row){
            //if(col ==2) break
            print("$col")
        }
        println()
    }

  loop@ for( row in matrix){
      for(col in row){
          if(col ==2) break@loop
          print("$col")
      }
      println()
  }

    for (row  in matrix){
        for(col in row){
            if(col==2) continue
            println("$col")
        }
    }

}*/

/*
* class Product constructor (val categoryLabel : String)
*
* class Product (val categoryLabel : Stirng)
*
* class
* */