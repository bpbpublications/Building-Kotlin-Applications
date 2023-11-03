package chapter_05

import kotlin.reflect.KClass

fun main() {


    val myClass: KClass<DemoClass1> = DemoClass1::class

    val myJavaClass: Class<DemoClass1> = DemoClass1::class.java

}