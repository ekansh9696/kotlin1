package problemShoppingCart

data class Product(val name: String, val price: Double, val discount: ItemDiscount = DiscountNone())
