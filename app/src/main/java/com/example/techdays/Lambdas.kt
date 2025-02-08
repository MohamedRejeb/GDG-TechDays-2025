package com.example.techdays

import kotlinx.coroutines.delay

suspend fun main() {
    // callback
    // lambda
    // higher order function

    timer(
        time = 1000L,
        action = {
            println("Action 1")
        },
    )
}

suspend fun timer(
    time: Long,
    action: () -> Unit,
) {
    // call some code on each second
    while (true) {
        delay(time)
        action()
    }
}

fun kLambdas() {
    Row(
        a = 1
    ) {

    }
}

fun Row(
    a: Int,
    content: () -> Unit,
) {

}