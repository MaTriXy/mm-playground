package com.elkriefy.playground.android.charts.bar

import com.elkriefy.playground.android.charts.bar.BarChartEntry

data class BarChartBar(
    val width: ClosedFloatingPointRange<Float>,
    val height: ClosedFloatingPointRange<Float>,
    val data: BarChartEntry
)
