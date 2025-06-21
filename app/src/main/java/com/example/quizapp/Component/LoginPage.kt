package com.example.quizapp.Component

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItemDefaults.contentColor
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quizapp.R
import com.example.quizapp.ui.theme.Yellow40


@Composable
fun LogIn(navController: NavController) {
    var emailTF by remember { mutableStateOf(TextFieldValue("")) }
    var passTF by remember { mutableStateOf(TextFieldValue("")) }

    val title: TextStyle = TextStyle(
        fontSize = 36.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Black
    )


    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp)
            .padding(WindowInsets.systemBars.asPaddingValues()),
        horizontalAlignment = Alignment.CenterHorizontally,
//    verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(60.dp))

        Text("Welcome Back", style = title)
        Text("to Rovio", style = title)

        Spacer(modifier = Modifier.height(60.dp))


        Text("E-mail", textAlign = TextAlign.Start, fontSize = 15.sp, fontWeight = FontWeight.SemiBold, color = Color.Gray, modifier = Modifier.fillMaxWidth().padding(horizontal = 30.dp))
        OutlinedTextField(
            value = emailTF,
            onValueChange = { emailTF = it },
            placeholder = { Text("Enter your email") },
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            shape = RoundedCornerShape(25.dp),
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Yellow40,
                unfocusedBorderColor = Color.Gray,
                disabledBorderColor = Color.LightGray
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 5.dp)
        )

Spacer(Modifier.height(20.dp))
        Text("Password", textAlign = TextAlign.Start, fontSize = 15.sp, fontWeight = FontWeight.SemiBold, color = Color.Gray, modifier = Modifier.fillMaxWidth().padding(horizontal = 30.dp))
        OutlinedTextField(
            value = passTF,
            onValueChange = { passTF = it },
            placeholder = { Text("Enter your password") },
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            shape = RoundedCornerShape(25.dp),
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Yellow40,
                unfocusedBorderColor = Color.Gray,
                disabledBorderColor = Color.LightGray
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 5.dp)
        )

        Text(
            text = "Forget password?",
            textAlign = TextAlign.End,
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Gray,
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 10.dp)
                .clickable { }
        )


        Button(
            onClick = {navController.navigate("Home")},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,       // background color
                contentColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth()
                .padding(18.dp)
                .height(55.dp)
        ) {
            Text(text = "Log In", fontSize = 20.sp)
        }

        Image(painter = painterResource(id = R.drawable.quiz_logo),
            contentDescription = "Quiz Logo",
            modifier = Modifier.width(300.dp)
                .height(260.dp)
        )


        Row {
            Text("New to Rovio? ")
            Text(" Sign up",fontWeight = FontWeight.Bold,modifier = Modifier.clickable { })

        }
    }
}