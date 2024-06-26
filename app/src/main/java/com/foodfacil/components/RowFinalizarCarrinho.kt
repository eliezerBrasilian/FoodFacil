package com.foodfacil.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.foodfacil.ui.theme.MainRed
import com.foodfacil.utils.toBrazilianCurrency

@Composable
fun RowFinalizarCarrinho(onClick: () -> Unit = {}, total: Float = 0f,
                         text: String = "Total sem a taxa de entrega") {
    val md = Modifier

    if (total == 0f)
        Box(
            md
                .height(0.dp)
                .fillMaxWidth()
        ) {}
    else
        Box(
            modifier = md
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, bottom = 30.dp, top = 20.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = md
                    .fillMaxWidth()
            ) {
                Column {
                    Text(text = text, fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color  = Color.DarkGray )
                    Text(text = toBrazilianCurrency(total), fontSize = 17.sp, fontWeight = FontWeight.SemiBold, color  = Color.DarkGray )
                }

                Button(
                    onClick = onClick,
                    modifier = md.width(200.dp),
                    colors = ButtonDefaults.buttonColors(
                        MainRed
                    ),
                    shape = RoundedCornerShape(20.dp)
                ) {
                   Text(text ="Finalizar Pedido", fontWeight = FontWeight.SemiBold, color  = Color.White, fontSize = 15.sp )
                }
            }
        }
}