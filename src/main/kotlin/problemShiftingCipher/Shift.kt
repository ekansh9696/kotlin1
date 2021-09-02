package problemShiftingCipher

class Shift {
    fun shiftBy(input: String, shift_by: Int): String {
        var result = ""
        for (character in input)
            result += if (character !in 'A'..'Z' && character !in 'a'..'z' && character !in '0'..'9') character
            else shifting(character, shift_by)
        return result
    }

    private fun shifting(character: Char, shift_by: Int): Char {

        val trueShift = if (character in '0'..'9') shift_by % 10 else shift_by % 26
        val afterShift = character + trueShift
        return getCharAfterShift(character, afterShift)
    }

    private fun getCharAfterShift(character: Char, afterShift: Char) =
        if (character in 'A'..'Z')
            if (afterShift > 'Z') afterShift - 26 else afterShift
        else if (character in 'a'..'z')
            if (afterShift > 'z') afterShift - 26 else afterShift
        else if (afterShift > '9') afterShift - 10 else afterShift

}