package com.levi.rappievaluator

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class RappiEvaluatorApplication

fun main(args: Array<String>) {
    runApplication<RappiEvaluatorApplication>(*args)
}
