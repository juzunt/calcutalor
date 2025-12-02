fun main() {
    runCalculator()
}

fun runCalculator() {
    println("Калькулятор запущен")

    val history = mutableListOf<String>()

    while (true) {
        printMenu()


        when (readln()) {
            "1" -> {
                print("Введите выражение: ")
                val input = readln()
                val result = calculateSimpleExpression(input)

                if (result == null) {
                    println("Ошибка: не удалось разобрать выражение")
                } else {
                    println("Результат: $result")
                    history.add("$input = $result")
                }
            }

            "2" -> {
                if (history.isEmpty()) {
                    println("История пока пустая")
                } else {
                    for ((index, record) in history.withIndex()) {
                        println("${index + 1}: $record")
                    }
                }
            }

            "3" -> {
                println("Выход...")
                break
            }

            else -> println("Неверный ввод, попробуйте снова")

        }
    }
}


fun printMenu() {
    println("====================")
    println("       КАЛЬКУЛЯТОР")
    println("====================")
    println("1. Посчитать выражение")
    println("2. История")
    println("3. Выйти")
    println("--------------------")
    print("Ваш выбор: ")
}

fun calculateSimpleExpression(expr: String): Double? {
    val parts = expr.trim().split("\\s+".toRegex())

    if (parts.size != 3) return null

    val a = parts[0].toDoubleOrNull() ?: return null
    val op = parts[1]
    val b = parts[2].toDoubleOrNull() ?: return null

    return when (op) {
        "+" -> a + b
        "-" -> a - b
        "*" -> a * b
        "/" -> if (b == 0.0) null else a / b
        else -> null
    }
}