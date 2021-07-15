class ShoppingCart(private var listItems : Map<Product, Int> ) {

    var payableAmount: Double = calculateAmount()
    fun calculateAmount(): Double
    {
        var result = 0.0
        for (item in listItems)
            result += item.key.mrp * item.value
        return result
    }
}
