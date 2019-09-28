package com.levi.rappiavaliator.controller

import com.levi.rappiavaliator.domain.Rating
import com.levi.rappiavaliator.service.RatingService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/avaliator/rating")
class RatingController(private val service: RatingService) {

    @PostMapping
    fun create(@RequestBody rating: Rating): Rating = service.create(rating)

}
