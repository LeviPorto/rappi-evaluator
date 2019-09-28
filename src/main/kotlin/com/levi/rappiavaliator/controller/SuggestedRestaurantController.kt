package com.levi.rappiavaliator.controller

import com.levi.rappiavaliator.domain.SuggestedRestaurant
import com.levi.rappiavaliator.service.SuggestedRestaurantService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/avaliator/suggestedRestaurant")
class SuggestedRestaurantController(private val service: SuggestedRestaurantService) {

    @PostMapping
    fun create(@RequestBody suggestedRestaurant: SuggestedRestaurant): SuggestedRestaurant = service.create(suggestedRestaurant)

}
