package com.staticnoiselog.ai

import kotlin.math.exp

// Function to calculate the dot product of two arrays
fun dotProduct(features: Array<Double>, weights: Array<Double>): Double {
    require(features.size == weights.size) { "Input feature and weight arrays must have the same size" }
    return features.zip(weights).sumOf { it.first * it.second }
}

// Sigmoid activation function
fun sigmoid(x: Double): Double {
    return 1.0 / (1.0 + exp(-x))
}
