package chapter_03.visibility_modifiers

private fun foo() { /*...*/ } // visible inside visibility.kt

public var bar: Int = 5 // property is visible everywhere
    private set         // setter is visible only in visibility.kt

internal val baz = 6    // visible inside the same module


fun sayHello() {/* ... */ }
class Demo { /* ... */}

// Class members

open class Base {
    private val x = 1
    protected open val y = 2
    internal open val z = 3
    val t = 4  // public by default

    protected class Nested {
        public val p: Int = 5
    }
}

class Derived : Base() {
    // x is not visible
    // y, z and t are visible
    // Nested and p are visible

    override val y = 5   // 'y' is protected
    override val z = 7   // 'z' is internal
}

class Unrelated(b: Base) {
    // b.x, b.y are not visible
    // b.z and b.t are visible (same module)
    // Base.Nested is not visible, and Nested::p is not visible either
}
