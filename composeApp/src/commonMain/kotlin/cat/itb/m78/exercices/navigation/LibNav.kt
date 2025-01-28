package cat.itb.m78.exercices.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable

object Destination {
    @Serializable
    data object ScreenStart
    @Serializable
    data object ScreenLandPage
}

@Composable
fun LibNav()
{
    val name = remember { mutableStateOf("") }
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = Destination.ScreenStart)
    {
        composable<Destination.ScreenStart>
        {
            ScreenStart (name = name) { navController.navigate(Destination.ScreenLandPage) }
        }

        composable<Destination.ScreenLandPage> {
            ScreenLandPage(name = name){ navController.navigate(Destination.ScreenStart)}
        }
    }
}

@Composable
fun ScreenStart(name: MutableState<String>, changeToNext : () -> Unit)
{
    Box(
        modifier = Modifier.background(color = Color.Cyan)
            .fillMaxSize()
    )
    {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            Card(
                modifier = Modifier.fillMaxWidth(0.5f),

            )
            {
                Text("Hola ${name.value}!!", modifier = Modifier.align(Alignment.CenterHorizontally))
            }

            Button(
                onClick = changeToNext
            )
            {
                Text("Jump to Land Page")
            }
        }
    }
}

@Composable
fun ScreenLandPage(name: MutableState<String>, changeToNext: () -> Unit)
{
    Box(
        modifier = Modifier.background(color = Color.Magenta)
            .fillMaxSize()
    )
    {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            TextField(
                value = name.value,
                onValueChange = {name.value = it},
                label = {Text("Change your name")}
            )
            Button(
                onClick = changeToNext
            )
            {
                Text("Jump to Start")
            }
        }
    }
}