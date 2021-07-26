package problemShoppingCart

class ShoppingCart {
    private val listItems: MutableMap<Product, Int> = mutableMapOf()

    fun getPayableAmount(): Double = if (listItems.isNotEmpty()) getBill() else 0.0

    fun addItemToCart(item: Product, quantity: Int) =
        if (listItems.isEmpty()) listItems[item] = quantity else itemPresentOrNew(item, quantity)


    fun removeItemFromCart(item: Product, quantity: Int) {
        checkExceptions(item, quantity)
        listItems[item] = if (listItems.containsKey(item)) listItems[item]!! - quantity else quantity
    }


    private fun getBill() =
        FivePercent().discountAmount(listItems.keys.sumOf { it.amountAfterDiscount(listItems[it]!!) }, 1)


    private fun itemPresentOrNew(item: Product, quantity: Int) {

        listItems[item] = if (listItems.containsKey(item)) listItems[item]!! + quantity else quantity
    }

    private fun checkExceptions(item: Product, quantity: Int) {
        if (listItems.isEmpty())
            throw error("Cart is empty")
        if (quantity <= 0)
            throw error("0 or negative quantity amount")
        if (item !in listItems)
            throw error("No such product in cart")
        if (listItems[item]!! < quantity)
            throw error("Not enough quantity in cart to remove")
    }

}


