package com.levi.rappiavaliator.service

import com.levi.rappiavaliator.domain.Rating
import com.levi.rappiavaliator.repository.RatingRepository
import org.springframework.stereotype.Service

@Service
class RatingService(private val repository: RatingRepository) {

    fun create(rating: Rating): Rating {
        return repository.save(rating)
    }

}
