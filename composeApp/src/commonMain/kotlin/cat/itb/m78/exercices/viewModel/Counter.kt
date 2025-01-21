package cat.itb.m78.exercices.viewModel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
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
        Row()
        {
            Column(
            )
            {
                Text(text = "${viewModel.score1.value}", color = Color.White)
                Button(
                    onClick = viewModel::scoreOneClick // or { viewModel.sayBye() }
                ) {
                    Text(text = "Score")
                }
            }
            Column (
                modifier = Modifier.padding(start = 150.dp)
            )
            {
                Text(text = "${viewModel.score2.value}", color = Color.White)
                Button(
                    onClick = viewModel::scoreTwoClick // or { viewModel.sayBye() }
                ) {
                    Text(text = "Score")
                }
            }
        }
    }

}