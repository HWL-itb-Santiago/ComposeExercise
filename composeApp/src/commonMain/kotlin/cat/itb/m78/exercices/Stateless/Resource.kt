package cat.itb.m78.exercices.Stateless

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import m78exercices.composeapp.generated.resources.Res
import m78exercices.composeapp.generated.resources.evangelion
import m78exercices.composeapp.generated.resources.example_string1
import org.jetbrains.compose.resources.imageResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun Resource()
{
    val stringValue = stringResource(Res.string.example_string1)
    Column (
    ){
        Text(stringValue)
        Image(
            painter = painterResource(Res.drawable.evangelion),
            modifier = Modifier.fillMaxSize(),
            contentDescription = null
        )
    }
}