package com.example.mycalculator_001v

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycalculator_001v.ui.theme.MyCalculator_001vTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyCalculator_001vTheme {
                Calculator()
            }
        }
    }
}

@Composable
fun Calculator() {
    var num1 by remember { mutableStateOf("") }
    var num2 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter

    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
                .padding(top = 50.dp)
        ) {
            TextField(
                value = num1,
                onValueChange = { num1 = it },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                ),
                visualTransformation = VisualTransformation.None,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                label = { Text("Number 1") }
            )

            TextField(
                value = num2,
                onValueChange = { num2 = it },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                ),
                visualTransformation = VisualTransformation.None,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                label = { Text("Number 2") }
            )

            TextField(
                value = result,
                onValueChange = { },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                ),
                visualTransformation = VisualTransformation.None,
                label = { Text(text = "Result") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                readOnly = true
            )

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
            ) {
                Button(onClick = {
                    result = try {
                        (num1.toDouble() + num2.toDouble()).toString()
                    } catch (e: Exception) {
                        "Error"
                    }
                }) {
                    Text(text = "+")
                }

                Button(onClick = {
                    result = try {
                        (num1.toDouble() - num2.toDouble()).toString()
                    } catch (e: Exception) {
                        "Error"
                    }
                }) {
                    Text(text = "-")
                }

                Button(onClick = {
                    result = try {
                        (num1.toDouble() * num2.toDouble()).toString()
                    } catch (e: Exception) {
                        "Error"
                    }
                }) {
                    Text(text = "*")
                }

                Button(onClick = {
                    result = try {
                        if (num2.toDouble() != 0.0) {
                            (num1.toDouble() / num2.toDouble()).toString()
                        } else {
                            "Error"
                        }
                    } catch (e: Exception) {
                        "Error"
                    }
                }) {
                    Text(text = "/")
                }

                Button(onClick = {
                    num1 = ""
                    num2 = ""
                    result = ""
                }) {
                    Text(text = "Clear")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorPreview() {
    MyCalculator_001vTheme {
        Calculator()
    }
}
