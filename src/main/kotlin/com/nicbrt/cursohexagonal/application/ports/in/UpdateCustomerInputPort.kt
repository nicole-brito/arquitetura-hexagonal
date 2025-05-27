package com.nicbrt.cursohexagonal.application.ports.`in`

import com.nicbrt.cursohexagonal.application.core.domain.Customer

interface UpdateCustomerInputPort {

    fun update(customer: Customer, zipcode: String)
}