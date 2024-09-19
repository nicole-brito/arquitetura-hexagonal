package com.nicbrt.cursohexagonal.application.ports.out

import com.nicbrt.cursohexagonal.application.core.domain.Address


interface FindAddressByZipCodeOutputPort {

    fun find(zipCode: String): Address
}