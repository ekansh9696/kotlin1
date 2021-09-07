package problemShoppingCart

interface ItemDiscount {
    val discountAmount: (Double, Int) -> Double
}

class DiscountNone : ItemDiscount {
    override val discountAmount: (Double, Int) -> Double = { _: Double, _: Int -> 0.0 }
}

class DiscountTenPercent : ItemDiscount {
    override val discountAmount: (Double, Int) -> Double = { price: Double, quantity: Int -> price * .1 * quantity }
}


class BuyOneGetOne : ItemDiscount {
    override val discountAmount: (Double, Int) -> Double =
        { price: Double, quantity: Int -> if (quantity % 2 == 0) price * quantity / 2 else price * (quantity - 1) / 2 }
}

class ConsecutiveDiscountThirtyPercent : ItemDiscount {
    override val discountAmount: (Double, Int) -> Double =
        { price: Double, quantity: Int -> if (quantity % 2 == 0) price * quantity / 2 * .3 else price * (quantity - 1) / 2 * .3 }
}

class FivePercent : ItemDiscount {
    override val discountAmount: (Double, Int) -> Double =
        { price: Double, _: Int -> if (price <= 500) price else price - (price * .05) }
}