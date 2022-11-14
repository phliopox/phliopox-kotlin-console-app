package data

object CartItems {
    private val mutableProducts = mutableMapOf<Product,Int>()
    val products : Map<Product,Int> = mutableProducts
// 외부에 공개되는 상품은 read only만 가능하게 immutable Map

    fun addProduct(product: Product){
        mutableProducts[product]?.let {
            mutableProducts[product] = it + 1
        } ?: kotlin.run{
            mutableProducts[product] = 1
        }
    }
}