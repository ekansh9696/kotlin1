package problemShoppingCart

data class Product(val name: String, val price: Double, val discount: ItemDiscount = DiscountNone()) {
    init {
        if (price < 0)
            throw error("Invalid Product Price Entered")
    }

    fun amountAfterDiscount(quantity: Int) =
        price * quantity - discount.discountAmount(price, quantity)

    override fun hashCode(): Int =
        name.hashCode() + price.hashCode() + discount.discountAmount.hashCode()

    override fun equals(other: Any?): Boolean =
        this.hashCode() == other.hashCode()
}