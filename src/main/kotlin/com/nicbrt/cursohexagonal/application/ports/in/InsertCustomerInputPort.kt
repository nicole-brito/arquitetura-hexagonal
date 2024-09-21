package com.nicbrt.cursohexagonal.application.ports.`in`

import com.nicbrt.cursohexagonal.application.core.domain.Customer

interface InsertCustomerInputPort {
    fun insert(customer: Customer, zipCode: String)
}