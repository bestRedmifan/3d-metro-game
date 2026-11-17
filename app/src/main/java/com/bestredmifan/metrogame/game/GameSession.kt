package com.bestredmifan.metrogame.game

import com.bestredmifan.metrogame.simulation.TrainControls
import com.bestredmifan.metrogame.simulation.TrainSimulator

/** Owns the authoritative simulation state for one gameplay session. */
class GameSession(
    private val simulator: TrainSimulator = TrainSimulator(),
) {
    var state: GameState = GameState()
        private set

    fun update(controls: TrainControls, deltaSeconds: Float): GameState {
        state = simulator.step(state, controls, deltaSeconds)
        return state
    }

    fun reset() {
        state = GameState()
    }
}
