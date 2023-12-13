package ac.id.ub.filkom.dugdugsehat

import ac.id.ub.filkom.dugdugsehat.navigation.Screen
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ac.id.ub.filkom.dugdugsehat.ui.theme.DugDugSehatTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.TextButton
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.pager.HorizontalPager
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnboardingScreen(navController: NavHostController) {
    val listOnboarding = OnboardingItems.getData()
    val scope = rememberCoroutineScope()
    val pageState = rememberPagerState()

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        HorizontalPager(
            count = listOnboarding.size,
            state = pageState,
            modifier = Modifier
                .fillMaxHeight(0.9f)
                .fillMaxWidth()
        ) { page ->
            OnBoardingItem(items = listOnboarding[page])
        }
        
        BottomSection(
            size = listOnboarding.size,
            index = pageState.currentPage,
            onNextButtonClick = {
                scope.launch {
                    pageState.animateScrollToPage(pageState.currentPage + 1)
                }
            },
            onSkipButtonClick = {
                val end = listOnboarding.size - 1
                if (pageState.currentPage + 1 < listOnboarding.size) scope.launch {
                    pageState.animateScrollToPage(end)
                }
            },
            onDoneButtonClick = {
                navController.navigate(Screen.SignIn.route)
            }
        )
    }
}

@Composable
fun OnBoardingItem(items: OnboardingItems) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 25.dp, end = 25.dp)
    ) {
        // Image
        Image(
            painterResource(id = items.image),
            stringResource(id = items.title),
            modifier = Modifier.height(265.dp)
        )
        Spacer(modifier = Modifier.height(15.dp))
        // Title
        Text(
            text = stringResource(id = items.title),
            fontFamily = FontFamily(Font(R.font.dmsans_bold)),
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
        )

        Spacer(modifier = Modifier.height(23.dp))

        // Description
        Text(
            text = stringResource(id = items.desc),
            fontFamily = FontFamily(Font(R.font.dmsans_regular)),
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun Indicators(size: Int, index: Int, onNextButtonClick: () -> Unit = {}, onDoneButtonClick: () -> Unit = {}, onSkipButtonCheck: () -> Unit = {}) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
            TextButton(
                onClick = onSkipButtonCheck,
                enabled = index != size-1,
                modifier = Modifier.width(95.dp)
            ) {
                Text(
                    text = if (index != size-1) "Skip" else "",
                    fontFamily = FontFamily(Font(R.font.dmsans_regular)),
                    color = Color(0XFF000000),
                    fontSize = 18.sp
                )
            }
        Spacer(modifier = Modifier.weight(1f))
        repeat(size) {
            Indicator(isSelected = it == index)
        }
        Spacer(modifier = Modifier.weight(1f))
        TextButton(
            modifier = Modifier.width(95.dp),
            onClick = if (index == size-1) onDoneButtonClick else onNextButtonClick
        ) {
            Text(text = if (index != size-1) "Next" else "Finish", fontFamily = FontFamily(Font(R.font.dmsans_regular)), color = Color(0XFF000000), fontSize = 18.sp)
        }
    }
}

@Composable
fun Indicator(isSelected: Boolean) {
    Box(
        modifier = Modifier
            .height(10.dp)
            .width(10.dp)
            .clip(CircleShape)
            .background(
                color = if (isSelected) Color(0XFFFF5D73) else Color(0X33000000)
            )
    ) {}
}

@Composable
fun BottomSection(size: Int, index: Int, onNextButtonClick: () -> Unit = {}, onDoneButtonClick: () -> Unit = {}, onSkipButtonClick: () -> Unit = {}) {
    Row() {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Indicators(size, index, onNextButtonClick, onDoneButtonClick, onSkipButtonClick)
        }
    }

}


@Preview(showBackground = true)
@Composable
fun OnboardingPreview() {
    DugDugSehatTheme {
//        OnboardingScreen()
    }
}

class OnboardingItems(
    val image: Int,
    val title: Int,
    val desc: Int
) {
    companion object {
        fun getData(): List<OnboardingItems> {
            return listOf(
                OnboardingItems(R.drawable.onboarding_1, R.string.title_onboard_1, R.string.brief_onboard_1),
                OnboardingItems(R.drawable.onboarding_2, R.string.title_onboard_2, R.string.brief_onboard_2),
                OnboardingItems(R.drawable.onboarding_3, R.string.title_onboard_3, R.string.brief_onboard_3)
            )
        }
    }
}