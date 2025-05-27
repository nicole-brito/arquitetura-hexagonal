package com.nicbrt.cursohexagonal.application.core.usecase

import com.nicbrt.cursohexagonal.application.ports.`in`.FindCustomerByIdInputPort
import com.nicbrt.cursohexagonal.application.ports.out.DeleteCustomerByIdOutputPort

class DeleteCustomerByIdUseCase (
    private val findCustomerByIdInputPort: FindCustomerByIdInputPort,
    private val deleteCustomerByIdOutputPort: DeleteCustomerByIdOutputPort
) {

    fun delete(id: String) {
        findCustomerByIdInputPort.find(id)
        deleteCustomerByIdOutputPort.delete(id)
    }

}