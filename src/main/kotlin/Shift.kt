class Shift {
    fun shiftBy(input: String, shift_by: Int): String {
        var result=""
        for (character in input)
        {
            val after_shift = character + (shift_by % 26)
            result +=
                if(character in 'A'..'Z') {
                if (after_shift > 'Z') after_shift - 26 else after_shift
                }
                else {
                if (after_shift > 'z') after_shift - 26 else after_shift
                }
        }
        return result
    }

}
