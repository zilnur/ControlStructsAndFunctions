import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val onlinedTime = OnlinedTime()
    val taxCalculator = TaxCalculator()
    println("Добрый день!")
    while (true) {
        println(
            """
        Выберите задание для проверки:
        1. Задача №1. Когда собеседник был онлайн
        2. Задача №2. Разная комиссия
        3. Закончить.
    """.trimIndent()
        )
        val input = scanner.nextLine()
        when (input) {
            "1" -> {
                println("Введите время, прошедшее с последнего пребывания онлайн (в секундах)")
                val timeAgo = scanner.nextLine().toInt()
                onlinedTime.agoToText(timeAgo)
            }
            "2" -> {
                println(
                    """
                Выберите тип карты:
                1. MasterCard
                2. Visa
                3. Мир
            """.trimIndent()
                )
                val cardType = when (scanner.nextLine()) {
                    "1" -> "MasterCard"
                    "2" -> "Visa"
                    "3" -> "Мир"
                    else -> ""
                }
                println("Введите сумму предыдущих переводов")
                val previousTransfersSum = scanner.nextLine().toInt()
                println("Введите сумму перевода")
                val transferSum = scanner.nextLine().toInt()
                taxCalculator.calculateTax(cardType, previousTransfersSum, transferSum)
            }
            else -> break
        }
    }
}