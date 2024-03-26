package com.staticnoiselog.ai

/**
 * This is a Kotlin class that provides a method to print a greeting message from Kotlin.
 * It is used to demonstrate calling Kotlin code from Java. And it is also an example of
 * class-level KDoc documentation.
 *
 * @property name The name of the entity to greet.
 *
 * @constructor Creates a new instance of the class.
 */
class KotlinForJava(private val name: String) {
    fun helloFromKotlin() {
        println("Hello from Kotlin, $name!")
    }
}