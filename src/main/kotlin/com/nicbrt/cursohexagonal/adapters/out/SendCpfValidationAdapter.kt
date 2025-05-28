package com.nicbrt.cursohexagonal.adapters.out

import com.nicbrt.cursohexagonal.application.ports.out.SendCpfForValidationOutputPort
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class SendCpfValidationAdapter (
    private val kafkaTemplate: KafkaTemplate<String, String>
) : SendCpfForValidationOutputPort {

    override fun send(cpf: String) {
        kafkaTemplate.send("tp-cpf-validation", cpf)
    }
}