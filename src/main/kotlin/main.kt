fun main() {
    print("Сумма ваших покупок составляет (в рублях): ")
    val sumOfPurchase = calculateSumOfPurchase()
    val sumOfDiscount = checkDiscount(sumOfPurchase)
    val additionalDiscount = (sumOfPurchase-sumOfDiscount)/100*1
    val totalDiscount = sumOfDiscount + additionalDiscount
    val isRegularCustomer: Boolean = false


    if (sumOfDiscount == 100) println("Скидка: $sumOfDiscount рублей")
    else if (sumOfDiscount == 0) println("Скидка на такую сумму не предоставляется.")
    else println("Ваша скидка: $sumOfDiscount р.")

    if (isRegularCustomer) {
        println("Так как вы наш постоянный покупатель, вам дополнительная скидка: $additionalDiscount р.")
        println("Итого:\n Сумма ваших покупок: $sumOfPurchase р.\n Общая скидка: $totalDiscount р.\n Сумма к оплате: ${sumOfPurchase - sumOfDiscount - additionalDiscount} р.")
    } else println("Итого:\n Сумма ваших покупок: $sumOfPurchase р.\n Общая скидка: $sumOfDiscount р.\n Сумма к оплате: ${sumOfPurchase - sumOfDiscount} р.")

}

fun calculateSumOfPurchase(): Int {
    while (true) {
        var amount: Int
        try {
            amount = readln().toInt()
            return amount

        } catch (e: NumberFormatException) {
            print("Вы ввели недопустимый формат! Попробуйте ещё раз: ")
        }
    }
}

fun checkDiscount(sumOfPurchase: Int): Int {
    return if (sumOfPurchase in 1000..9999) 100 else if (sumOfPurchase > 10000) sumOfPurchase / 100 * 5 else 0
}