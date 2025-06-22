package com.example.quizapp.Component

import com.example.quizapp.R

data class Quizs(
    val quizImageRes: Int,
    val quizQuestion: String,
    val quizOptions: List<String>,
    val quizAnswer: String
)
val quizsTrending = listOf(
    Quizs(
        quizImageRes = R.drawable.footballer,
        quizQuestion = "Famous Portuguese footballer?",
        quizOptions = listOf("Ronaldo", "Messi", "Neymar", "Mbappe"),
        quizAnswer = "Ronaldo"
    ),
    Quizs(
        quizImageRes = R.drawable.naruto,
        quizQuestion = "Naruto’s last name?",
        quizOptions = listOf("Uzumaki", "Uchiha", "Hatake", "Nara"),
        quizAnswer = "Uzumaki"
    ),
    Quizs(
        quizImageRes = R.drawable.minecraft,
        quizQuestion = "Minecraft creator?",
        quizOptions = listOf("Notch", "Elon", "Mark", "Tim"),
        quizAnswer = "Notch"
    ),
    Quizs(
        quizImageRes = R.drawable.sun,
        quizQuestion = "Planet closest to Sun?",
        quizOptions = listOf("Mercury", "Venus", "Earth", "Mars"),
        quizAnswer = "Mercury"
    ),
    Quizs(
        quizImageRes = R.drawable.hitler,
        quizQuestion = "Who was Hitler’s country?",
        quizOptions = listOf("Germany", "Italy", "Russia", "France"),
        quizAnswer = "Germany"
    ),
    Quizs(
        quizImageRes = R.drawable.root,
        quizQuestion = "What is the square root of 49?",
        quizOptions = listOf("5", "6", "7", "8"),
        quizAnswer = "7"
    ),
    Quizs(
        quizImageRes = R.drawable.banana,
        quizQuestion = "Which fruit is yellow and curved?",
        quizOptions = listOf("Apple", "Banana", "Grapes", "Strawberry"),
        quizAnswer = "Banana"
    ),
    )

val quizsDaily = listOf(
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


val quizsMath = listOf(
    Quizs(
        quizImageRes = R.drawable.addition,
        quizQuestion = "What is 7 + 8?",
        quizOptions = listOf("14", "15", "16", "17"),
        quizAnswer = "15"
    ),
    Quizs(
        quizImageRes = R.drawable.multiplication,
        quizQuestion = "What is 12 × 3?",
        quizOptions = listOf("36", "30", "45", "33"),
        quizAnswer = "36"
    ),
    Quizs(
        quizImageRes = R.drawable.division,
        quizQuestion = "What is 100 ÷ 5?",
        quizOptions = listOf("10", "15", "20", "25"),
        quizAnswer = "20"
    ),
    Quizs(
        quizImageRes = R.drawable.root,
        quizQuestion = "What is the square root of 49?",
        quizOptions = listOf("5", "6", "7", "8"),
        quizAnswer = "7"
    ),
    Quizs(
        quizImageRes = R.drawable.square,
        quizQuestion = "Solve: 3² + 4² = ?",
        quizOptions = listOf("25", "12", "18", "30"),
        quizAnswer = "25"
    ),
    Quizs(
        quizImageRes = R.drawable.pi,
        quizQuestion = "What's the value of π (pi) approx?",
        quizOptions = listOf("3.14", "2.17", "1.62", "3.00"),
        quizAnswer = "3.14"
    ),
    Quizs(
        quizImageRes = R.drawable.multiplication,
        quizQuestion = "What is 9 × 9?",
        quizOptions = listOf("81", "72", "99", "90"),
        quizAnswer = "81"
    ),

)

val quizsHistory = listOf(
    Quizs(
        quizImageRes = R.drawable.india,
        quizQuestion = "Who led India’s independence?",
        quizOptions = listOf("Gandhi", "Nehru", "Patel", "Bose"),
        quizAnswer = "Gandhi"
    ),
    Quizs(
        quizImageRes = R.drawable.america,
        quizQuestion = "Who discovered America?",
        quizOptions = listOf("Columbus", "Magellan", "Vasco", "Cook"),
        quizAnswer = "Columbus"
    ),
    Quizs(
        quizImageRes = R.drawable.taj,
        quizQuestion = "Who built the Taj Mahal?",
        quizOptions = listOf("Shah", "Akbar", "Babur", "Jahangir"),
        quizAnswer = "Shah"
    ),
    Quizs(
        quizImageRes = R.drawable.hitler,
        quizQuestion = "Who was Hitler’s country?",
        quizOptions = listOf("Germany", "Italy", "Russia", "France"),
        quizAnswer = "Germany"
    ),
    Quizs(
        quizImageRes = R.drawable.coldwar,
        quizQuestion = "Where was the Cold War?",
        quizOptions = listOf("World", "Asia", "Europe", "Africa"),
        quizAnswer = "World"
    ),
    Quizs(
        quizImageRes = R.drawable.piramid,
        quizQuestion = "Which empire built pyramids?",
        quizOptions = listOf("Egypt", "Rome", "Maya", "Greece"),
        quizAnswer = "Egypt"
    ),
    Quizs(
        quizImageRes = R.drawable.napoleon,
        quizQuestion = "Who was known as Napoleon?",
        quizOptions = listOf("France", "Germany", "Italy", "Spain"),
        quizAnswer = "France"
    )
)

val quizsScience = listOf(
    Quizs(
        quizImageRes = R.drawable.sun,
        quizQuestion = "Planet closest to Sun?",
        quizOptions = listOf("Mercury", "Venus", "Earth", "Mars"),
        quizAnswer = "Mercury"
    ),
    Quizs(
        quizImageRes = R.drawable.water,
        quizQuestion = "Water's chemical formula?",
        quizOptions = listOf("H2O", "CO2", "O2", "NaCl"),
        quizAnswer = "H2O"
    ),
    Quizs(
        quizImageRes = R.drawable.oxygen,
        quizQuestion = "Gas used for breathing?",
        quizOptions = listOf("Oxygen", "Nitrogen", "Carbon", "Helium"),
        quizAnswer = "Oxygen"
    ),
    Quizs(
        quizImageRes = R.drawable.atom,
        quizQuestion = "Center of an atom?",
        quizOptions = listOf("Nucleus", "Electron", "Proton", "Neutron"),
        quizAnswer = "Nucleus"
    ),
    Quizs(
        quizImageRes = R.drawable.lemon,
        quizQuestion = "Acid in lemon?",
        quizOptions = listOf("Citric", "Acetic", "Sulfuric", "Hydrochloric"),
        quizAnswer = "Citric"
    ),
    Quizs(
        quizImageRes = R.drawable.blood,
        quizQuestion = "Organ that pumps blood?",
        quizOptions = listOf("Heart", "Lungs", "Kidney", "Brain"),
        quizAnswer = "Heart"
    ),
    Quizs(
        quizImageRes = R.drawable.planet,
        quizQuestion = "Largest planet?",
        quizOptions = listOf("Jupiter", "Saturn", "Mars", "Earth"),
        quizAnswer = "Jupiter"
    )
)

val quizsGaming = listOf(
    Quizs(
        quizImageRes = R.drawable.mario,
        quizQuestion = "Main character of Mario?",
        quizOptions = listOf("Mario", "Luigi", "Peach", "Toad"),
        quizAnswer = "Mario"
    ),
    Quizs(
        quizImageRes = R.drawable.epic,
        quizQuestion = "Battle royale by Epic?",
        quizOptions = listOf("Fortnite", "PUBG", "Valorant", "Apex"),
        quizAnswer = "Fortnite"
    ),
    Quizs(
        quizImageRes = R.drawable.pikachu,
        quizQuestion = "Pikachu's game series?",
        quizOptions = listOf("Pokemon", "Zelda", "Kirby", "Mario"),
        quizAnswer = "Pokemon"
    ),
    Quizs(
        quizImageRes = R.drawable.gta,
        quizQuestion = "GTA stands for?",
        quizOptions = listOf("Auto", "Action", "Gun", "Fight"),
        quizAnswer = "Auto"
    ),
    Quizs(
        quizImageRes = R.drawable.freefire,
        quizQuestion = "Free fire developer?",
        quizOptions = listOf("Garena", "Tencent", "Epic", "Ubisoft"),
        quizAnswer = "Garena"
    ),
    Quizs(
        quizImageRes = R.drawable.kratos,
        quizQuestion = "Kratos is from?",
        quizOptions = listOf("God", "Halo", "Doom", "Rust"),
        quizAnswer = "God"
    ),
    Quizs(
        quizImageRes = R.drawable.minecraft,
        quizQuestion = "Minecraft creator?",
        quizOptions = listOf("Notch", "Elon", "Mark", "Tim"),
        quizAnswer = "Notch"
    )
)

val quizsAnime = listOf(
    Quizs(
        quizImageRes = R.drawable.naruto,
        quizQuestion = "Naruto’s last name?",
        quizOptions = listOf("Uzumaki", "Uchiha", "Hatake", "Nara"),
        quizAnswer = "Uzumaki"
    ),
    Quizs(
        quizImageRes = R.drawable.luffy,
        quizQuestion = "Luffy’s crew name?",
        quizOptions = listOf("Strawhats", "RedHair", "Blackbeard", "Beast"),
        quizAnswer = "Strawhats"
    ),
    Quizs(
        quizImageRes = R.drawable.dragonball,
        quizQuestion = "Dragon Ball's prince?",
        quizOptions = listOf("Vegeta", "Goku", "Trunks", "Piccolo"),
        quizAnswer = "Vegeta"
    ),
    Quizs(
        quizImageRes = R.drawable.titan,
        quizQuestion = "Titan slayer Eren’s last name?",
        quizOptions = listOf("Yeager", "Ackerman", "Reiss", "Braun"),
        quizAnswer = "Yeager"
    ),
    Quizs(
        quizImageRes = R.drawable.shinigami,
        quizQuestion = "Anime with shinigami notebook?",
        quizOptions = listOf("DeathNote", "Bleach", "JJK", "Demon"),
        quizAnswer = "DeathNote"
    ),
    Quizs(
        quizImageRes = R.drawable.gojo,
        quizQuestion = "Gojo's power type?",
        quizOptions = listOf("Limitless", "Sharingan", "Bankai", "Nen"),
        quizAnswer = "Limitless"
    ),
    Quizs(
        quizImageRes = R.drawable.tanjiro,
        quizQuestion = "Tanjiro’s sister?",
        quizOptions = listOf("Nezuko", "Sakura", "Nico", "Hinata"),
        quizAnswer = "Nezuko"
    )
)

val quizsSports = listOf(
    Quizs(
        quizImageRes = R.drawable.cricket,
        quizQuestion = "Cricket legend 'Master Blaster'?",
        quizOptions = listOf("Sachin", "Kohli", "Dhoni", "Dravid"),
        quizAnswer = "Sachin"
    ),
    Quizs(
        quizImageRes = R.drawable.footballer,
        quizQuestion = "Famous Portuguese footballer?",
        quizOptions = listOf("Ronaldo", "Messi", "Neymar", "Mbappe"),
        quizAnswer = "Ronaldo"
    ),
    Quizs(
        quizImageRes = R.drawable.olympics,
        quizQuestion = "Olympics held every ___ years?",
        quizOptions = listOf("Four", "Two", "Five", "Three"),
        quizAnswer = "Four"
    ),
    Quizs(
        quizImageRes = R.drawable.wimbledon,
        quizQuestion = "Wimbledon is for which sport?",
        quizOptions = listOf("Tennis", "Cricket", "Golf", "Boxing"),
        quizAnswer = "Tennis"
    ),
    Quizs(
        quizImageRes = R.drawable.basketball,
        quizQuestion = "Basketball GOAT Michael?",
        quizOptions = listOf("Jordan", "Kobe", "LeBron", "Curry"),
        quizAnswer = "Jordan"
    ),
    Quizs(
        quizImageRes = R.drawable.captain,
        quizQuestion = "Captain of 2011 WC India?",
        quizOptions = listOf("Dhoni", "Kohli", "Yuvraj", "Sachin"),
        quizAnswer = "Dhoni"
    ),
    Quizs(
        quizImageRes = R.drawable.wickets,
        quizQuestion = "Sport with wickets?",
        quizOptions = listOf("Cricket", "Baseball", "Hockey", "Football"),
        quizAnswer = "Cricket"
    )
)

