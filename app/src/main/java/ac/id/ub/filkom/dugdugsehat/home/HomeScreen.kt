package ac.id.ub.filkom.dugdugsehat.home

import ac.id.ub.filkom.dugdugsehat.R
import ac.id.ub.filkom.dugdugsehat.home.component.HomeTopBanner
import ac.id.ub.filkom.dugdugsehat.home.component.HrEcgCard
import ac.id.ub.filkom.dugdugsehat.ui.theme.Primary50
import ac.id.ub.filkom.dugdugsehat.ui.theme.Primary500
import ac.id.ub.filkom.dugdugsehat.ui.theme.Primary600
import ac.id.ub.filkom.dugdugsehat.ui.theme.Purple50
import ac.id.ub.filkom.dugdugsehat.ui.theme.Purple600
import ac.id.ub.filkom.dugdugsehat.ui.theme.Type
import ac.id.ub.filkom.dugdugsehat.ui.theme.largeSpace
import ac.id.ub.filkom.dugdugsehat.ui.theme.mediumSpace
import ac.id.ub.filkom.dugdugsehat.ui.theme.smallSpace
import ac.id.ub.filkom.dugdugsehat.viewmodel.UserViewModel
import android.Manifest
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun HomeScreen(
//    navController: NavController,
//    scaffoldState: ScaffoldState,
    viewModel: HomeViewModel = viewModel<HomeViewModel>(),
    userViewModel: UserViewModel
) {
    var text by rememberSaveable { mutableStateOf("") }

    val bluetoothPermissionResultLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted ->
            viewModel.onPermissionResult(
                permission = Manifest.permission.BLUETOOTH_CONNECT,
                isGranted = isGranted
            )
        }
    )

    LaunchedEffect(key1 = viewModel.polarIdState) {
        text = viewModel.polarIdState.value
    }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            item {
                HomeTopBanner(
//                    userFullName = mainViewModel.email,
                    userFullName = "John Doe",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = mediumSpace, start = mediumSpace, bottom = smallSpace)
                )
                Spacer(modifier = Modifier.height(largeSpace))
            }
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = largeSpace)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(R.drawable.ic_warning_icon),
                            contentDescription = "Warning Icon",
                            modifier = Modifier
                                .padding(start = smallSpace)
                        )
                        Spacer(
                            modifier = Modifier
                                .width(smallSpace)
                        )
                        Text(
                            modifier = Modifier
                                .alpha(0.5f),
                            text = stringResource(R.string.reminder),
                            style = Type.body4Regular()
                        )
                    }
                    Spacer(modifier = Modifier.height(largeSpace))
                }

            }
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = largeSpace)
                ) {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.Bottom
                    ) {
                        Column(
                            modifier = Modifier
                        ) {
                            Text(
                                text = stringResource(R.string.polar_id),
                                style = Type.body4Medium(),
                                textAlign = TextAlign.Start,
                                modifier = Modifier
                                    .padding(start = smallSpace)
                            )
                            TextField(
                                value = text,
                                onValueChange = {
                                    text = it
                                    viewModel.setPolarId(it)
                                },
                                colors = TextFieldDefaults.outlinedTextFieldColors(
                                    focusedBorderColor = Primary500,
                                    unfocusedBorderColor = Primary500
                                ),
                                maxLines = 1,
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Text,
                                    imeAction = ImeAction.Done
                                ),
                                modifier = Modifier
                                    .width(200.dp)
                            )
                            Spacer(
                                modifier = Modifier
                                    .width(smallSpace)
                            )
                        }
                        Button(
                            onClick = {
                                bluetoothPermissionResultLauncher.launch(
                                    Manifest.permission.BLUETOOTH_CONNECT
                                )
                            },
                            shape = CircleShape,
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Primary500,
                                contentColor = colorResource(R.color.white)
                            ),
                            modifier = Modifier
                                .padding(
                                    start = largeSpace
                                )
                        ) {
                            Text(
                                text = stringResource(R.string.connect_btn),
                                style = Type.body5Regular()
                            )
                        }
                    }
                    Text(
                        text = stringResource(R.string.battery_level, 100) + "%",
                        style = Type.body5Regular(),
                        modifier = Modifier
                            .padding(top = mediumSpace)
                    )
                    Spacer(modifier = Modifier.height(largeSpace))
                }
            }
            item {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = largeSpace, end = largeSpace)
                ) {
                    Text(
                        text = stringResource(R.string.recent_check_day,3),
                        style = Type.body2Bold()
                    )
                    IconButton(
                        onClick = { /*TODO*/ }
                    ) {
                        Image(
                            painter = painterResource(R.drawable.ic_sync_icon),
                            contentDescription = null
                        )
                    }
                }
                Spacer(modifier = Modifier.height(mediumSpace))
            }
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = largeSpace, end = largeSpace)
                ) {
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
                }
                Spacer(modifier = Modifier.height(100.dp))
            }
        }
    }

//@RequiresApi(Build.VERSION_CODES.S)
//@Preview(showBackground = true)
//@Composable
//fun HomeScreenPreview() {
//    DugDugSehatTheme {
//        HomeScreen()
//    }
//}