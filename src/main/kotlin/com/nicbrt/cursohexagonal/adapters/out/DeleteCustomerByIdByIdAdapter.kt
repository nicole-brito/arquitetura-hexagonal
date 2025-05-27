package com.nicbrt.cursohexagonal.adapters.out

import com.nicbrt.cursohexagonal.adapters.out.repository.CustomerRepository
import com.nicbrt.cursohexagonal.application.ports.out.DeleteCustomerByIdOutputPort
import org.springframework.stereotype.Component

@Component
class DeleteCustomerByIdByIdAdapter(
    private val customerRepository: CustomerRepository
): DeleteCustomerByIdOutputPort {

    override fun delete(id: String) {
        customerRepository.deleteById(id)
    }
}