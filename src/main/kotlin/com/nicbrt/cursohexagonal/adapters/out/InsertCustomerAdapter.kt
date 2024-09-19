package com.nicbrt.cursohexagonal.adapters.out

import com.nicbrt.cursohexagonal.adapters.out.repository.CustomerRepository
import com.nicbrt.cursohexagonal.adapters.out.repository.entity.CustomerEntity
import com.nicbrt.cursohexagonal.application.core.domain.Customer
import com.nicbrt.cursohexagonal.application.ports.out.InsertCustomerOutputPort
import org.springframework.stereotype.Component

@Component
class InsertCustomerAdapter(
    private val customerRepository: CustomerRepository
): InsertCustomerOutputPort {

    override fun insert(customer: Customer) {
        customerRepository.save(CustomerEntity(customer))

    }
}