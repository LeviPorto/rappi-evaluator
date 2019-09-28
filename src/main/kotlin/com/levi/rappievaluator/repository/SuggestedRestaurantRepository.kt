package com.levi.rappievaluator.repository

import com.levi.rappievaluator.domain.SuggestedRestaurant
import org.springframework.data.cassandra.repository.CassandraRepository
import java.util.*

interface SuggestedRestaurantRepository : CassandraRepository<SuggestedRestaurant, UUID> {

    fun findByName(name: String): SuggestedRestaurant?

}
