package Lesson6

fun example() {
    /*
    val runnable = object: Runnable {
        override fun run() {
            println("I'm a runnable")
        }
    }
    JavaRun.runNuw(runnable)
    */
    JavaRun.runNuw {
        println("Passing a lambda as a runnable")
    }
}