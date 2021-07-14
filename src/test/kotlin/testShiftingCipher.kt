import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ShiftingCipherTests : StringSpec({

        "single letter (capital) Shift by 1 No loopback" {
            val obj: Shift = Shift()
            obj.shiftBy("A", 1) shouldBe "B"

        }
        "multiple letters (capital) Shift by 1 No loopback" {
            val obj: Shift = Shift()
            obj.shiftBy("ABCDE", 1) shouldBe "BCDEF"
        }
        "single letter (capital) Shift by 4 No loopback" {
            val obj: Shift = Shift()
            obj.shiftBy("F", 4) shouldBe "J"

        }
        "multiple letters (capital) Shift by 3 No loopback" {
            val obj: Shift = Shift()
            obj.shiftBy("ABCDE", 3) shouldBe "DEFGH"
        }

        "single letter (capital) Shift by 1 loopback" {
            val obj: Shift = Shift()
            obj.shiftBy("Z", 1) shouldBe "A"

        }
        "multiple letters (capital) Shift by 3 all loopback" {
        val obj: Shift = Shift()
        obj.shiftBy("XYZ", 3) shouldBe "ABC"
        }

        "multiple letters (capital) Shift by 3 some loopback" {
            val obj: Shift = Shift()
            obj.shiftBy("MPZ", 3) shouldBe "PSC"
        }
    "single letter (small) Shift by 1 No loopback" {
        val obj: Shift = Shift()
        obj.shiftBy("x", 1) shouldBe "y"

    }
    "multiple letters (small) Shift by 1 No loopback" {
        val obj: Shift = Shift()
        obj.shiftBy("hello", 1) shouldBe "ifmmp"
    }
    "single letter (small) Shift by 10 No loopback" {
        val obj: Shift = Shift()
        obj.shiftBy("a", 10) shouldBe "k"

    }
    "multiple letters (small) Shift by 3 No loopback" {
        val obj: Shift = Shift()
        obj.shiftBy("bro", 3) shouldBe "eur"
    }

    "single letter (small) Shift by 1 loopback" {
        val obj: Shift = Shift()
        obj.shiftBy("z", 1) shouldBe "a"

    }
    "multiple letters (small) Shift by 5 all loopback" {
        val obj: Shift = Shift()
        obj.shiftBy("zvx", 5) shouldBe "eac"
    }

    "multiple letters (small) Shift by 3 some loopback" {
        val obj: Shift = Shift()
        obj.shiftBy("azx", 3) shouldBe "dca"
    }


})