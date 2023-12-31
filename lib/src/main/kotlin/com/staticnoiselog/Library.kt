/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package com.staticnoiselog

import com.staticnoiselog.ai.dotProduct
import com.staticnoiselog.ai.sigmoid

class Library {
    fun someLibraryMethod(): Boolean {
        val javaTool = JavaTool()
        javaTool.jThing("you")
        return true
    }

    fun methodBasedOnOtherModule(one: Double): Double {
        val result = dotProduct(arrayOf(one, 0.5, 0.8), arrayOf(0.4, -0.1, 0.3))
        return sigmoid(result)
    }
}
