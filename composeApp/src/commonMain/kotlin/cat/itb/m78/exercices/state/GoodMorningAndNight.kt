package cat.itb.m78.exercices.state

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun GoodMorningAndNight()
{
    var message by remember { mutableStateOf("Good ?!")}

    Column(
        modifier = Modifier.background(color = Color.White)
    )
    {
        val morning = "Morning"
        val night = "Night"
        Text(message)
        Button(onClick = {
            message = "Good $morning"
        })
        {
            Text(text = morning.toString())
        }
        Button(onClick = {
            message = "Good $night"
        })
        {
            Text(text = night.toString())
        }
    }
}