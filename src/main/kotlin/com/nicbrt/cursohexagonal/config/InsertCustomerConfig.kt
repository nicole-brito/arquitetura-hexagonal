package com.nicbrt.cursohexagonal.config

import com.nicbrt.cursohexagonal.adapters.out.FindAddressByZipCodeAdapter
import com.nicbrt.cursohexagonal.adapters.out.InsertCustomerAdapter
import com.nicbrt.cursohexagonal.application.core.usecase.InsertCustomerUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class InsertCustomerConfig {

    @Bean
    fun insertCustomer(
        findAddressByZipCodeAdapter: FindAddressByZipCodeAdapter,
        insertCustomerAdapter: InsertCustomerAdapter
    ) = InsertCustomerUseCase(
        findAddressByZipCodeAdapter,
        insertCustomerAdapter
    )
}