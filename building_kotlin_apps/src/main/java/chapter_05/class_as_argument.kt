package chapter_05

import kotlin.reflect.KClass

@Target(AnnotationTarget.CLASS, AnnotationTarget.CONSTRUCTOR)
@Retention(AnnotationRetention.RUNTIME)
annotation class DemoAnn(val param1: KClass<*>, val param2: KClass<out Any>)


// Usage demo
@DemoAnn(String::class, Int::class)
class DemoClass1 {}

// Usage demo
@DemoAnn(Int::class, Double::class)
class DemoClass2 {}