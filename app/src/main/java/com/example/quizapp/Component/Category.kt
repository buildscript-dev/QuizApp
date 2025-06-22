package com.example.quizapp.Component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizapp.R
import com.example.quizapp.ui.theme.BlueGrey

// 🧠 Correct data class
data class Category(
    val categoryName: String? = null,
    val categoryNum: Int? = null,
    @DrawableRes val image: Int? = null
)

// 🛠️ Provide sample category data
fun getCategoryItems(): List<Category> = listOf(
    Category(image = R.drawable.filter),
    Category(categoryName = "All", categoryNum = 34),
    Category(categoryName = "Popular", categoryNum = 10),
    Category(categoryName = "Daily", categoryNum = 7)
)

// 🧱 Render the LazyRow of CategoryItems
@Composable
fun CategoryList(categories: List<Category>) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(categories) { category ->
            CategoryItem(category)
        }
    }
}

@Composable
fun CategoryItem(category: Category) {
    Column(
        modifier = Modifier.padding(vertical = 16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                containerColor = Color.Transparent
            ),
            shape = RoundedCornerShape(50), // 🍩 makes it more pill-like
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = Color.Black,
                    shape = RoundedCornerShape(50)
                )
                .height(48.dp) // 🔥 optional height for balance
                .padding(horizontal = 4.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                category.image?.let {
                    Image(
                        painter = painterResource(id = it),
                        contentDescription = category.categoryName ?: "Icon",
                        modifier = Modifier
                            .size(24.dp)
                    )
                }

                category.categoryName?.let {
                    Text(text = it)
                }

                category.categoryNum?.let {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(25.dp))
                            .background(BlueGrey)
                            .padding(horizontal = 6.dp, vertical = 2.dp)
                    ) {
                        Text(
                            text = "$it",
                            color = Color.Black,
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }
    }
}
