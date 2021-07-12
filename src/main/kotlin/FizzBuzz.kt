
class FizzBuzz
{
    fun check(number: Int): String {
        var res = ""
        res += checkFizz(number) + checkBuzz(number)
        if (res != "")
            return res
        else
            return number.toString()
    }

    fun checkFizz(number: Int): String = if (number % 3 == 0) "fizz" else ""
    fun checkBuzz(number: Int): String = if (number % 5 == 0) "buzz" else ""
}