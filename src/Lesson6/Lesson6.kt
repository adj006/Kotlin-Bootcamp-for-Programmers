package Lesson6

import java.util.function.Function

data class Fish (var name: String)

fun main(args: Array<String>) {
    fishExamples()
}

fun fishExamples() {
    val fish = Fish("splashy")

    /*
    with (fish.name) {
        capitalize()
    }
    */
    /*
    myWith (fish.name) {
        println(capitalize())
    }
    */

    // without inline an object is created every call to myWith
    myWith(fish.name, object : Function1<String, Unit> {
        override fun invoke(name: String) {
            name.capitalize()
        }
    })

    // with inline no object is created, and lambda is just inlined here
    fish.name.capitalize()

    println(fish.run { name })

    println(fish.apply {  })

    val fish2 = Fish("splashy").apply { name = "Sharky" }
    println(fish2.name)

    println(fish.let { it.name.capitalize() }
        .let { it + "fish" }
        .let { it.length }
        .let { it + 31 })
}

fun myWith(name: String, block: String.() -> Unit) {
    name.block()
}