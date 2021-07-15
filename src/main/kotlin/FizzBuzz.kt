class FizzBuzz {
    fun checkFizzBuzz(num: String): String {
        val number = num.toInt()
        var res = ""
        res += checkFizz(number) + checkBuzz(number)
        return getResult(res, number)
    }

    private fun getResult(res: String, number: Int): String {
        return if (res != "")
            res
        else
            number.toString()
    }

    private fun checkFizz(number: Int): String = if (number % 3 == 0) "fizz" else ""

    private fun checkBuzz(number: Int): String = if (number % 5 == 0) "buzz" else ""
}