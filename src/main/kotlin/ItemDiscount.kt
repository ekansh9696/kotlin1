interface ItemDiscount {
    fun getDiscountAmount(price: Double, quantity: Int): Double
}

class DiscountNone : ItemDiscount {
    override fun getDiscountAmount(price: Double, quantity: Int) = 0.0
}

class DiscountTenPercent : ItemDiscount {
    override fun getDiscountAmount(price: Double, quantity: Int) = price * .1 * quantity
}

