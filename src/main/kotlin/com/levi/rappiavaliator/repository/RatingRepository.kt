package com.levi.rappiavaliator.repository

import com.levi.rappiavaliator.domain.Rating
import org.springframework.data.cassandra.repository.CassandraRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface RatingRepository : CassandraRepository<Rating, UUID>
