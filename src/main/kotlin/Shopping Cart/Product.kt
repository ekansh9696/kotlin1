package `Shopping Cart`

data class Product(val name: String, val MRP: Double, val discount: ItemDiscount = DiscountNone())
