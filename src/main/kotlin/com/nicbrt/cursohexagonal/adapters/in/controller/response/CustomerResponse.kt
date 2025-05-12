package com.nicbrt.cursohexagonal.adapters.`in`.controller.response

import com.nicbrt.cursohexagonal.application.core.domain.Customer

data class CustomerResponse (
    val id : String,
    val name : String,
    val address: AddressResponse,
    val cpf : String,
    val isValidCpf : Boolean,
) {

    constructor(customer : Customer) : this(
        //!! = Operador de assertiva de confirmação ("Eu sei que não vai ser nulo")
        customer.id!!,
        customer.name,
        AddressResponse(customer.address!!),
        customer.cpf,
        customer.isValidCpf,

    )
}