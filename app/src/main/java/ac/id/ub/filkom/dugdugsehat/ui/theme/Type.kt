package ac.id.ub.filkom.dugdugsehat.ui.theme

import ac.id.ub.filkom.dugdugsehat.R
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    headlineLarge = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 32.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.sp
    ),
    headlineMedium = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 28.sp,
        lineHeight = 36.sp,
        letterSpacing = 0.sp
    ),
    headlineSmall = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.sp
    ),
    titleLarge = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    titleMedium = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp
    ),
    titleSmall = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.1.sp
    ),
    bodyLarge = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp
    ),
    bodyMedium = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp
    ),
    bodySmall = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp
    ),
    labelLarge = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),
    labelMedium = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    labelSmall = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
)

object Type {
    fun heading1Bold() = TextStyle(
        fontFamily = FontFamily(Font(R.font.dmsans_bold)),
        fontWeight = FontWeight.Bold,
        fontSize = 36.sp
    )
    fun heading1Medium() = TextStyle(
        fontFamily = FontFamily(Font(R.font.dmsans_medium)),
        fontWeight = FontWeight.Medium,
        fontSize = 36.sp
    )
    fun heading1Regular() = TextStyle(
        fontFamily = FontFamily(Font(R.font.dmsans_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp
    )
    fun heading2Bold() = TextStyle(
        fontFamily = FontFamily(Font(R.font.dmsans_bold)),
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp
    )
    fun heading2Medium() = TextStyle(
        fontFamily = FontFamily(Font(R.font.dmsans_medium)),
        fontWeight = FontWeight.Medium,
        fontSize = 32.sp
    )
    fun heading2Regular() = TextStyle(
        fontFamily = FontFamily(Font(R.font.dmsans_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp
    )
    fun heading3Bold() = TextStyle(
        fontFamily = FontFamily(Font(R.font.dmsans_bold)),
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp
    )
    fun heading3Medium() = TextStyle(
        fontFamily = FontFamily(Font(R.font.dmsans_medium)),
        fontWeight = FontWeight.Medium,
        fontSize = 28.sp
    )
    fun heading3Regular() = TextStyle(
        fontFamily = FontFamily(Font(R.font.dmsans_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp
    )
    fun heading4Bold() = TextStyle(
        fontFamily = FontFamily(Font(R.font.dmsans_bold)),
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    )
    fun heading4Medium() = TextStyle(
        fontFamily = FontFamily(Font(R.font.dmsans_medium)),
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp
    )
    fun heading4Regular() = TextStyle(
        fontFamily = FontFamily(Font(R.font.dmsans_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp
    )
    fun heading5Bold() = TextStyle(
        fontFamily = FontFamily(Font(R.font.dmsans_bold)),
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    )
    fun heading5Medium() = TextStyle(
        fontFamily = FontFamily(Font(R.font.dmsans_medium)),
        fontWeight = FontWeight.Medium,
        fontSize = 22.sp
    )
    fun heading5Regular() = TextStyle(
        fontFamily = FontFamily(Font(R.font.dmsans_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp
    )
    fun body1Bold() = TextStyle(
        fontFamily = FontFamily(Font(R.font.dmsans_bold)),
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    )
    fun body1Medium() = TextStyle(
        fontFamily = FontFamily(Font(R.font.dmsans_medium)),
        fontWeight = FontWeight.Medium,
        fontSize = 22.sp
    )
    fun body1Regular() = TextStyle(
        fontFamily = FontFamily(Font(R.font.dmsans_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp
    )
    fun body2Bold() = TextStyle(
        fontFamily = FontFamily(Font(R.font.dmsans_bold)),
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    )
    fun body2Medium() = TextStyle(
        fontFamily = FontFamily(Font(R.font.dmsans_medium)),
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp
    )
    fun body2Regular() = TextStyle(
        fontFamily = FontFamily(Font(R.font.dmsans_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp
    )
    fun body3Bold() = TextStyle(
        fontFamily = FontFamily(Font(R.font.dmsans_bold)),
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    )
    fun body3Medium() = TextStyle(
        fontFamily = FontFamily(Font(R.font.dmsans_medium)),
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    )
    fun body3Regular() = TextStyle(
        fontFamily = FontFamily(Font(R.font.dmsans_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    fun body4Bold() = TextStyle(
        fontFamily = FontFamily(Font(R.font.dmsans_bold)),
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    )
    fun body4Medium() = TextStyle(
        fontFamily = FontFamily(Font(R.font.dmsans_medium)),
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    )
    fun body4Regular() = TextStyle(
        fontFamily = FontFamily(Font(R.font.dmsans_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )
    fun body5Bold() = TextStyle(
        fontFamily = FontFamily(Font(R.font.dmsans_bold)),
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp
    )
    fun body5Medium() = TextStyle(
        fontFamily = FontFamily(Font(R.font.dmsans_medium)),
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp
    )
    fun body5Regular() = TextStyle(
        fontFamily = FontFamily(Font(R.font.dmsans_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
}


//val DMSansFont = FontFamily(
//    Font(R.font.dmsans_bold, FontWeight.Bold),
//    Font(R.font.dmsans_medium, FontWeight.Medium),
//    Font(R.font.dmsans_regular, FontWeight.Normal),
//    Font(R.font.dmsans_italic, FontWeight.Normal, FontStyle.Italic)
//)
