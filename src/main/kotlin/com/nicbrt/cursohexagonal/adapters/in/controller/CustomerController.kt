package com.nicbrt.cursohexagonal.adapters.`in`.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/customers")
class CustomerController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun insert() {

    }
}