package com.nicbrt.cursohexagonal.application.ports.`in`

import com.nicbrt.cursohexagonal.application.core.domain.Customer

interface FindCustomerByIdInputPort {

    fun find(id: String): Customer

}