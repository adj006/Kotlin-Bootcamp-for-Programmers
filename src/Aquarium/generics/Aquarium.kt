package Aquarium.generics

fun main(args: Array<String>) {
    genericExample()
}

open class WaterSupply(var needsProcessed: Boolean)

class TapWater : WaterSupply(true) {
    fun addChemicalCleaners() = apply { needsProcessed = false }
}

class FishStoreWater : WaterSupply(false)

class LakeWater : WaterSupply(true) {
    fun filter() = apply { needsProcessed = false }
}

// class Aquarium<T: Any>(val waterSupply: T)  // class Aquarium<T: Any?>(val waterSupply: T)
class Aquarium<out T: WaterSupply>(val waterSupply: T) {
    /*
    fun addWater() {
        check(!waterSupply.needsProcessed) { "water supply needs processed" }
        println("adding water from $waterSupply")
    }
    */
    fun addWater(cleaner: Cleaner<T>) {
        if(waterSupply.needsProcessed) {
            cleaner.clean(waterSupply)
        }
        println("adding water from $waterSupply")
    }
}

interface Cleaner<in T: WaterSupply> {
    fun clean(waterSupply: T)
}

class TapWaterCleaner: Cleaner<TapWater> {
    override fun clean(WaterSupply: TapWater) {
        WaterSupply.addChemicalCleaners()
    }
}

fun addItemTo(aquarium: Aquarium<WaterSupply>) = println("item added")

fun genericExample() {
    /*
    val aquarium = Aquarium(TapWater()) // val aquarium = Aquarium<TapWater>(TapWater())
    aquarium.waterSupply.addChemicalCleaners()

    *//*
    * Replaced Any with WaterSupply in Aquarium so that we only receive of types WaterSupply
    *
    val aquarium2 = Aquarium("string")
    println(aquarium.waterSupply)
    *//*

    *//*
    * Removed ? from Any in Aquarium to make the type not nullable
    *
    val aquarium3 = Aquarium(null)
    aquarium.waterSupply
    *//*

    val aquarium4 = Aquarium(LakeWater())
    aquarium4.waterSupply.filter()
    aquarium4.addWater()
    */

    val cleaner = TapWaterCleaner()
    val aquarium = Aquarium(TapWater())
    aquarium.addWater(cleaner)
    //addItemTo(aquarium)
}