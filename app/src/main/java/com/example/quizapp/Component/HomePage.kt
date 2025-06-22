package com.example.quizapp.Component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quizapp.R


@Composable
fun HomePage(navController: NavController) {

    var userName = "Madara"
    val categories = getCategoryItems()
    val title: TextStyle = TextStyle(
        fontSize = 32.sp,
        fontWeight = FontWeight.W500,
        color = Color.Black
    )
    val subTitle: TextStyle = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.W500,
        color = Color.Gray
    )


   Column(modifier = Modifier.fillMaxSize()
       .padding(16.dp)
       .padding(WindowInsets.systemBars.asPaddingValues())) {


       Row(modifier = Modifier.fillMaxWidth(),
           horizontalArrangement = Arrangement.End) {
           IconButton(
               onClick = {},
               modifier = Modifier
                   .padding(horizontal = 4.dp)
                   .border(
                       width = 1.dp,
                       color = Color.Black,
                       shape = RoundedCornerShape(25.dp)
                   )
                   .size(42.dp)
           ) {
               Icon(
                   imageVector = Icons.Default.Notifications,
                   contentDescription = "Notification",
               )
           }
           IconButton(
               onClick = {},
               modifier = Modifier
                   .padding(end = 16.dp)
                   .border(
                       width = 1.dp,
                       color = Color.Black,
                       shape = RoundedCornerShape(25.dp)
                   )
                   .size(42.dp)
           ) {
               Image(
                   painter = painterResource(id = R.drawable.profile), // ✅ FIXED
                   contentDescription = "Profile Picture",
                   contentScale = ContentScale.Fit,
               )
           }
       }

       Text("Hi, ${userName}", style = title)
       Text("Welcome to Quiz App", style = subTitle)


       CategoryList(categories = categories)
       QuizCardRow(navController = navController )

   }
}
