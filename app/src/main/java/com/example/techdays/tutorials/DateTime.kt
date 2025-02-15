package com.example.techdays.tutorials

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

fun main() {
    // Save:
    // Date -> Timestamp: Long

    // Get:
    // Timestamp: Long -> Date

    val now = Date()

    val calendar = Calendar.getInstance()
    calendar.time = now

    val year = calendar.get(Calendar.YEAR)

    val dayOfWeek = SimpleDateFormat("EEEE, MMM d").format(calendar.getTime())

    println(now)
    println("dayOfWeek: $dayOfWeek")
}