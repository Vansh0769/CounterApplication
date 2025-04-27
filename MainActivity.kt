package com.example.counterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.counterapp.ViewModel.CounterViewModel
import com.example.counterapp.ui.theme.CounterAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel:CounterViewModel = viewModel() //  Creating an instance of the Counter View model.
            //Importing necessary dependency of viewModel.

            // Calling the Composable Counter app
            CounterAppTheme {

                    CounterApp(viewModel,Modifier.fillMaxSize())

                }
            }
        }
    }

@Composable
fun CounterApp(viewModel: CounterViewModel,modifier: Modifier = Modifier,) {
    Column(modifier = Modifier.fillMaxSize()
             .padding(16.dp)

    ) {
        Text(text = "Count: ${viewModel.count.value}")
        Spacer(modifier = Modifier.height(16.dp))

        Row {

            Button(onClick = {
                viewModel.increment()
            }) {
                Text(text = "Increment")
            }

            Button(onClick = {
                viewModel.decrement()
            }) {
                Text(text = "Decrement ")
            }
        }


    }
}