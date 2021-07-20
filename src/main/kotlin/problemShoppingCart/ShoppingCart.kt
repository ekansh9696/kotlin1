package problemShoppingCart

class ShoppingCart {
    private var listItems: MutableMap<Product, Int> = mutableMapOf()
    private var payableAmount: Double = 0.0

    fun getPayableAmount(): Double {
        payableAmount = calculateAmount()
        return payableAmount
    }

    private fun calculateAmount(): Double {
        var result = 0.0
        if (listItems.isNotEmpty())
            for (item in listItems)
                result += getPayableAmountForEachItem(item)
        else
            return 0.0

        return checkAndCalculateFivePercent(result)
    }

    private fun getPayableAmountForEachItem(item: Map.Entry<Product, Int>) =
        item.key.price * item.value - item.key.discount.getDiscountAmount(item.key.price, item.value)

    private fun checkAndCalculateFivePercent(result: Double) =
        if (result <= 500) result else result - (result * .05)


    fun addItemToCart(buyingItem: Pair<Product, Int>) {
        if (listItems.isEmpty()) listItems = mutableMapOf(buyingItem) else ItemPresentOrNew(buyingItem)
    }

    private fun ItemPresentOrNew(buyingItem: Pair<Product, Int>) {
        val allProducts = listItems.keys
        if (buyingItem.first in allProducts) {
            val updatedQuantity: Int = listItems[buyingItem.first]!! + buyingItem.second
            listItems[buyingItem.first] = updatedQuantity
        } else
            listItems[buyingItem.first] = buyingItem.second
    }

}

