package com.nicbrt.cursohexagonal.application.ports.out

import com.nicbrt.cursohexagonal.application.core.domain.Customer

interface UpdateCustomerOutputPort {

    fun update(customer: Customer)

}