package com.elkriefy.playground.android.charts.grid.axisscale

import com.elkriefy.playground.android.charts.grid.axisscale.XAxisScale

class FixedTicksXAxisScale(
    override val min: Long,
    override val max: Long,
    tickCount: Int
) : XAxisScale {
    override val tick: Long = (max - min) / tickCount
    override val start: Long = min
}
