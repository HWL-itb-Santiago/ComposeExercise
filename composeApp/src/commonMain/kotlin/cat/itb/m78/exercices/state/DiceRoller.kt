package cat.itb.m78.exercices.state

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import m78exercices.composeapp.generated.resources.Res
import m78exercices.composeapp.generated.resources.dice_1
import m78exercices.composeapp.generated.resources.dice_2
import m78exercices.composeapp.generated.resources.dice_3
import m78exercices.composeapp.generated.resources.dice_4
import m78exercices.composeapp.generated.resources.dice_5
import m78exercices.composeapp.generated.resources.dice_6
import m78exercices.composeapp.generated.resources.tapestry
import m78exercices.composeapp.generated.resources.title
import org.jetbrains.compose.resources.painterResource

@Composable
fun DiceRoller()
{
    var dice1 by remember { mutableStateOf(1)}
    var dice2 by remember { mutableStateOf(1)}
    val imageModifier = Modifier
    Box(
        modifier = Modifier.fillMaxSize()
    )
    {
        Image(
            painter = painterResource(Res.drawable.tapestry),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier.fillMaxSize().
            padding(top = 150.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        )
        {
            Image(
                painter = painterResource(Res.drawable.title),
                contentDescription = null,
                contentScale = ContentScale.None,
                modifier = Modifier.fillMaxWidth()
            )
            Button(onClick = {
                val result1 = (1..6).random()
                val result2 = (1..6).random()

                dice1 = result1
                dice2 = result2
            })
            {
                Text(text = "Roll the dice",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center)
            }
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center
            )
            {
                DiceImage(dice1)
                DiceImage(dice2)
            }
        }
    }
}

@Composable
fun DiceImage(diceNumber: Int, modifier: Modifier = Modifier) {
    // Mostrar la imagen correspondiente al número del dado
    val imageRes = when (diceNumber) {
        1 -> Res.drawable.dice_1
        2 -> Res.drawable.dice_2
        3 -> Res.drawable.dice_3
        4 -> Res.drawable.dice_4
        5 -> Res.drawable.dice_5
        6 -> Res.drawable.dice_6
        else -> Res.drawable.dice_1
    }
    Image(
        painter = painterResource(imageRes),
        contentDescription = "Dice $diceNumber",
        contentScale = ContentScale.Fit,
        modifier = modifier
    )
}