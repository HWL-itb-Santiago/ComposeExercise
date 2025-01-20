package cat.itb.m78.exercices


import androidx.compose.runtime.*
import cat.itb.m78.exercices.state.DiceRoller
import cat.itb.m78.exercices.state.GoodMorningAndNight
import cat.itb.m78.exercices.state.SayHelloScreen
import cat.itb.m78.exercices.state.SecretNumber
import cat.itb.m78.exercices.theme.AppTheme

@Composable
internal fun App() = AppTheme {
    DiceRoller()
}

/*@Composable
fun MainPage()
{
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        Button(onClick = {})
        {
            Text("Hello World")
        }
        Button(onClick = {})
        {
            Text("Welcome")
        }
    }
}
*/