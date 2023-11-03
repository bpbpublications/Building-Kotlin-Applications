package chapter_01.kotlin

import java.time.LocalDate

data class Patient(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val dateOfBirth: LocalDate,
    val phoneNumber: String,
    val email: String
)
