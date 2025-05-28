package com.nicbrt.cursohexagonal.application.ports.out

interface SendCpfForValidationOutputPort {

    fun send(cpf: String)

}