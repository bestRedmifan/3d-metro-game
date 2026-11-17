package com.bestredmifan.metrogame.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun GameScreen(
    currentStation: String,
    nextStation: String,
    speedKmh: Float,
    distanceMeters: Float,
    onThrottleUp: () -> Unit,
    onThrottleDown: () -> Unit,
    onBrake: () -> Unit,
    onToggleDoors: () -> Unit,
    onReverse: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier.fillMaxSize()) {
        // Placeholder 3D view. Real Filament rendering will replace this area.
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
                .backgroundPlaceholder(),
        )

        GameHud(
            currentStation = currentStation,
            nextStation = nextStation,
            speedKmh = speedKmh,
            distanceMeters = distanceMeters,
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp, bottom = 18.dp)
                .align(androidx.compose.ui.Alignment.BottomCenter),
        ) {
            TrainControlPanel(
                canToggleDoors = true,
                onThrottleUp = onThrottleUp,
                onThrottleDown = onThrottleDown,
                onBrake = onBrake,
                onToggleDoors = onToggleDoors,
                onReverse = onReverse,
                modifier = Modifier.weight(1f),
            )
        }
    }
}
