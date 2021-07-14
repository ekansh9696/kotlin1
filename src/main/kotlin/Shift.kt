class Shift {
    fun shiftBy(input: String, shift_by: Int): String {
        var result=""
        for (character in input)
        {
            result+=(character+(shift_by%26))
        }
        return result
    }

}
