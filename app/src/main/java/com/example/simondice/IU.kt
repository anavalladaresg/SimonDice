// IU.kt
package com.example.simondice

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.simondice.ui.theme.*

@Composable
fun interfazColores(viewModel: MainViewModel = viewModel(), modifier: Modifier = Modifier) {
    val record by viewModel.record.collectAsState()

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
            Botones(viewModel)
        }
    }
}

@Composable
fun Botones(viewModel: MainViewModel) {
    Column {
        Row {
            BotonVerde(viewModel)
            BotonRosa(viewModel)
        }
        Row {
            BotonAzul(viewModel)
            BotonNaranja(viewModel)
        }
    }
}

@Composable
fun BotonVerde(viewModel: MainViewModel) {
    Button(
        onClick = { viewModel.incrementarRecord() },
        modifier = Modifier
            .padding(16.dp)
            .width(125.dp)
            .height(125.dp),
        shape = CutCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(containerColor = PastelGreen)
    ) {}
}

@Composable
fun BotonRosa(viewModel: MainViewModel) {
    Button(
        onClick = { viewModel.incrementarRecord() },
        modifier = Modifier
            .padding(16.dp)
            .width(125.dp)
            .height(125.dp),
        shape = CutCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(containerColor = PastelPink)
    ) {}
}

@Composable
fun BotonAzul(viewModel: MainViewModel) {
    Button(
        onClick = { viewModel.incrementarRecord() },
        modifier = Modifier
            .padding(16.dp)
            .width(125.dp)
            .height(125.dp),
        shape = CutCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(containerColor = PastelBlue)
    ) {}
}

@Composable
fun BotonNaranja(viewModel: MainViewModel) {
    Button(
        onClick = { viewModel.incrementarRecord() },
        modifier = Modifier
            .padding(16.dp)
            .width(125.dp)
            .height(125.dp),
        shape = CutCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(containerColor = PastelOrange)
    ) {}
}

/**
 * Preview de la interfaz de usuario
 */
@Preview
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewBotones() {
    val viewModel = MainViewModel(RecordRepository())
    interfazColores(viewModel)
}