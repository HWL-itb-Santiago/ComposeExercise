package cat.itb.m78.exercices.State

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun GoodMorningAndNight()
{
    var message = remember { mutableStateOf("Good ?!") }
    Column ()
    {
        Text(message.value)
        Button (onClick = {
            message.value = "Good Morning!";
        })
        {
            Text("Morning")
        }
        Button (onClick = {
            message.value = "Good Night!";
        })
        {
            Text("Night")
        }
    }
}