class TaxCalculator {

    fun calculateTax(cardType: String, previousTransfersSum: Int, transferSum: Int) {
        if (transferSum > 150000) {
            println("Операция заблокирована. (Превышение дневного лимита)")
        }
        if (transferSum + previousTransfersSum > 600000) {
            println("Операция заблокирована. (Превышение месячного лимита)")
        }

        when (cardType) {
            "MasterCard" -> {
                val sumForTax = previousTransfersSum - 75000
                if (sumForTax > 0) {
                    val tax = (sumForTax * 0.006).toInt() + 20
                    println("Комиссия составит $tax рублей")
                } else {
                    println("Комиссия не взымается")
                }
            }
            "Visa" -> {
                val tax = (transferSum * 0.0075).toInt()
                if (tax > 35) {
                    println("Комиссия составит $tax рублей")
                } else {
                    println("Комиссия составит 35 рублей")
                }
            }
            "Мир" -> println("Комиссия не взымается")
            else -> println("Неизвестная карта")
        }
    }
}