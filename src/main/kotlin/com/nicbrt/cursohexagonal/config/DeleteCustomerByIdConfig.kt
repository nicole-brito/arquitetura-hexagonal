package com.nicbrt.cursohexagonal.config

import com.nicbrt.cursohexagonal.adapters.out.DeleteCustomerByIdByIdAdapter
import com.nicbrt.cursohexagonal.application.core.usecase.DeleteCustomerByIdUseCase
import com.nicbrt.cursohexagonal.application.core.usecase.FindCustomerByIdUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DeleteCustomerByIdConfig {

    @Bean
    fun deleteCustomer(
        findCustomerByIdUseCase: FindCustomerByIdUseCase,
        deleteCustomerByIdByIdAdapter: DeleteCustomerByIdByIdAdapter
    ) = DeleteCustomerByIdUseCase(
        findCustomerByIdUseCase,
        deleteCustomerByIdByIdAdapter
    )
}