package com.levi.rappiavaliator.service

import com.levi.rappiavaliator.domain.SuggestedRestaurant
import com.levi.rappiavaliator.repository.SuggestedRestaurantRepository
import org.springframework.stereotype.Service

@Service
class SuggestedRestaurantService(private val repository: SuggestedRestaurantRepository) {

    fun create(suggestedRestaurant: SuggestedRestaurant): SuggestedRestaurant {
        val existentSuggestedRestaurant = repository.findByName(suggestedRestaurant.name)

        return if (existentSuggestedRestaurant == null) {
            repository.save(SuggestedRestaurant(suggestedRestaurant.id, suggestedRestaurant.name,
                    suggestedRestaurant.address, suggestedRestaurant.count + 1, suggestedRestaurant.phone))
        } else {
            repository.save(SuggestedRestaurant(existentSuggestedRestaurant.id, existentSuggestedRestaurant.name,
                    existentSuggestedRestaurant.address, existentSuggestedRestaurant.count + 1, existentSuggestedRestaurant.phone))
        }

    }

}
