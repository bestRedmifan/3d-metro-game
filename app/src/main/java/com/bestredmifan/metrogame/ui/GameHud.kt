package com.bestredmifan.metrogame.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun GameHud(
    currentStation: String,
    nextStation: String,
    speedKmh: Float,
    distanceMeters: Float,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp)
            .background(
                color = Color(0xFF101820).copy(alpha = 0.78f),
                shape = RoundedCornerShape(16.dp),
            ),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column {
                Text("Current station", style = MaterialTheme.typography.labelMedium, color = Color(0xFFB5C7D6))
                Text(currentStation, style = MaterialTheme.typography.titleLarge)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Speed", style = MaterialTheme.typography.labelMedium, color = Color(0xFFB5C7D6))
                Text("${speedKmh.toInt()} km/h", style = MaterialTheme.typography.headlineMedium)
            }
            Column(horizontalAlignment = Alignment.End) {
                Text("Next stop", style = MaterialTheme.typography.labelMedium, color = Color(0xFFB5C7D6))
                Text(nextStation, style = MaterialTheme.typography.titleMedium)
            }
        }
        Row(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 18.dp, bottom = 18.dp),
        ) {
            Text("Distance: ${distanceMeters.toInt()} m", style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Composable
fun TrainControlPanel(
    canToggleDoors: Boolean,
    onThrottleUp: () -> Unit,
    onThrottleDown: () -> Unit,
    onBrake: () -> Unit,
    onToggleDoors: () -> Unit,
    onReverse: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxHeight()
            .background(Color(0xFF151E28), shape = RoundedCornerShape(18.dp))
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Text("Controls", style = MaterialTheme.typography.titleMedium)

        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            Button(onClick = onThrottleUp, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1D6EF2))) {
                Text("Throttle +")
            }
            Button(onClick = onThrottleDown, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3B4A5D))) {
                Text("Throttle -")
            }
        }

        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            Button(onClick = onBrake, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD64545))) {
                Text("Brake")
            }
            Button(onClick = onReverse, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7C4DFF))) {
                Text("Reverse")
            }
        }

        Button(
            onClick = onToggleDoors,
            enabled = canToggleDoors,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3AAE76)),
        ) {
            Text("Doors")
        }
    }
}
