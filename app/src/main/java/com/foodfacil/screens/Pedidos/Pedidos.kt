package com.foodfacil.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ButtonDefaults
import androidx.wear.compose.material.Text
import com.foodfacil.ui.theme.MainRed
import com.foodfacil.viewModel.SalgadosViewModel
import com.simpletext.SimpleText
import com.foodfacil.R
import com.foodfacil.ui.theme.MainGray

@Composable
fun Pedidos(
    navController: NavHostController,
    salgadosViewModel: SalgadosViewModel,
    paddingValues: PaddingValues
) {
    val md = Modifier
    Column(
        md
            .padding(paddingValues)
            .background(Color.White)) {
        Top(md)
        MainContent(md = md)
    }
}

@Composable
private fun Top(md:Modifier){
    Box(modifier = md
        .fillMaxWidth()
        .height(90.dp)
        .background(MainGray),
        contentAlignment = Alignment.Center){
        SimpleText("Meus Pedidos", color = MainRed, fontSize = 17)
    }
}
@Composable
private fun MainContent(md:Modifier){
    Box(modifier = md
        .fillMaxWidth()
        .fillMaxHeight(1f)
        .padding(horizontal = 20.dp),
        contentAlignment = Alignment.Center){
        Column(verticalArrangement = Arrangement.spacedBy(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = R.drawable.sem_pedidos_image), contentDescription = null)
            SimpleText("Você ainda não realizou um pedido!", fontSize = 17, fontWeight = "400")
            Text(text = "Bora Pedir? Acesse o cardápio para ver as opções disponíveis",
                textAlign = TextAlign.Center, fontSize = 15.sp, color = Color.Black)
            Spacer(modifier = md.height(20.dp))
            Button(onClick = { /*TODO*/ }, modifier = md.fillMaxWidth(), colors = ButtonDefaults.buttonColors(
                MainRed)) {
                SimpleText("Ver cardápio", color = Color.White, fontSize = 16)
            }
        }
    }
}
