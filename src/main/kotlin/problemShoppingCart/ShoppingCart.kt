package problemShoppingCart

class ShoppingCart(private val listItems: Map<Product, Int>?=null) {

    private val payableAmount: Double = calculateAmount()

    private fun calculateAmount(): Double {
        var result = 0.0
        if (listItems != null) {
            for (item in listItems)
            result += getPayableAmountForEachItem(item)
        return checkAndCalculateFivePercent(result)
        }
        else
            return 0.0
    }
    private fun getPayableAmountForEachItem(item: Map.Entry<Product, Int>) =
        item.key.price * item.value - item.key.discount.getDiscountAmount(item.key.price, item.value)

    private fun checkAndCalculateFivePercent(result: Double) =
        if (result <= 500) result else result - (result * .05)

    fun getPayableAmount() = payableAmount


}
