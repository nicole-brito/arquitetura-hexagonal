package com.nicbrt.cursohexagonal.adapters.`in`.controller.response

import com.nicbrt.cursohexagonal.application.core.domain.Address

class AddressResponse (
    val street: String,
    val city: String,
    val state: String,
) {

    constructor(address: Address) : this(
        address.street,
        address.city,
        address.state,
    )
}