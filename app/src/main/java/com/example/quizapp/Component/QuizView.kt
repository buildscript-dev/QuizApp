package com.example.quizapp.Component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizapp.ui.theme.Yellow40


@Composable
fun QuizPallet(quizItem: Quizs, onNextClick: () -> Unit) {
    val title: TextStyle = TextStyle(
        fontSize = 26.sp,
        fontWeight = FontWeight.W500,
        color = Color.Black
    )

    var selectedOption by remember(quizItem) { mutableStateOf<String?>(null) }

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

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onNextClick,
            enabled = selectedOption != null,

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
