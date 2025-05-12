package com.nicbrt.cursohexagonal.application.core.usecase

import com.nicbrt.cursohexagonal.application.core.exceptions.ObjectNotFoundException
import com.nicbrt.cursohexagonal.application.ports.`in`.FindCustomerByIdInputPort
import com.nicbrt.cursohexagonal.application.ports.out.FindCustomerByIdOutputPort

class FindCustomerByIdUseCase (
    private val findCustomerByIdOutputPort: FindCustomerByIdOutputPort
    ): FindCustomerByIdInputPort {

    override fun find(id: String) =
        findCustomerByIdOutputPort.find(id) ?: throw ObjectNotFoundException("Customer not found")
}