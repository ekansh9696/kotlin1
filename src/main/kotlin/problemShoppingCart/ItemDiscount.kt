package problemShoppingCart

interface ItemDiscount {
    fun getDiscountAmount(price: Double, quantity: Int): Double
}

data class DiscountNone(val discountApplied: Boolean=true) : ItemDiscount {
    override fun getDiscountAmount(price: Double, quantity: Int) = 0.0
}

data class DiscountTenPercent(val discountApplied:Boolean=true) : ItemDiscount {
    override fun getDiscountAmount(price: Double, quantity: Int) = price * .1 * quantity
}


data class BuyOneGetOne (val discountApplied: Boolean=true) : ItemDiscount {
    override fun getDiscountAmount(price: Double, quantity: Int) =
        if (quantity % 2 == 0) price * quantity / 2 else price * (quantity - 1) / 2
}

data class ConsecutiveDiscountThirtyPercent(val discountApplied: Boolean=true) : ItemDiscount {
    override fun getDiscountAmount(price: Double, quantity: Int): Double =
        if (quantity % 2 == 0) price * quantity / 2 * .3 else price * (quantity - 1) / 2 * .3
}

