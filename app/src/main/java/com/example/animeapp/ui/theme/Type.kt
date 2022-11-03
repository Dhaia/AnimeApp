package com.example.animeapp.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.animeapp.R

val Gilory = FontFamily(
    Font(R.font.gilroy_bold),
    Font(R.font.gilroy_medium),
    Font(R.font.gilroy_regular),
    Font(R.font.gilroy_semi_bold),
    )
val QuiqkSand = FontFamily(
    Font(R.font.quicksand_bold),
    Font(R.font.quicksand_medium),
    Font(R.font.quicksand_regular),
    Font(R.font.quicksand_semi_bold),
)

// Set of Material typography styles to start with
val Typography = Typography(
    defaultFontFamily = QuiqkSand,
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)