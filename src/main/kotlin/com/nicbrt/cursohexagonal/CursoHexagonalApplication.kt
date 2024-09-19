package com.nicbrt.cursohexagonal

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class CursoHexagonalApplication

fun main(args: Array<String>) {
	runApplication<CursoHexagonalApplication>(*args)
}
