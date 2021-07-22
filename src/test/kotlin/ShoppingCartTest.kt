import io.kotest.assertions.throwables.shouldThrow
import problemShoppingCart.*
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.*

class ShoppingCartTests : StringSpec({

    "GIVEN an empty cart THEN the amount payable must be 0 rupees" {
        val user1: ShoppingCart = ShoppingCart()
        user1.getPayableAmount() shouldBe 0.0
    }

    "equality test for objects of class Product"{
        val item = Product("toothpaste", 30.0)
        val item2 = Product("toothpaste", 30.0)
        val result = item == item2
        result shouldBe true
    }

    "inequality test for objects of class Product"{
        val item = Product("toothpaste", 30.0)
        val item2 = Product("toothpaste", 30.0, DiscountTenPercent())
        val result = item == item2
        result shouldBe false
    }

    "GIVEN an empty cart WHEN adding 3 cookies worth 30 rupees THEN the amount payable must be 90 rupees" {
        val user1: ShoppingCart = ShoppingCart()
        val cookies: Product = Product("cookies", 30.0)
        val cookieQuantity = Pair(cookies, 3)
        user1.addItemToCart(cookieQuantity)
        user1.getPayableAmount() shouldBe 90.0
    }
    "GIVEN an empty cart WHEN adding 3 cookies worth 30 rupees AND applying discount of 10 percent on each cookie THEN the amount payable must be 81 rupees" {
        val user1: ShoppingCart = ShoppingCart()
        val cookies = Product("cookies", 30.0, DiscountTenPercent())
        val cookieQuantity = Pair(cookies, 3)
        user1.addItemToCart(cookieQuantity)
        user1.getPayableAmount() shouldBe 81.0
    }
    "GIVEN an empty cart WHEN adding 3 cookies worth 30 rupees AND adding 2 noodles worth 50 rupees AND applying discount of 10 percent on each cookie THEN the amount payable must be 181 rupees" {
        val user1: ShoppingCart = ShoppingCart()
        val cookies = Product("cookies", 30.0, DiscountTenPercent())
        val cookieQuantity = Pair(cookies, 3)
        user1.addItemToCart(cookieQuantity)
        val noodles = Product("noodles", 50.0)
        val noodleQuantity = Pair(noodles, 2)
        user1.addItemToCart(noodleQuantity)
        user1.getPayableAmount() shouldBe 181.0
    }
    "GIVEN an empty cart WHEN adding 6 cookies worth 30 rupees AND applying buy one get one free offer THEN the amount payable must be 90 rupees" {
        val user1: ShoppingCart = ShoppingCart()
        val cookies = Product("cookies", 30.0, BuyOneGetOne())
        val cookieQuantity = Pair(cookies, 6)
        user1.addItemToCart(cookieQuantity)
        user1.getPayableAmount() shouldBe 90.0
    }
    "GIVEN an empty cart WHEN adding 3 soap bars worth 40 rupees AND applying buy one get one free offer THEN the amount payable must be 80 rupees" {
        val user1: ShoppingCart = ShoppingCart()
        val soap = Product("soap bar", 40.0, BuyOneGetOne())
        val soapWithQuantity = Pair(soap, 3)
        user1.addItemToCart(soapWithQuantity)
        user1.getPayableAmount() shouldBe 80.0
    }
    "GIVEN an empty cart WHEN adding 2 soap bars worth 50 rupees AND applying discount of 30 percent to the next soap bought after each purchase THEN the amount payable must be 85 rupees" {
        val user1: ShoppingCart = ShoppingCart()
        val soap = Product("soap bar", 50.0, ConsecutiveDiscountThirtyPercent())
        val soapWithQuantity = Pair(soap, 2)
        user1.addItemToCart(soapWithQuantity)
        user1.getPayableAmount() shouldBe 85.0
    }
    "GIVEN an empty cart WHEN adding 5 soap bars worth 50 rupees AND applying discount of 30 percent to the next soap bought after each purchase THEN the amount payable must be 220 rupees" {
        val user1: ShoppingCart = ShoppingCart()
        val soap = Product("soap bar", 50.0, ConsecutiveDiscountThirtyPercent())
        val soapWithQuantity = Pair(soap, 5)
        user1.addItemToCart(soapWithQuantity)
        user1.getPayableAmount() shouldBe 220.0
    }
    "GIVEN an empty cart WHEN the total amount in cart is more than 500 rupees (Adding 5 soap bars of 60 rupees each, applying ten percent discount on each and 10 cookies worth 50 rupees each )THEN the amount payable must be 731.5 rupees" {
        val user1: ShoppingCart = ShoppingCart()
        val soap = Product("soap bar", 60.0, DiscountTenPercent())
        val soapWithQuantity = Pair(soap, 5)
        user1.addItemToCart(soapWithQuantity)
        val cookies = Product("cookies", 50.0)
        val cookieWithQuantity = Pair(cookies, 10)
        user1.addItemToCart(cookieWithQuantity)
        user1.getPayableAmount() shouldBe 731.5
    }
    "GIVEN an empty cart WHEN we add 3 soap bars worth 60 rupees on buy1 get1 , add 2 cookies worth 10 rupees , again add 1 soap bar worth 60 rupees on buy1 get1 THEN the amount payable must be 140 rupees" {
        val user1: ShoppingCart = ShoppingCart()
        val item1 = Product("soap bar", 60.0, BuyOneGetOne())
        val item1WithQuantity = Pair(item1, 3)
        user1.addItemToCart(item1WithQuantity)
        val item2 = Product("cookies", 10.0)
        val item2WithQuantity = Pair(item2, 2)
        user1.addItemToCart(item2WithQuantity)
        val item3 = Product("soap bar", 60.0, BuyOneGetOne())
        val item3WithQuantity = Pair(item3, 1)
        user1.addItemToCart(item3WithQuantity)
        user1.getPayableAmount() shouldBe 140.0
    }
    "GIVEN an empty cart WHEN adding 5 soap bars worth -50 rupees AND applying discount of 30 percent to the next soap bought after each purchase THEN an exception should be thrown as the product price is negative" {

        val exception = shouldThrow<IllegalStateException> {
            val user1: ShoppingCart = ShoppingCart()
            val item = Product("soap bar", -50.0, ConsecutiveDiscountThirtyPercent())
            val itemWithQuantity = Pair(item, 5)
            user1.addItemToCart(itemWithQuantity)
        }
        exception.message shouldBe "Invalid Product Price Entered"
    }
})