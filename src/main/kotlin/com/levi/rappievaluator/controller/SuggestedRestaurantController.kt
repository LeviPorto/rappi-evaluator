package com.levi.rappievaluator.controller

import com.levi.rappievaluator.domain.SuggestedRestaurant
import com.levi.rappievaluator.service.SuggestedRestaurantService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/evaluator/suggestedRestaurant")
class SuggestedRestaurantController(private val service: SuggestedRestaurantService) {

    @PostMapping
    fun create(@RequestBody suggestedRestaurant: SuggestedRestaurant): SuggestedRestaurant = service.create(suggestedRestaurant)

}
