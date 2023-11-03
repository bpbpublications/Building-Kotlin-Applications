package chapter_04

class GenericType<T>(t: T) {
    var value = t
}



fun main() {
    val genericObj: GenericType<String> = GenericType<String>("Generic type")
    val genericObj2 = GenericType("Generic type")

    val map = mapOf("A" to 12.0, "B" to 20.5)

    val map2: Map<String, Double> = mapOf()
    val map3 = mapOf<String, Double>()


}