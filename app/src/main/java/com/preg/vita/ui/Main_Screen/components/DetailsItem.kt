package com.example.janintriassignment.ui.screens.home_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.janintriassignment.data.db.model.HealthData
import com.preg.vita.R


@Composable
fun DetailsItem(healthData: HealthData) {
    DetailsItemContent(healthData)
}

@Composable
private fun DetailsItemContent(healthData: HealthData) {
    val (id, heartRate, sysBp, diaBp, weight, kicks, timestamp) = healthData
    Column(
        modifier = Modifier
            .padding(bottom = 14.dp)
            .padding(horizontal = 11.dp)
            .fillMaxWidth()
            .shadow(4.dp)
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(topEnd = 4.dp, topStart = 4.dp))
                .background(color = MaterialTheme.colorScheme.surfaceVariant)
                .padding(top = 14.dp, start = 14.dp, end = 14.dp, bottom = 18.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconText(R.drawable.heart, "$heartRate bpm")
                Spacer(modifier = Modifier.weight(1f))
                IconText(R.drawable.bp, "$sysBp/$diaBp mmHg")
            }
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconText(R.drawable.weight, "$weight kg")
                Spacer(modifier = Modifier.weight(1f))
                IconText(R.drawable.embryo, "$kicks kicks")
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .clip(RoundedCornerShape(bottomEnd = 4.dp, bottomStart = 4.dp))
                .background(color = MaterialTheme.colorScheme.primary)
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 6.dp)
        ) {
            Text(
                text = timestamp,
                fontSize = 12.sp,
                color = Color.White,
                fontWeight = FontWeight.W300
            )
        }
    }
}

@Preview
@Composable
private fun DetailsItemPreview() {
    DetailsItemContent(
        healthData = HealthData(
            diaBp = 80,
            sysBp = 120,
            weight = 75,
            kicks = 9,
            heartRate = 90,
            timestamp = "Mon, 13 Jan 2025 03:45 pm"
        )
    )
}

@Composable
private fun IconText(
    icon: Int,
    text: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.width(150.dp)
    ) {
        Icon(
            painter = painterResource(id = icon),
            modifier = Modifier.size(20.dp),
            contentDescription = null
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = text,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}