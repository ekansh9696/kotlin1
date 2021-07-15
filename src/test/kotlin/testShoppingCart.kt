import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ShoppingCarTests : StringSpec({

    "GIVEN an empty cart WHEN adding 3 cookies worth 30 rupees THEN the amount payable must be 90 rupees" {
        val items: List<Product> = listOf(Product("cookies", 30.0))
        val itemWithQuantity: Map<Product, Int> = items.zip(listOf(3)).toMap()
        val user1: ShoppingCart = ShoppingCart(itemWithQuantity)
        user1.calculateAmount() shouldBe 90.0
    }
    "GIVEN an empty cart WHEN adding 3 cookies worth 30 rupees AND applying discount of 10 percent on each cookie THEN the amount payable must be 81 rupees" {
        val items: List<Product> = listOf(Product("cookies", 30.0, DiscountTenPercent()))
        val itemWithQuantity: Map<Product, Int> = items.zip(listOf(3)).toMap()
        val user1: ShoppingCart = ShoppingCart(itemWithQuantity)
        user1.calculateAmount() shouldBe 81.0
    }
    "GIVEN an empty cart WHEN adding 3 cookies worth 30 rupees AND adding 2 noodles worth 50 rupees AND applying discount of 10 percent on each cookie THEN the amount payable must be 81 rupees" {
        val items: List<Product> = listOf(Product("cookies", 30.0, DiscountTenPercent()), Product("noodles", 50.0))
        val itemWithQuantity: Map<Product, Int> = items.zip(listOf(3, 2)).toMap()
        val user1: ShoppingCart = ShoppingCart(itemWithQuantity)
        user1.calculateAmount() shouldBe 181.0
    }
})