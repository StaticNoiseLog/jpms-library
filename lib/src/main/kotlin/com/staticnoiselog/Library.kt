package com.staticnoiselog

import com.staticnoiselog.ai.dotProduct
import com.staticnoiselog.ai.sigmoid

class Library {
    fun methodCallingJava(txt: String): Boolean {
        val javaTool = JavaTool()
        javaTool.jThing(txt)
        return txt.isNotBlank()
    }

    fun methodBasedOnOtherModule(one: Double): Double {
        val result = dotProduct(arrayOf(one, 0.5, 0.8), arrayOf(0.4, -0.1, 0.3))
        return sigmoid(result)
    }
}
