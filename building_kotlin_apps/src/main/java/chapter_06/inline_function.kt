package chapter_06

inline fun String.removeSlice(
    text: String,
    action: (String) -> Unit
) {
    val startIndex = this.indexOf(text)
    val result = this.removeRange(startIndex, startIndex + text.length)
    action(result)
}

// noinline
inline fun bar(inlined: () -> Unit, noinline notInlined: (String) -> Unit) { }

fun main() {
   "email@gmail.com".removeSlice("@gmail") { println(it) }
   "212IPX021".removeSlice("IPX") { println(it) }
}
