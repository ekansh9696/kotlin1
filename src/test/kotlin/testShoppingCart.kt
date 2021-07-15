import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ShoppingCarTests : StringSpec({

    "given empty cart, adding 3 cookies worth 30 rupees, amount payable must be 90 rupees" {
        val item : Product = Product("cookies",30.0)
        val listOfItems : List<Pair<Product,Int>> = listOf(Pair(item,3))
        val user1: ShoppingCart = ShoppingCart(listOfItems.map{it.first to it.second}.toMap())
        user1.calculateAmount() shouldBe 90
    }

    })