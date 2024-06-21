package com.speechlesscompany.compasskoala.ui.styles

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.speechlesscompany.compasskoala.R

object Font {

    val QuickSand = FontFamily(
        Font(R.font.quicksand_regular, FontWeight.Normal),
        Font(R.font.quicksand_bold, FontWeight.Bold),
        Font(R.font.quicksand_semi_bold, FontWeight.SemiBold),
        Font(R.font.quicksand_medium, FontWeight.Medium),
        Font(R.font.quicksand_light, FontWeight.Light)
    )
}
