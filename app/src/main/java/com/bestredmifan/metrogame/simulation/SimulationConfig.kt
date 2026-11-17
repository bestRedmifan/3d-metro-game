package com.bestredmifan.metrogame.simulation

data class SimulationConfig(
    val maximumSpeedMetersPerSecond: Float = 22.2f,
    val accelerationMetersPerSecondSquared: Float = 0.8f,
    val brakingMetersPerSecondSquared: Float = 1.6f,
    val coastingDragMetersPerSecondSquared: Float = 0.08f,
) {
    init {
        require(maximumSpeedMetersPerSecond > 0f)
        require(accelerationMetersPerSecondSquared > 0f)
        require(brakingMetersPerSecondSquared > 0f)
        require(coastingDragMetersPerSecondSquared >= 0f)
    }
}
