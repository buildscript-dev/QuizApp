package com.example.quizapp.Component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quizapp.R
import com.example.quizapp.ui.theme.BlueGrey

// 🧠 Correct data class
data class Category(
    val categoryName: String? = null,
    val categoryNum: Int? = null,
    val categoryFilter: String? = null,
    @DrawableRes val image: Int? = null
)

// 🛠️ Provide sample category data
fun getCategoryItems(): List<Category> = listOf(
    Category(categoryName = "All", categoryNum = 10, categoryFilter = null),
    Category(categoryName = "Trending", categoryNum = 6, categoryFilter = "trend"),
    Category(categoryName = "Daily", categoryNum = 8, categoryFilter = "daily"),
    Category(categoryName = "Math", categoryNum = 2, categoryFilter = "math"),
    Category(categoryName = "Science",categoryNum = 4, categoryFilter = "science"),
    Category(categoryName = "Gaming", categoryNum = 9,categoryFilter = "gaming"),
    Category(categoryName = "History", categoryNum = 4, categoryFilter = "history"),
    Category(categoryName = "Anime", categoryNum = 7, categoryFilter = "anime"),
    Category(categoryName = "Sports", categoryNum = 1, categoryFilter = "sports"),
)

@Composable
fun CategoryList(categories: List<Category>) {
    var selectedIndex by remember { mutableStateOf(-1) }

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        itemsIndexed(categories) { index, category ->
            CategoryItem(
                category = category,
                isSelected = index == selectedIndex,
                onClick = { selectedIndex = index }
            )
        }
    }
}

@Composable
fun CategoryItem(
    category: Category,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier.padding(vertical = 16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = onClick,
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(
                contentColor = if (isSelected) Color.White else Color.Black,
                containerColor = if (isSelected) Color.Black else Color.Transparent
            ),
            border = BorderStroke(1.dp, Color.Black),
            modifier = Modifier
                .height(48.dp)
                .defaultMinSize(minWidth = 1.dp) // remove weird min width behavior
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                category.image?.let {
                    Image(
                        painter = painterResource(id = it),
                        contentDescription = category.categoryName ?: "Icon",
                        modifier = Modifier.size(24.dp)
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


@Composable
fun QuizHomePage(navController: NavController) {
    val categories = getCategoryItems()
    var selectedFilter by remember { mutableStateOf<String?>(null) }

    Column {
        // Category filter row
        LazyRow(
            modifier = Modifier.padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(categories) { cat ->
                CategoryItem(
                    category = cat,
                    isSelected = selectedFilter == cat.categoryFilter,
                    onClick = { selectedFilter = cat.categoryFilter }
                )
            }
        }

        // Filter the list
        val filtered = if (selectedFilter == null) quizCards
        else quizCards.filter { it.category == selectedFilter }

        // Show filtered quiz cards
        QuizCardRow(navController = navController, cards = filtered)
    }
}
