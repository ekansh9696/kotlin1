import FizzBuzz.FizzBuzz
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class FizzBuzzTests : StringSpec({
    "Number 3 itself" {
        val obj: FizzBuzz = FizzBuzz()
        obj.checkFizzBuzz("3") shouldBe "fizz"
    }
    "Number 5 itself" {
        val obj: FizzBuzz = FizzBuzz()
        obj.checkFizzBuzz("5") shouldBe "buzz"
    }
    "Non valid number"{
        val obj: FizzBuzz = FizzBuzz()
        obj.checkFizzBuzz("7") shouldBe "7"
    }
    "Number divisible by 3 (not 5)"{
        val obj: FizzBuzz = FizzBuzz()
        obj.checkFizzBuzz("12") shouldBe "fizz"
    }
    "Number divisible by 5 (not 3)"{
        val obj: FizzBuzz = FizzBuzz()
        obj.checkFizzBuzz("35") shouldBe "buzz"
    }
    "Number divisible by 3 and 5"{
        val obj: FizzBuzz = FizzBuzz()
        obj.checkFizzBuzz("60") shouldBe "fizzbuzz"
    }
})