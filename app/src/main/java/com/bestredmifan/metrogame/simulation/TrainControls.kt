package com.bestredmifan.metrogame.simulation

data class TrainControls(
    val throttle: Float = 0f,
    val brake: Float = 0f,
    val doorsOpen: Boolean = false,
) {
    fun normalized(): TrainControls = copy(
        throttle = throttle.coerceIn(0f, 1f),
        brake = brake.coerceIn(0f, 1f),
    )
}
