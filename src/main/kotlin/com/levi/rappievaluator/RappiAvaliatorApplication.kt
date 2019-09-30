package com.levi.rappievaluator

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCaching
class RappiEvaluatorApplication

fun main(args: Array<String>) {
    runApplication<RappiEvaluatorApplication>(*args)
}
