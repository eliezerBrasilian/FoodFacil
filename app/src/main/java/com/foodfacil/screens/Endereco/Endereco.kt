package com.foodfacil.screens.Endereco

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.foodfacil.components.CustomTopBar
import com.foodfacil.components.EnderecoItem
import com.foodfacil.components.VazioComponentText
import com.foodfacil.datastore.StoreUserData

@Composable

fun Endereco(
    paddingValues: PaddingValues,
    storeUserData: StoreUserData,
    navController: NavHostController
) {

    val bairro = storeUserData.getBairro.collectAsState(initial = "")
    val cidade = storeUserData.getCidade.collectAsState(initial = "")
    val rua = storeUserData.getRua.collectAsState(initial = "")
    val complemento = storeUserData.getComplemento.collectAsState(initial = "")
    val numero = storeUserData.getNumeroEndereco.collectAsState(initial = "")

    Scaffold(modifier = Modifier.padding(paddingValues), topBar = {  CustomTopBar(title = "Endereço", navController) }) { pv->
        Surface(modifier = Modifier
            .fillMaxSize()
            .padding(pv)
            .padding(top = 40.dp)) {
            Column(verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {

                if(bairro.value.isNullOrEmpty()){
                    VazioComponentText(md = Modifier, text = "Você ainda não cadastrou nenhum endereço")
                }else{
                    Spacer(modifier = Modifier.height(40.dp))
                    EnderecoItem(cidade.value, "Cidade")
                    EnderecoItem(bairro.value, "Bairro")
                    EnderecoItem(rua.value, "Rua")
                    EnderecoItem(numero.value, "Número")
                    EnderecoItem(complemento.value, "Ponto de referência")
                }
            }
        }
    }
}

