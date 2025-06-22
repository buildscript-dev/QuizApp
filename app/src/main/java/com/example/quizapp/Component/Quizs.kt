package com.example.quizapp.Component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizapp.R
import com.example.quizapp.ui.theme.Yellow40

// ✅ Data class
data class Quizs(
    val quizImageRes: Int,
    val quizQuestion: String,
    val quizOptions: List<String>,
    val quizAnswer: String
)

// ✅ List of quiz items
val quizs = listOf(
    Quizs(
        quizImageRes = R.drawable.french,
        quizQuestion = "What is the capital of France?",
        quizOptions = listOf("Paris", "London", "Berlin", "Madrid"),
        quizAnswer = "Paris"
    ),
    Quizs(
        quizImageRes = R.drawable.twoplustwo,
        quizQuestion = "What is 2 + 2?",
        quizOptions = listOf("3", "4", "5", "22"),
        quizAnswer = "4"
    ),
    Quizs(
        quizImageRes = R.drawable.mars,
        quizQuestion = "Which planet is known as the Red Planet?",
        quizOptions = listOf("Earth", "Mars", "Jupiter", "Venus"),
        quizAnswer = "Mars"
    ),
    Quizs(
        quizImageRes = R.drawable.sky,
        quizQuestion = "What color is the sky on a clear day?",
        quizOptions = listOf("Blue", "Red", "Green", "Black"),
        quizAnswer = "Blue"
    ),
    Quizs(
        quizImageRes = R.drawable.meow,
        quizQuestion = "Which animal says 'meow'?",
        quizOptions = listOf("Dog", "Cow", "Cat", "Sheep"),
        quizAnswer = "Cat"
    ),
    Quizs(
        quizImageRes = R.drawable.week,
        quizQuestion = "How many days are there in a week?",
        quizOptions = listOf("5", "6", "7", "8"),
        quizAnswer = "7"
    ),
    Quizs(
        quizImageRes = R.drawable.banana,
        quizQuestion = "Which fruit is yellow and curved?",
        quizOptions = listOf("Apple", "Banana", "Grapes", "Strawberry"),
        quizAnswer = "Banana"
    ),
    Quizs(
        quizImageRes = R.drawable.summer,
        quizQuestion = "Which season comes after spring?",
        quizOptions = listOf("Summer", "Autumn", "Winter", "Monsoon"),
        quizAnswer = "Summer"
    ),
    Quizs(
        quizImageRes = R.drawable.spider,
        quizQuestion = "How many legs does a spider have?",
        quizOptions = listOf("6", "8", "4", "10"),
        quizAnswer = "8"
    ),
    Quizs(
        quizImageRes = R.drawable.oxygen,
        quizQuestion = "Which gas do we breathe in to survive?",
        quizOptions = listOf("Oxygen", "Carbon Dioxide", "Nitrogen", "Helium"),
        quizAnswer = "Oxygen"
    )
)

@Composable
fun QuizPallet(quizItem: Quizs, onNextClick: () -> Unit) {
    val title: TextStyle = TextStyle(
        fontSize = 26.sp,
        fontWeight = FontWeight.W500,
        color = Color.Black
    )

    var selectedOption by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(quizItem.quizImageRes),
            contentDescription = "QuizImage",
            modifier = Modifier
                .width(300.dp)
                .height(300.dp)
        )

        Text(
            text = quizItem.quizQuestion,
            style = title,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 25.dp)
        )

        // ✅ Chunk the options in 2 rows of 2
        quizItem.quizOptions.chunked(2).forEach { rowOptions ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                rowOptions.forEach { option ->
                    ColorChangeButton(
                        text = option,
                        isSelected = selectedOption == option,
                        onClick = { selectedOption = option }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(35.dp))

        Button(
            onClick = onNextClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(50.dp)
        ) {
            Text(text = "Next", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
        }
    }
}

@Composable
fun ColorChangeButton(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) Yellow40 else Color.Transparent,
            contentColor = Color.Black
        ),
        modifier = Modifier
            .width(165.dp)
            .height(50.dp)
            .border(
                width = 1.dp,
                color = Color.Gray,
                shape = RoundedCornerShape(25.dp)
            ),
        shape = RoundedCornerShape(25.dp)
    ) {
        Text(
            text = text,
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}
