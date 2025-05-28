package com.nicbrt.cursohexagonal.application.core.usecase

import com.nicbrt.cursohexagonal.application.core.domain.Customer
import com.nicbrt.cursohexagonal.application.ports.`in`.FindCustomerByIdInputPort
import com.nicbrt.cursohexagonal.application.ports.`in`.UpdateCustomerInputPort
import com.nicbrt.cursohexagonal.application.ports.out.FindAddressByZipCodeOutputPort
import com.nicbrt.cursohexagonal.application.ports.out.SendCpfForValidationOutputPort
import com.nicbrt.cursohexagonal.application.ports.out.UpdateCustomerOutputPort

class UpdateCustomerUseCase (
    private val findCustomerByIdInputPort: FindCustomerByIdInputPort,
    private val findAddressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,
    private val updateCustomerOutputPort: UpdateCustomerOutputPort,
    private val sendCpfForValidationOutputPort: SendCpfForValidationOutputPort
    ): UpdateCustomerInputPort {

    override fun update(customer: Customer, zipcode: String) {
        if(customer.id == null) throw IllegalArgumentException("The ID field cannot be null")
        val savedCpf = findCustomerByIdInputPort.find(customer.id).cpf

        customer.apply {
            address = findAddressByZipCodeOutputPort.find(zipcode)
        }.let {
            updateCustomerOutputPort.update(it)
            if (savedCpf != it.cpf) {
                sendCpfForValidationOutputPort.send(it.cpf)
            }
        }

    }
}