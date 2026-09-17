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

fun flipCoin() : String {
    val flip = (1..2).random()
    if (flip == 1) {
        return "The coin is Heads"
    }
    return "The coin is Tails"
}

fun rollDice() : String {
    val dice = (1..6).random()
    return "The dice rolled a $dice"
}

fun roulette() : String {
    val result = (1..36).random()
    var color = ""
    if (result == 0) {
        color = "Green"
    } else if (result%2 == 1) {
        color = "Red"
    } else {
        color = "Black"
    }
    return "The result is: $result $color"
}

@Composable
fun homeScreen(
    modifier: Modifier = Modifier
) {
    var homeText by remember {mutableStateOf("")}

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
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
        ) {
            var count1 by remember {mutableStateOf(0)}
            var count2 by remember {mutableStateOf(0)}
            var count3 by remember {mutableStateOf(0)}
            Button (
                onClick = {
                    homeText = flipCoin()
                    count1++
                }
            ) {
                Text(
                    text = "Flip Coin, Clicked: $count1",
                )
            }
            Button (
                onClick = {
                    homeText = rollDice()
                    count2++
                }
            ) {
                Text(
                    text = "Roll Dice, Clicked: $count2",
                )
            }
            Button (
                onClick = {
                    homeText = roulette()
                    count3++
                }
            ) {
                Text(
                    text = "Play Roulette, Clicked: $count3",
                )
            }
        }
    }
}
