package com.foodfacil.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.foodfacil.R
import com.foodfacil.ui.theme.MainRed

@Composable
fun PixContainer(borderColor:Color = MainRed, trailingIconVisible:Boolean = true, onClick:()->Unit = {}) {
    val md = Modifier
    Box(
        modifier = md
            .height(60.dp)
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(12.dp))
            .border(width = 1.dp, color = borderColor, RoundedCornerShape(12.dp))
            .padding(vertical = 10.dp, horizontal = 20.dp).clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween, modifier = md.fillMaxWidth()
        ) {

            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                Circle(size = 30.dp, color = Color(0xffF1F1F1)) {
                    Image(
                        painter = painterResource(id = R.drawable.pix),
                        contentDescription = null,
                        md.size(20.dp)
                    )
                }
                Text("PIX", fontWeight = FontWeight.SemiBold, fontSize = 15.sp)

            }
            if(trailingIconVisible)
                Image(
                    painter = painterResource(id = R.drawable.custom_yellow_check),
                    contentDescription = null,
                    md.size(17.dp)
                )
        }

    }
}