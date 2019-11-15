package Aquarium

fun main(args: Array<String>) {
    buildAquarium()
    //makeFish()
}

fun buildAquarium() {
    val myAquarium = Aquarium()

    println("Length: ${myAquarium.length} " +
            "Width: ${myAquarium.width} " +
            "Height: ${myAquarium.height}")

    myAquarium.height = 80

    println("Height: ${myAquarium.height} cm")

    println("Volume: ${myAquarium.volume} liters")

    val smallAquarium = Aquarium(length = 20, width = 15, height = 30)
    println("Small Aquarium: ${smallAquarium.volume} liters")

    val smallAquarium2 = Aquarium(numberOfFish = 9)
    println("Small Aquarium 2: ${smallAquarium2.volume} liters with " +
            "length ${smallAquarium2.length} " +
            "width ${smallAquarium2.width} " +
            "height ${smallAquarium2.height} ")
}

fun feedFish(fish: FishAction) {
    // make some food then
    fish.eat()
}

/*
fun makeFish() {
    val shark = Shark()
    val plecostomus = Plecostomus()

    println("Shark: ${shark.color}\nPlecostomus: ${plecostomus.color}")

    shark.eat()
    plecostomus.eat()
}*/
