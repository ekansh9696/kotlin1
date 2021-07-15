import kotlin.math.ceil

interface ItemDiscount {
    fun getDiscountAmount(price: Double, quantity: Int): Double
}

class DiscountNone : ItemDiscount {
    override fun getDiscountAmount(price: Double, quantity: Int) = 0.0
}

class DiscountTenPercent : ItemDiscount {
    override fun getDiscountAmount(price: Double, quantity: Int) = price * .1 * quantity
}


class BuyOneGetOne : ItemDiscount {
    override fun getDiscountAmount(price: Double, quantity: Int) = if (quantity%2==0) price * quantity/2 else price*(quantity-1)/2
}

