package chapter_05

import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.memberProperties

// the function here takes an object as argument and return its JSON representation
fun serialize(obj: Any): String = buildString { serializeObject2(obj) }
/*
here the serialize function delegates all the work to the serializeObject function
*/

// a StringBuilder extension function
private fun StringBuilder.serializeObject1(obj: Any) {
    obj.javaClass.kotlin.memberProperties.joinTo(this, prefix = "{", postfix = "}") { prop ->
        serializeString(prop.name)
        append(":")
        serializePropertyValue(prop.get(obj))
        return@joinTo ""
    }
}

// a second implementation handling annotated elements
private fun StringBuilder.serializeObject2(obj: Any) {
    obj.javaClass.kotlin.memberProperties.joinTo(this, prefix = "{", postfix = "}") { prop ->
        val jsonProperty = prop.findAnnotation<JsonProperty>()
        val propName = jsonProperty?.name ?: prop.name
        serializeString(propName)
        append(":")
        serializePropertyValue(prop.get(obj))
        return@joinTo ""
    }
}

private fun StringBuilder.serializePropertyValue(value: Any?) {
    when (value) {
        null -> append("null")
        is String -> serializeString(value)
        is Number, is Boolean -> append(value.toString())
        is List<*> -> serializeCollection(value)
        else -> serializeObject2(value)
    }
}

private fun StringBuilder.serializeCollection(data: List<Any?>) {
    data.joinTo(this, prefix = "[", postfix = "]") {
        serializePropertyValue(it)
        return@joinTo ""
    }
}

private fun StringBuilder.serializeString(str: String) {
    append('\"')
    str.forEach { append(it.escape()) }
    append('\"')
}


private fun Char.escape(): Any = when (this) {
    '\\' -> "\\\\"
    '\"' -> "\\\""
    '\u000C' -> "\\f"
    '\n' -> "\\n"
    '\b' -> "\\b"
    '\t' -> "\\t"
    '\r' -> "\\r"
    else -> this
}


data class Patient(
    @JsonProperty("first_name")
    val firstName: String,
    @JsonProperty("last_name")
    val lastName: String,
    val age: Int,
    val vip: Boolean? = false,
    val addresses: List<Address> = listOf()
)

data class Address(
    val street: String,
    val postalCode: String? = null,
    val city: String? = null
)

@Target(AnnotationTarget.PROPERTY)
annotation class JsonProperty(val name: String)


fun main() {
    val patient = Patient(
        "Adam",
        "Said",
        45,
        addresses = listOf(Address("21st Main Street.", "12000")))

    val patient2 = Patient(
        "Mounir",
        "BOUSSETTA",
        35)


    println(serialize(patient2))
}
