package screen

import LINE_DIVIDER
import data.CartItems
import data.Product
import extensions.getNotEmptyInt
import extensions.getNotEmptyString

class ShoppingProductList(private val selectedCategory : String) : Screen(){
    private val products = arrayOf(
        Product("패션", "겨울패딩"),
        Product("패션", "겨울바지"),
        Product("전자기기", "아이폰"),
        Product("전자기기", "에어팟"),
        Product("전자기기", "애플워치"),
        Product("반려동물용픔", "건식사료"),
        Product("반려동물용픔", "습식사료"),
        Product("반려동물용픔", "치약"),
        Product("반려동물용픔", "간식")
    )

    private val categories:Map<String,List<Product>> = products.groupBy {
        product -> product.categoryLabel
    }

    fun showProducts(){
        ScreenStack.push(this)
        val categoryProduct = categories[selectedCategory]
        if (!categoryProduct.isNullOrEmpty()) {
            println("""
                $LINE_DIVIDER
                선택하신 [$selectedCategory] 카테고리 상품입니다.
            """.trimIndent())

            categoryProduct.forEachIndexed { index, product ->
                println("${index}.${product.name}") }
           /*
           val size = categoryProduct.size
           for(index in 0  until  size){
                println("${index}.${categoryProduct[index].name}")
            }*/
            showCartOption(categoryProduct)
        }else{
           showEmptyProductMessage(selectedCategory)
        }
    }

    private fun showCartOption(categoryProducts : List<Product>){
        println("""
            $LINE_DIVIDER
            장바구니에 담을 상품 번호를 선택해주세요.
        """.trimIndent())

        val selectedIndex = readLine().getNotEmptyInt()
        categoryProducts.getOrNull(selectedIndex)?.let{ product ->
            CartItems.addProduct(product)
            println("=>장바구니로 이동하시려면 #을, 계속 쇼핑하시려면 *을 입력해주세요.")
            val answer = readLine().getNotEmptyString()
            if(answer == "#"){
             val shoppingCart = ShoppingCart()
                shoppingCart.showCartItems()
            }else if(answer =="*"){
                showProducts()
            }else{
                //TODO 그외의 값에 대한 처리
            }
        }?:kotlin.run {
            println("$selectedIndex 번은 목록에 없는 상품 번호 입니다. 다시 입력해주세요.")
        }
    }

    private fun showEmptyProductMessage(selectedCategory: String) {
        println("[$selectedCategory] 카테고리 상품이 등록되기 전입니다.")
    }
}