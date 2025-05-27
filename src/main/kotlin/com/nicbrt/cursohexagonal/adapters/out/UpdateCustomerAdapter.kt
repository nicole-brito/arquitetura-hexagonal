package com.nicbrt.cursohexagonal.adapters.out

import com.nicbrt.cursohexagonal.adapters.out.repository.CustomerRepository
import com.nicbrt.cursohexagonal.adapters.out.repository.entity.CustomerEntity
import com.nicbrt.cursohexagonal.application.core.domain.Customer
import com.nicbrt.cursohexagonal.application.ports.out.UpdateCustomerOutputPort
import org.springframework.stereotype.Component

@Component
class UpdateCustomerAdapter (
    private val repository: CustomerRepository,
    private val customerRepository: CustomerRepository
): UpdateCustomerOutputPort {
    override fun update(customer: Customer) {
        customerRepository.save(CustomerEntity(customer))
    }
}