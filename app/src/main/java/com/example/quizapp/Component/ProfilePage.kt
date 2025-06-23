package com.example.quizapp.Component

import androidx.compose.foundation.Image
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.quizapp.R
import com.example.quizapp.ui.theme.BlueGrey
import com.example.quizapp.ui.theme.Yellow40
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun ProfilePage(navController: NavController, userViewModel: UserViewModel) {
    var userName by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }
    var tempName by remember { mutableStateOf(userViewModel.userName) }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.systemBars.asPaddingValues())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(150.dp)
                .border(
                    width = 5.dp,
                    color = Color.White,
                    shape = RoundedCornerShape(50.dp)
                )
                .clip(RoundedCornerShape(50.dp))
                .clickable {
                    // You can add image picker here later
                },
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Profile",
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(50.dp))
            )
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White // sets card background to white
            ),
            shape = RoundedCornerShape(16.dp), // Optional: round the card itself
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp) // optional lil shadow
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Quiz Overview", fontSize = 20.sp, color = Color.Gray)
                Spacer(modifier = Modifier.height(8.dp))
                Text("300/700 Quiz Solved", fontSize = 28.sp, fontWeight = FontWeight.Bold)

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .height(20.dp)
                            .width(170.dp)
                            .background(Color.Black, shape = RoundedCornerShape(10.dp))
                            .border(
                                shape = RoundedCornerShape(10.dp),
                                width = 1.dp,
                                color = Color.Black
                            )
                    )
                    Box(
                        modifier = Modifier
                            .height(20.dp)
                            .width(50.dp)
                            .background(BlueGrey, shape = RoundedCornerShape(10.dp))
                    )
                    Box(
                        modifier = Modifier
                            .height(20.dp)
                            .width(100.dp)
                            .background(Color.Gray, shape = RoundedCornerShape(10.dp))
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Left side: Black dot and "Subscription" text
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(15.dp)
                                .background(color = Color.Black, shape = RoundedCornerShape(50.dp))
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Subscription", fontSize = 14.sp, color = Color.Gray)
                    }

                    // Right side: "Activated"
                    Text(
                        "Activated",
                        fontSize = 20.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp, start = 16.dp, end = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Left side: Black dot and "Subscription" text
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(15.dp)
                                .background(color = BlueGrey, shape = RoundedCornerShape(50.dp))
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Rewards", fontSize = 14.sp, color = Color.Gray)
                    }

                    Text(
                        "Claim",
                        modifier = Modifier.clickable { showDialog = true },
                        fontSize = 20.sp,
                        color = Yellow40,
                        fontWeight = FontWeight.Bold
                    )

                    if (showDialog) {
                        AlertDialog(
                            onDismissRequest = { showDialog = false },
                            confirmButton = {
                                Button(onClick = { showDialog = false },
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color.Black,
                                        contentColor = Color.White
                                    )) {
                                    Text("Back")
                                }
                            },
                            title = {
                                Text("Reward Claimed", fontWeight = FontWeight.Bold)
                            },
                            text = {
                                Text("All reward is collected.\nNew rewards will be available after 24 hours.")
                            },
                            containerColor = Color.White,
                            titleContentColor = Color.Black,
                            textContentColor = Color.DarkGray
                        )
                    }
                }
            }
    }

        OutlinedTextField(
            value = tempName,
            onValueChange = { tempName = it },
            label = { Text("Enter UserName") },
            placeholder = { Text("Username") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, ),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color.Gray,
                disabledBorderColor = Color.LightGray
            )
        )


        var dateField by remember { mutableStateOf(TextFieldValue("")) }

        OutlinedTextField(
            value = dateField,
            onValueChange = { newValue ->
                val rawDigits = newValue.text.filter { it.isDigit() }.take(6)

                val formatted = buildString {
                    for (i in rawDigits.indices) {
                        append(rawDigits[i])
                        if ((i == 1 || i == 3) && i != rawDigits.lastIndex) {
                            append('/')
                        }
                    }
                }

                // Calculate cursor position
                val oldCursor = newValue.selection.end
                var cursorOffset = 0

                if (formatted.length > dateField.text.length) {
                    if (formatted.getOrNull(oldCursor - 1) == '/') {
                        cursorOffset = 1
                    }
                }

                val newCursor = (oldCursor + cursorOffset).coerceAtMost(formatted.length)

                dateField = TextFieldValue(
                    text = formatted,
                    selection = TextRange(newCursor)
                )
            },
            label = { Text("Enter DOB") },
            placeholder = { Text("DD/MM/YY") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color.Gray,
                disabledBorderColor = Color.LightGray
            )
        )



        Button(
            onClick = {
                userViewModel.userName = tempName
                navController.navigate("home")
            },
            modifier = Modifier
                .padding(16.dp)
                .width(300.dp)
                .height(50.dp)
                .border(
                    width = 1.dp,
                    color = Color.Black,
                    shape = RoundedCornerShape(16.dp)
                ),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = Color.Black
            ),
            shape = RoundedCornerShape(10.dp) // match the border for clean corners
        ) {
            Text("Continue", fontSize = 18.sp)
        }


        IconButton(
            onClick = {   navController.navigate("Login"){
                popUpTo(0) { inclusive = true }
            } },
            colors = IconButtonDefaults.iconButtonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            ),
            modifier = Modifier.size(48.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.ExitToApp,
                contentDescription = "Log Out"
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text("Log Out", fontSize = 14.sp)
    }

}


class UserViewModel : ViewModel() {
    var userName by mutableStateOf("")
}