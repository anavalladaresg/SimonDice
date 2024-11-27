// IU.kt
package com.example.simondice

import MainViewModel
import android.content.res.Configuration
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.simondice.ui.theme.*
import androidx.compose.runtime.collectAsState

@Composable
fun interfazColores(viewModel: MainViewModel = viewModel(), modifier: Modifier = Modifier) {
    val record by viewModel.record.collectAsState()
    val currentColor by viewModel.currentColor.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Record: ${record.record}",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(16.dp)
            )
            Botones(viewModel, currentColor)
        }
        errorMessage?.let { message ->
            Snackbar(
                modifier = Modifier.padding(16.dp),
                action = {
                    Button(onClick = { viewModel.clearErrorMessage() }) {
                        Text("Dismiss")
                    }
                }
            ) {
                Text(message)
            }
        }
    }
}

@Composable
fun Botones(viewModel: MainViewModel, currentColor: Color?) {
    Column {
        Row {
            BotonVerde(viewModel, currentColor)
            BotonRosa(viewModel, currentColor)
        }
        Row {
            BotonAzul(viewModel, currentColor)
            BotonNaranja(viewModel, currentColor)
        }
    }
}

@Composable
fun BotonVerde(viewModel: MainViewModel, currentColor: Color?) {
    val backgroundColor by animateColorAsState(
        targetValue = if (currentColor == PastelGreen) Color.LightGray else PastelGreen
    )
    Button(
        onClick = { viewModel.userInput(PastelGreen) },
        modifier = Modifier
            .padding(16.dp)
            .width(125.dp)
            .height(125.dp),
        shape = CutCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor)
    ) {}
}

@Composable
fun BotonRosa(viewModel: MainViewModel, currentColor: Color?) {
    val backgroundColor by animateColorAsState(
        targetValue = if (currentColor == PastelPink) Color.LightGray else PastelPink
    )
    Button(
        onClick = { viewModel.userInput(PastelPink) },
        modifier = Modifier
            .padding(16.dp)
            .width(125.dp)
            .height(125.dp),
        shape = CutCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor)
    ) {}
}

@Composable
fun BotonAzul(viewModel: MainViewModel, currentColor: Color?) {
    val backgroundColor by animateColorAsState(
        targetValue = if (currentColor == PastelBlue) Color.LightGray else PastelBlue
    )
    Button(
        onClick = { viewModel.userInput(PastelBlue) },
        modifier = Modifier
            .padding(16.dp)
            .width(125.dp)
            .height(125.dp),
        shape = CutCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor)
    ) {}
}

@Composable
fun BotonNaranja(viewModel: MainViewModel, currentColor: Color?) {
    val backgroundColor by animateColorAsState(
        targetValue = if (currentColor == PastelOrange) Color.LightGray else PastelOrange
    )
    Button(
        onClick = { viewModel.userInput(PastelOrange) },
        modifier = Modifier
            .padding(16.dp)
            .width(125.dp)
            .height(125.dp),
        shape = CutCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor)
    ) {}
}