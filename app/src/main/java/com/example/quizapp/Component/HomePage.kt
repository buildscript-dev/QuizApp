package com.example.quizapp.Component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.quizapp.R


@Composable
fun HomePage(navController: NavController) {
   Column(modifier = Modifier.fillMaxSize()
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

   }
}
