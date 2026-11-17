package com.bestredmifan.metrogame.simulation

import com.bestredmifan.metrogame.game.GameState
import kotlin.math.max

class TrainSimulator(
    private val config: SimulationConfig = SimulationConfig(),
) {
    fun step(state: GameState, controls: TrainControls, deltaSeconds: Float): GameState {
        val dt = deltaSeconds.coerceIn(0f, 0.1f)
        if (dt == 0f) return state
        val input = controls.normalized()

        // The train cannot depart while its doors are open.
        val throttle = if (input.doorsOpen) 0f else input.throttle
        val acceleration = when {
            input.brake > 0f -> -config.brakingMetersPerSecondSquared * input.brake
            throttle > 0f -> config.accelerationMetersPerSecondSquared * throttle
            else -> -config.coastingDragMetersPerSecondSquared
        }
        val speed = (state.speedMetersPerSecond + acceleration * dt)
            .coerceIn(0f, config.maximumSpeedMetersPerSecond)
        val moved = (state.speedMetersPerSecond + speed) * 0.5f * dt

        return state.copy(
            speedMetersPerSecond = speed,
            distanceMeters = state.distanceMeters + max(0f, moved),
            isRunning = speed > 0.05f,
            doorsOpen = input.doorsOpen && speed <= 0.05f,
        )
    }
}
