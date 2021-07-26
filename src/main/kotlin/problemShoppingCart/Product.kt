package problemShoppingCart

data class Product(val name: String, val price: Double, val discount: ItemDiscount = DiscountNone()) {
    init {
        if (price < 0)
            throw error("Invalid Product Price Entered")
    }

    fun amountAfterDiscount(quantity: Int) =
        price * quantity - discount.getDiscountAmount(price, quantity)
}
