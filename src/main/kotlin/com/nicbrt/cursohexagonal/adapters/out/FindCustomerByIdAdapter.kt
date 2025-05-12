package com.nicbrt.cursohexagonal.adapters.out

import com.nicbrt.cursohexagonal.adapters.out.repository.CustomerRepository
import com.nicbrt.cursohexagonal.application.core.domain.Customer
import com.nicbrt.cursohexagonal.application.ports.out.FindCustomerByIdOutputPort
import org.springframework.stereotype.Component
import kotlin.jvm.optionals.getOrNull

@Component
class FindCustomerByIdAdapter(
    private val customerRepository: CustomerRepository
) : FindCustomerByIdOutputPort {

    override fun find(id: String): Customer? =
        customerRepository.findById(id)
            .getOrNull()
            .let {
                return it?.toCustomer()
            }
}