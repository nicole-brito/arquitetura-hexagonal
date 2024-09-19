package com.nicbrt.cursohexagonal.adapters.out

import com.nicbrt.cursohexagonal.adapters.out.client.FindAddressByZipCodeClient
import com.nicbrt.cursohexagonal.application.core.domain.Address
import com.nicbrt.cursohexagonal.application.ports.out.FindAddressByZipCodeOutputPort
import org.springframework.stereotype.Component

@Component
class FindAddressByZipCodeAdapter(
    private val findAddressByZipCodeClient: FindAddressByZipCodeClient
): FindAddressByZipCodeOutputPort {

    override fun find(zipCode: String): Address =
    findAddressByZipCodeClient.find(zipCode).toAddress()

}