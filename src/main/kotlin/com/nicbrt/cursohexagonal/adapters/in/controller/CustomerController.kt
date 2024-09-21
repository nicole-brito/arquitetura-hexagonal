package com.nicbrt.cursohexagonal.adapters.`in`.controller

import com.nicbrt.cursohexagonal.adapters.`in`.controller.request.CustomerRequest
import com.nicbrt.cursohexagonal.application.core.domain.Customer
import com.nicbrt.cursohexagonal.application.ports.`in`.InsertCustomerInputPort
import com.nicbrt.cursohexagonal.application.ports.out.InsertCustomerOutputPort
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/customers")
class CustomerController(
    private val insertCustomerInputPort: InsertCustomerInputPort
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun insert(@Valid @RequestBody customerRequest: CustomerRequest) {
        with(customerRequest){
            val customer = Customer(name = name, cpf = cpf)
            insertCustomerInputPort.insert(customer, zipCode)
        }
    }
}