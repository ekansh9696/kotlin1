package problemShoppingCart

class ShoppingCart {
    private var listItems: Map<Product, Int> = mapOf()
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
        if (listItems.isEmpty()) listItems = mapOf(buyingItem) else itemPresentOrNew(buyingItem)
    }

    private fun itemPresentOrNew(buyingItem: Pair<Product, Int>) {

        if (listItems.containsKey(buyingItem.first)) {
            val updatedQuantity: Int = listItems[buyingItem.first]!! + buyingItem.second
            listItems = listItems.minus(buyingItem.first)
            listItems = listItems.plus(Pair(buyingItem.first, updatedQuantity))
        } else
            listItems = listItems.plus(buyingItem)

    }
}


