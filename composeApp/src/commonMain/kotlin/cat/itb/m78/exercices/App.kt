package cat.itb.m78.exercices


import androidx.compose.runtime.*
import cat.itb.m78.exercices.navigation.NavigationHoisting
import cat.itb.m78.exercices.navigation.ScreenMenu
import cat.itb.m78.exercices.state.DiceRoller
import cat.itb.m78.exercices.state.GoodMorningAndNight
import cat.itb.m78.exercices.state.SayHelloScreen
import cat.itb.m78.exercices.state.SecretNumber
import cat.itb.m78.exercices.theme.AppTheme
import cat.itb.m78.exercices.viewModel.Counter
import cat.itb.m78.exercices.viewModel.ShoppingList

@Composable
internal fun App() = AppTheme {
    NavigationHoisting()
}