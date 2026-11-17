package com.bestredmifan.metrogame.game

data class GameState(
    val speedMetersPerSecond: Float = 0f,
    val distanceMeters: Float = 0f,
    val isRunning: Boolean = false,
    val doorsOpen: Boolean = true,
) {
    val speedKilometersPerHour: Float
        get() = speedMetersPerSecond * 3.6f
}
