package com.elkriefy.playground.android.charts.grid

import com.elkriefy.playground.android.charts.line.LegendItemData

interface GridChartData {
    val minX: Long
    val maxX: Long
    val minY: Float
    val maxY: Float
    val legendData: List<LegendItemData>
}
