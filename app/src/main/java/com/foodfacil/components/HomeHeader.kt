package com.foodfacil.components
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.foodfacil.R
import com.foodfacil.ui.theme.GreenDot
import com.simpletext.SimpleText

@Composable
fun HomeHeader(md:Modifier){
    Row(modifier = md.fillMaxWidth().padding(top = 50.dp, start = 20.dp, end = 20.dp), verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Absolute.SpaceBetween) {
       Logo(md)
        FuncionamentoColumn(md)
        Cart(md)
    }
}

@Composable
fun Logo(md: Modifier) {
    Image(painter = painterResource(id = R.drawable.top_logo), contentDescription = null,
        md.width(90.dp)
        )
}

@Composable
fun FuncionamentoColumn(md: Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(5.dp)) {
            SimpleText("Estamos funcionando!", fontSize = 16, fontWeight = "bold")
            Dot(md)
        }
        SimpleText("De 09:00 às 19:00", fontSize = 16)
    }
}

@Composable
fun Dot(md: Modifier) {
    Box(
        md
            .size(13.dp)
            .background(color = GreenDot, shape = CircleShape))
}

@Composable
fun Cart(md: Modifier) {
    Image(painter = painterResource(id = R.drawable.top_carrinho),
        contentDescription = null, md.size(25.dp))
}