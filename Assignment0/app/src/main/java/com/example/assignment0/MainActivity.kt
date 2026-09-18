package com.example.assignment0

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment0.ui.theme.Assignment0Theme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assignment0Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    homeScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

fun decision1() : String {
    val flip = (1..2).random()
    if (flip == 1) {
        return "yes, you should go to that restaurant"
    }
    return "no, you shouldn't go to that restaurant"
}

fun decision2() : String {
    val flip = (1..4).random()
    if (flip == 1) {
        return "yes, you should go to that restaurant"
    }
    return "no, you shouldn't go to that restaurant"
}

fun decision3() : String {
    val flip = (1..6).random()
    if (flip == 1) {
        return "yes, you should go to that restaurant"
    }
    return "no, you shouldn't go to that restaurant"
}

@Composable
fun homeScreen(
    modifier: Modifier = Modifier
) {
    var homeText by remember {mutableStateOf("")}
    Text("Student ID: 1825571\nCCID: siquan1")
    Column (
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier=Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(homeText, fontSize=40.sp)
            }
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
        ) {
            var count1 by remember {mutableStateOf(0)}
            var count2 by remember {mutableStateOf(0)}
            var count3 by remember {mutableStateOf(0)}
            Button (
                onClick = {
                    homeText = decision1()
                    count1++
                }
            ) {
                Text(
                    text = "Go to McDonald's? Clicked: $count1",
                )
            }
            Button (
                onClick = {
                    homeText = decision2()
                    count2++
                }
            ) {
                Text(
                    text = "Go to Burger King? Clicked: $count2",
                )
            }
            Button (
                onClick = {
                    homeText = decision3()
                    count3++
                }
            ) {
                Text(
                    text = "Go to Tim Hortons? Clicked: $count3",
                )
            }
        }
    }
}
