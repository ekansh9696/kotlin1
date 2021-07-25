package problemShoppingCart

class ShoppingCart {
    private val listItems: MutableMap<Product, Int> = mutableMapOf()

    fun getPayableAmount(): Double {

        return if (listItems.isNotEmpty())
            FivePercent().getDiscountAmount(listItems.keys.sumOf {
                it.price * listItems[it]!! - it.discount.getDiscountAmount(
                    it.price,
                    listItems[it]!!
                )
            }, 1)
        else
            0.0

    }

    fun addItemToCart(item : Product, quantity : Int) {
        if (listItems.isEmpty()) listItems[item] = quantity else itemPresentOrNew(item,quantity)
    }

    private fun itemPresentOrNew(item : Product,quantity : Int) {

        if (listItems.containsKey(item)) {
            val updatedQuantity: Int = listItems[item]!! + quantity
            listItems[item] = updatedQuantity
        } else
            listItems[item] = quantity
    }
}


