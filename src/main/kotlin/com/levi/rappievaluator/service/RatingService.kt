package com.levi.rappievaluator.service

import com.levi.rappievaluator.api.ManagerApi
import com.levi.rappievaluator.domain.Rating
import com.levi.rappievaluator.dto.RatingDTO
import com.levi.rappievaluator.repository.RatingRepository
import org.springframework.stereotype.Service

@Service
class RatingService(private val repository: RatingRepository,
                    private val evaluationProcessorService: EvaluationProcessorService,
                    private val cachedEvaluationProcessorService: CachedEvaluationProcessorService,
                    private val managerApi: ManagerApi) {

    fun create(rating: Rating): Rating {
        val createdRating = repository.save(rating)

        verifyInCacheAndProcessRating(rating)

        return createdRating
    }

    fun retrieveRestaurantRatings(restaurantId: Int): List<RatingDTO> {
        val restaurantRatings = repository.findByRestaurantId(restaurantId)

        val evaluators = managerApi.retrieveByIds(restaurantRatings.map { it.userId })

        return restaurantRatings.map { restaurantRating ->
            val evaluator = evaluators.first { restaurantRating.userId == it.id }
            RatingDTO(restaurantRating.id, restaurantRating.value, restaurantRating.restaurantId, evaluator
                    , restaurantRating.comment, restaurantRating.date)
        }
    }

    private fun verifyInCacheAndProcessRating(rating: Rating) {
        val cachedRestaurantAverageRating = cachedEvaluationProcessorService.retrieveInCache(rating.restaurantId.toString())
        if (cachedRestaurantAverageRating == null) {
            evaluationProcessorService.processRating(cachedRestaurantAverageRating, rating, retrieveRestaurantRatings(rating.restaurantId))
        } else {
            evaluationProcessorService.processRating(cachedRestaurantAverageRating, rating)
        }
    }

}
