package com.example.janintriassignment.ui.screens.home_screen.components

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import dagger.hilt.android.qualifiers.ApplicationContext

@Composable
fun AddVitalsDialog(
    onDismissRequest: () -> Unit,
    onSubmit: (String, String, String, String, String) -> Unit
) {
    var sysBP by remember { mutableStateOf("") }
    var diaBP by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var babyKicks by remember { mutableStateOf("") }
    var heartRate by remember { mutableStateOf("") }

    Dialog(onDismissRequest = onDismissRequest) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(Color.White)
                .padding(bottom = 16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Add Vitals",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF4A235A),
                    textAlign = TextAlign.Start
                )


                Row(
                    modifier = Modifier
                        .fillMaxWidth()

                        ,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Row(modifier = Modifier.weight(1f)) {
                        sysBP = TextField("Sys BP")
                    }
                    Row(modifier = Modifier.weight(1f)){
                    diaBP = TextField("Dia BP")
                    }
                }

                weight = TextField("Weight (in KG)")

                babyKicks = TextField("Baby Kicks")

                heartRate = TextField("Heart Rate")


                Button(
                    onClick = {
                        if(sysBP.isNotEmpty() and diaBP.isNotEmpty() and weight.isNotEmpty() and babyKicks.isNotEmpty() and heartRate.isNotEmpty())
                            onSubmit(sysBP, diaBP, weight, babyKicks, heartRate)

                              },
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .fillMaxWidth()
                        .height(48.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    ),
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Text(
                        text = "Submit",
                        color = Color.White,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}



@Composable
fun TextField(plText: String): String {

    var text by rememberSaveable { mutableStateOf("") }
    val containerColor = MaterialTheme.colorScheme.secondary
    OutlinedTextField(

        value = text,
        onValueChange = { text = it },
        label = { Text(plText,
            fontSize = 14.sp) },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Number
        ) ,
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Color.Gray,
            focusedBorderColor = MaterialTheme.colorScheme.surface
        ),
        singleLine = true
    )
    return text
}



@Preview
@Composable
fun AddVitalsDialogPreview() {
    AddVitalsDialog({}, { _, _, _, _, _ -> })
}

