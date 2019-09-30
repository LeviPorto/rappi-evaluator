package com.levi.rappievaluator

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.scheduling.annotation.EnableAsync

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCaching
@EnableAsync
class RappiEvaluatorApplication

fun main(args: Array<String>) {
    runApplication<RappiEvaluatorApplication>(*args)
}
