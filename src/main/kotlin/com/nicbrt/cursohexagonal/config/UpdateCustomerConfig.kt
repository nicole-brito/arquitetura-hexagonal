package com.nicbrt.cursohexagonal.config

import com.nicbrt.cursohexagonal.adapters.out.FindAddressByZipCodeAdapter
import com.nicbrt.cursohexagonal.adapters.out.UpdateCustomerAdapter
import com.nicbrt.cursohexagonal.application.core.usecase.FindCustomerByIdUseCase
import com.nicbrt.cursohexagonal.application.core.usecase.UpdateCustomerUseCase
import com.nicbrt.cursohexagonal.application.ports.`in`.UpdateCustomerInputPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UpdateCustomerConfig {

    @Bean
    fun updateCustomer(
        findCustomerByIdUseCase: FindCustomerByIdUseCase,
        findAddressByZipCodeAdapter: FindAddressByZipCodeAdapter,
        updateCustomerAdapter: UpdateCustomerAdapter
    ) =UpdateCustomerUseCase(
            findCustomerByIdUseCase,
            findAddressByZipCodeAdapter,
            updateCustomerAdapter
        )
    }