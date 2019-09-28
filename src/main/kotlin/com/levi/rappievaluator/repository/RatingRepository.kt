package com.levi.rappievaluator.repository

import com.levi.rappievaluator.domain.Rating
import org.springframework.data.cassandra.repository.CassandraRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface RatingRepository : CassandraRepository<Rating, UUID> {
    fun findByRestaurantId(restaurantId: Int): List<Rating>
}
