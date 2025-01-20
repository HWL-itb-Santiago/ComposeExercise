package cat.itb.m78.exercices.stateless

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun Welcome()
{
    Column (
        modifier = Modifier.fillMaxSize()
            .background(color = Color.White)
    )
    {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier.fillMaxWidth()
                .fillMaxHeight(0.5f)
                .background(color = Color.Transparent)
                .padding(bottom = 80.dp)
        )
        {
            Text("Welcome!", fontWeight = FontWeight.SemiBold)
            Text("Start learning now", fontWeight = FontWeight.Medium)
        }
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier.fillMaxWidth()
                .background(color = Color.Transparent)
                .padding(bottom = 80.dp)
        )
        {
            Button(onClick = {})
            {
                Text("Login")
            }
            Button(onClick = {})
            {
                Text("Register")
            }
        }
    }
}