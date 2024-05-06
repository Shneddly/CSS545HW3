package com.example.css545hw3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.css545hw3.ui.theme.CSS545HW3Theme
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.compose.ui.platform.LocalContext

class MainActivity : ComponentActivity() {

    private lateinit var textViewModel: TextViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize ViewModel
        textViewModel = ViewModelProvider(this).get(TextViewModel::class.java)

        setContent {
            val enteredText by remember { textViewModel.enteredText }.observeAsState("")

            // Save the entered text in savedInstanceState
            savedInstanceState?.getString("enteredText")?.let { textViewModel.setEnteredText(it) }

            Column(
                modifier = Modifier.fillMaxSize().padding(16.dp),
                horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
                verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center
            ) {
                TextField(
                    value = enteredText,
                    onValueChange = { textViewModel.setEnteredText(it) },
                    label = { Text("Enter Text") },
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("enteredText", textViewModel.enteredText.value)
    }
}