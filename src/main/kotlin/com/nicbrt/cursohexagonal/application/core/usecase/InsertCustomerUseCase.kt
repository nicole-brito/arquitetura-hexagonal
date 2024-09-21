package com.nicbrt.cursohexagonal.application.core.usecase

import com.nicbrt.cursohexagonal.application.core.domain.Customer
import com.nicbrt.cursohexagonal.application.ports.`in`.InsertCustomerInputPort
import com.nicbrt.cursohexagonal.application.ports.out.FindAddressByZipCodeOutputPort
import com.nicbrt.cursohexagonal.application.ports.out.InsertCustomerOutputPort

class InsertCustomerUseCase (
    private val findAddressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,
    private val insertCustomerOutputPort: InsertCustomerOutputPort
): InsertCustomerInputPort {

    override fun insert(customer: Customer, zipCode: String) {
        customer.apply {
            address = findAddressByZipCodeOutputPort.find(zipCode)
        }.let {
            insertCustomerOutputPort.insert(it)
        }
    }
}