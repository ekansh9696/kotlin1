import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ShiftingCipherTests : StringSpec({
    "Number 3 itself" {
        val obj : Shift = Shift()
        obj.shiftBy("A",1) shouldBe "B"
    }})