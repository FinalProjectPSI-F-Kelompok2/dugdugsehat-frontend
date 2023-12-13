package ac.id.ub.filkom.dugdugsehat

import ac.id.ub.filkom.dugdugsehat.home.component.HrEcgCard
import ac.id.ub.filkom.dugdugsehat.ui.theme.DugDugSehatTheme
import ac.id.ub.filkom.dugdugsehat.ui.theme.Primary50
import ac.id.ub.filkom.dugdugsehat.ui.theme.Primary600
import ac.id.ub.filkom.dugdugsehat.ui.theme.Purple50
import ac.id.ub.filkom.dugdugsehat.ui.theme.Purple600
import ac.id.ub.filkom.dugdugsehat.ui.theme.Type
import ac.id.ub.filkom.dugdugsehat.ui.theme.mediumSpace
import ac.id.ub.filkom.dugdugsehat.viewmodel.UserViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class history: ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DugDugSehatTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel = UserViewModel()
                    Historyscreen(viewModel)
                }
            }
        }
    }
}

@Composable
fun Historyscreen(
    viewModel: UserViewModel
){
    var email by remember { mutableStateOf(viewModel.email2) }
    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        item {
            Column(
                modifier = Modifier
                    .padding(vertical = 20.dp)
                    .padding(24.dp),
                horizontalAlignment = Alignment.Start

            ){
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp)
                ) {
                    androidx.compose.material3.Text(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = mediumSpace, end = mediumSpace),
                        text = email,
                        style = Type.heading3Medium()
                    )
                }
                Spacer(modifier = Modifier.height(mediumSpace))
                HrEcgCard(
                    value = 75,
                    cardColor = Primary50,
                    contentColor = Primary600,
                    cardTitle = stringResource(R.string.hr_card),
                    unit = stringResource(R.string.hr_value),
                    painter = painterResource(R.drawable.ic_heart_icon),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = mediumSpace, end = mediumSpace)
                )
                Spacer(modifier = Modifier.height(mediumSpace))
                HrEcgCard(
                    value = 24,
                    cardColor = Purple50,
                    contentColor = Purple600,
                    cardTitle = stringResource(R.string.ecg_card),
                    unit = stringResource(R.string.ecg_value),
                    painter = painterResource(R.drawable.ic_bolt_icon),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = mediumSpace, end = mediumSpace)
                )
                Spacer(modifier = Modifier.height(mediumSpace))
                HrEcgCard(
                    value = 80,
                    cardColor = Primary50,
                    contentColor = Primary600,
                    cardTitle = stringResource(R.string.hr_card),
                    unit = stringResource(R.string.hr_value),
                    painter = painterResource(R.drawable.ic_heart_icon),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = mediumSpace, end = mediumSpace)
                )
                Spacer(modifier = Modifier.height(mediumSpace))
                HrEcgCard(
                    value = 27,
                    cardColor = Purple50,
                    contentColor = Purple600,
                    cardTitle = stringResource(R.string.ecg_card),
                    unit = stringResource(R.string.ecg_value),
                    painter = painterResource(R.drawable.ic_bolt_icon),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = mediumSpace, end = mediumSpace)
                )
                Spacer(modifier = Modifier.height(mediumSpace))
                HrEcgCard(
                    value = 78,
                    cardColor = Primary50,
                    contentColor = Primary600,
                    cardTitle = stringResource(R.string.hr_card),
                    unit = stringResource(R.string.hr_value),
                    painter = painterResource(R.drawable.ic_heart_icon),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = mediumSpace, end = mediumSpace)
                )
                Spacer(modifier = Modifier.height(mediumSpace))
                HrEcgCard(
                    value = 26,
                    cardColor = Purple50,
                    contentColor = Purple600,
                    cardTitle = stringResource(R.string.ecg_card),
                    unit = stringResource(R.string.ecg_value),
                    painter = painterResource(R.drawable.ic_bolt_icon),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = mediumSpace, end = mediumSpace)
                )
                Spacer(modifier = Modifier.height(mediumSpace))
                HrEcgCard(
                    value = 82,
                    cardColor = Primary50,
                    contentColor = Primary600,
                    cardTitle = stringResource(R.string.hr_card),
                    unit = stringResource(R.string.hr_value),
                    painter = painterResource(R.drawable.ic_heart_icon),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = mediumSpace, end = mediumSpace)
                )
                Spacer(modifier = Modifier.height(mediumSpace))
                HrEcgCard(
                    value = 28,
                    cardColor = Purple50,
                    contentColor = Purple600,
                    cardTitle = stringResource(R.string.ecg_card),
                    unit = stringResource(R.string.ecg_value),
                    painter = painterResource(R.drawable.ic_bolt_icon),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = mediumSpace, end = mediumSpace)
                )
                Spacer(modifier = Modifier.height(mediumSpace))
                HrEcgCard(
                    value = 79,
                    cardColor = Primary50,
                    contentColor = Primary600,
                    cardTitle = stringResource(R.string.hr_card),
                    unit = stringResource(R.string.hr_value),
                    painter = painterResource(R.drawable.ic_heart_icon),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = mediumSpace, end = mediumSpace)
                )
                Spacer(modifier = Modifier.height(mediumSpace))
                HrEcgCard(
                    value = 30,
                    cardColor = Purple50,
                    contentColor = Purple600,
                    cardTitle = stringResource(R.string.ecg_card),
                    unit = stringResource(R.string.ecg_value),
                    painter = painterResource(R.drawable.ic_bolt_icon),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = mediumSpace, end = mediumSpace)
                )
            }
            Spacer(modifier = Modifier.height(100.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HistoryScreenPreview() {
    DugDugSehatTheme {
        val viewModel = UserViewModel()
        Historyscreen(viewModel)
    }
}