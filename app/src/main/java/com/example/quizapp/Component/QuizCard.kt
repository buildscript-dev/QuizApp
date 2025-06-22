package com.example.quizapp.Component

import android.provider.ContactsContract.Data
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quizapp.R
import com.example.quizapp.ui.theme.Yellow40

// 🔸 Data class
data class QuizCard(
    @DrawableRes val image: Int,
    val title: String,
    val subTitle: String,
    val timer: String,
    val eleColor: Color,
    val category: String
)

// 🔸 Sample cards
val QuizCards: List<QuizCard> = listOf(
    QuizCard(R.drawable.speaker, "Trending", "Trending from the last 1 hour", "5 min", Color(0xFFFFC0CB),  category = "trend"),
    QuizCard(R.drawable.daily, "Daily Quiz", "Your daily challenge is waiting!", "2 min", Color(0xFFFFC107), category = "daily"),
    QuizCard(R.drawable.math, "Math Mania", "Sharpen your brain with numbers", "4 min", Color.Black, category = "math"),
    QuizCard(R.drawable.history, "History Blast", "Time-travel through history facts", "6 min", Yellow40, category = "history"),
    QuizCard(R.drawable.science, "Science Lab", "Test your scientific IQ", "3 min", Color(0xff0E2148), category = "science"),
    QuizCard(R.drawable.gaming, "Gaming Legends", "How much do you know about games?", "5 min", Color(0xffC95792), category = "gaming"),
    QuizCard(R.drawable.anime, "Anime Showdown", "Otaku mode: ON!", "4 min", Color(0xffFFDCDC), category = "anime"),
    QuizCard(R.drawable.sports, "Sports Central", "For the true fans", "6 min", Color(0xffE07A5F), category = "sports")
)

@Composable
fun QuizCardView(quizCard: QuizCard, navController: NavController) {
    val selectedCategory = quizCard.category
    val selectedQuizList = getQuizListForCategory(selectedCategory)
    Box(
        modifier = Modifier
            .width(320.dp)
            .height(450.dp)
            .padding(8.dp)
            .graphicsLayer {}
            .drawBehind {
                drawRoundRect(
                    color = quizCard.eleColor,
                    topLeft = Offset(-10f, 18f),
                    size = Size(size.width, size.height),
                    cornerRadius = CornerRadius(32.dp.toPx(), 32.dp.toPx()),
                    alpha = 0.3f
                )
            }
            .clip(RoundedCornerShape(25.dp))
            .background(Color.White)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp)
            ) {
                Image(
                    painter = painterResource(id = quizCard.image),
                    contentDescription = "Card Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(280.dp)
                        .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                )

                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(12.dp)
                        .background(Color.Black, RoundedCornerShape(25.dp))
                        .padding(horizontal = 12.dp, vertical = 4.dp)
                ) {
                    Text(text = quizCard.timer, fontSize = 12.sp, color = Color.White)
                }

                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(20.dp)
                        .size(42.dp)
                        .clip(RoundedCornerShape(50))
                        .background(Color.Black)
                        .clickable {
                            navController.navigate("QuizStart/${quizCard.category}")
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Default.PlayArrow, contentDescription = "Play", tint = Color.White)
                }
            }

            Spacer(modifier = Modifier.height(40.dp))

            Column(modifier = Modifier.padding(horizontal = 30.dp)) {
                Text(text = quizCard.title, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = quizCard.subTitle, fontSize = 14.sp, color = Color.Gray)
            }
        }
    }
}

// 🔥 Now render the row
@Composable
fun QuizCardRow(navController: NavController) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(QuizCards) { card ->
            QuizCardView(quizCard = card, navController = navController)
        }
    }
}
