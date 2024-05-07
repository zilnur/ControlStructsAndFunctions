
class OnlinedTime {

    fun agoToText(ago: Int) {
        when (ago) {
            in 0..60 -> println("был(а) только что")
            in 61..<(60 * 60) -> println("был(а) ${formattedToMinutes(ago)} назад")
            in (60 * 60)..<(24 * 60 * 60) -> println("был(а) ${formattedToHours(ago)} назад")
            else -> println("был(а) ${formattedToDays(ago)}")
        }
    }

    private fun formattedToMinutes(ago: Int): String{
        val minutesCount = ago / 60
        val result = when {
            minutesCount.toString().last() == '1' && minutesCount != 11 -> "$minutesCount минуту"
            charArrayOf('2','3','4').contains(minutesCount.toString().last()) && minutesCount < 10 || minutesCount > 20 -> "$minutesCount минуты"
            else -> "$minutesCount минут"
        }
        return result
    }

    private fun formattedToHours(ago: Int): String {
        val hoursCount = ago / (60 * 60)
        val result = when {
            hoursCount.toString().last() == '1' && hoursCount != 11 -> "$hoursCount час"
            charArrayOf('2','3','4').contains(hoursCount.toString().last()) && hoursCount < 10 || hoursCount > 20 -> "$hoursCount часа"
            else -> "$hoursCount часов"
        }
        return  result
    }

    private fun formattedToDays(ago: Int): String {
        val daysCount = ago / (24 * 60 * 60)
        val result = when {
            daysCount == 1 -> "вчера"
            daysCount < 3 -> "позавчера"
            else -> "давно"
        }
        return  result
    }
}