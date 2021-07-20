package problemShoppingCart

data class Product(val name: String, val price: Double, val discount: ItemDiscount = DiscountNone())
{
    init {
        if (price<0)
            throw error("Invalid Product Price Entered")
    }
}
