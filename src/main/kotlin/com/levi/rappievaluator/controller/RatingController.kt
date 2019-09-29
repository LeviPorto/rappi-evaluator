package com.levi.rappievaluator.controller

import com.levi.rappievaluator.domain.Rating
import com.levi.rappievaluator.service.RatingService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/evaluator/rating")
class RatingController(private val service: RatingService) {

    @PostMapping
    fun create(@RequestBody rating: Rating): Rating = service.create(rating)

    @GetMapping
    fun findByRestaurant(@PathVariable restaurantId : Int) = service.retrieveByRestaurant(restaurantId)
}
