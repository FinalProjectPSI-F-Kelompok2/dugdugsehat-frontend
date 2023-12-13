package ac.id.ub.filkom.dugdugsehat.check.ecg

import ac.id.ub.filkom.dugdugsehat.R
import ac.id.ub.filkom.dugdugsehat.check.hr.HrCheckViewModel
import ac.id.ub.filkom.dugdugsehat.ui.theme.Primary400
import ac.id.ub.filkom.dugdugsehat.ui.theme.Primary500
import ac.id.ub.filkom.dugdugsehat.ui.theme.Primary600
import ac.id.ub.filkom.dugdugsehat.ui.theme.Purple400
import ac.id.ub.filkom.dugdugsehat.ui.theme.Purple500
import ac.id.ub.filkom.dugdugsehat.ui.theme.Purple600
import ac.id.ub.filkom.dugdugsehat.ui.theme.Type
import ac.id.ub.filkom.dugdugsehat.ui.theme.smallSpace
import ac.id.ub.filkom.dugdugsehat.ui.theme.xxxxlSpace
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.patrykandpatrick.vico.compose.axis.horizontal.rememberBottomAxis
import com.patrykandpatrick.vico.compose.axis.vertical.rememberStartAxis
import com.patrykandpatrick.vico.compose.chart.Chart
import com.patrykandpatrick.vico.compose.chart.line.lineChart
import com.patrykandpatrick.vico.compose.chart.scroll.rememberChartScrollState
import com.patrykandpatrick.vico.compose.component.shape.shader.fromBrush
import com.patrykandpatrick.vico.compose.style.ProvideChartStyle
import com.patrykandpatrick.vico.core.DefaultAlpha
import com.patrykandpatrick.vico.core.axis.AxisItemPlacer
import com.patrykandpatrick.vico.core.chart.line.LineChart
import com.patrykandpatrick.vico.core.component.shape.shader.DynamicShaders
import com.patrykandpatrick.vico.core.entry.ChartEntryModelProducer
import com.patrykandpatrick.vico.core.entry.FloatEntry

@Composable
fun EcgCheckScreen(
    //  navController: NavController,
    //  scaffoldState: ScaffoldState,
    viewModel: HrCheckViewModel = HrCheckViewModel()
) {
    val modelProducer = remember { ChartEntryModelProducer() }
    val datasetForModel = remember { mutableStateListOf(listOf<FloatEntry>()) }
    val datasetLineSpec = remember { arrayListOf<LineChart.LineSpec>() }
    var xPos = 0f
    val dataPoints = arrayListOf<FloatEntry>()
    var ecgValue = ""

    val scrollState = rememberChartScrollState()

    datasetLineSpec.add(
        LineChart.LineSpec(
            lineColor = Purple400.toArgb(),
            lineBackgroundShader = DynamicShaders.fromBrush(
                brush = Brush.verticalGradient(
                    listOf(
                        Purple500.copy(DefaultAlpha.LINE_BACKGROUND_SHADER_START),
                        Purple500.copy(DefaultAlpha.LINE_BACKGROUND_SHADER_END)
                    )
                )
            )
        )
    )
    for (i in 1 .. 300) {
        val randomYFloat = (1 .. 30).random().toFloat()
        ecgValue = randomYFloat.toInt().toString()
        dataPoints.add(FloatEntry(x = xPos, y = randomYFloat))
        xPos += 1f
    }

    datasetForModel.add(dataPoints)
    modelProducer.setEntries(datasetForModel)

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ){
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(xxxxlSpace),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(R.string.ecg_title),
                    textAlign = TextAlign.Center,
                    style = Type.heading4Bold(),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(75.dp))
                Row(
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = ecgValue,
                        style = Type.heading1Bold(),
                        color = Purple600
                    )
                    Text(
                        text = stringResource(R.string.ecg_value),
                        style = Type.body3Regular(),
                        color = Purple600,
                        modifier = Modifier
                            .padding(start = smallSpace, bottom = smallSpace)
                    )
                }
                Spacer(modifier = Modifier.height(75.dp))
            }
        }

        item {
            Card(modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
            ) {
                //TODO VICOCHART
                ProvideChartStyle {
                    Chart(
                        chart = lineChart(
                            lines = datasetLineSpec
                        ),
                        chartModelProducer = modelProducer,
                        startAxis = rememberStartAxis(
                            title = "Heart rate values",
                            tickLength = 0.dp,
                            valueFormatter = { value, _ ->
                                value.toInt().toString()
                            },
                            itemPlacer = AxisItemPlacer.Vertical.default(
                                maxItemCount = 6
                            ),
                            guideline = null
                        ),
                        bottomAxis = rememberBottomAxis(
                            title = "Time length",
                            tickLength = 0.dp,
                            valueFormatter = { value, _ ->
                                ((value.toInt() + 30).toString())
                            },
                            guideline = null
                        ),
                        chartScrollState = scrollState,
                        isZoomEnabled = true
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EcgCheckScreenPreview() {
    EcgCheckScreen()
}