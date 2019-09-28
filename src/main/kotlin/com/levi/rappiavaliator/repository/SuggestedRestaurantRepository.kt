package com.levi.rappiavaliator.repository

import com.levi.rappiavaliator.domain.SuggestedRestaurant
import org.springframework.data.cassandra.repository.CassandraRepository
import java.util.*

interface SuggestedRestaurantRepository : CassandraRepository<SuggestedRestaurant, UUID> {

    fun findByName(name: String): SuggestedRestaurant?

}
