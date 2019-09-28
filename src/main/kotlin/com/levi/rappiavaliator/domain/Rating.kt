package com.levi.rappiavaliator.domain

import com.datastax.driver.core.utils.UUIDs
import com.levi.rappiavaliator.domain.enumeration.ImprovementType
import com.levi.rappiavaliator.domain.enumeration.RangeTime
import org.springframework.data.cassandra.core.mapping.Column
import org.springframework.data.cassandra.core.mapping.PrimaryKey
import org.springframework.data.cassandra.core.mapping.Table
import java.time.Instant
import java.util.*

@Table
class Rating(
        @PrimaryKey val id: UUID = UUIDs.timeBased(),
        @Column val value: Double,
        @Column val restaurantId: Int,
        @Column val orderId: Int,
        @Column val userId: Int,
        @Column val comment: String,
        @Column val date: Instant,
        @Column val arrivedOnTime: Boolean,
        @Column val arrivalRangeTime: RangeTime,
        @Column val improvementType: ImprovementType
)
