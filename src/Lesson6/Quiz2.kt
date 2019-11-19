package Lesson6

fun main(args:Array<String>) {
    val numbers = listOf<Int>(1,2,3,4,5,6,7,8,9,0)
    println(numbers.divisibleBy {
        it.rem(3)
    })
}

fun List<Int>.divisibleBy(block: (Int) -> Int): List<Int> {
    val list = mutableListOf<Int>()
    for (element in this) {
        if(block(element) == 0) {
            list.add(element)
        }
    }
    return list
}

