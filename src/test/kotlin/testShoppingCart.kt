import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ShoppingCartTests : StringSpec({

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
    "GIVEN an empty cart WHEN adding 6 cookies worth 30 rupees AND applying buy one get one free offer THEN the amount payable must be 90 rupees" {
        val items: List<Product> = listOf(Product("cookies", 30.0, BuyOneGetOne()))
        val itemWithQuantity: Map<Product, Int> = items.zip(listOf(6)).toMap()
        val user1: ShoppingCart = ShoppingCart(itemWithQuantity)
        user1.calculateAmount() shouldBe 90.0
    }
    "GIVEN an empty cart WHEN adding 3 soap bars worth 40 rupees AND applying buy one get one free offer THEN the amount payable must be 80 rupees" {
        val items: List<Product> = listOf(Product("soap bar", 40.0, BuyOneGetOne()))
        val itemWithQuantity: Map<Product, Int> = items.zip(listOf(3)).toMap()
        val user1: ShoppingCart = ShoppingCart(itemWithQuantity)
        user1.calculateAmount() shouldBe 80.0
    }
    "GIVEN an empty cart WHEN adding 2 soap bars worth 50 rupees AND applying discount of 30 percent to the next soap bought after each purchase THEN the amount payable must be 85 rupees" {
        val items: List<Product> = listOf(Product("soap bar", 50.0, ConsecutiveDiscountThirtyPercent()))
        val itemWithQuantity: Map<Product, Int> = items.zip(listOf(2)).toMap()
        val user1: ShoppingCart = ShoppingCart(itemWithQuantity)
        user1.calculateAmount() shouldBe 85.0
    }
    "GIVEN an empty cart WHEN adding 5 soap bars worth 50 rupees AND applying discount of 30 percent to the next soap bought after each purchase THEN the amount payable must be 220 rupees" {
        val items: List<Product> = listOf(Product("soap bar", 50.0, ConsecutiveDiscountThirtyPercent()))
        val itemWithQuantity: Map<Product, Int> = items.zip(listOf(5)).toMap()
        val user1: ShoppingCart = ShoppingCart(itemWithQuantity)
        user1.calculateAmount() shouldBe 220.0
    }
    "GIVEN an empty cart WHEN the total amount in cart is more than 500 rupees (Adding 5 soap bars of 60 rupees each, applying ten percent discount on each and 10 cookies worth 50 rupees each )THEN the amount payable must be 731.5 rupees" {
        val items: List<Product> = listOf(Product("soap bar", 60.0, DiscountTenPercent()),Product("cookies",50.0))
        val itemWithQuantity: Map<Product, Int> = items.zip(listOf(5,10)).toMap()
        val user1: ShoppingCart = ShoppingCart(itemWithQuantity)
        user1.calculateAmount() shouldBe 731.5
    }
})