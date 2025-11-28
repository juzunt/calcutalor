fun main() {
    println("===Kotlin Calculator===")

    while (true) {
        showMenu()
        print("Ваш выбор: ")

        val command = readln() ?: continue

        if (command == "exit") {
            println("До встречи!")
            break
        }

        when (command) {
            "1" -> add()
            "2" -> subtract()
            "3" -> multiply()
            "4" -> devide()
            else -> println("Неизвестная команда!")
        }

    }


}

fun showMenu() {
    println()
    println("1 - Сложение")
    println("2 - Вычитание")
    println("3 - Умножение")
    println("4 - Деление")
    println("exit - выйти")
    println()
}

fun readNumber(message: String): Double {
    print(message)

    while (true) {
        val input = readln()
        val number = input.toDoubleOrNull()

        if (number != null) return number

        print("Неверный ввод, попробуйте еще раз: ")
    }
}

fun add() {
    val a = readNumber("Введите первое число: ")
    val b = readNumber("Введите второе число: ")
    println("${a + b}")
}

fun subtract() {
    val a = readNumber("Введите первое число: ")
    val b = readNumber("Введите второе число: ")
    println("${a - b}")
}

fun multiply() {
    val a = readNumber("Введите первое число: ")
    val b = readNumber("Введите второе число: ")
    println("${a * b}")
}

fun devide() {
    val a = readNumber("Введите первое число: ")
    val b = readNumber("Введите второе число: ")

    if (b == 0.0) {
        println("Ошибка: деление на ноль!")
    } else {
        println("${a / b}")
    }
}