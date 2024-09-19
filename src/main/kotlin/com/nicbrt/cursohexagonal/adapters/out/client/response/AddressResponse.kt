package com.nicbrt.cursohexagonal.adapters.out.client.response

import com.nicbrt.cursohexagonal.application.core.domain.Address

data class AddressResponse(
    val street: String,
    val city: String,
    val state: String
) {
    fun toAddress() = Address(
        street,
        city,
        state
    )
}
