package cat.itb.m78.exercices.state

import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Color
import kotlin.random.Random

@Composable
fun SecretNumber()
{
    var ranNum by remember { mutableStateOf(value = (0..100).random()) }

    var userNumber by remember { mutableStateOf(value = "")}
    var tip by remember { mutableStateOf(value = "")}
    var userTries by remember { mutableStateOf(value = 0)}

    Column(
        modifier = Modifier.fillMaxSize().
        background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    )
    {
        OutlinedTextField(userNumber,
            label = {Text(text = "Adivina el numero secreto")},
            onValueChange = {
                userNumber = it
            }
            )

        Button(onClick = {
            tip = if (userNumber.toInt() > ranNum)
                "El numero oculto es menor"
            else if (userNumber.toInt() < ranNum)
                "El numero oculto es mayor"
            else
                "Has acertado!"
            userTries++

        })
        {
            Text(text = "Validar")
        }
        Text(tip)
        Text("Intentos $userTries")
    }
}