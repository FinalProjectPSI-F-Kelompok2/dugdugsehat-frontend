package ac.id.ub.filkom.dugdugsehat.check.component

class HrPlotter {
//    companion object {
//        private const val TAG = "TimePlotter"
//        private const val NVALS = 300 // 5 min
//        private const val RR_SCALE = .1
//    }
//
//    private var listener: PlotterListener? = null
//    val hrFormatter: XYSeriesFormatter<*>
//    val rrFormatter: XYSeriesFormatter<*>
//    private var lineandpointformatterhr: LineAndPointFormatter
//    private var lineandpointformatterrr: LineAndPointFormatter
//    val hrSeries: SimpleXYSeries
//    val rrSeries: SimpleXYSeries
//    private val xHrVals = MutableList(NVALS) { 0.0 }
//    private val yHrVals = MutableList(NVALS) { 0.0 }
//    private val xRrVals = MutableList(NVALS) { 0.0 }
//    private val yRrVals = MutableList(NVALS) { 0.0 }
//
//    init {
//        val now = Date()
//        val endTime = now.time.toDouble()
//        val startTime = endTime - NVALS * 1000
//        val delta = (endTime - startTime) / (NVALS - 1)
//
//        // Specify initial values to keep it from auto-sizing
//        for (i in 0 until NVALS) {
//            xHrVals[i] = startTime + i * delta
//            yHrVals[i] = 60.0
//            xRrVals[i] = startTime + i * delta
//            yRrVals[i] = 100.0
//        }
//        val pointLabelHr  = PointLabelFormatter(android.graphics.Color.RED)
//        val pointLabelRR = PointLabelFormatter(android.graphics.Color.BLUE)
//
//        lineandpointformatterhr = LineAndPointFormatter(android.graphics.Color.RED, android.graphics.Color.RED, android.graphics.Color.RED, pointLabelHr)
//        hrFormatter = lineandpointformatterhr
//        hrFormatter.isLegendIconEnabled = false
//        hrSeries = SimpleXYSeries(xHrVals, yHrVals, "HR")
//        lineandpointformatterrr = LineAndPointFormatter(android.graphics.Color.BLUE, android.graphics.Color.BLUE, android.graphics.Color.BLUE, pointLabelRR)
//        rrFormatter = lineandpointformatterrr
//        rrFormatter.isLegendIconEnabled = false
//        rrSeries = SimpleXYSeries(xRrVals, yRrVals, "RR")
//    }
//
//    fun addValues(polarHrData: PolarHrData.PolarHrSample) {
//        val now = Date()
//        val time = now.time
//        for (i in 0 until NVALS - 1) {
//            xHrVals[i] = xHrVals[i + 1]
//            yHrVals[i] = yHrVals[i + 1]
//            hrSeries.setXY(xHrVals[i], yHrVals[i], i)
//        }
//        xHrVals[NVALS - 1] = time.toDouble()
//        yHrVals[NVALS - 1] = polarHrData.hr.toDouble()
//        hrSeries.setXY(xHrVals[NVALS - 1], yHrVals[NVALS - 1], NVALS - 1)
//
//        // Do RR
//        // We don't know at what time the RR intervals start.  All we know is
//        // the time the data arrived (the current time, now). This
//        // implementation assumes they end at the current time, and spaces them
//        // out in the past accordingly.  This seems to get the
//        // relative positioning reasonably well.
//
//        // Scale the RR values by this to use the same axis. (Could implement
//        // NormedXYSeries and use two axes)
//        val rrsMs = polarHrData.rrsMs
//        val nRrVals = rrsMs.size
//        if (nRrVals > 0) {
//            for (i in 0 until NVALS - nRrVals) {
//                xRrVals[i] = xRrVals[i + 1]
//                yRrVals[i] = yRrVals[i + 1]
//                rrSeries.setXY(xRrVals[i], yRrVals[i], i)
//            }
//            var totalRR = 0.0
//            for (i in 0 until nRrVals) {
//                totalRR += RR_SCALE * rrsMs[i]
//            }
//            var index = 0
//            var rr: Double
//            for (i in NVALS - nRrVals until NVALS) {
//                rr = RR_SCALE * rrsMs[index++]
//                xRrVals[i] = time - totalRR
//                yRrVals[i] = rr
//                totalRR -= rr
//                rrSeries.setXY(xRrVals[i], yRrVals[i], i)
//            }
//        }
//        listener?.update()
//    }
//    fun setListener(listener: PlotterListener?) {
//        this.listener = listener
//    }


}

//@Composable
//fun LineChart(datasetForModel) {
//
//}

//@Composable
//fun PlotCanvas(series: SimpleXYSeries, lineColor: Color) {
//    Canvas(
//        modifier = Modifier
//            .fillMaxSize()
//    ) {
//        val minX = series.getxVals().minOfOrNull { 0.0 }
//        val maxX = series.getxVals().maxOfOrNull { 1.0 }
//        val minY = series.getyVals().minOfOrNull { 0.0 }
//        val maxY = series.getyVals().maxOfOrNull { 1.0 }
//
//        val points = series.getxVals().mapIndexed { index, number ->
//            val canvasX = size.width * ((number.toDouble() - (minX ?: 0.0)) / ((maxX ?: 1.0) - (minX ?: 0.0))).toFloat()
//            val canvasY = size.height * (1 - (series.getyVals()[index].toDouble() - (minY ?: 0.0)) / ((maxY ?: 1.0) - (minY ?: 0.0))).toFloat()
//            Offset(canvasX, canvasY)
//        }
//
//        // Draw the plot lines
//        for (i in 0 until points.size - 1) {
//            drawLine(
//                color = lineColor,
//                start = points[i],
//                end = points[i + 1],
//                strokeWidth = 2.dp.toPx(),
//                cap = StrokeCap.Round
//            )
//        }
//
//        // Draw data points
//        points.forEach { point ->
//            drawCircle(color = lineColor, radius = 4.dp.toPx(), center = point)
//        }
//    }
//
//}

