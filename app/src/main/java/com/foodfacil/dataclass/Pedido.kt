package com.foodfacil.dataclass

import com.foodfacil.enums.PagamentoStatus
import com.foodfacil.enums.PedidoStatus
import com.foodfacil.enums.Plataforma
import com.foodfacil.enums.TipoDePagamento
import kotlinx.serialization.Serializable

@Serializable
data class Pedido(
    val userId:String,
    val userEmail:String,
    val salgados: List<SimplesSalgado>,
    val acompanhamentos: List<SimplesAdicional>,
    val endereco: AddressDto,
    val pagamentoEscolhido: TipoDePagamento,
    val quantiaReservada: Float,
    val plataforma: Plataforma,
    val dispositivoToken:String,
    val total: Float,
    val createdAt: Long,
    val pagamentoStatus: PagamentoStatus,
    val status: PedidoStatus
)