package chapter_04


fun <T> genericCollection(list: Collection<T>) {
/*
    if (list is List<Int>) { // this type of check is not possible at runtime
        // ...
    }
*/

    // Using star projections!
    if (list is List<*>) { // if this is a list of any type

        val numberList = list as List<Int> // cast will work at runtime
        val first:Int = numberList.first() // might not work at runtime
    }
}