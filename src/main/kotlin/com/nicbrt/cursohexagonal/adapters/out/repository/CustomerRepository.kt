package com.nicbrt.cursohexagonal.adapters.out.repository

import com.nicbrt.cursohexagonal.adapters.out.repository.entity.CustomerEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository: MongoRepository<CustomerEntity, String>