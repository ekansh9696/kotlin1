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
        "multiple letters (capital) Shift by 29 all loopback" {
        val obj: Shift = Shift()
        obj.shiftBy("XYZ", 29) shouldBe "ABC"
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
    "multiple letters Shift by 5 no loopback" {
        val obj: Shift = Shift()
        obj.shiftBy("arNOld", 1) shouldBe "bsOPme"
    }
    "multiple letters Shift by 5 all loopback" {
        val obj: Shift = Shift()
        obj.shiftBy("XyZ", 3) shouldBe "AbC"
    }

    "multiple letters Shift by 3 some loopback" {
        val obj: Shift = Shift()
        obj.shiftBy("aZxN", 3) shouldBe "dCaQ"
    }
    "single digit Shift by 1 no loopback"{
        val obj : Shift= Shift()
        obj.shiftBy("1",1) shouldBe "2"
    }

    "multiple digit Shift by 3 no loopback"{
        val obj:Shift = Shift()
        obj.shiftBy("643",3) shouldBe "976"

    }

    "single digit Shift by 1  loopback"{
        val obj : Shift= Shift()
        obj.shiftBy("9",1) shouldBe "0"
    }
    "single digit Shift by value greater than 26"{
        val obj:Shift=Shift()
        obj.shiftBy("0",33) shouldBe "3"
    }
    "multiple digit Shift by 5 all loopback"{
        val obj:Shift = Shift()
        obj.shiftBy("869",5) shouldBe "314"
    }

    "complex string without spaces shift by 1"{
        val obj:Shift = Shift()
        obj.shiftBy("ZeaLMate924",1) shouldBe "AfbMNbuf035"
    }

    "complex string without spaces shift by 12"{
        val obj:Shift = Shift()
        obj.shiftBy("ZzAa123",12) shouldBe "LlMm345"
    }

    "complex string without spaces shift by value greater than 26"{
        val obj:Shift = Shift()
        obj.shiftBy("ZzAa964",31) shouldBe "EeFf075"
    }
})