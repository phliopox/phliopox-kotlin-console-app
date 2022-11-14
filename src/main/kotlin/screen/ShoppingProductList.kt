package screen

import data.Product

class ShoppingProductList {
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

    fun showProducts(selectedCategory : String){
        val categoryProduct = categories[selectedCategory]
        if (!categoryProduct.isNullOrEmpty()) {
            println("""
                ***=================***
                선택하신 [$selectedCategory] 카테고리 상품입니다.
            """.trimIndent())
            val size = categoryProduct.size
            for(index in 0  until  size){
                println("${index}.${categoryProduct[index].name}")
            }
        }else{
           showEmptyProductMessage(selectedCategory)
        }
        }

    private fun showEmptyProductMessage(selectedCategory: String) {
        println("[$selectedCategory] 카테고리 상품이 등록되기 전입니다.")
    }
}