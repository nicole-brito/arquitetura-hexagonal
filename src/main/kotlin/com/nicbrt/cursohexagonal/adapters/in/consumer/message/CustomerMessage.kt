package com.nicbrt.cursohexagonal.adapters.`in`.consumer.message

import com.nicbrt.cursohexagonal.application.core.domain.Customer

data class CustomerMessage(
    val id: String,
    val name: String,
    val zipCode: String,
    val cpf: String,
    val isValidCpf: Boolean
) {

    fun toCustomer() = Customer(id, name, cpf = cpf, isValidCpf = isValidCpf)
}