package ac.id.ub.filkom.dugdugsehat.check.hr

import ac.id.ub.filkom.dugdugsehat.R
import ac.id.ub.filkom.dugdugsehat.navigation.Screen
import ac.id.ub.filkom.dugdugsehat.ui.theme.Primary400
import ac.id.ub.filkom.dugdugsehat.ui.theme.Primary50
import ac.id.ub.filkom.dugdugsehat.ui.theme.Primary500
import ac.id.ub.filkom.dugdugsehat.ui.theme.Primary600
import ac.id.ub.filkom.dugdugsehat.ui.theme.Type
import ac.id.ub.filkom.dugdugsehat.ui.theme.smallSpace
import ac.id.ub.filkom.dugdugsehat.ui.theme.xxxxlSpace
import android.content.Intent
import android.util.Log
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
import com.patrykandpatrick.vico.compose.axis.vertical.startAxis
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
import com.polar.sdk.api.PolarBleApi
import com.polar.sdk.api.PolarBleApiCallback
import com.polar.sdk.api.PolarBleApiDefaultImpl
import com.polar.sdk.api.errors.PolarInvalidArgument
import com.polar.sdk.api.model.PolarDeviceInfo
import com.polar.sdk.api.model.PolarHrData
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import kotlinx.coroutines.withContext
import java.text.DecimalFormat
import java.util.UUID


//class HrCheckScreen {
//    companion object {
//        private const val TAG ="HRActivity"
//    }
//    private lateinit var api: PolarBleApi
//    private lateinit var plotter: HrPlotter
//    private lateinit var plot: XYPlot
//    private var hrDisposable: Disposable? = null
//
//    private lateinit var textHR: String
//
//    private lateinit var deviceId: String
//    private val intent: Intent = Intent()
    @Composable
    fun HrCheckScreen(
        //  navController: NavController,
        //  scaffoldState: ScaffoldState,
        //viewModel: HrCheckViewModel = HrCheckViewModel()
    ) {
        val modelProducer = remember { ChartEntryModelProducer() }
        val datasetForModel = remember { mutableStateListOf(listOf<FloatEntry>()) }
        val datasetLineSpec = remember { arrayListOf<LineChart.LineSpec>() }
        var xPos = 0f
        val dataPoints = arrayListOf<FloatEntry>()
        var hrValue = ""

        val scrollState = rememberChartScrollState()

        datasetLineSpec.add(
            LineChart.LineSpec(
                lineColor = Primary400.toArgb(),
                lineBackgroundShader = DynamicShaders.fromBrush(
                    brush = Brush.verticalGradient(
                        listOf(
                            Primary500.copy(DefaultAlpha.LINE_BACKGROUND_SHADER_START),
                            Primary500.copy(DefaultAlpha.LINE_BACKGROUND_SHADER_END)
                        )
                    )
                )
            )
        )
        for (i in 1 .. 300) {
            val randomYFloat = (1 .. 140).random().toFloat()
            hrValue = randomYFloat.toInt().toString()
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
                        text = stringResource(R.string.hr_title),
                        textAlign = TextAlign.Center,
                        style = Type.heading3Bold(),
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
                            text = hrValue,
                            style = Type.heading1Bold(),
                            color = Primary600
                        )
                        Text(
                            text = stringResource(R.string.hr_value),
                            style = Type.body3Regular(),
                            color = Primary600,
                            modifier = Modifier
                                .padding(start = smallSpace, bottom = smallSpace)
                        )
                    }
                    Spacer(modifier = Modifier.height(75.dp))
    //                    PlotCanvas(series = plotter.hrSeries, lineColor = Primary50)
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
                                    value.toInt().toString()
                                },
                                itemPlacer = AxisItemPlacer.Horizontal.default(
                                    spacing = 30
                                ),
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

//        deviceId = "123456789"
////        deviceId = intent.getStringExtra("id") ?:throw Exception("HR Activity couldn't be created, no deviceId given")
//
//        api =PolarBleApiDefaultImpl.defaultImplementation(
//            LocalContext.current,
//            setOf(
//                PolarBleApi.PolarBleSdkFeature.FEATURE_POLAR_ONLINE_STREAMING
//            )
//        )
//
//        api.setApiLogger { str: String -> Log.d("SDK", str) }
//        api.setApiCallback(object : PolarBleApiCallback() {
//            override fun blePowerStateChanged(powered: Boolean) {
//                Log.d(TAG, "BluetoothStateChanged $powered")
//            }
//
//            override fun deviceConnected(polarDeviceInfo: PolarDeviceInfo) {
//                Log.d(TAG, "Device connected ${polarDeviceInfo.deviceId}")
//            }
//
//            override fun deviceConnecting(polarDeviceInfo: PolarDeviceInfo) {
//                Log.d(TAG, "Device connecting ${polarDeviceInfo.deviceId}")
//            }
//
//            override fun deviceDisconnected(polarDeviceInfo: PolarDeviceInfo) {
//                Log.d(TAG, "Device disconnected ${polarDeviceInfo.deviceId}")
//            }
//
//            override fun bleSdkFeatureReady(
//                identifier: String,
//                feature: PolarBleApi.PolarBleSdkFeature
//            ) {
//                Log.d(TAG, "feature ready $feature")
//
//                when(feature) {
//                    PolarBleApi.PolarBleSdkFeature.FEATURE_POLAR_ONLINE_STREAMING -> {
//                        streamHR()
//                    }
//                    else -> {}
//                }
//            }
//
//            override fun disInformationReceived(identifier: String, uuid: UUID, value: String) {
//                if (uuid == UUID.fromString("00002a28-0000-1000-8000-00805f9b34fb")) {
//                    Log.d(TAG, "Firmware: " + identifier + " " + value.trim { it <= ' ' })
//
//                }
//            }
//
//            override fun batteryLevelReceived(identifier: String, level: Int) {
//                Log.d(TAG, "Battery level: $identifier $level%")
//            }
//        })
//
//        try {
//            api.connectToDevice(deviceId)
//        } catch (a: PolarInvalidArgument) {
//            a.printStackTrace()
//        }
//
//        plotter = HrPlotter()
//        plotter.setListener(this)
//        plot.addSeries(plotter.hrSeries, plotter.hrFormatter)
//        plot.addSeries(plotter.rrSeries, plotter.rrFormatter)
//        plot.setRangeBoundaries(50, 100, BoundaryMode.AUTO)
//        plot.setDomainBoundaries(0, 3600000, BoundaryMode.AUTO)
//        // Left labels will increment by 10
//        plot.setRangeStep(StepMode.INCREMENT_BY_VAL, 10.0)
//        plot.setDomainStep(StepMode.INCREMENT_BY_VAL, 60000.0)
//        // Make left labels be an integer (no decimal places)
//        plot.graph.getLineLabelStyle(XYGraphWidget.Edge.LEFT).format = DecimalFormat("#")
//        // These don't seem to have an effect
//        plot.linesPerRangeLabel = 2

//        disposeOnDestroy()

//    fun streamHR() {
//        val isDisposed = hrDisposable?.isDisposed ?: true
//        if (isDisposed) {
//            hrDisposable = api.startHrStreaming(deviceId)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe (
//                    { hrData: PolarHrData ->
//                        for (sample in hrData.samples) {
//                            Log.d(TAG, "HR ${sample.hr}")
//
//                            textHR = sample.hr.toString()
//                            plotter.addValues(sample)
//                        }
//                    },
//                    { error: Throwable ->
//                        Log.e(TAG, "HR stream failed. reason $error")
//                        hrDisposable = null
//                    },
//                    {
//                        Log.d(TAG, "HR stream complete")
//                    }
//                )
//        } else {
//            //Note stops streaming if its running
//            hrDisposable?.dispose()
//            hrDisposable = null
//        }
//    }
//
//    override fun update() {
//        plot.redraw()
//    }
//
//    @Composable
//    fun disposeOnDestroy() {
//        api.shutDown()
//        hrDisposable?.dispose()
//    }

    @Preview(showBackground = true)
    @Composable
    fun HeartCheckScreenPreview() {
        HrCheckScreen()
    }
//}
