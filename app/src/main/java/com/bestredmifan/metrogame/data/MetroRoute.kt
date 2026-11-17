package com.bestredmifan.metrogame.data

data class MetroRoute(
    val id: String,
    val name: String,
    val stations: List<MetroStation>,
    val isLoop: Boolean = false,
) {
    init {
        require(id.isNotBlank()) { "Route id must not be blank" }
        require(name.isNotBlank()) { "Route name must not be blank" }
        require(stations.size >= 2) { "A route must have at least two station entries" }
    }
}

data class MetroStation(
    val id: String,
    val name: String,
    val distanceFromPreviousMeters: Float,
) {
    init {
        require(id.isNotBlank()) { "Station id must not be blank" }
        require(name.isNotBlank()) { "Station name must not be blank" }
        require(distanceFromPreviousMeters >= 0f) { "Station distance cannot be negative" }
    }
}
