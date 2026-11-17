package com.bestredmifan.metrogame.simulation

import com.bestredmifan.metrogame.data.MetroRoute

/** Tracks the active stop and cumulative route distance for a route run. */
class RouteProgress(val route: MetroRoute) {
    var stationIndex: Int = 0
        private set
    var distanceToNextStationMeters: Float = route.stations.getOrNull(1)?.distanceFromPreviousMeters ?: 0f
        private set

    val currentStation get() = route.stations[stationIndex]
    val nextStation get() = route.stations.getOrNull(stationIndex + 1)
    val isComplete get() = nextStation == null

    fun advance(distanceMeters: Float): Boolean {
        if (distanceMeters <= 0f || isComplete) return false
        distanceToNextStationMeters -= distanceMeters
        if (distanceToNextStationMeters > 0f) return false

        stationIndex += 1
        val nextIndex = stationIndex + 1
        distanceToNextStationMeters = route.stations.getOrNull(nextIndex)?.distanceFromPreviousMeters ?: 0f
        return true
    }
}
