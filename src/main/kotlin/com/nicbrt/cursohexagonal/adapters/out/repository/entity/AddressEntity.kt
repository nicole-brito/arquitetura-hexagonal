package com.nicbrt.cursohexagonal.adapters.out.repository.entity

import com.nicbrt.cursohexagonal.application.core.domain.Address

class AddressEntity(
    val street: String,
    val city: String,
    val state: String
) {
    constructor(address: Address) : this(
        address.street,
        address.city,
        address.state
    )
}