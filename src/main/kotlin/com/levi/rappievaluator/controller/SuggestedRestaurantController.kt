package com.levi.rappievaluator.controller

import com.levi.rappievaluator.domain.SuggestedRestaurant
import com.levi.rappievaluator.dto.SuggestedRestaurantDTO
import com.levi.rappievaluator.service.SuggestedRestaurantService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/evaluator/suggestedRestaurant")
class SuggestedRestaurantController(private val service: SuggestedRestaurantService) {

    @PostMapping
    fun create(@RequestBody suggestedRestaurant: SuggestedRestaurant): SuggestedRestaurant = service.create(suggestedRestaurant)

    @GetMapping("/zomatoSearch")
    fun findSuggestedRestaurantsFromZomatoApi(@RequestHeader("user-key") userKey : String,
                                              @RequestParam("q") searchedWord : String,
                                              @RequestParam("entity_type") entityType : String) : List<SuggestedRestaurantDTO> {
        return service.retrieveSuggestedRestaurantsFromZomatoApi(userKey, entityType, searchedWord)
    }
}
