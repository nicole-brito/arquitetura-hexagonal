package com.nicbrt.cursohexagonal.config

import com.nicbrt.cursohexagonal.adapters.out.FindCustomerByIdAdapter
import com.nicbrt.cursohexagonal.application.core.usecase.FindCustomerByIdUseCase
import com.nicbrt.cursohexagonal.application.ports.`in`.FindCustomerByIdInputPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FindCustomerByIdConfig {

    @Bean
    fun findCustomerById(findCustomerByIdAdapter: FindCustomerByIdAdapter): FindCustomerByIdInputPort {
        return FindCustomerByIdUseCase(findCustomerByIdAdapter)
    }

}