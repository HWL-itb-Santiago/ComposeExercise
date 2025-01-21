package cat.itb.m78.exercices.viewModel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

data class Product(val name : String, val ammount : Int)

class ShoppingListViewModel : ViewModel() {
    var name = mutableStateOf("")
    var amount =  mutableStateOf("")
    var listOfItems = mutableStateListOf<Product>()

    fun AddItem()
    {
        if (name.value.isNotEmpty() && amount.value.isNotEmpty()) {
            val newItem = Product(name.value, amount.value.toInt())
            listOfItems.add(newItem)
            name.value = ""
            amount.value = ""
        }
    }
}

@Composable
fun ShoppingList()
{
    val viewModel = viewModel { ShoppingListViewModel() }
    Box(
        modifier = Modifier.background(color = MaterialTheme.colorScheme.background).
        fillMaxSize()
    )
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Column(
            modifier = Modifier.clip(RoundedCornerShape(16.dp)).
            background(color = Color(0xFFe2e2e2)).
            size(width = 300.dp, height = 200.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            OutlinedTextField(viewModel.name.value,
                label = {Text(text = "Name")},
                onValueChange = {
                    viewModel.name.value = it
                })

            OutlinedTextField(viewModel.amount.value,
                label = {Text(text = "Amount")},
                onValueChange = {
                    viewModel.amount.value = it
                })

            Button(onClick =
            viewModel::AddItem
            )
            {
                Text(text = "Add")
            }
        }
    }
    Column (
        modifier = Modifier.fillMaxWidth().
        padding(top = 200.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    )
    {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
        )
        {
            items(viewModel.listOfItems.size) { index ->
                val item = viewModel.listOfItems[index]
                Text(
                    text = "${item.name} ${item.ammount}"
                )
            }
        }
    }
}