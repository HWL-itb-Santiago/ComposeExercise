package cat.itb.m78.exercices.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel


sealed interface NavigationHoisting
{
    data object ScreenMenu : NavigationHoisting
    data object Screen1 : NavigationHoisting
    data object Screen2 : NavigationHoisting
    data class Screen3(val name: String) : NavigationHoisting
}

class NavigationVHoistingViewModel : ViewModel()
{
    val actualScreen = mutableStateOf<NavigationHoisting>(NavigationHoisting.ScreenMenu)

    fun changeScreen(destiny : NavigationHoisting)
    {
        actualScreen.value = destiny
    }
}

@Composable
fun NavigationHoisting()
{
    val viewModel = viewModel { NavigationVHoistingViewModel() }
    val currentScreen = viewModel.actualScreen.value

    /*when(currentScreen)
    {
        NavigationHoisting.ScreenMenu -> ScreenMenu (
            { viewModel.changeScreen(NavigationHoisting.Screen1)},
            { viewModel.changeScreen(NavigationHoisting.Screen2)},
            { viewModel.changeScreen(NavigationHoisting.Screen3)}
        )
        NavigationHoisting.Screen1 -> Screen1(
            { viewModel.changeScreen((NavigationHoisting.ScreenMenu))}
        )
        NavigationHoisting.Screen2 -> Screen2(
            { viewModel.changeScreen((NavigationHoisting.ScreenMenu))}
        )
        NavigationHoisting.Screen3 -> Screen3(
            { viewModel.changeScreen((NavigationHoisting.ScreenMenu))}
        )
    }*/
}

@Composable
fun Screen1(changeScreenMenu: () -> Unit)
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
            Text(text = "Screen 1")
            Button(
                onClick = changeScreenMenu
            )
            {
                Text(text = "Menu Screen")
            }
        }

    }
}

@Composable
fun Screen2(changeScreenMenu: () -> Unit)
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
            Text(text = "Screen 2")
            Button(
                onClick = changeScreenMenu
            )
            {
                Text(text = "Menu Screen")
            }
        }

    }
}

@Composable
fun Screen3(changeScreenMenu: () -> Unit)
{
    Box(
        modifier = Modifier.background(color = Color.LightGray)
            .fillMaxSize()
    )
    {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            Text(text = "Screen 3")
            Button(
                onClick = changeScreenMenu
            )
            {
                Text(text = "Menu Screen")
            }
        }

    }
}

@Composable
fun ScreenMenu(changeScreen1: () -> Unit, changeScreen2: () -> Unit, changeScreen3Hello: () -> Unit, changeScreen3Bye: () -> Unit)
{
    Box(
        modifier = Modifier.background(color = Color.Yellow)
            .fillMaxSize()
    )
    {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            Button(
                onClick = changeScreen1
            )
            {
                Text("Screen 1")
            }
            Button(
                onClick = changeScreen2
            )
            {
                Text("Screen 2")
            }
            Button(
                onClick = changeScreen3Hello
            )
            {
                Text("Screen 3 Hello")
            }
            Button(
                onClick = changeScreen3Bye
            )
            {
                Text("Screen 3 Bye")
            }
        }

    }
}