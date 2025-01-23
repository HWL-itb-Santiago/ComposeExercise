package cat.itb.m78.exercices.viewModel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

class CounterViewModel : ViewModel() {
    var score1 = mutableStateOf(0)
    var score2 =  mutableStateOf(0)
    fun scoreOneClick(){
        score1.value += 1
    }
    fun scoreTwoClick(){
        score2.value += 1
    }
}

@Composable
fun Counter() {
    val viewModel = viewModel { CounterViewModel() }
    Box(
        modifier = Modifier.fillMaxSize().
        background(color = MaterialTheme.colorScheme.onBackground)
    )
    {
        Row(
            modifier = Modifier.fillMaxSize()
        )
        {
            ButtonScore(viewModel.score1.value, viewModel::scoreOneClick)
            ButtonScore(viewModel.score2.value, viewModel::scoreTwoClick)
        }
    }
}

@Composable
fun ButtonScore(score : Int, toDo : () -> Unit)
{
    Column()
    {
        Text(text = "$score", color = Color.White)
        Button(
            onClick = toDo // or { viewModel.sayBye() }
        ) {
            Text(text = "Score")
        }
    }
}