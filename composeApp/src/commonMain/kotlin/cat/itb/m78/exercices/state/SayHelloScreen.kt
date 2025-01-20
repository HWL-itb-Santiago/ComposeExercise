package cat.itb.m78.exercices.state

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.unit.dp

@Composable
fun SayHelloScreen()
{
    var showDialog by remember { mutableStateOf(false) }
    var message by remember { mutableStateOf("")}
    Column (
        modifier = Modifier.fillMaxSize().
            background(color = Color.White).
            padding(top = 10.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        OutlinedTextField(message,
            label = { Text(text = "Name") },
            onValueChange = {
                message = it
            })

        Button(onClick = {
            showDialog = true
        })
        {
            Text(text = "SayHello")
        }

        if (showDialog)
            AlertDialog(
                onDismissRequest = {showDialog = false},
                confirmButton = {Button(onClick = { showDialog = false }) {
                    Text("OK")
                }},
                text = {Text("Hello $message")}
            )
    }


}


/*    var text by remember { mutableStateOf(("")) }
    var showDialog by remember { mutableStateOf(false) }
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxSize()
    )
    {
        OutlinedTextField(
            value = text,
            label = { Text("Name")},
            placeholder = {Text(". . .")},
            onValueChange = {newText ->
                text = newText
            })

        Button(onClick = {
            showDialog = true
        })
        {
            Text("SayHello")
        }
        if (showDialog)
        {
            AlertDialog(
                onDismissRequest = {showDialog = false},
                confirmButton={},
                text = { Text("HELLO " + text)}
            )
        }
    }*/