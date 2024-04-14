package com.foodfacil.dataClass

import kotlinx.serialization.Serializable

@Serializable
data class SalgadosResponse(
    val lista: List<SalgadoResponseDto>,
    val message: String
)