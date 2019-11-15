package Spices

fun main(args: Array<String>) {
    makeSpice()
}

fun makeSpice() {

    val spiceCabinet = listOf(SpiceContainer(Curry("yellow curry", "mild")),
                            SpiceContainer(Curry("red curry", "medium")),
                            SpiceContainer(Curry("green curry", "spicy"))
    )

    for(element in spiceCabinet) println(element.label)
}

data class SpiceContainer(var spice: Spice) {
    val label = spice.name
}