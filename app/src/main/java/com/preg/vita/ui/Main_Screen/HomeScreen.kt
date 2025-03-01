package com.example.janintriassignment.ui.screens.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.janintriassignment.data.db.model.HealthData
import com.example.janintriassignment.ui.screens.home_screen.components.AddVitalsDialog
import com.example.janintriassignment.ui.screens.home_screen.components.DetailsItem
import com.example.janintriassignment.utils.getCurrentTimeFormatted


@Composable
fun HomeScreen(vm: HomeViewModel = hiltViewModel()) {
    val healthData = vm.healthData.collectAsState()
    val addData = vm::addHealthData
    HomeScreenContent(
        healthData = healthData.value,
        addData = addData
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeScreenContent(
    healthData: List<HealthData>,
    addData: (HealthData) -> Unit
) {
    val showDialog = rememberSaveable { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.surface),
                title = {
                    Text(
                        "Track My Pregnancy",
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onSurface,
                        fontWeight = FontWeight.SemiBold
                    )
                },
                modifier = Modifier.shadow(6.dp)
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                containerColor = MaterialTheme.colorScheme.primary,
                shape = CircleShape,
                onClick = {
                    showDialog.value = true
                }
            ) {
                Icon(
                    Icons.Filled.Add,
                    tint = Color.White,
                    contentDescription = "Add",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    ) { it ->
        Column(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.background)
                .fillMaxSize()
                .padding(it)
        ) {
            LazyColumn {
                item {
                    Spacer(modifier = Modifier.height(14.dp))
                }
                items(healthData.size){ idx ->
                    DetailsItem(healthData[idx])
                }
            }
            if (showDialog.value) {
                AddVitalsDialog(
                    onDismissRequest = { showDialog.value = false },
                    onSubmit = { sys, dia, weight, kicks, heartRate ->
                        println("Systolic: $sys, Diastolic: $dia, Weight: $weight, Kicks: $kicks")
                        showDialog.value = false
                        addData(
                            HealthData(
                                diaBp = dia.toInt(),
                                sysBp = sys.toInt(),
                                weight = weight.toInt(),
                                kicks = kicks.toInt(),
                                heartRate = heartRate.toInt(),
                                timestamp = getCurrentTimeFormatted()
                            )
                        )
                    }
                )
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreenContent(
        healthData = emptyList(),
        addData = {}
    )
}