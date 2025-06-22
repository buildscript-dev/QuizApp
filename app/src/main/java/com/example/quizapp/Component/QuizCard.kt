package com.example.quizapp.Component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizapp.R

// 🔸 Data model
data class QuizCard(
    @DrawableRes val image: Int,
    val title: String,
    val subTitle: String,
    val timer: String
)

// 🔸 Sample card list
val QuizCards: List<QuizCard> = listOf(
    QuizCard(
        image = R.drawable.speaker,
        title = "Trending",
        subTitle = "Trending from the last 1 hour",
        timer = "5 min"
    ),
    QuizCard(
        image = R.drawable.speaker,
        title = "Daily Quiz",
        subTitle = "Your daily challenge is waiting!",
        timer = "2 min"
    ),
//    QuizCard(
//        image = R.drawable.math, // replace with actual drawable
//        title = "Math Mania",
//        subTitle = "Sharpen your brain with numbers",
//        timer = "4 min"
//    ),
//    QuizCard(
//        image = R.drawable.history, // replace with actual drawable
//        title = "History Blast",
//        subTitle = "Time-travel through history facts",
//        timer = "6 min"
//    ),
//    QuizCard(
//        image = R.drawable.science, // replace with actual drawable
//        title = "Science Lab",
//        subTitle = "Test your scientific IQ",
//        timer = "3 min"
//    ),
//    QuizCard(
//        image = R.drawable.gaming, // replace with actual drawable
//        title = "Gaming Legends",
//        subTitle = "How much do you know about games?",
//        timer = "5 min"
//    ),
//    QuizCard(
//        image = R.drawable.anime, // replace with actual drawable
//        title = "Anime Showdown",
//        subTitle = "Otaku mode: ON!",
//        timer = "4 min"
//    ),
//    QuizCard(
//        image = R.drawable.sports, // replace with actual drawable
//        title = "Sports Central",
//        subTitle = "For the true fans",
//        timer = "6 min"
//    )
)


// 🔸 Composable to render a single card
@Composable
fun QuizCardView(quizCard: QuizCard) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
            .padding(16.dp)
            .clip(RoundedCornerShape(25.dp))
            .background(Color.White),
    ) {
        Column(modifier = Modifier.fillMaxSize()) {

            // 🖼️ Top image
            Box(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = quizCard.image),
                    contentDescription = "Card Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(240.dp)
                        .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                )

                // 🕒 Timer badge at top-right
                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(12.dp)
                        .background(
                            color = Color.Black,
                            shape = RoundedCornerShape(25.dp)
                        )
                        .padding(horizontal = 12.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = quizCard.timer,
                        fontSize = 12.sp,
                        color = Color.White
                    )
                }
            }
            // ▶️ Play button in bottom-right
            Box(
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(horizontal = 20.dp)
                    .size(42.dp)
                    .clip(RoundedCornerShape(50))
                    .background(Color.Black)
                    .clickable { },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "Play",
                    tint = Color.White
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // 🔠 Title & Subtitle
            Column(modifier = Modifier.padding(horizontal = 30.dp)) {
                Text(
                    text = quizCard.title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = quizCard.subTitle,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
        }


    }
}


@Composable
fun QuizCardRow() {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(QuizCards.size) { index ->
            QuizCardView(quizCard = QuizCards[index])
        }
    }
}
