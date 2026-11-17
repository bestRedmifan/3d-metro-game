package com.bestredmifan.metrogame.game

/** Converts frame timestamps into bounded simulation time steps. */
class GameLoop(private val onFrame: (deltaSeconds: Float) -> Unit) {
    private var previousFrameNanos: Long? = null
    var isRunning: Boolean = false
        private set

    fun start() {
        previousFrameNanos = null
        isRunning = true
    }

    fun stop() {
        isRunning = false
        previousFrameNanos = null
    }

    fun frame(frameTimeNanos: Long) {
        if (!isRunning) return
        val previous = previousFrameNanos
        previousFrameNanos = frameTimeNanos
        if (previous != null && frameTimeNanos >= previous) {
            val delta = (frameTimeNanos - previous) / 1_000_000_000f
            onFrame(delta.coerceAtMost(0.1f))
        }
    }
}
