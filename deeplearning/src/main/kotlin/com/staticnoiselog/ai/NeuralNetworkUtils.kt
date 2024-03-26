package com.staticnoiselog.ai

import kotlin.math.exp

/**
 * Calculates the dot product of two arrays.
 *
 * @param features The first array in the dot product operation.
 * @param weights The second array in the dot product operation.
 * @return The dot product of the two input arrays.
 * @throws IllegalArgumentException If the input arrays do not have the same size.
 */
fun dotProduct(features: Array<Double>, weights: Array<Double>): Double {
    require(features.size == weights.size) { "Input feature and weight arrays must have the same size" }
    return features.zip(weights).sumOf { it.first * it.second }
}

/**
 * Calculates the sigmoid activation function for a given input.
 *
 * @param x The input to the sigmoid function.
 * @return The output of the sigmoid function.
 */
fun sigmoid(x: Double): Double {
    return 1.0 / (1.0 + exp(-x))
}
