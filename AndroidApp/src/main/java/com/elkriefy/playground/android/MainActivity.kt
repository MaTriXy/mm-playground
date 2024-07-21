package com.elkriefy.playground.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elkriefy.playground.Greeting
import com.elkriefy.playground.android.charts.ChartAnimation
import com.elkriefy.playground.android.charts.bar.BarChart
import com.elkriefy.playground.android.charts.bar.BarChartCategory
import com.elkriefy.playground.android.charts.bar.BarChartConfig
import com.elkriefy.playground.android.charts.bar.BarChartData
import com.elkriefy.playground.android.charts.bar.BarChartEntry
import com.elkriefy.playground.android.charts.bubble.Bubble
import com.elkriefy.playground.android.charts.bubble.BubbleChart
import com.elkriefy.playground.android.charts.gasbottle.GasBottle
import com.elkriefy.playground.android.charts.line.LineChart
import com.elkriefy.playground.android.charts.line.LineChartData
import com.elkriefy.playground.android.charts.line.LineChartPoint
import com.elkriefy.playground.android.charts.line.LineChartSeries
import java.time.LocalDateTime

class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            MyApplicationTheme {
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    GreetingView(Greeting().greet())
//                    BarchartView()
//                    GasBottleView()
//                    BubbleChartView()
//                }
//            }
//        }
//    }
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
        MyApplicationTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    // Greeting at the top with 10% height
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(IntrinsicSize.Min)
                            .weight(0.1f)
                            .padding(bottom = 16.dp) // Margin to separate from other views
                    ) {
                        GreetingView(Greeting().greet())
                    }

//                    // Other views, each taking about 10% of the screen
//                    Box(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .weight(0.1f)
//                            .padding(vertical = 8.dp)
//                    ) {
//                        BarchartView()
//                    }

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.3f)
                            .padding(vertical = 8.dp)
                    ) {
                        GasBottleView()
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.3f)
                            .padding(vertical = 8.dp)
                    ) {
                        BubbleChartView()
                    }

                    // Spacer to fill the rest of the screen
                    Spacer(modifier = Modifier.weight(0.4f))
                }
            }
        }
    }
}
}

@Composable
fun GasBottleView() {
    GasBottle(
        percentage = 75f,
        modifier = Modifier.size(width = 200.dp, height = 300.dp),
        animation = ChartAnimation.Simple {
            spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessVeryLow
            )
        }
    )
}


@Composable
fun BubbleChartView(){
    val bubbles = listOf(
        Bubble(
            name = "first",
            value = 1.2f,
            icon = Icons.Default.Star,
            color = Color.Yellow
        ),
        Bubble(
            name = "second",
            value = 4.6f,
            icon = Icons.Default.List,
            color = Color.Green
        ),
        Bubble(
            name = "third",
            value = 6.9f,
            icon = Icons.Default.Favorite,
            color = Color.Blue
        ),
    )
    BubbleChart(
        bubbles = bubbles,
        modifier = Modifier.size(300.dp),
        animation = ChartAnimation.Sequenced(),
    )
}
@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Composable
fun BarchartView() {
    val barChartData = BarChartData(
        categories = listOf(
            BarChartCategory(
                name = "Bar Chart 1",
                entries = listOf(
                    BarChartEntry(
                        x = "primary",
                        y = 17f,
                        color = Color.Yellow,
                    ),
                    BarChartEntry(
                        x = "secondary",
                        y = 30f,
                        color = Color.Red,
                    ),
                )
            ),
            BarChartCategory(
                name = "Bar Chart 2",
                entries = listOf(
                    BarChartEntry(
                        x = "primary",
                        y = -5f,
                        color = Color.Yellow,
                    ),
                    BarChartEntry(
                        x = "secondary",
                        y = -24f,
                        color = Color.Red,
                    ),
                )
            ),
        )
    )
    BarChart(
        data = barChartData,
        config = BarChartConfig(
            thickness = 14.dp,
            cornerRadius = 7.dp,
        ),
        modifier = Modifier.height(250.dp),
        animation = ChartAnimation.Sequenced(),
    )
}



@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView("Hello, Android!")
        BarchartView()
        GasBottleView()
        BubbleChartView()
    }
}
