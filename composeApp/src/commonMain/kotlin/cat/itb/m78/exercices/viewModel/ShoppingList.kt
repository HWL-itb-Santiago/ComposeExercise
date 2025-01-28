package cat.itb.m78.exercices.viewModel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

data class Product(val name : String, val amount : Long)

class ShoppingListViewModel : ViewModel() {
    var name = mutableStateOf("")
    var amount =  mutableStateOf("")
    var listOfItems = mutableStateListOf<Product>()

    fun addItem()
    {
        if (name.value.isNotEmpty() && amount.value.isNotEmpty()) {
            val newItem = Product(name.value, amount.value.toLong())
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
        InputSection(viewModel.name, viewModel.amount, viewModel::addItem)
    }
    Column (
        modifier = Modifier.fillMaxWidth().
        padding(top = 200.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    )
    {
        ItemSection(viewModel.listOfItems)
    }
}

@Composable
fun ItemSection(listOfItems : SnapshotStateList<Product>)
{
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    )
    {
        items(listOfItems.size) { index ->
            val item = listOfItems[index]
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 50.dp, end = 50.dp, top = 10.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(color = Color(0xFFe2e2e2)),

                horizontalArrangement = Arrangement.SpaceBetween
            )
            {
                Text(
                    text = item.name, modifier = Modifier.padding(start = 10.dp)
                )
                Text(
                    text = "${item.amount}", modifier = Modifier.padding(end = 10.dp)
                )
            }
        }

    }
}

@Composable
fun InputSection(name : MutableState<String>, amount : MutableState<String>, toDo : () -> Unit)
{
    Column(
        modifier = Modifier.clip(RoundedCornerShape(16.dp)).
        background(color = Color(0xFFe2e2e2)).
        size(width = 300.dp, height = 200.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        OutLineButton(name)
        OutLineButton(amount)
        Button(onClick =
            toDo
        )
        {
            Text(text = "Add")
        }
    }
}

@Composable
fun OutLineButton(name : MutableState<String>)
{
    OutlinedTextField(name.value,
        label = {Text(text = "Name")},
        onValueChange = {
            name.value = it
        })
}