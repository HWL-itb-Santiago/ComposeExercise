package cat.itb.m78.exercices.State

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlin.random.Random

@Composable
fun SecretNumber()
{
    var text by remember { mutableStateOf(("")) }
    var output by remember { mutableStateOf("")}
    var tries = 0
    var ranNumber : Int = 0
    if (tries == 0)
    {
        ranNumber = (0..1).random()
    }
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxSize()
    )
    {
        OutlinedTextField(
            value = text,
            label = { Text("Adivina el número secreto") },
            placeholder = { Text(". . .") },
            onValueChange = {newText ->
                text = newText
            })

        Button(onClick = {
            tries++
            if (ranNumber == text.toInt())
            {
                output = "Has acertado!"
            }
            else if (ranNumber > text.toInt())
            {
                output = "El numero que buscas es mayor"
            }
            else
            {
                output = "El numero que buscas es menor"
            }
        })
        {
            Text("Validar")
        }
        Text(ranNumber.toString())
    }
}