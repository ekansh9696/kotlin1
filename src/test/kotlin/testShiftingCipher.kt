import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ShiftingCipherTests : StringSpec({
    "single letter (capital) Shift by 1" {
        val obj : Shift = Shift()
        obj.shiftBy("A",1) shouldBe "B"

        }
    "multiple letters (capital) Shift by 1" {
        val obj : Shift = Shift()
        obj.shiftBy("ABCDE",1) shouldBe "BCDEF"
    }
    "single letter (capital) Shift by 4" {
        val obj : Shift = Shift()
        obj.shiftBy("F",4) shouldBe "J"

    }
    "multiple letters (capital) Shift by 3" {
        val obj : Shift = Shift()
        obj.shiftBy("ABCDE",3) shouldBe "DEFGH"
    }
})