package chapter_05


@Target(
    AnnotationTarget.CLASS,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY,
    AnnotationTarget.VALUE_PARAMETER
)
annotation class MyCustomAnnotation(val name: String)


// Usage
@MyCustomAnnotation( "demo")
class Demo {}


fun main() {
    // test code
}