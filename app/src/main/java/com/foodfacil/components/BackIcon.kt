package com.foodfacil.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.foodfacil.ui.theme.MainYellow

@Composable
fun BackIcon(md: Modifier = Modifier, navController: NavHostController,
             icon:ImageVector = Icons.AutoMirrored.Filled.ArrowBack){
    Box(md.padding(start = 15.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MainYellow,
            modifier = md.clickable { navController.popBackStack() })
    }
}

