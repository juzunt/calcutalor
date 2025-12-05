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
    val s = expr.trim()
    val ops = setOf('+', '-', '*', '/')
    var opsIndex = -1
    for (i in 1 until s.length) {

        if ((s[i] == '+' || s[i] == '-') && (s[i - 1] == '*' || s[i - 1] == '/')){
            continue
        }

        if (s[i] in ops) {
            opsIndex = i
            break
        }
    }
    if (opsIndex == -1) return null


    val op = s[opsIndex]
    val aString = s.substring(0, opsIndex)
    val bString = s.substring(opsIndex + 1)

    val a = aString.toDoubleOrNull() ?: return null
    val b = bString.toDoubleOrNull() ?: return null

    return when (op) {
        '+' -> a + b
        '-' -> a - b
        '*' -> a * b
        '/' -> if (b == 0.0) null else a / b
        else -> null
    }
}