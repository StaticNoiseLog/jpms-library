package com.staticnoiselog.ai

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NeuralNetworkUtilsKtTest {

    @Test
    fun dotProduct() {
        val features = arrayOf(0.2, 0.5, 0.8)
        val weights = arrayOf(0.4, -0.1, 0.3)

        val result = dotProduct(features, weights)

        // Assuming the dot product calculation logic is correct
        // The result should be (0.2 * 0.4) + (0.5 * (-0.1)) + (0.8 * 0.3) = 0.2 * 0.4 - 0.5 * 0.1 + 0.8 * 0.3 = 0.14
        assertEquals(0.27, result, 1e-10) // 1e-10 is a small epsilon for double comparison

    }

    @Test
    fun sigmoid() {
        val x = 2.0
        val result = sigmoid(x)

        // Assuming the sigmoid calculation logic is correct
        // The result should be 1 / (1 + exp(-2)) ≈ 0.8807970779778823
        assertEquals(0.8807970779778823, result, 1e-10)
    }
}