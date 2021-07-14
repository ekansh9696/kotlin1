class Shift {
    fun shiftBy(input: String, shift_by: Int): String {
        var result=""
        for (character in input)
        {
            val true_shift = if (character in '0'..'9') shift_by % 10 else shift_by %26
            val after_shift = character + true_shift
            result +=
                if(character in 'A'..'Z') {
                if (after_shift > 'Z') after_shift - 26 else after_shift
                }
                else if(character in 'a'..'z'){
                if (after_shift > 'z') after_shift - 26 else after_shift
                }
                else
                {
                    if(after_shift > '9') after_shift - 10 else after_shift
                }
        }
        return result
    }

}
