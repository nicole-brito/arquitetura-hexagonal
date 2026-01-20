package com.nicbrt.cursohexagonal.adapters.`in`.consumer

import com.nicbrt.cursohexagonal.adapters.`in`.consumer.message.CustomerMessage
import com.nicbrt.cursohexagonal.application.ports.`in`.UpdateCustomerInputPort
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class ReceiveValidatedCostumerDataConsumer(
    private val updateCustomerInputPort: UpdateCustomerInputPort
) {

    @KafkaListener(topics = ["tp-cpf-validated"], groupId = "nicbrt")
    fun receive(customerMessage: CustomerMessage) {
        with(customerMessage) {
            updateCustomerInputPort.update(toCustomer(), zipCode)
        }
    }
}