package cat.itb.m78.exercices.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel


sealed interface NavigationHoisting
{
    data object ScreenMenu : NavigationHoisting
    data object Screen1 : NavigationHoisting
    data object Screen2 : NavigationHoisting
    data class Screen3Hello(val name: String): NavigationHoisting
    data class Screen3Bye(val name: String) : NavigationHoisting
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
    val name = remember {mutableStateOf("")}
    val viewModel = viewModel { NavigationVHoistingViewModel() }
    when (val currentScreen = viewModel.actualScreen.value)
    {
        NavigationHoisting.ScreenMenu -> ScreenMenu(
            name = name,
            { viewModel.changeScreen(NavigationHoisting.Screen1) },
            { viewModel.changeScreen(NavigationHoisting.Screen2) },
            { viewModel.changeScreen(NavigationHoisting.Screen3Hello(name = name.value))},
            { viewModel.changeScreen(NavigationHoisting.Screen3Bye(name = name.value))}
        )
        NavigationHoisting.Screen1 -> Screen1 { viewModel.changeScreen(NavigationHoisting.ScreenMenu) }
        NavigationHoisting.Screen2 -> Screen2(
            changeScreen3 = { viewModel.changeScreen(NavigationHoisting.Screen3Hello(it)) },
            name = name
        )
        is NavigationHoisting.Screen3Bye -> Screen3Bye(currentScreen.name) {
            viewModel.changeScreen(NavigationHoisting.ScreenMenu)
        }
        is NavigationHoisting.Screen3Hello -> Screen3Hello(currentScreen.name) {
            viewModel.changeScreen(NavigationHoisting.ScreenMenu)
        }
    }
}

@Composable
fun ScreenMenu(
    name: MutableState<String>,
    changeScreen1: () -> Unit,
    changeScreen2: (String) -> Unit,
    changeScreen3Hello: (String) -> Unit,
    changeScreen3Bye: (String) -> Unit
)
{
    Box(
        modifier = Modifier.background(color = Color.Yellow)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            OnButton(changeScreen1, "Screen1")
            OnButton({changeScreen2(name.value)}, "Screen 2")
            OnButton({changeScreen3Hello(name.value)}, "Screen 3 Hello")
            OnButton({changeScreen3Bye(name.value)}, "Screen 3 Bye")
        }
    }
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
            OnButton("Screen 1", changeScreenMenu, "Menu Screen")
        }
    }
}

@Composable
fun Screen2(changeScreen3: (String) -> Unit, name: MutableState<String>)
{
    Box(
        modifier = Modifier.background(color = Color.Magenta)
            .fillMaxSize()
    ) {
        TextField(
            value = name.value,
            onValueChange = { name.value = it },
            label = { Text("Enter name") },
            modifier = Modifier.fillMaxSize().padding(16.dp)
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { changeScreen3(name.value) }
            ) {
                Text("Go to Screen 3")
            }
        }
    }
}

@Composable
fun Screen3Hello(message: String, changeScreenMenu: () -> Unit)
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
            OnButton("Hello $message",changeScreenMenu, "Menu Screen")
        }
    }
}

@Composable
fun Screen3Bye(message: String, changeScreenMenu: () -> Unit)
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
            OnButton("Good Bye $message", changeScreenMenu, "Menu Screen")
        }
    }
}


@Composable
fun OnButton(newScreen: () -> Unit, toWrite: String)
{
    Button(
        onClick = newScreen
    )
    {
        Text(toWrite)
    }
}

@Composable
fun OnButton(toWriteBeforeButton: String, newScreen: () -> Unit, toWriteOnButton: String)
{
    Text(toWriteBeforeButton)
    Button(
        onClick = newScreen
    )
    {
        Text(toWriteOnButton)
    }
}